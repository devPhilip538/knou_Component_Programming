package com.springbook.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

/* 오승필/202184-010073 */
@Repository
public class BoardDAOSpring {
	private static final Logger logger = LoggerFactory.getLogger(BoardDAOSpring.class);
	/* 오승필/202184-010073 */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String BOARD_INSERT = "insert into board(title, writer, content) values(?,?,?)";
	private final String BOARD_UPDATE = "update board set title=?, content=? where seq=?";
	private final String BOARD_DELETE = "delete board where seq=?";
	private final String BOARD_GET    = "select * from board where seq=?";
	private final String BOARD_LIST   = "select * from board order by seq desc";

 	/* 오승필/202184-010073 */
 	public void insertBoard(BoardVO vo) {
		logger.info("BoardDAOSpring ===> JDBC로 insertBoard() 기능 처리");
 		this.jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
 	}
	/* 오승필/202184-010073 */
 	public void updateBoard(BoardVO vo) {
		logger.info("BoardDAOSpring ===> JDBC로 updateBoard() 기능 처리");
 		jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getWriter(), vo.getSeq());
 	}
	/* 오승필/202184-010073 */
 	public void deleteBoard(BoardVO vo) {
		logger.info("BoardDAOSpring ===> JDBC로 deleteBoard() 기능 처리");
 		jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
 	}
	/* 오승필/202184-010073 */
 	public BoardVO getBoard(BoardVO vo) {
		logger.info("BoardDAOSpring ===> JDBC로 getBoard() 기능 처리");
 		Object[] args = {vo.getSeq()};
 		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
 	}
	/* 오승필/202184-010073 */
 	public List<BoardVO> getBoardList(BoardVO vo) {
		logger.info("BoardDAOSpring ===> JDBC로 getBoardList() 기능 처리");
 		return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
 		
 	}
}
/* 오승필/202184-010073 */
class BoardRowMapper implements RowMapper<BoardVO>{

	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO board = new BoardVO();
		board.setSeq(rs.getInt("SEQ"));
		board.setTitle(rs.getString("TITLE"));
		board.setWriter(rs.getString("WRITER"));
		board.setContent(rs.getString("CONTENT"));
		board.setTitle(rs.getString("TITLE"));
		board.setRegDate(rs.getDate("REGDATE"));
		board.setCnt(rs.getInt("CNT"));
		return board;
	}
	
}
