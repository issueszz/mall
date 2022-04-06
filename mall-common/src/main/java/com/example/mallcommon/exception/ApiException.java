package com.example.mallcommon.exception;

import com.example.mallcommon.api.CommonCode;

public class ApiException extends RuntimeException{
    private CommonCode commonCode;

    public ApiException(CommonCode commonCode) {
        super(commonCode.getMessage());
        this.commonCode = commonCode;
    }

    public ApiException(String message) {
        super(message);
    }

    public CommonCode getCommonCode() {
        return commonCode;
    }
}
