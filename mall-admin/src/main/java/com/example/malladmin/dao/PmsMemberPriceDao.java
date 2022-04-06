package com.example.malladmin.dao;

import com.example.mallmbg.model.PmsMemberPrice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PmsMemberPriceDao {
    /*批量插入*/
    int insertList(@Param("list") List<PmsMemberPrice> memberPriceList);
}
