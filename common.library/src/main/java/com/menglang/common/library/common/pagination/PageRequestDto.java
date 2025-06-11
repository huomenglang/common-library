package com.menglang.common.library.common.pagination;

import com.menglang.common.library.common.order.OrderBy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageRequestDto {
    private int page = 0;
    private int size = 10;
    private List<OrderBy> orderBy;
}
