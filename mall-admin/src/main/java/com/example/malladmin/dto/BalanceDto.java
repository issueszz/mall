package com.example.malladmin.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BalanceDto {
    private String dealDate;
    private BigDecimal dealAmount;
}
