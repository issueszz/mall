package com.example.malladmin.dto;

import com.example.mallmbg.model.OmsOrder;
import com.example.mallmbg.model.OmsOrderItem;
import com.example.mallmbg.model.OmsOrderOperateHistory;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class OmsOrderDetail extends OmsOrder {
    @Getter
    @Setter
    @Schema(description = "订单商品列表")
    private List<OmsOrderItem> orderItemList;

    @Getter
    @Setter
    @Schema(description = "订单操作记录列表")
    private List<OmsOrderOperateHistory> historyList;
}
