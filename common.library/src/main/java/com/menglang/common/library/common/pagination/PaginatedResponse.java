package com.menglang.common.library.common.pagination;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.menglang.common.library.common.filter.FilterBy;
import jakarta.annotation.Nullable;
import lombok.Data;

import java.util.List;

@Data
public class PaginatedResponse<T> {
    private List<T> data;
    private PageInfo pagination;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private SortBy sort;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private FilterBy filters;
}
