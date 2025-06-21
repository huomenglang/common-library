package com.menglang.common.library.exceptions.common;

import com.menglang.common.library.exceptions.BaseException;

public class UnauthorizedException extends BaseException {
    public UnauthorizedException(String message){
        super(message);
    }
}
