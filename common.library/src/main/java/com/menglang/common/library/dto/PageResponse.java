package com.menglang.common.library.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.menglang.common.library.dto.pageDto.PageBody;
import com.menglang.common.library.dto.pageDto.StatusResponse;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class PageResponse implements Serializable {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private boolean success;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private StatusResponse status;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private PageBody content;

}
