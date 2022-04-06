package com.example.malladmin.controller;

import com.example.malladmin.dto.OmsOrderDetail;
import com.example.malladmin.dto.OmsOrderQueryParam;
import com.example.malladmin.service.OmsOrderService;
import com.example.mallcommon.api.CommonPage;
import com.example.mallcommon.api.CommonResult;
import com.example.mallmbg.model.OmsOrder;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@Tag(name = "OmsOrderController", description = "订单管理")
public class OmsOrderController {
    @Autowired
    private OmsOrderService orderService;

    @Operation(description = "查询订单")
    @GetMapping("/list")
    public CommonResult<CommonPage<OmsOrder>> list(OmsOrderQueryParam queryParam,
                                                   @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                   @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        List<OmsOrder> orders = orderService.list(queryParam, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(orders));
    }

    @GetMapping("/{id}")
    @Operation(description = "订单详情")
    public CommonResult<OmsOrderDetail> detail(@PathVariable Long id) {
        OmsOrderDetail orderDetail = orderService.detail(id);
        return CommonResult.success(orderDetail);
    }
}