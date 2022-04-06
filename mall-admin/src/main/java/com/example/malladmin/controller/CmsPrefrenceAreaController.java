package com.example.malladmin.controller;

import com.example.malladmin.service.CmsPrefrenceAreaService;
import com.example.mallcommon.api.CommonResult;
import com.example.mallmbg.model.CmsPrefrenceArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/prefrenceArea")
public class CmsPrefrenceAreaController {
    @Autowired
    private CmsPrefrenceAreaService prefrenceAreaService;

    @GetMapping("/listAll")
    public CommonResult<List<CmsPrefrenceArea>> listAll() {
        List<CmsPrefrenceArea> prefrenceAreas = prefrenceAreaService.listAll();
        return CommonResult.success(prefrenceAreas);
    }
}
