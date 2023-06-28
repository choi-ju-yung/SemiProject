package com.semi.sc.service;

import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.commit;
import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.semi.product.model.vo.Product;
import com.semi.sc.dao.ReportDao;
import com.semi.sc.model.dto.BoardComment;
import com.semi.sc.model.dto.Report;
import com.semi.sc.model.dto.ServiceFile;

public class ReportService {
	private ReportDao dao=new ReportDao();
	
	public int selectReportCount(String loginId) {
		Connection conn=getConnection();
		int count=dao.selectReportCount(conn, loginId);
		close(conn);
		return count;
	}
	
	public List<Report> selectReportList(int cPage, int numPerpage, String loginId) {
		Connection conn=getConnection();
		List<Report> reportList=dao.selectReportList(conn, cPage, numPerpage, loginId);
		close(conn);
		return reportList;
	}
	
	public List<Product> selectBuyList(String loginId) {
		Connection conn=getConnection();
		List<Product> buyList=dao.selectBuyList(conn, loginId);
		close(conn);
		return buyList;
	}
	
	public int insertReportBuyList(Report r, List<String> filesNames, List<Product> byBuyList) {
		Connection conn=getConnection();
		int result=dao.insertReportBoard(conn, r);
		int fileresult=0, buyresult=0, pResult=0;
		for(String file:filesNames) {
			fileresult+=dao.insertReportFile(conn, file);
		}
		for(Product p:byBuyList) {
			pResult+=dao.updateReportBoard(conn, p);
		}
		if(result>0&&fileresult==filesNames.size()&&pResult==byBuyList.size()) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public Report selectReportContent(int reportNo) {
		Connection conn=getConnection();
		Report r=dao.selectReportContent(conn, reportNo);
		close(conn);
		return r;
	}
	
	public List<ServiceFile> selectReportFile(int reportNo) {
		Connection conn=getConnection();
		List<ServiceFile> files=dao.selectReportFile(conn, reportNo);
		close(conn);
		return files;
	}
	
	public List<BoardComment> selectReportComment(int reportNo) {
		Connection conn=getConnection();
		List<BoardComment> comments=dao.selectReportComment(conn, reportNo);
		close(conn);
		return comments;
	}
	
	public int insertComment(BoardComment bc) {
		Connection conn=getConnection();
		int result=dao.insertComment(conn, bc);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public int deleteComment(int commentNo) {
		Connection conn=getConnection();
		int result=dao.deleteComment(conn, commentNo);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public int updateComment(int commentNo, String data) {
		Connection conn=getConnection();
		int result=dao.updateComment(conn, commentNo, data);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public Product selectProductInfo(int productId) {
		Connection conn=getConnection();
		Product p=dao.selectProductInfo(conn, productId);
		close(conn);
		return p;
	}
	
	public int insertReportProduct(Report r, List<String> filesNames, int productId) {
		Connection conn=getConnection();
		int result=dao.insertReportBoard(conn, r);
		int fileresult=0;
		for(String file:filesNames) {
			fileresult+=dao.insertReportFile(conn, file);
		}
		int productresult=dao.insertReportList(conn, r, productId);
		if(result>0&&fileresult==filesNames.size()&&productresult>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

	public Product selectReportProductList(int reportNo) {
		Connection conn=getConnection();
		Product reportProduct=dao.selectReportProductList(conn, reportNo);
		close(conn);
		return reportProduct;
	}

	public List<Product> selectByBuyList(List<Integer> tradeList) {
		Connection conn=getConnection();
		List<Product> list=new ArrayList();
		for(Integer tradeId:tradeList) {
			list.add(dao.selectByBuyList(conn, tradeId));
		}
		close(conn);
		return list;
	}

}
