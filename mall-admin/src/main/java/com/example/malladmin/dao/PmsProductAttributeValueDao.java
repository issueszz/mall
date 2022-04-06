package com.example.malladmin.dao;

import com.example.mallmbg.model.PmsProductAttributeValue;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PmsProductAttributeValueDao {
    int insert(@Param("list") List<PmsProductAttributeValue> productAttributeValueList);
}
