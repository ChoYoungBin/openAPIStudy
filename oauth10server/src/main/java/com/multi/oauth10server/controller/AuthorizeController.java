package com.multi.oauth10server.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.thinker.oauth.util.OAuthException;

import com.multi.oauth10server.model.RequestTokenVO;
import com.multi.oauth10server.model.UsersVO;
import com.multi.oauth10server.service.RequestTokenService;
import com.multi.oauth10server.service.UsersService;
import com.multi.oauth10server.util.SessionUtil;

@Controller
@RequestMapping(value = "/oauth/authorize")
public class AuthorizeController {

	@Autowired
	private RequestTokenService requestTokenService;

	@Autowired
	private UsersService usersService;

	@GetMapping
	public ModelAndView authorizeGet(HttpServletRequest request) throws Exception {
		//아래의 return 문을 삭제하고 코드를 작성합니다.
		return null;
	}

	@PostMapping
	public ModelAndView authorizePost(HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//아래의 return 문을 삭제하고 코드를 작성합니다.
		return null;
	}

}
