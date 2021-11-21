package com.springbook.view.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

/**
 * Servlet implementation class DispatcherServlet
 */
//<!-- /* 오승필/202184-010073 */ -->
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Date time = new Date();
	private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
//        Date date = new Date();
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("DispatcherServlet 생성" + formatter.format(time));
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		<!-- /* 오승필/202184-010073 */ -->
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		<!-- /* 오승필/202184-010073 */ -->
		// TODO Auto-generated method stub
//		doGet(request, response);
		request.setCharacterEncoding("euc-kr");
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		<!-- /* 오승필/202184-010073 */ -->
		System.out.println("오승필/202184-010073/" + formatter.format(time) + "/");
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		if(path.equals("/login.do")){
			System.out.println("오승필/202184-010073/" + formatter.format(time) + "/ 로그인 처리");
			// 로그인 id, password 가져오
			String id = request.getParameter("id");
			String password = request.getParameter("password");

			// DB 연동처리(id/pw) 조회
			UserVO vo = new UserVO();
			vo.setId(id);
			vo.setPassword(password);

			UserDAO userDAO = new UserDAO();
			UserVO user = userDAO.getUser(vo);
			// 로그인 처리 여부
			if (user != null) {
				response.sendRedirect("getBoardList.do");
			} else {
				response.sendRedirect("login2.jsp");
			}
		} else if(path.equals("/logout.do")){
			System.out.println("오승필/202184-010073/" + formatter.format(time) + "/ 로그아웃 처리");
			// 로그아웃
			HttpSession session = request.getSession(); 
			session.invalidate();
			response.sendRedirect("login2.jsp");
		} else if(path.equals("/insertBoard.do")){
			System.out.println("오승필/202184-010073/" + formatter.format(time) + "/ 글 등록 처리");

			// 입력한 제목,본문,작성자 가져오기글
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");

			// DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);

			BoardDAO boardDAO = new BoardDAO();
			boardDAO.insertBoard(vo);

			// 게시판 리스트로 이동
			response.sendRedirect("getBoardList.do");
		} else if(path.equals("/updateBoard.do")){
			System.out.println("오승필/202184-010073/" + formatter.format(time) + "/ 글 수정 처리");
			// 입력한 제목,본문,작성자 가져오기글
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String seq = request.getParameter("seq");

			// DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setContent(content);
			vo.setSeq(Integer.parseInt(seq));

			BoardDAO boardDAO = new BoardDAO();
			boardDAO.updateBoard(vo);
			// 게시판 리스트로 이동
			response.sendRedirect("getBoardList.do");
		} else if(path.equals("/deleteBoard.do")){
			System.out.println("오승필/202184-010073/" + formatter.format(time) + "/ 글 삭제 처리");
			// 삭제할 글번호 가져오기
			String seq = request.getParameter("seq");

			// DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.deleteBoard(vo);

			// 게시판 리스트로 이동
			response.sendRedirect("getBoardList.do");
		} else if(path.equals("/getBoard.do")){
			System.out.println("오승필/202184-010073/" + formatter.format(time) + "/ 글 상세 조회 처리");
			// 글 상세 seq 번호
			String seq = request.getParameter("seq");

			// DB 연동처리
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));

			BoardDAO boardDAO = new BoardDAO();
			BoardVO board = boardDAO.getBoardDetail(vo);

			HttpSession session = request.getSession();
			session.setAttribute("board", board);

			// 게시판 상세 리스트로 이동
			response.sendRedirect("getBoard2.jsp");
		} else if(path.equals("/getBoardList.do")){
			System.out.println("오승필/202184-010073/" + formatter.format(time) + "/ 글 목록 검색 처리");
			//DB 연동처리
			BoardVO vo = new BoardVO();
			BoardDAO boardDAO = new BoardDAO();
			List<BoardVO> boardList = boardDAO.getBoardList(vo);
			// 검색 결과를 세션에 저장하고 목록 화면으로 이동 
			HttpSession session = request.getSession(); 
			session.setAttribute("boardList", boardList); 
			response.sendRedirect("getBoardList2.jsp");
		}
	 }
}
