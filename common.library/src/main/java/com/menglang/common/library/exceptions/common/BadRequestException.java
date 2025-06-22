package com.menglang.common.library.exceptions.common;

import com.menglang.common.library.exceptions.BaseException;

public class BadRequestException extends BaseException {
    public BadRequestException(String message) {
        super(message);
    }

}
