package com.example.malladmin.service;

import com.example.malladmin.dto.UmsMenuNode;
import com.example.mallmbg.model.UmsMenu;
import com.example.mallmbg.model.UmsRole;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UmsRoleService {
    /*根据管理员id获取菜单*/
    List<UmsMenu> getMenuList(Long adminId);

    /*获取所有的角色列表*/
    List<UmsRole> list();

    /*分页获取角色列表*/
    List<UmsRole> list(String keyword, Integer pageNum, Integer pageSize);

    /*根据角色id获取菜单列表*/
    List<UmsMenu> listMenu(Long roleId);

    /*给角色分配菜单*/
    @Transactional
    int allocMenu(Long roleId, List<Long> menuIds);
}
