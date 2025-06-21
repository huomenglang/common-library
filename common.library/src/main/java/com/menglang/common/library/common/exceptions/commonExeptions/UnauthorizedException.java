package com.menglang.common.library.common.exceptions.commonExeptions;

import com.menglang.common.library.common.exceptions.BaseException;

public class UnauthorizedException extends BaseException {
    public UnauthorizedException(String message){
        super(message);
    }
}
