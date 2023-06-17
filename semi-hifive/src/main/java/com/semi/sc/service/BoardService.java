package com.semi.sc.service;

import static com.semi.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.semi.sc.dao.BoardDao;
import com.semi.sc.model.dto.Board;
public class BoardService {
	private BoardDao dao=new BoardDao();

	public int selectBoardCount(String noticeYN) {
		Connection conn=getConnection();
		int count=dao.selectBoardCount(conn, noticeYN);
		close(conn);
		return count;
	}

	public List<Board> selectBoardList(int cPage, int numPerpage, String noticeYN) {
		Connection conn=getConnection();
		List<Board> boardList=dao.selectBoardList(conn, cPage, numPerpage, noticeYN);
		close(conn);
		return boardList;
	}

	public int insertBoard(Board b) {
		Connection conn=getConnection();
		int result=dao.insertBoard(conn, b);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

	public Board selectBoardContent(int boardNo) {
		Connection conn=getConnection();
		Board b=dao.selectBoardContent(conn, boardNo);
		close(conn);
		return b;
	}
	
	
}
