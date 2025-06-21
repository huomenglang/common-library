package com.menglang.common.library.page;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.menglang.common.library.page.paginate.PageBody;
import com.menglang.common.library.page.paginate.StatusResponse;
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
