package com.springbook.biz.board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class BoardServiceClient {
    private static final Logger logger = LoggerFactory.getLogger(BoardServiceClient.class);
    /* 오승필/202184-010073 */
    public static void main(String[] args) {
        AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");

        BoardService boardService = (BoardService) container.getBean("boardService");

        BoardVO vo = new BoardVO();
        vo.setTitle("정보과학과3");
        vo.setWriter("오승필3");
        vo.setContent("202184-010073");

        boardService.insertBoard(vo);

        List<BoardVO> boardList = boardService.getBoardList(vo);
        for (BoardVO board : boardList) {
            logger.info(board.toString());
        }
    }
}
