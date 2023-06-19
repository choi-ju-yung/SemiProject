package com.semi.sc.dao;

import static com.semi.common.JDBCTemplate.close;

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
import com.semi.sc.model.dto.BoardComment;
import com.semi.sc.model.dto.BoardFile;
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
		return Board.builder().boardNo(rs.getInt("board_no"))
				.boardTitle(rs.getString("board_title"))
				.boardContent(rs.getString("board_content"))
				.boardDate(rs.getDate("board_date"))
				.boardCategory(rs.getString("board_category"))
				.noticeYn(rs.getString("notice_yn").charAt(0))
				.build();
	}
	//board file 반환 메소드
	public static BoardFile getBoardFile(ResultSet rs, int boardNo) throws SQLException{
		return BoardFile.builder().boardNo(boardNo)
				.boardFileName("board_filename")
				.fileNo("file_no").build();
	}
	
	//board comment 반환 메소드
	public static BoardComment getComment(ResultSet rs) throws SQLException{
		return BoardComment.builder()
				.commentNo(rs.getInt("board_comment_no"))
				.commentWriter(rs.getString("board_comment_writer"))
				.boardNo(rs.getInt("board_no"))
				.commentNoFK(rs.getInt("board_comment_fk"))
				.commentDate(rs.getDate("board_comment_date"))
				.commentContent(rs.getString("board_comment_content"))
				.build();
	}
	
	//구분에 따라 공지사항, 자주하는 질문 테이블 갯수 불러오는 메소드
	public int selectBoardCount(Connection conn, String noticeYN) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectBoardCount"));
			pstmt.setString(1, noticeYN);
			rs=pstmt.executeQuery();	
			if(rs.next()) {
				count=rs.getInt("boardCount");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return count;
	}

	//notice_yn을 기준으로 게시글 리스트를 불러옴
	public List<Board> selectBoardList(Connection conn, int cPage, int numPerpage, String noticeYN) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Board> boards=new ArrayList();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectBoardList"));
			pstmt.setString(1, noticeYN);
			pstmt.setInt(2, (cPage-1)*numPerpage+1);
			pstmt.setInt(3, cPage*numPerpage);
			rs=pstmt.executeQuery();
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

	//Board 테이블에 데이터 추가
	public int insertBoard(Connection conn, Board b) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("insertBoard"));
			pstmt.setString(1, b.getBoardWriter());
			pstmt.setString(2, b.getBoardTitle());
			pstmt.setString(3, b.getBoardContent());
			pstmt.setString(4, b.getBoardCategory());
			pstmt.setString(5, String.valueOf(b.getNoticeYn()));
			
			result=pstmt.executeUpdate();
			if(result>0) {
				System.out.println("정상 추가 되었습니다.");
			}else {
				System.out.println("업데이트 실패했습니다");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	//boardNo에 해당하는 컬럼 불러옴
	public Board selectBoardContent(Connection conn, int boardNo) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Board b=null;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectBoardContent"));
			pstmt.setInt(1, boardNo);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				b=getBoard(rs);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return b;
	}
	public Board selectBoardFile(Connection conn, int boardNo, Board b) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectBoardFile"));
			pstmt.setInt(1, boardNo);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return b;
	}
	public List<BoardComment> selectBoardComment(Connection conn, int boardNo) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<BoardComment> comments=new ArrayList();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selecComment"));
			pstmt.setInt(1, boardNo);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				comments.add(getComment(rs));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return comments;
	}

}
