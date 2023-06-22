package com.semi.sc.service;

import static com.semi.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.semi.sc.dao.InquiryDao;
import com.semi.sc.model.dto.Inquiry;

public class InquiryService {
	private InquiryDao dao=new InquiryDao();

	public int selectInquiryCount() {
		Connection conn=getConnection();
		int count=dao.selectInquiryCount(conn);
		close(conn);
		return count;
	}

	public List<Inquiry> selectInquiryList(int cPage, int numPerpage) {
		Connection conn=getConnection();
		List<Inquiry> inquiryList=dao.selectInquiryList(conn,cPage,numPerpage);
		close(conn);
		return inquiryList;
	}
}
