package com.menglang.common.library.builder;

import com.menglang.common.library.common.filter.FilterBy;
import com.menglang.common.library.common.filter.FilterGroup;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@AllArgsConstructor
public class FilterSpecification<T> {
    private final BuildFilter<T> buildFilter;

    public Specification<T> build(FilterGroup group) {
        if (group == null) return null;

        Specification<T> spec = null;

        if (group.getAND() != null) {
            for (FilterBy filter : group.getAND()) {
                spec = spec == null ? buildFilter.build(filter) : spec.and(buildFilter.build(filter));
            }
        }

        if (group.getOR() != null) {
            for (FilterBy filter : group.getOR()) {
                spec = spec == null ? buildFilter.build(filter) : spec.or(buildFilter.build(filter));
            }
        }

        if (group.getNOT() != null) {
            for (FilterBy filter : group.getNOT()) {
                Specification<T> notSpec = Specification.not(buildFilter.build(filter));
                spec = (spec ==null) ? notSpec : spec.and(notSpec);
            }
        }

        return spec;
    }


}
