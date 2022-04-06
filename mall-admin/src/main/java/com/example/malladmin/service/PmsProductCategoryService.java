package com.example.malladmin.service;

import com.example.malladmin.dto.PmsProductCategoryWithChildrenItem;
import com.example.mallmbg.model.PmsProductCategory;

import java.util.List;

public interface PmsProductCategoryService {
    /*分页获取商品分类*/
    List<PmsProductCategory> getList(Long parentId, Integer PageNum, Integer pageSize);

    /*层级方式获取商品分类*/
    List<PmsProductCategoryWithChildrenItem> listWithChildren();
}
