package com.example.malladmin.dao;

import com.example.mallmbg.model.PmsSkuStock;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PmsSkuStockDao {
    /*批量插入*/
    int insertList(@Param("list") List<PmsSkuStock> skuStockList);
}
