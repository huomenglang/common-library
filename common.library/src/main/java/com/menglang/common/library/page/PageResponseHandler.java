package com.menglang.common.library.page;

import com.menglang.common.library.page.paginate.PageInfo;
import com.menglang.common.library.page.paginate.BasePageResponse;
import com.menglang.common.library.page.paginate.PageBody;
import com.menglang.common.library.page.paginate.StatusResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public  class PageResponseHandler {

    private static final Logger log = LoggerFactory.getLogger(PageResponseHandler.class);

    public static ResponseEntity<PageResponse> error(Object error,String message, HttpStatusCode code){
        StatusResponse statusResponse=StatusResponse.builder()
                .code((short) code.value())
                .timeStamp(LocalDateTime.now())
                .message(message)
                .error(error)
                .build();
        PageResponse response= PageResponse.builder()
                .success(false)
                .status(statusResponse)
                .build();
        return ResponseEntity.ok(response);
    }

    public static ResponseEntity<PageResponse> failed(String message, HttpStatusCode code) {

        StatusResponse statusResponse=StatusResponse.builder()
                .code((short) code.value())
                .timeStamp(LocalDateTime.now())
                .message(message)
                .build();
        PageResponse response= PageResponse.builder()
                .success(false)
                .status(statusResponse)
                .build();
        return ResponseEntity.ok(response);
    }

    public static ResponseEntity<PageResponse> success(Object data, Page<?> page, String message) {
        StatusResponse statusResponse=StatusResponse.builder()
                .code((short) 200)
                .timeStamp(LocalDateTime.now())
                .message(message)
                .build();

        PageBody body=new PageBody();
        
        if(data instanceof BasePageResponse){
            body.setBody(data);
        } else if (data instanceof List<?>) {
            if (!((List<?>) data).isEmpty() && ((List<?>) data).getFirst() instanceof BasePageResponse) {
                body.setBody(data);
            }else {
                body.setBody(Collections.emptyList());
            }
        }

        if(page!=null){
            PageInfo pageInfo=PageInfo.builder()
                    .totalPage(page.getTotalPages())
                    .totalItems(page.getTotalElements())
                    .limit(page.getSize())
                    .hasPrevious(page.hasPrevious())
                    .hasNext(page.hasNext())
                    .currentPage(page.getNumber()+1)
                    .build();

             body.setPageInfo(pageInfo);
        }

        PageResponse response= PageResponse.builder()
                .success(true)
                .status(statusResponse)
                .content(body)
                .build();
        return ResponseEntity.ok(response);
    }
}
