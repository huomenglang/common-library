package com.menglang.common.library.common.pagination;

import com.menglang.common.library.common.filter.FilterBy;
import jakarta.annotation.Nullable;
import lombok.Data;

import java.util.List;

@Data
public class PaginatedResponse<T> {
    private List<T> data;
    private PageInfo pagination;
    private SortBy sort;
    @Nullable
    private FilterBy filters;
}
