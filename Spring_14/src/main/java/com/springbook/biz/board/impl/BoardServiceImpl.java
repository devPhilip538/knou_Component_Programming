package com.springbook.biz.board.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
/* 오승필/202184-010073 */
@Service("boardService")
public class BoardServiceImpl implements BoardService {
	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);

	@Autowired
	private BoardDAO boardDAO;
//	private BoardDAOSpring boardDAO;
//	private BoardDAOMybatis boardDAO;

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