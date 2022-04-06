package com.example.malladmin.dao;

import com.example.mallmbg.model.PmsProductLadder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PmsProductLadderDao {
    /*批量插入*/
    int insertList(@Param("list") List<PmsProductLadder> productLadderList);
}
