package com.menglang.common.library.page.order;

import lombok.Data;

@Data
public class OrderBy {
    private String field;

    // Default direction is ASC if not specified
    private OrderDirection direction = OrderDirection.ASC;
}
