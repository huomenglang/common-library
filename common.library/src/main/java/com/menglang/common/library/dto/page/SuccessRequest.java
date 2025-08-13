package com.menglang.common.library.dto.page;

import org.springframework.data.domain.Page;

public record SuccessRequest(
        Object data,
        Page<?> page,
        Short code,
        String message
) {

}
