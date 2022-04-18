package com.example.malladmin.service;

import com.example.malladmin.dto.UmsAdminParam;
import com.example.mallcommon.api.CommonResult;
import com.example.mallcommon.domain.UserDto;
import com.example.mallmbg.model.UmsAdmin;
import com.example.mallmbg.model.UmsResource;
import com.example.mallmbg.model.UmsRole;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UmsAdminService {
    UmsAdmin getAdminByUsername(String name);

    UmsAdmin register(UmsAdminParam umsAdminParam);

    CommonResult login(String username, String password);

//    String refreshToken(String oldToken);

    UmsAdmin getItem(Long id);

    /*根据username or nickname 模糊查询*/
    List<UmsAdmin> list(String keyword, Integer pageNum, Integer pageSize);

    int update(Long id, UmsAdmin umsAdmin);

//    int delete(Long id);

    /*获取用户角色列表*/
    List<UmsRole> getRoleList(Long adminId);

    @Transactional
    int updateRole(Long adminId, List<Long> roleIds);

    List<UmsResource> getResourceList(Long adminId);

    UserDto loadUserByUsername(String username);

    /*获取当前后台登陆用户*/
    UmsAdmin getCurrentAdmin();
}
