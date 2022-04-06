package com.example.malladmin.dao;

import com.example.mallmbg.model.PmsProductFullReduction;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PmsProductFullReductionDao {
    int insertList(@Param("list") List<PmsProductFullReduction> productFullReductionList);
}
