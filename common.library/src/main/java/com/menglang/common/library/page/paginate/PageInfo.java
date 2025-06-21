package com.menglang.common.library.page.paginate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PageInfo {
    private int currentPage;
    private int totalPage;
    private Long totalItems;
    private int limit;
    private boolean hasNext;
    private boolean hasPrevious;

}
