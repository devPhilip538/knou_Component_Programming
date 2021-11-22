package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.view.board.DeleteBoardController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;
/* 오승필/202184-010073 */
@Controller
public class LoginController{
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value="/loign.do")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		logger.info("로그인 호출");
		   //1. 사용자 입력정보(id, password)추출
			String id = request.getParameter("id");
			String password = request.getParameter("password"); //2. DB 연동
			//3. 적절한 화면으로 이동
			ModelAndView mav = new ModelAndView();
			// 로그인 id, password 가져오
			// DB 연동처리(id/pw) 조회
			UserVO vo = new UserVO();
			vo.setId(id);
			vo.setPassword(password);
	
			UserDAO userDAO = new UserDAO();
			UserVO user = userDAO.getUser(vo);
			// 로그인 처리 여부
			if (user != null) {
				mav.setViewName("redirect:getBoardList.do");
			} else {
				mav.setViewName("redirect:login.jsp");
			}
			return mav;
	}
}
