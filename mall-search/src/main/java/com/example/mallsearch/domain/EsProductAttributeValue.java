package com.example.mallsearch.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

@Setter
@Getter
public class EsProductAttributeValue implements Serializable {
    private static final long serivalVersionUID = 1L;
    private Long id;
    private Long productAttributeId;
    /*属性值*/
    @Field(type = FieldType.Keyword)
    private String value;
    /*属性参数： 0->规格； 1->参数*/
    private Integer type;
    /*属性名称*/
    private String name;
}
