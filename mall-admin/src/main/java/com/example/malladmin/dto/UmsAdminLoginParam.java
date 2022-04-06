package com.example.malladmin.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UmsAdminLoginParam {
    @NotEmpty
    private String username;

    @NotEmpty
    private String password;
}
