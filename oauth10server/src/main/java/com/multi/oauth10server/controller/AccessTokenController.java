package com.multi.oauth10server.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.thinker.oauth.generator.TokenGenerator;
import org.thinker.oauth.parameter.AccessTokenParam;
import org.thinker.oauth.util.OAuthMsgConstants;

import com.multi.oauth10server.model.AccessTokenVO;
import com.multi.oauth10server.model.ConsumerVO;
import com.multi.oauth10server.model.RequestTokenVO;
import com.multi.oauth10server.model.UsersVO;
import com.multi.oauth10server.service.ConsumerService;
import com.multi.oauth10server.service.RequestTokenService;
import com.multi.oauth10server.service.UsersService;

@Controller
@RequestMapping(value = "/oauth/access_token")
public class AccessTokenController {

	@Autowired
	private RequestTokenService requestTokenService;

	@Autowired
	private UsersService usersService;

	@Autowired
	private ConsumerService consumerService;

	@GetMapping
	public ModelAndView getAccessToken(HttpServletRequest request) throws Exception {
		//아래의 return 문을 삭제하고 코드를 작성하세요.
		return null;
	}
}
