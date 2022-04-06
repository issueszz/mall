package com.example.malladmin.dao;

import com.example.malladmin.dto.OmsOrderDetail;
import com.example.malladmin.dto.OmsOrderQueryParam;
import com.example.mallmbg.model.OmsOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OmsOrderDao {
    /*条件查询订单*/
    List<OmsOrder> getList(@Param("queryParam") OmsOrderQueryParam queryParam);

    /*订单详情*/
    OmsOrderDetail getDetail(@Param("id") Long id);
}
