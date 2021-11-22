package com.springbook.view.board;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/* 오승필/202184-010073 */
public class InsertBoardController implements Controller {
    private static final Logger logger = LoggerFactory.getLogger(InsertBoardController.class);
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info("글 등록 처리");
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

        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:getBoardList.do");

        return mav;
    }
}
