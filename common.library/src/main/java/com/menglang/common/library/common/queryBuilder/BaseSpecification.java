package com.menglang.common.library.common.queryBuilder;

import com.menglang.common.library.common.filter.FilterBy;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BaseSpecification<T> implements Specification<T> {

    private final List<FilterBy> filters;

    public BaseSpecification(List<FilterBy> filters) {
        this.filters = filters;
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        List<Predicate> predicates=new ArrayList<>();

        for (FilterBy filter:filters){
            Path<?> path=root.get(filter.getField());
            Object value= this.castToFieldType(path.getJavaType(),filter.getValue());

            switch (filter.getType()) {
                case CONTAINS ->
                        predicates.add(cb.like(cb.lower(root.get(filter.getField())), "%" + value.toString().toLowerCase() + "%"));
                case STARTS_WITH ->predicates.add(cb.like(path.as(String.class), value + "%")) ;
                case ENDS_WITH ->predicates.add(cb.like(path.as(String.class), "%" + value));
                case GT -> predicates.add(cb.gt(root.get(filter.getField()), (Number) value));
                case GTE ->predicates.add(cb.ge(root.get(filter.getField()), (Number) value));
                case LT ->predicates.add(cb.lt(root.get(filter.getField()), (Number) value));
                case LTE ->predicates.add(cb.le(root.get(filter.getField()), (Number) value));
                case IN ->predicates.add(path.in(List.of(value)));
                case NOT_IN ->predicates.add(cb.not(path.in(List.of(value))));
                case NOT ->predicates.add(cb.notEqual(path, value));
                default ->predicates.add(cb.equal(path, value));
            }
        }
        return cb.and(predicates.toArray(new Predicate[0]));
    }


    private Object castToFieldType(Class<?> type, String value) {
        if (type.equals(String.class)) return value;
        if (type.equals(Integer.class) || type.equals(int.class)) return Integer.valueOf(value);
        if (type.equals(Long.class) || type.equals(long.class)) return Long.valueOf(value);
        if (type.equals(Double.class) || type.equals(double.class)) return Double.valueOf(value);
        if (type.equals(LocalDate.class)) return LocalDate.parse(value);
        return value;
    }
   }
