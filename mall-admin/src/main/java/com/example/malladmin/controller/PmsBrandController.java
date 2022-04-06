package com.example.malladmin.controller;

import com.example.malladmin.service.PmsBrandService;
import com.example.mallcommon.api.CommonPage;
import com.example.mallcommon.api.CommonResult;
import com.example.mallmbg.model.PmsBrand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class PmsBrandController {
    @Autowired
    private PmsBrandService brandService;

    @GetMapping("/list")
    public CommonResult<CommonPage<PmsBrand>> getList(@RequestParam(value = "keyword", required = false) String keyword,
                                                      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                      @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        List<PmsBrand> brandList = brandService.getList(keyword, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(brandList));
    }
}
