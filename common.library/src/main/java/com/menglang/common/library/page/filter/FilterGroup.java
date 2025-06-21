package com.menglang.common.library.page.filter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilterGroup {
    private List<FilterBy> AND;
    private List<FilterBy> OR;
    private List<FilterBy> NOT;
}
