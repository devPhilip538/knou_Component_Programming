package com.springbook.view.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/* 오승필/202184-010073 */
public class LogoutController implements Controller {
    private static final Logger logger = LoggerFactory.getLogger(LogoutController.class);
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info("로그아웃 처리");
        // 로그아웃
        HttpSession session = request.getSession();
        session.invalidate();

        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:login.jsp");
        return mav;
    }
}
