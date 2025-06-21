package com.menglang.common.library.dto.pageDto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.menglang.common.library.common.filter.FilterBy;
import com.menglang.common.library.common.pagination.PageInfo;
import com.menglang.common.library.common.pagination.SortBy;
import lombok.Data;

import java.util.List;

@Data
public class PageBody {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object body;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private PageInfo pageInfo;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<SortBy> sort;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<FilterBy> filters;


}
