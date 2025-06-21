package com.menglang.common.library.common.queryBuilder;
import com.menglang.common.library.common.filter.FilterBy;
import com.menglang.common.library.common.filter.FilterType;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class QueryParamParser {
    private static final Set<String> IGNORE_PARAMS=Set.of("page","size","sort");

    public static List<FilterBy> parse(Map<String,String> queryParams){
        return queryParams.entrySet().stream().filter(q->!IGNORE_PARAMS.contains(q.getKey()))
                .map(q->{
                    String[] parts=q.getKey().split("_");
                    String field=parts[0];
                    String operator=parts.length>1?parts[1].toLowerCase():"EQUAL";
                    return new FilterBy(field, q.getValue(),FilterType.valueOf(operator));
                }).toList();
    }


    /*------------- example in microservice simple filter--------------------------------
    //GET /api/products?name_like=phone&category_eq=electronics&price_gte=100&price_lte=1000&sort=price,asc&page=0&size=5
   public Page<Product> search(Map<String, String> params, Pageable pageable) {
       List<FilterRequest> filters = QueryParamParser.parse(params);
       Specification<Product> spec = new BaseSpecification<>(filters);
       return productRepository.findAll(spec, pageable);
   }

   **- ----future build with AND , OR complex query filter and use method POST

   {
  "and": [
    { "field": "name", "operator": "like", "value": "phone" }
  ],
  "or": [
    { "field": "category", "operator": "eq", "value": "electronics" },
    { "field": "category", "operator": "eq", "value": "gadgets" }
  ]
}

     */





}
