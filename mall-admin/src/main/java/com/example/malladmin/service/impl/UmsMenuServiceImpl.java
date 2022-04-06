package com.example.malladmin.service.impl;

import com.example.malladmin.dto.UmsMenuNode;
import com.example.malladmin.service.UmsMenuService;
import com.example.mallmbg.mapper.UmsMenuMapper;
import com.example.mallmbg.model.UmsMenu;
import com.example.mallmbg.model.UmsMenuExample;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UmsMenuServiceImpl implements UmsMenuService {
    @Autowired
    private UmsMenuMapper menuMapper;

    @Override
    public List<UmsMenu> list(Long parentId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        UmsMenuExample example = new UmsMenuExample();
        example.createCriteria().andParentIdEqualTo(parentId);
        return menuMapper.selectByExample(example);
    }

    @Override
    public int create(UmsMenu umsMenu) {
        umsMenu.setCreateTime(new Date());
        updateLevel(umsMenu);
        return menuMapper.insert(umsMenu);
    }

    /*预处理菜单层级*/
    private void updateLevel(UmsMenu umsMenu) {
        if (umsMenu.getParentId() == 0) {
            umsMenu.setLevel(0);
        } else {
            UmsMenu parentMenu = menuMapper.selectByPrimaryKey(umsMenu.getParentId());
            if (parentMenu != null) {
                umsMenu.setLevel(parentMenu.getLevel() + 1);
            } else {
                umsMenu.setLevel(0);
            }
        }
    }

    @Override
    public List<UmsMenuNode> treeList() {
        List<UmsMenu> menus = menuMapper.selectByExample(new UmsMenuExample());
        List<UmsMenuNode> result = menus.stream()
                .filter(menu -> menu.getParentId().equals(0L))
                .map(menu -> covertMenuNode(menu, menus)).collect(Collectors.toList());
        return result;
    }

    private UmsMenuNode covertMenuNode(UmsMenu menu, List<UmsMenu> menus) {
        UmsMenuNode menuNode = new UmsMenuNode();
        BeanUtils.copyProperties(menu, menuNode);
        List<UmsMenuNode> children = menus.stream()
                .filter(subMenu -> subMenu.getParentId().equals(menu.getId()))
                .map(subMenu -> covertMenuNode(subMenu, menus)).collect(Collectors.toList());
        menuNode.setChildren(children);
        return menuNode;
    }
}
