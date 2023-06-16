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
	
	
}
