package com.multi.oauth10client.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HttpServletBean;
import org.thinker.oauth.ResourceTokenVO;
import org.thinker.oauth.TokenSender;

import com.multi.oauth10client.Setup;

public class OAuth10ResourceServlet extends HttpServletBean {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//이곳에 코드를 작성합니다.
	}

}
