package com.example.malladmin.service;

import com.example.mallmbg.model.PmsProductAttributeCategory;

import java.util.List;

/*商品属性分类service*/
public interface PmsProductAttributeCategoryService {
    /*分页获取属性分类*/
    List<PmsProductAttributeCategory> getList(Integer pageNum, Integer pageSize);

    /*创建属性分类*/
    int create(String name);
}
