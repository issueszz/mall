package com.example.malladmin.service.impl;

import cn.hutool.core.util.StrUtil;
import com.example.malladmin.dao.UmsRoleDao;
import com.example.malladmin.service.UmsRoleService;
import com.example.mallmbg.mapper.UmsRoleMapper;
import com.example.mallmbg.mapper.UmsRoleMenuRelationMapper;
import com.example.mallmbg.model.*;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UmsRoleServiceImpl implements UmsRoleService {
    @Autowired
    private UmsRoleDao umsRoleDao;

    @Autowired
    private UmsRoleMapper roleMapper;

    @Autowired
    private UmsRoleMenuRelationMapper roleMenuRelationMapper;

    @Override
    public List<UmsMenu> getMenuList(Long adminId) {
        return umsRoleDao.getMenuList(adminId);
    }

    @Override
    public List<UmsRole> list() {
        return roleMapper.selectByExample(new UmsRoleExample());
    }

    @Override
    public List<UmsRole> list(String keyword, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        UmsRoleExample example = new UmsRoleExample();
        if (!StrUtil.isEmpty(keyword)) {
            example.createCriteria().andNameLike("%" + keyword + "%");
        }
        return roleMapper.selectByExample(example);
    }

    @Override
    public List<UmsMenu> listMenu(Long roleId) {
        return umsRoleDao.getMenuListByRoleId(roleId);
    }

    @Override
    public int allocMenu(Long roleId, List<Long> menuIds) {
        // 先删除已有的关系
        UmsRoleMenuRelationExample example = new UmsRoleMenuRelationExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        roleMenuRelationMapper.deleteByExample(example);

        // 批量建立新的关系
        for (Long menuId : menuIds) {
            UmsRoleMenuRelation roleMenuRelation = new UmsRoleMenuRelation();
            roleMenuRelation.setRoleId(roleId);
            roleMenuRelation.setMenuId(menuId);
            roleMenuRelationMapper.insert(roleMenuRelation);
        }
        return menuIds.size();
    }
}
