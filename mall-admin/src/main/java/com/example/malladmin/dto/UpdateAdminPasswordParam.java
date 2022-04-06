package com.example.malladmin.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UpdateAdminPasswordParam {
    @NotEmpty
    private String userName;
    @NotEmpty
    private String oldPassword;
    @NotEmpty
    private String newPassword;
}
