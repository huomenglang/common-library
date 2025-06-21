package com.menglang.common.library.page.filter;

import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FilterDate {

    @Pattern(regexp = "\\d+", message = "Start date must be a string of digits")
    private String startDate;

    @Pattern(regexp = "\\d+", message = "End date must be a string of digits")
    private String endDate;
}

