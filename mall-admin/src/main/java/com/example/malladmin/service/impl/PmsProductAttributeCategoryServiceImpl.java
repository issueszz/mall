package com.example.malladmin.service.impl;

import com.example.malladmin.service.PmsProductAttributeCategoryService;
import com.example.mallmbg.mapper.PmsProductAttributeCategoryMapper;
import com.example.mallmbg.model.PmsProductAttributeCategory;
import com.example.mallmbg.model.PmsProductAttributeCategoryExample;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PmsProductAttributeCategoryServiceImpl implements PmsProductAttributeCategoryService {
    @Autowired
    private PmsProductAttributeCategoryMapper productAttributeCategoryMapper;

    @Override
    public List<PmsProductAttributeCategory> getList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PmsProductAttributeCategoryExample example = new PmsProductAttributeCategoryExample();
        return productAttributeCategoryMapper.selectByExample(example);
    }

    @Override
    public int create(String name) {
        PmsProductAttributeCategory attributeCategory = new PmsProductAttributeCategory();
        attributeCategory.setName(name);
        return productAttributeCategoryMapper.insertSelective(attributeCategory);
    }
}
