package com.multi.contactsapp.util;

import com.multi.contactsapp.domain.ApiErrorInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {ApiException.class})
    @ResponseBody
    public ResponseEntity<ApiErrorInfo> handlerApiException(ApiException e){

        ApiErrorInfo info = new ApiErrorInfo();
        info.setStatus(e.getStatus());
        info.setMessage("@ControllerAdvice"+ e.getMessage());

        return new ResponseEntity<>(info, HttpStatus.BAD_REQUEST);
    }

}
