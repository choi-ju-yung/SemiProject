package com.semi.sc.service;

import java.sql.Connection;
import java.util.List;

import com.semi.product.model.vo.Product;
import com.semi.sc.dao.ReportDao;
import com.semi.sc.model.dto.Report;

import static com.semi.common.JDBCTemplate.*;

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

}
