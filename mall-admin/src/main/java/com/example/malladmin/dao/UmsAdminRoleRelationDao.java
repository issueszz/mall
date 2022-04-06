package com.example.malladmin.dao;

import com.example.mallmbg.model.UmsAdminRoleRelation;
import com.example.mallmbg.model.UmsResource;
import com.example.mallmbg.model.UmsRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UmsAdminRoleRelationDao {
    /*批量插入用户角色*/
    int insertList(@Param("list") List<UmsAdminRoleRelation> umsAdminRoleRelations);

    /*获取用户所有可访问的资源*/
    List<UmsResource> getResourceList(@Param("adminId") Long adminId);

    /*获取用户所有角色*/
    List<UmsRole> getRoleList(@Param("adminId") Long adminId);
}