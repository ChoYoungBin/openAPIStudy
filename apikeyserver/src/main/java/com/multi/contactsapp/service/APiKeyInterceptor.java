package com.multi.contactsapp.service;

import com.multi.contactsapp.openapi.ApiKeyProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class APiKeyInterceptor implements HandlerInterceptor {

    @Autowired
    private ApiKeyProcessor keyService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        keyService.checkApiKey((String) request.getHeader("Origin"), request.getParameter("key"));

        return true;
    }
}
