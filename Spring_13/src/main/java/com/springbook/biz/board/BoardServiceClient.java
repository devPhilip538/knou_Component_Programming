package com.springbook.biz.board;
import com.springbook.biz.board.impl.BoardDAO;
import java.util.List;

public class BoardServiceClient {
    public static void main(String[] args) {
        BoardDAO boardDAO = new BoardDAO();
        BoardVO vo = new BoardVO();
        vo.setTitle("MyBatis 테스트");
        vo.setWriter("김유신");
        vo.setContent("MyBatis 내용 입니다...");
        boardDAO.insertBoard(vo);
        List<BoardVO> boardList = boardDAO.getBoardList(vo);
        for(BoardVO board: boardList){
            System.out.println("[MyBatis 테스트]"+board.toString());
        }
    }
}
