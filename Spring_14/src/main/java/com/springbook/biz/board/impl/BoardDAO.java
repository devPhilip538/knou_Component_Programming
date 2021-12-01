package com.springbook.biz.board.impl;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.util.SqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import java.util.List;
/* 오승필/202184-010073 */
@Repository
public class BoardDAO {
    private static final Logger logger = LoggerFactory.getLogger(BoardDAO.class);
    private SqlSession mybatis;
    public BoardDAO() {
        mybatis = SqlSessionFactoryBean.getSqlSessionInstance();
    }
    /* 오승필/202184-010073 */
    // CRUD 기능의 메소드 구현
    // 글 등록
    public void insertBoard(BoardVO vo) {
        logger.info("===> mybatis로 insertBoard() 기능 처리");
        mybatis.insert("BoardDAO.insertBoard", vo);
    }
    /* 오승필/202184-010073 */
    // 글 수정
    public void updateBoard(BoardVO vo) {
        logger.info("===> mybatis로 updateBoard() 기능 처리");
        mybatis.update("BoardDAO.updateBoard", vo);
    }

    /* 오승필/202184-010073 */
    // 글 삭제
    public void deleteBoard(BoardVO vo) {
        logger.info("===> mybatis로 deleteBoard() 기능 처리");
        mybatis.delete("BoardDAO.deleteBoard", vo);
    }
    /* 오승필/202184-010073 */
    // 글 상세조회
    public BoardVO  getBoardDetail(BoardVO vo) {
        logger.info("===> mybatis로 getBoardDetail() 기능 처리");
        return (BoardVO) mybatis.selectOne("BoardDAO.getBoard", vo);
    }

    /* 오승필/202184-010073 */
    // 글 목록 조회
    public List<BoardVO> getBoardList(BoardVO vo) {
        logger.info("===> mybatis로 getBoardList() 기능 처리");
        return mybatis.selectList("BoardDAO.getBoardList", vo);
    }
}
