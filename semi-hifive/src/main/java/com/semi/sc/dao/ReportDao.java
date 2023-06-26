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

import com.semi.productpage.model.vo.Product;
import com.semi.sc.model.dto.BoardComment;
import com.semi.sc.model.dto.Report;
import com.semi.sc.model.dto.ServiceFile;

public class ReportDao {
	private final Properties sql=new Properties();
	{
		String path = BoardDao.class.getResource("/sql/service/report_sql.properties").getPath();
		try {
			sql.load(new FileReader(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static Report getReport(ResultSet rs) throws SQLException {
		return Report.builder()
				.reportContent(rs.getString("report_content"))
				.reportNo(rs.getInt("report_no"))
				.productNo(rs.getInt("product_no"))
				.tradeNo(rs.getInt("trage_no"))
				.reportWriter(rs.getString("report_writer"))
				.reportDate(rs.getDate("report_date"))
				.reportCategory(rs.getString("report_category"))
				.build();
	}
	
	//file 반환 메소드
	public static ServiceFile getFile(ResultSet rs) throws SQLException {
		return ServiceFile.builder()
				.contentNo(rs.getInt("report_no"))
				.filename(rs.getString("report_renamed_filename"))
				.fileNo(rs.getInt("file_no"))
				.build();
	}

	// comment 반환 메소드
	public static BoardComment getComment(ResultSet rs) throws SQLException {
		return BoardComment.builder()
				.commentNo(rs.getInt("report_comment_no"))
				.commentWriter(rs.getString("nickname"))
				.boardNo(rs.getInt("report_no"))
				.commentNoFK(rs.getInt("report_comment_fk"))
				.commentDate(rs.getDate("report_comment_date"))
				.commentContent(rs.getString("report_comment_content"))
				.build();
	}
	
	//거래 리스트 반환 메소드
	public static Product getProduct(ResultSet rs) throws SQLException{
		return Product.builder()
				.title(rs.getString("product_title"))
				.registTime(rs.getDate("sell_date"))
				.userId(rs.getString("buyer_id"))
				.build();
	}
	
	//해당 데이터 갯수
	public int selectReportCount(Connection conn, String loginId) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectReportCount"));
			pstmt.setString(1, loginId);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				rs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return 0;
	}
	
	//해당 아이디한테 보일 리스트
	public List<Report> selectReportList(Connection conn, int cPage, int numPerpage, String loginId) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Report> reportList=new ArrayList();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectReportList"));
			pstmt.setString(1, loginId);
			pstmt.setInt(2, (cPage-1)*numPerpage+1);
			pstmt.setInt(3, cPage*numPerpage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				reportList.add(getReport(rs));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return reportList;
	}

	//2주 이내의 거래 리스트
	public List<Product> selectBuyList(Connection conn, String loginId) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Product> buyList=new ArrayList();
		String query=sql.getProperty("selectBuyList");
		System.out.println(loginId);
		try {
			query=query.replaceAll("#SS", "'판매완료'");
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, loginId);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				buyList.add(getProduct(rs));
			}
			System.out.println(buyList);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return buyList;
	}
}
