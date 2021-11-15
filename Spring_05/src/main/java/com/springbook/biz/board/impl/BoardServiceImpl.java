package com.springbook.biz.board.impl;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
/* 오승필/202184-010073 */
public class BoardServiceImpl implements BoardService {
    private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
    private BoardDAO boardDAO;
    /* 오승필/202184-010073 */
    public void setBoardDAO(BoardDAO boardDAO) {
        logger.info("setBoardDAO() 호출");
        this.boardDAO = boardDAO;
    }
    /* 오승필/202184-010073 */
    @Override
    public void insertBoard(BoardVO vo) {
        logger.info("insertBoard() 호출");
        boardDAO.insertBoard(vo);
    }
    /* 오승필/202184-010073 */
    @Override
    public void updateBoard(BoardVO vo) {
        logger.info("updateBoard() 호출");
        boardDAO.updateBoard(vo);
    }
    /* 오승필/202184-010073 */
    @Override
    public void deleteBoard(BoardVO vo) {
        logger.info("deleteBoard() 호출");
        boardDAO.deleteBoard(vo);
    }
    /* 오승필/202184-010073 */
    @Override
    public BoardVO getBoardDetail(BoardVO vo) {
        logger.info("getBoardDetail() 호출");
        return boardDAO.getBoardDetail(vo);
    }
    /* 오승필/202184-010073 */
    @Override
    public List<BoardVO> getBoardList(BoardVO vo) {
        logger.info("getBoardList() 호출");
        return boardDAO.getBoardList(vo);
    }
}
