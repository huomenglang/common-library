package com.menglang.common.library.common.exceptions.commonExeptions;

import com.menglang.common.library.common.exceptions.BaseException;

public class BadRequestException extends BaseException {
    public BadRequestException(String message) {
        super(message);
    }
}
