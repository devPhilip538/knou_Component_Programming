package com.springbook.view.board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

@Controller
public class BoardController {
    private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
    
    @Autowired
    private BoardService boardService;

    @RequestMapping("/insertBoard.do")
    public String insertBoard(BoardVO vo) {
        logger.info("게시판 등록");
        boardService.insertBoard(vo);
        return "getBoardList.do";
    }

    @RequestMapping("/getBoardList.do")
    public ModelAndView getBoardList(BoardVO vo, ModelAndView mav) {
        logger.info("게시판 리스트 요청");
        mav.addObject("boardList", boardService.getBoardList(vo));
        mav.setViewName("getBoardList.jsp");
        return mav;
    }

    @RequestMapping("deleteBoard.do")
    public String deleteBoard (BoardVO vo) {
        logger.info("글 삭제 처리");
        boardService.deleteBoard(vo);
        return "getBoardList.do";
    }

    @RequestMapping("getBoard")
    public ModelAndView getBoard (BoardVO vo, ModelAndView mav) {
        mav.addObject("board", boardService.getBoardDetail(vo));
        mav.setViewName("getBoard.jsp");
        return mav;
    }

    @RequestMapping("updateBoard.do")
    public String updateBoard (BoardVO vo) {
        boardService.updateBoard(vo);
        return "getBoardList.do";
    }

}
