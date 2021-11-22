package com.springbook.view.board;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
/* 오승필/202184-010073 */
public class GetBoardListController implements Controller {
    private static final Logger logger = LoggerFactory.getLogger(GetBoardListController.class);
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info("게시판 리스트 요청");
        //DB 연동처리
        BoardVO vo = new BoardVO();
        BoardDAO boardDAO = new BoardDAO();
        List<BoardVO> boardList = boardDAO.getBoardList(vo);
        // 검색 결과를 세션에 저장하고 목록 화면으로 이동
        ModelAndView mav = new ModelAndView();
        mav.addObject("boardList", boardList);
        mav.setViewName("getBoardList");
        return mav;
    }
}
