package com.springbook.biz.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/* 오승필/202184-010073 */
@Controller
public class LogoutController {
    private static final Logger logger = LoggerFactory.getLogger(LogoutController.class);

    @RequestMapping("/logout.do")
    public String logout(HttpSession session) {
        logger.info("로그아웃 처리");
        session.invalidate();
        return "login.jsp";
    }
}
