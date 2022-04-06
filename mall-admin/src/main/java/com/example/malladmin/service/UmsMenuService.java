package com.example.malladmin.service;

import com.example.malladmin.dto.UmsMenuNode;
import com.example.mallmbg.model.UmsMenu;

import java.util.List;

public interface UmsMenuService {
    /*创建后台菜单*/
    int create(UmsMenu umsMenu);

    /*分页查询后台菜单*/
    List<UmsMenu> list(Long parentId, Integer pageNum, Integer pageSize);

    /*树形结构返回菜单列表*/
    List<UmsMenuNode> treeList();
}
