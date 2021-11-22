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
public class GetBoardController implements Controller {
    private static final Logger logger = LoggerFactory.getLogger(GetBoardController.class);
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info("글 상세 조회 처리");
        // 글 상세 seq 번호
        String seq = request.getParameter("seq");

        // DB 연동처리
        BoardVO vo = new BoardVO();
        vo.setSeq(Integer.parseInt(seq));

        BoardDAO boardDAO = new BoardDAO();
        BoardVO board = boardDAO.getBoardDetail(vo);

        // Model And View
        ModelAndView mav = new ModelAndView();
        mav.addObject("board", board);
        mav.setViewName("getBoard");
        return mav;
    }
}
