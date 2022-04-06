package com.example.mallcommon.exception;

import com.example.mallcommon.api.CommonCode;

public class Asserts {
    public static void fail(String message) {
        throw new ApiException(message);
    }
    public static void fail(CommonCode commonCode) {
        throw new ApiException(commonCode);
    }
}
