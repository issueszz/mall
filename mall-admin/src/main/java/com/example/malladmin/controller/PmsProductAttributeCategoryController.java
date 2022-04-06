package com.example.malladmin.controller;

import com.example.malladmin.service.PmsProductAttributeCategoryService;
import com.example.mallcommon.api.CommonPage;
import com.example.mallcommon.api.CommonResult;
import com.example.mallmbg.model.PmsProductAttributeCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productAttribute/category")
public class PmsProductAttributeCategoryController {
    @Autowired
    private PmsProductAttributeCategoryService productAttributeCategoryService;

    @GetMapping("/list")
    public CommonResult<CommonPage<PmsProductAttributeCategory>> getList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                                         @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        return CommonResult.success(CommonPage.restPage(productAttributeCategoryService.getList(pageNum, pageSize)));
    }

    @PostMapping("/create")
    public CommonResult create(@RequestParam String name) {
        int count = productAttributeCategoryService.create(name);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }
}
