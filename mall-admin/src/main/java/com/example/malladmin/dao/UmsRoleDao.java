package com.example.malladmin.dao;

import com.example.mallmbg.model.UmsMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UmsRoleDao {
    /*根据用户id获取菜单*/
    List<UmsMenu> getMenuList(@Param("adminId") Long adminId);

    /*根据角色id获取菜单*/
    List<UmsMenu> getMenuListByRoleId(@Param("roleId") Long roleId);
}
