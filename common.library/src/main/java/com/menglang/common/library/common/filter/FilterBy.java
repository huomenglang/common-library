package com.menglang.common.library.common.filter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilterBy {
    private String field;
    private String value;
    private FilterType type = FilterType.EQUALS;
}
