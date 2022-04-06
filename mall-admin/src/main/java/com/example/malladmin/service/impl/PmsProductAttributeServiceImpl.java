package com.example.malladmin.service.impl;

import com.example.malladmin.dto.PmsProductAttributeParam;
import com.example.malladmin.service.PmsProductAttributeService;
import com.example.mallmbg.mapper.PmsProductAttributeCategoryMapper;
import com.example.mallmbg.mapper.PmsProductAttributeMapper;
import com.example.mallmbg.model.PmsProductAttribute;
import com.example.mallmbg.model.PmsProductAttributeCategory;
import com.example.mallmbg.model.PmsProductAttributeExample;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PmsProductAttributeServiceImpl implements PmsProductAttributeService {

    @Autowired
    private PmsProductAttributeMapper productAttributeMapper;

    @Autowired
    private PmsProductAttributeCategoryMapper productAttributeCategoryMapper;
    @Override
    public List<PmsProductAttribute> getList(Long cid, Integer type, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PmsProductAttributeExample productAttributeExample = new PmsProductAttributeExample();
        productAttributeExample.setOrderByClause("sort desc");
        productAttributeExample.createCriteria().andProductAttributeCategoryIdEqualTo(cid).andTypeEqualTo(type);
        return productAttributeMapper.selectByExample(productAttributeExample);
    }

    @Override
    public int create(PmsProductAttributeParam pmsProductAttributeParam) {
        //添加商品属性
        PmsProductAttribute pmsProductAttribute = new PmsProductAttribute();
        BeanUtils.copyProperties(pmsProductAttributeParam, pmsProductAttribute);
        int count = productAttributeMapper.insertSelective(pmsProductAttribute);
        // 更新商品属性分类数量
        PmsProductAttributeCategory productAttributeCategory = productAttributeCategoryMapper.selectByPrimaryKey(pmsProductAttribute.getProductAttributeCategoryId());
        if (pmsProductAttribute.getType() == 0) {
            productAttributeCategory.setAttributeCount(productAttributeCategory.getAttributeCount() + 1);
        } else if (pmsProductAttribute.getType() == 1) {
            productAttributeCategory.setParamCount(productAttributeCategory.getParamCount() + 1);
        }
        productAttributeCategoryMapper.updateByPrimaryKey(productAttributeCategory);
        return count;
    }
}
