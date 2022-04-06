package com.example.malladmin.dao;

import com.example.malladmin.dto.PmsProductCategoryWithChildrenItem;

import java.util.List;

public interface PmsProductCategoryDao {
    List<PmsProductCategoryWithChildrenItem> listWithChildren();
}
