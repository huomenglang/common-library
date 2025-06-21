package com.menglang.common.library.page.paginate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.menglang.common.library.page.filter.FilterBy;
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
