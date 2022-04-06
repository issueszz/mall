package com.example.malladmin.dto;


import lombok.Getter;
import lombok.Setter;

public class PmsProductResult extends PmsProductParam {
    @Getter
    @Setter
    /*商品分类父id*/
    private Long cateParentId;
}
