package com.springbook.biz.board2;

import java.util.List;

/* 오승필/202184-010073 */
public interface BoardService {
    // 글 등록
    void insertBoard(BoardVO vo);

    // 글 수정
    void updateBoard(BoardVO vo);

    // 글 삭제
    void deleteBoard(BoardVO vo);

    // 글 상세조회
    BoardVO getBoardDetail(BoardVO vo);

    // 글 리스트조회
    List<BoardVO> getBoardList(BoardVO vo);


}
