package com.example.malladmin.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.BCrypt;
import com.example.malladmin.dao.UmsAdminRoleRelationDao;
import com.example.malladmin.dto.UmsAdminParam;
import com.example.malladmin.service.AuthService;
import com.example.malladmin.service.UmsAdminCacheService;
import com.example.malladmin.service.UmsAdminService;
import com.example.mallcommon.api.CommonResult;
import com.example.mallcommon.api.ResultCode;
import com.example.mallcommon.constant.AuthConstant;
import com.example.mallcommon.domain.UserDto;
import com.example.mallcommon.exception.Asserts;
import com.example.mallcommon.util.RequestUtil;
import com.example.mallmbg.mapper.UmsAdminLoginLogMapper;
import com.example.mallmbg.mapper.UmsAdminMapper;
import com.example.mallmbg.mapper.UmsAdminRoleRelationMapper;
import com.example.mallmbg.model.*;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UmsAdminServiceImpl implements UmsAdminService {
    //private static final Logger LOGGER = LoggerFactory.getLogger(UmsAdminServiceImpl.class);

    @Autowired
    private UmsAdminCacheService umsAdminCacheService;

    @Autowired
    private UmsAdminMapper umsAdminMapper;

    @Autowired
    private UmsAdminRoleRelationMapper umsAdminRoleRelationMapper;


    @Autowired
    private UmsAdminRoleRelationDao umsAdminRoleRelationDao;

    @Autowired
    private UmsAdminLoginLogMapper loginLogMapper;

    @Autowired
    private AuthService authService;

    @Override
    public UmsAdmin getAdminByUsername(String username) {
        UmsAdminExample umsAdminExample = new UmsAdminExample();
        umsAdminExample.createCriteria().andUsernameEqualTo(username);
        List<UmsAdmin> adminList = umsAdminMapper.selectByExample(umsAdminExample);
        if (adminList != null && adminList.size() > 0) {
            return adminList.get(0);
        }
        return null;
    }

    @Override
    public UmsAdmin register(UmsAdminParam umsAdminParam) {
        UmsAdmin umsAdmin = new UmsAdmin();
        BeanUtils.copyProperties(umsAdminParam, umsAdmin);
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setStatus(1);

        // 查询是否有相同的用户
        UmsAdminExample umsAdminExample = new UmsAdminExample();
        umsAdminExample.createCriteria().andUsernameEqualTo(umsAdmin.getUsername());
        List<UmsAdmin> umsAdminList = umsAdminMapper.selectByExample(umsAdminExample);
        if (umsAdminList.size() > 0) {
            return null;
        }
        // 加密密码
        String encodePassword = BCrypt.hashpw(umsAdmin.getPassword());
        umsAdmin.setPassword(encodePassword);

        umsAdminMapper.insert(umsAdmin);

        return umsAdmin;
    }

    @Override
    public CommonResult login(String username, String password) {
        if (StrUtil.isEmpty(username) || StrUtil.isEmpty(password)) {
            Asserts.fail("用户名或者密码不能为空");
        }
        Map<String, String> params = new HashMap<>();
        params.put("client_id", AuthConstant.ADMIN_CLIENT_ID);
        params.put("client_secret", "123456");
        params.put("grant_type", "password");
        params.put("username", username);
        params.put("password", password);
        CommonResult result = authService.getAccessToken(params);
        if (ResultCode.SUCCESS.getCode() == result.getCode() && result.getData() != null) {
            //登陆成功写入登陆日志
            insertLoginLog(username);
        }
        return result;
    }

    /*插入登陆日志*/
    private void insertLoginLog(String username) {
        UmsAdmin admin = getAdminByUsername(username);
        if (admin == null) return;
        UmsAdminLoginLog loginLog = new UmsAdminLoginLog();
        loginLog.setAdminId(admin.getId());
        loginLog.setCreateTime(new Date());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        loginLog.setIp(RequestUtil.getRequestIp(request));
        loginLogMapper.insert(loginLog);
    }
    @Override
    public List<UmsResource> getResourceList(Long adminId) {
        return umsAdminRoleRelationDao.getResourceList(adminId);
    }

    @Override
    public UserDto loadUserByUsername(String username) {
        UmsAdmin admin = getAdminByUsername(username);
        if (admin != null) {
            List<UmsRole> roles = getRoleList(admin.getId());
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(admin, userDto);
            if (CollUtil.isNotEmpty(roles)) {
                List<String> roleList = roles.stream().map(item -> item.getId() + "_" + item.getName()).collect(Collectors.toList());
                userDto.setRoles(roleList);
            }
            return userDto;
        }
        return null;
    }


    @Override
    public int updateRole(Long adminId, List<Long> roleIds) {
        int count = roleIds == null ? 0 : roleIds.size();
        // 删除原来的用户角色关系
        UmsAdminRoleRelationExample umsAdminRoleRelationExample = new UmsAdminRoleRelationExample();
        umsAdminRoleRelationExample.createCriteria().andAdminIdEqualTo(adminId);
        umsAdminRoleRelationMapper.deleteByExample(umsAdminRoleRelationExample);

        // 建立新的用户角色关系
        if (!CollectionUtil.isEmpty(roleIds)) {
            List<UmsAdminRoleRelation> list = new ArrayList<>();
            for (Long roleId: roleIds) {
                UmsAdminRoleRelation umsAdminRoleRelation = new UmsAdminRoleRelation();
                umsAdminRoleRelation.setAdminId(adminId);
                umsAdminRoleRelation.setRoleId(roleId);
                list.add(umsAdminRoleRelation);
            }
            // 批量更新用户角色
            umsAdminRoleRelationDao.insertList(list);
        }
        return count;
    }
    /*获取用户持有角色详细信息*/
    @Override
    public List<UmsRole> getRoleList(Long adminId) {
        return umsAdminRoleRelationDao.getRoleList(adminId);
    }

    /*根据关键词分页获取用户数据*/
    @Override
    public List<UmsAdmin> list(String keyword, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        UmsAdminExample example = new UmsAdminExample();

        if (!StrUtil.isEmpty(keyword)) {
            example.createCriteria().andUsernameLike("%" + keyword + "%");
            example.or(example.createCriteria().andNickNameLike("%" + keyword + "%"));
        }
        return umsAdminMapper.selectByExample(example);
    }

    @Override
    public int update(Long id, UmsAdmin umsAdmin) {
        umsAdmin.setId(id);
        if (StrUtil.isEmpty(umsAdmin.getPassword())) {
            umsAdmin.setPassword(null);
        } else {
            umsAdmin.setPassword(BCrypt.hashpw(umsAdmin.getPassword()));
        }
        int count = umsAdminMapper.updateByPrimaryKeySelective(umsAdmin);
        umsAdminCacheService.delAdmin(id);
        return count;
    }

    @Override
    public UmsAdmin getItem(Long id) {
        return umsAdminMapper.selectByPrimaryKey(id);
    }

}
