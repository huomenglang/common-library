package com.menglang.common.library.builder;

import com.menglang.common.library.common.filter.FilterBy;
import com.menglang.common.library.common.filter.FilterValueType;
import jakarta.persistence.criteria.Path;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.util.List;

public class BuildFilter<T> {
    public Specification<T> build(FilterBy filter) {
        return (root, query, cb) -> {
            Path<?> path = root.get(filter.getField());
            Object value = convertValue(path, filter.getValue(), filter.getValueType());
            switch (filter.getType()) {
                case EQUALS:
                    return cb.equal(path, value);
                case CONTAINS:
                    return cb.like(cb.lower(root.get(filter.getField())), "%" + value.toString().toLowerCase() + "%");
                case STARTS_WITH:
                    return cb.like(path.as(String.class), value + "%");
                case ENDS_WITH:
                    return cb.like(path.as(String.class), "%" + value);
                case GT:
                    return cb.gt(root.get(filter.getField()), (Number) value);
                case GTE:
                    return cb.ge(root.get(filter.getField()), (Number) value);
                case LT:
                    return cb.lt(root.get(filter.getField()), (Number) value);
                case LTE:
                    return cb.le(root.get(filter.getField()), (Number) value);
                case IN:
                    return path.in(List.of(value));
                case NOT_IN:
                    return cb.not(path.in(List.of(value)));
                case NOT:
                    return cb.notEqual(path, value);
                default:
                    return cb.equal(path, value);
            }
        };
    }

    private Object convertValue(Path<?> path, String value, FilterValueType valueType) {
        Class<?> type = path.getJavaType();

        switch (valueType) {
            case INT:
                return Integer.valueOf(value);
            case NUMBER:
                return Double.valueOf(value);
            case BOOLEAN:
                return Boolean.valueOf(value);
            case DATE:
                return LocalDate.parse(value);
            default:
                return value;
        }
    }
}
