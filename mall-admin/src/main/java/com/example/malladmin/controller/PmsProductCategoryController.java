package com.example.malladmin.controller;

import com.example.malladmin.dto.PmsProductCategoryWithChildrenItem;
import com.example.malladmin.service.PmsProductCategoryService;
import com.example.mallcommon.api.CommonPage;
import com.example.mallcommon.api.CommonResult;
import com.example.mallmbg.model.PmsProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productCategory")
public class PmsProductCategoryController {
    @Autowired
    private PmsProductCategoryService categoryService;

    /*分页查询商品列表*/
    @GetMapping("/list/{parentId}")
    public CommonResult<CommonPage<PmsProductCategory>> getList(@PathVariable Long parentId,
                                                                @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<PmsProductCategory> pmsProductCategoryList = categoryService.getList(parentId, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(pmsProductCategoryList));
    }

    @GetMapping("/list/withChildren")
    public CommonResult<List<PmsProductCategoryWithChildrenItem>> listWithChildren() {
        List<PmsProductCategoryWithChildrenItem> list = categoryService.listWithChildren();
        return CommonResult.success(list);
    }
}
