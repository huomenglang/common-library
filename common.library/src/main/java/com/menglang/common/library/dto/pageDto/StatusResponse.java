package com.menglang.common.library.dto.pageDto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class StatusResponse {
    private Short code;
    private LocalDateTime timeStamp;
    private String message;
}
