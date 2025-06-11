package com.menglang.common.library.utils;

import com.menglang.common.library.common.order.OrderDirection;
import com.menglang.common.library.common.pagination.PageInfo;
import com.menglang.common.library.common.pagination.PageRequestDto;
import com.menglang.common.library.common.pagination.PaginatedResponse;
import com.menglang.common.library.common.pagination.SortBy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PageUtils {



    public static <T> PaginatedResponse<T> fromPage(Page<T> page) {

        PaginatedResponse<T> response = new PaginatedResponse<>();
        PageInfo pageInfo = PageInfo.builder().currentPage(page.getNumber()).totalPage(page.getTotalPages()).hasNext(page.hasNext()).hasPrevious(page.hasPrevious()).limit(page.getSize()).build();
        SortBy sort = SortBy.builder().field("name").direction(Sort.Direction.DESC.toString()).build();
        response.setData(page.getContent());
        response.setPagination(pageInfo);
        response.setSort(sort);

        return response;

    }

    public static Pageable toPageable(PageRequestDto dto) {
        if (dto.getOrderBy() == null || dto.getOrderBy().isEmpty()) {
            return PageRequest.of(dto.getPage(), dto.getSize());
        }
        Sort sort = Sort.by(dto.getOrderBy().stream().map(order -> new Sort.Order(order.getDirection() == OrderDirection.DESC ? Sort.Direction.DESC : Sort.Direction.ASC, order.getField())).toList());
        return PageRequest.of(dto.getPage(), dto.getSize(), sort);
    }
}
