package com.multi.contactsapp.util;

import com.multi.contactsapp.openapi.ApiKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {ApiKeyException.class})
    @ResponseBody
    public ResponseEntity<ApiErrorInfo> handleApiKeyException(ApiKeyException e) {
        ApiErrorInfo error = new ApiErrorInfo("API Key 처리 오류 : " + e.getMessage(), e.getStatus());
        ResponseEntity<ApiErrorInfo> entity =
                new ResponseEntity<ApiErrorInfo>(error, HttpStatus.UNAUTHORIZED);
        return entity;
    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    public ResponseEntity<ApiErrorInfo> handleCustomException(Exception e) {
        ApiErrorInfo error = new ApiErrorInfo("서버측 처리 오류 : " + e.getMessage(), "E100");
        ResponseEntity<ApiErrorInfo> entity =
                new ResponseEntity<ApiErrorInfo>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        return entity;
    }
}
