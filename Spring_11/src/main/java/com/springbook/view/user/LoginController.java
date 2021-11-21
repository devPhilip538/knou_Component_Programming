package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

public class LoginController implements Controller {
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("1111111111");
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
			mav.setViewName("getBoardList.do");
		} else {
			mav.setViewName("login2.jsp");
		}
		return mav;
	}
}
