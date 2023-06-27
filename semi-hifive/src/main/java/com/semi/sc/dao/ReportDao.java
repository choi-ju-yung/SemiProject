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

import com.semi.product.model.vo.Product;
import com.semi.sc.model.dto.BoardComment;
import com.semi.sc.model.dto.Report;
import com.semi.sc.model.dto.ReportList;
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
				.reportWriter(rs.getString("nickname"))
				.reportTitle(rs.getString("report_title"))
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
	public static Product getTrade(ResultSet rs) throws SQLException{
		return Product.builder()
				.title(rs.getString("product_title"))
				.registTime(rs.getDate("sell_date"))
				.userId(rs.getString("buyer_id"))
				.productId(rs.getInt("trade_id"))
				.build();
	}
	
	//신고 판매글 정보 반환 메소드
	public static Product getProduct(ResultSet rs) throws SQLException{
		return Product.builder()
				.productId(rs.getInt("product_id"))
				.title(rs.getString("product_title"))
				.price(rs.getInt("price"))
				.registTime(rs.getDate("regist_time"))
				.userId(rs.getString("nickname"))
				.build();
	}
	
	//신고 리스트 반환 메소드
	public static ReportList getReportList(ResultSet rs) throws SQLException{
		return ReportList.builder()
				.reportListNo(rs.getInt("report_list_no"))
				.reportNo(rs.getInt("report_no"))
				.productId(rs.getInt("product_id"))
				.tradeId(rs.getInt("trade_id"))
				.userId(rs.getString("nickname"))
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
			pstmt=conn.prepareStatement(sql.getProperty("selectReports"));
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
		try {
			query=query.replaceAll("#SS", "'판매완료'");
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, loginId);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				buyList.add(getTrade(rs));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return buyList;
	}

	//신고글 저장
	public int insertReportBoard(Connection conn, Report r) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("insertReport"));
			pstmt.setString(1, r.getReportWriter());
			pstmt.setString(2, r.getReportTitle());
			pstmt.setString(3, r.getReportContent());
			pstmt.setString(4, r.getReportCategory());
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	//신고글 첨부파일 저장
	public int insertReportFile(Connection conn, String file) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("insertFile"));
			pstmt.setString(1, file);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	//신고글 작성된 내역 저장
	public int insertReportList(Connection conn, ReportList rl) {
		PreparedStatement pstmt=null;
		int result=0;
		String query=sql.getProperty("insertReportList");
		try {
			query=query.replaceAll("#PI", rl.getProductId()!=0?String.valueOf(rl.getProductId()):"NULL");
			query=query.replaceAll("#TI", rl.getTradeId()!=0?String.valueOf(rl.getTradeId()):"NULL");
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, rl.getUserId());
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	//신고글 내용 불러옴
	public Report selectReportContent(Connection conn, int reportNo) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Report r=null;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectContent"));
			pstmt.setInt(1, reportNo);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				r=getReport(rs);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return r;
	}

	//신고글 파일 불러옴
	public List<ServiceFile> selectReportFile(Connection conn, int reportNo) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<ServiceFile> files=new ArrayList();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectFile"));
			pstmt.setInt(1, reportNo);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				files.add(getFile(rs));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return files;
	}

	//신고글 댓글 불러옴
	public List<BoardComment> selectReportComment(Connection conn, int reportNo) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<BoardComment> comments=new ArrayList();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectComment"));
			pstmt.setInt(1, reportNo);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				comments.add(getComment(rs));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return comments;
	}

	//댓글 추가
	public int insertComment(Connection conn, BoardComment bc) {
		PreparedStatement pstmt=null;
		int result=0;
		String query=sql.getProperty("insertComment");
		try {
			query=query.replaceAll("#FK", bc.getCommentNoFK()==0?"null":String.valueOf(bc.getCommentNoFK()));
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, bc.getCommentWriter());
			pstmt.setInt(2, bc.getBoardNo());
			pstmt.setString(3, bc.getCommentContent());
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	//댓글 삭제
	public int deleteComment(Connection conn, int commentNo) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("deleteComment"));
			pstmt.setInt(1, commentNo);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	//댓글 수정
	public int updateComment(Connection conn, int commentNo, String data) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("updateComment"));
			pstmt.setString(1, data);
			pstmt.setInt(2, commentNo);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	//신고글 정보 확인
	public Product selectProductInfo(Connection conn, int productId) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Product p=null;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectProduct"));
			pstmt.setInt(1, productId);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				p=getProduct(rs);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return p;
	}

	//판매글을 신고 내역에 저장
	public int insertReportList(Connection conn, Report r, int productId) {
		PreparedStatement pstmt=null;
		int result=0;
		String query=sql.getProperty("insertReportListByProduct");
		try {
			query=query.replaceAll("#PI", productId!=0?String.valueOf(productId):"NULL");
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, r.getReportWriter());
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	//신고한 정보 불러오는 메소드
	public List<Product> selectReportProductList(Connection conn, String loginId) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Product> reportProduct=new ArrayList();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectReportList"));
			pstmt.setString(1, loginId);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				reportProduct.add(getProduct(rs));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return reportProduct;
	}
	
	
}
