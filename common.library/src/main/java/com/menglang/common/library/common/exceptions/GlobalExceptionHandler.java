package com.menglang.common.library.common.exceptions;

import com.menglang.common.library.common.exceptions.commonExeptions.*;
import com.menglang.common.library.dto.PageResponse;
import com.menglang.common.library.dto.PageResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<PageResponse> handleBadRequestException(BadRequestException e){
        return PageResponseHandler.failed(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DuplicateRequestException.class)
    public ResponseEntity<PageResponse> handleDuplicateRequestException(DuplicateRequestException e) {
        return PageResponseHandler.failed(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<PageResponse> handleForBiddenException(ForbiddenException e) {
        return PageResponseHandler.failed(e.getMessage(), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<PageResponse> handleNotFoundException(NotFoundException e) {
        return PageResponseHandler.failed(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InternalServerException.class)
    public ResponseEntity<PageResponse> handleInternalServerException(InternalServerException e){
        return PageResponseHandler.failed(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<PageResponse> handleConflictException(ConflictException e){
        return PageResponseHandler.failed(e.getMessage(),HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<PageResponse> handleUnauthorizedException(UnauthorizedException ex){
        return PageResponseHandler.failed(ex.getMessage(),HttpStatus.UNAUTHORIZED);
    }

}
