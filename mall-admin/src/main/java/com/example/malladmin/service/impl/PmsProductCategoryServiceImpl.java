package com.example.malladmin.service.impl;

import com.example.malladmin.dao.PmsProductCategoryDao;
import com.example.malladmin.dto.PmsProductCategoryWithChildrenItem;
import com.example.malladmin.service.PmsProductCategoryService;
import com.example.mallmbg.mapper.PmsProductCategoryMapper;
import com.example.mallmbg.model.PmsProductCategory;
import com.example.mallmbg.model.PmsProductCategoryExample;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PmsProductCategoryServiceImpl implements PmsProductCategoryService {
    @Autowired
    private PmsProductCategoryMapper categoryMapper;

    @Autowired
    private PmsProductCategoryDao pmsProductCategoryDao;

    @Override
    public List<PmsProductCategory> getList(Long parentId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PmsProductCategoryExample example = new PmsProductCategoryExample();
        example.setOrderByClause("sort desc");
        example.createCriteria().andParentIdEqualTo(parentId);
        return categoryMapper.selectByExample(example);
    }

    @Override
    public List<PmsProductCategoryWithChildrenItem> listWithChildren() {
        return pmsProductCategoryDao.listWithChildren();
    }
}
