package com.example.malladmin.dto;

import com.example.mallmbg.model.PmsProductCategory;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class PmsProductCategoryWithChildrenItem extends PmsProductCategory {
    @Getter
    @Setter
    private List<PmsProductCategory> children;
}
