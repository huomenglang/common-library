package com.menglang.common.library.page.paginate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SortBy {
    private String field;
    private String direction;
}
