package com.example.malladmin.controller;

import com.example.malladmin.dto.PmsProductAttributeParam;
import com.example.malladmin.service.PmsProductAttributeService;
import com.example.malladmin.validator.FlagValidator;
import com.example.mallcommon.api.CommonPage;
import com.example.mallcommon.api.CommonResult;
import com.example.mallmbg.model.PmsProductAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productAttribute")
public class PmsProductAttributeController {
    @Autowired
    private PmsProductAttributeService pmsProductAttributeService;

    @GetMapping("/list/{cid}")
    public CommonResult<CommonPage<PmsProductAttribute>> getList(@PathVariable Long cid,
                                                                 @RequestParam(value = "type", required = true) Integer type,
                                                                 @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                 @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<PmsProductAttribute> pmsProductAttributes = pmsProductAttributeService.getList(cid, type, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(pmsProductAttributes));
    }

    @PostMapping("/create")
    public CommonResult create(@FlagValidator @RequestBody PmsProductAttributeParam pmsProductAttributeParam) {
        int count = pmsProductAttributeService.create(pmsProductAttributeParam);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }
}
