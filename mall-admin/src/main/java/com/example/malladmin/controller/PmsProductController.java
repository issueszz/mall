package com.example.malladmin.controller;

import com.example.malladmin.dto.PmsProductParam;
import com.example.malladmin.dto.PmsProductQueryParam;
import com.example.malladmin.dto.PmsProductResult;
import com.example.malladmin.service.PmsProductService;
import com.example.mallcommon.api.CommonPage;
import com.example.mallcommon.api.CommonResult;
import com.example.mallmbg.model.PmsProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class PmsProductController {
    @Autowired
    private PmsProductService pmsProductService;

    @GetMapping("/list")
    public CommonResult<CommonPage<PmsProduct>> getList(PmsProductQueryParam productQueryParam,
                                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        List<PmsProduct> productList = pmsProductService.list(productQueryParam, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(productList));
    }

    @PostMapping("/create")
    public CommonResult create(@RequestBody PmsProductParam pmsProductParam) {
        int count = pmsProductService.create(pmsProductParam);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @PostMapping("/update/deleteStatus")
    public CommonResult updateDeleteStatus(@RequestParam("ids") List<Long> ids,
                                           @RequestParam("deleteStatus") Integer deleteStatus) {
        int count = pmsProductService.updateDeleteStatus(ids, deleteStatus);

        if (count > 0) {
            return CommonResult.success(count);
        }

        return CommonResult.failed();
    }

    @GetMapping("/updateInfo/{id}")
    public CommonResult<PmsProductResult> updateInfo(@PathVariable("id") Long id) {
        PmsProductResult productResult = pmsProductService.getUpdateInfo(id);
        return CommonResult.success(productResult);
    }
}
