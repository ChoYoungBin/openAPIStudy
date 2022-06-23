package com.multi.oauth10client.servlet;

import com.multi.oauth10client.Setup;
import org.springframework.web.servlet.HttpServletBean;
import org.thinker.oauth.ResourceTokenVO;
import org.thinker.oauth.TokenSender;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class OAuth10ResourceServlet extends HttpServletBean {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession();
            String AT = (String) session.getAttribute("AT");
            String ATS = (String) session.getAttribute("ATS");

            ResourceTokenVO vo = new ResourceTokenVO();
            vo.setMethod("GET");
            vo.setRequestURL(Setup.RESOURCE_URL);
            vo.setConsumerKey(Setup.CONSUMER_KEY);
            vo.setConsumerSecretKey(Setup.CONSUMER_SECRET);
            vo.setRequestOauthToken(AT);
            vo.setRequestOauthTokenSecret(ATS);
            vo.sign();

            TokenSender sender = new TokenSender();
            sender.sendHttpClient(vo);

            String result = vo.getResult();

            resp.setContentType("application/json");
            resp.getWriter().print(result);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
