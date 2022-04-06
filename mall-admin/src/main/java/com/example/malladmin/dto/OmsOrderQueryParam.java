package com.example.malladmin.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class OmsOrderQueryParam {
    @Schema(description = "订单编号")
    private String orderSn;

    @Schema(description = "收货人姓名/号码")
    private String receiverKeyword;

    @Schema(description = "订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单")
    private Integer status;

    @Schema(description = "订单类型：0->正常订单；1->秒杀订单")
    private Integer orderType;

    @Schema(description = "订单来源：0->PC订单；1->app订单")
    private Integer sourceType;

    @Schema(description = "订单提交时间")
    private String createTime;
}
