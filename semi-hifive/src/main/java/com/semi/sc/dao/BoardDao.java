package com.semi.sc.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.semi.sc.model.dto.Board;
import static com.semi.common.JDBCTemplate.*;
public class BoardDao {
	private final Properties sql=new Properties();
	{
		String path = BoardDao.class.getResource("/sql/service/servicesql.properties").getPath();
		try {
			sql.load(new FileReader(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//Board 객체 반환 메소드
	public static Board getBoard(ResultSet rs) throws SQLException{
//		BOARD_NO NUMBER CONSTRAINT BOARD_NO_PK PRIMARY KEY,
//		BOARD_WRITER VARCHAR2(30) NOT NULL,
//		BOARD_TITLE	VARCHAR2(150) NOT NULL,
//		BOARD_CONTENT VARCHAR2(4000) NOT NULL,
//		BOARD_DATE TIMESTAMP DEFAULT SYSDATE NOT NULL,
//		BOARD_CATEGORY VARCHAR2(50)	NULL,
//		NOTICE_YN CHAR(5) DEFAULT 'Y' NOT NULL,
//		BOARD_FILE VARCHAR2(2000) NULL
		return Board.builder().boardNo(rs.getInt("board_no"))
				.boardTitle(rs.getString("board_title"))
				.boardContent(rs.getString("board_content"))
				.boardDate(rs.getDate("board_date"))
				.boardCategory(rs.getString("board_category"))
				.noticeYn(rs.getString("notice_yn").charAt(0))
				.boardRenamedFileName(rs.getString("board_original_filename"))
				.build();
	}
	
	//구분에 따라 공지사항, 자주하는 질문 테이블 갯수 불러오는 메소드
	public int selectBoardCount(Connection conn, String noticeYN) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectBoardCount"));
			//SELECT COUNT(*) AS boardCount FROM BOARD WHERE NOTICE_YN=?
			pstmt.setString(1, noticeYN);
			rs=pstmt.executeQuery();	
			if(rs.next()) {
				count=rs.getInt("boardCount");
				System.out.println(rs.getInt(1));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return count;
	}

	public List<Board> selectBoardList(Connection conn, int cPage, int numPerpage, String noticeYN) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Board> boards=new ArrayList();
		try {
			pstmt=conn.prepareStatement("select * from board");
			System.out.println("sql문");
			//SELECT * FROM (SELECT ROWNUM AS RNUM, B.*
			//FROM (SELECT * FROM BOARD WHERE NOTICE_YN=? ORDER BY BOARD_DATE DESC) B)
			//WHERE RNUM BETWEEN ? AND ?
//			pstmt.setString(1, noticeYN);
//			pstmt.setInt(2, 1);
//			pstmt.setInt(3, 10);
			rs=pstmt.executeQuery();
			System.out.println("resultset");
			while(rs.next()) {
				boards.add(getBoard(rs));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return boards;
	}

}
