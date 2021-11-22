package com.springbook.view.board;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.biz.board.impl.BoardDAOSpring;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/* 오승필/202184-010073 */
public class DeleteBoardController implements Controller {
    private static final Logger logger = LoggerFactory.getLogger(DeleteBoardController.class);

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info("글 삭제 처리");
        // 삭제할 글번호 가져오기
        String seq = request.getParameter("seq");

        // DB 연동 처리
        BoardVO vo = new BoardVO();
        vo.setSeq(Integer.parseInt(seq));

        BoardDAO boardDAO = new BoardDAO();
        boardDAO.deleteBoard(vo);

        ///
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:getBoardList.do");
        return mav;
    }
}
