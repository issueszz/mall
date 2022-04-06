package com.example.malladmin.controller;

import com.example.malladmin.service.OmsOrderSettingService;
import com.example.mallcommon.api.CommonResult;
import com.example.mallmbg.model.OmsOrderSetting;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orderSetting")
@Tag(name = "OmsOrderSettingController", description = "订单设置管理")
public class OmsOrderSettingController {
    @Autowired
    private OmsOrderSettingService orderSettingService;

    @GetMapping("/{id}")
    @Operation(description = "返回订单设置")
    public CommonResult<OmsOrderSetting> getItem(@PathVariable Long id) {
        return CommonResult.success(orderSettingService.getItem(id));
    }

    @PostMapping("/update/{id}")
    @Operation(description = "修改订单设置")
    public CommonResult update(@PathVariable Long id, @RequestBody OmsOrderSetting orderSetting) {
        int count = orderSettingService.update(id, orderSetting);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }
}
