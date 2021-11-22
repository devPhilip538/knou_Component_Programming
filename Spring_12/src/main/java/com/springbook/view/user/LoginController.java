package com.springbook.view.user;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;
import org.springframework.web.bind.annotation.RequestMethod;

/* 오승필/202184-010073 */
@Controller
public class LoginController{
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login.do", method= RequestMethod.GET)
	public String loginView(UserVO vo, UserDAO userDAO) {
		logger.info("로그인화면 요청");
		return "login.jsp";
	}

	@RequestMapping(value = "/login.do", method= RequestMethod.POST)
	public String login(@ModelAttribute("user") UserVO vo, HttpSession session) {
		logger.info("로그인 요청");
		UserVO user = userService.getUser(vo);
		if (user != null) {
			session.setAttribute("userName", user.getName());
			return "getBoardList.do";
		} else {
			return "login.jsp";
		}
	}
}
