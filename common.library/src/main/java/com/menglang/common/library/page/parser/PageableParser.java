package com.menglang.common.library.page.parser;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PageableParser {
    public static Pageable from(Map<String,String> queryParams){
        int page = parseIntOrDefault(queryParams.get("page"), 0);
        int size = parseIntOrDefault(queryParams.get("size"), 10);

        List<Sort.Order> orders = new ArrayList<>();

        queryParams.entrySet().stream().filter(s->s.getKey().equalsIgnoreCase("sort"))
                .flatMap(entry-> Arrays.stream(entry.getValue().split(",")))
                .forEach(value->{
                   // sort=price,asc&sort=name,desc&page=0&size=10
                    String[] parts=value.split(",");
                    if(parts.length==2){
                        orders.add(new Sort.Order(Sort.Direction.fromString(parts[1]),parts[0]));
                    } else if (parts.length==1) {
                        orders.add(new Sort.Order(Sort.Direction.DESC,parts[0]));
                    }
                });

        Sort sort=orders.isEmpty()?Sort.unsorted():Sort.by(orders);
        return PageRequest.of(page,size,sort);

    }

    private static int parseIntOrDefault(String val, int defaultVal) {
        try {
            return val != null ? Integer.parseInt(val) : defaultVal;
        } catch (NumberFormatException e) {
            return defaultVal;
        }
    }


    /*
    @GetMapping
        public Page<Product> search(
           @RequestParam Map<String, String> params
        ) {
    Pageable pageable = PageableBuilder.from(params);
    List<FilterRequest> filters = QueryParamParser.parse(params);
    Specification<Product> spec = new BaseSpecification<>(filters);
    return productRepository.findAll(spec, pageable);
     }
     */
}
