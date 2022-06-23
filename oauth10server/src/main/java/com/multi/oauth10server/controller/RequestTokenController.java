package com.multi.oauth10server.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.thinker.oauth.generator.TokenGenerator;
import org.thinker.oauth.parameter.RequestTokenParam;

import com.multi.oauth10server.model.ConsumerVO;
import com.multi.oauth10server.model.RequestTokenVO;
import com.multi.oauth10server.service.ConsumerService;
import com.multi.oauth10server.service.RequestTokenService;

@Controller
@RequestMapping(value = "/oauth/request_token")
public class RequestTokenController {

	@Autowired
	private ConsumerService consumerService;

	@Autowired
	private RequestTokenService requestTokenService;

	@GetMapping
	public ModelAndView requestToken(HttpServletRequest request) throws Exception {
		// 아래의 return 문을 삭제하고 코드를 작성합니다. 
		return null;
	}
}
