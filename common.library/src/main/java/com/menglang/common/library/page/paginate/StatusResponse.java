package com.menglang.common.library.page.paginate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class StatusResponse {
    private Short code;
    private LocalDateTime timeStamp;
    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object error;

}
