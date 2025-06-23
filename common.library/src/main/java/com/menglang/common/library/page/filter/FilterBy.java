package com.menglang.common.library.page.filter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilterBy {
    private String field;
    private String value;
    private FilterType type = FilterType.EQ;
}
