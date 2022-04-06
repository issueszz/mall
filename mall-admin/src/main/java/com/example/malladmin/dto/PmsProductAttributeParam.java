package com.example.malladmin.dto;

import com.example.malladmin.validator.FlagValidator;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.validation.constraints.NotEmpty;

@Data
@EqualsAndHashCode(callSuper = false)
public class PmsProductAttributeParam {
    /*属性分类ID*/
    @NotEmpty
    private Long productAttributeCategoryId;

    /*属性名称*/
    @NotEmpty
    private String name;

    /*属性选择类型：0->唯一；1->单选；2->多选*/
    @FlagValidator({"0","1","2"})
    private Integer selectType;

    /*属性录入方式：0->手工录入；1->从列表中选取*/
    @FlagValidator({"0","1"})
    private Integer inputType;

    /*可选值列表，以逗号隔开*/
    private String inputList;

    private Integer sort;

    /*分类筛选样式：0->普通；1->颜色*/
    @FlagValidator({"0","1"})
    private Integer filterType;

    /*检索类型；0->不需要进行检索；1->关键字检索；2->范围检索*/
    @FlagValidator({"0","1","2"})
    private Integer searchType;

    /*相同属性产品是否关联；0->不关联；1->关联*/
    @FlagValidator({"0","1"})
    private Integer relatedStatus;

    /*是否支持手动新增；0->不支持；1->支持*/
    @FlagValidator({"0","1"})
    private Integer handAddStatus;

    /*属性的类型；0->规格；1->参数*/
    @FlagValidator({"0","1"})
    private Integer type;
}
