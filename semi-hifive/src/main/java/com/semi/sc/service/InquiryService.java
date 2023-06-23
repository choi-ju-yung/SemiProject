package com.semi.sc.service;

import static com.semi.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.semi.sc.dao.InquiryDao;
import com.semi.sc.model.dto.Inquiry;
import com.semi.sc.model.dto.ServiceFile;

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

	public Inquiry selectInquiryContent(int inquiryNo) {
		Connection conn=getConnection();
		Inquiry q=dao.selectInquiryContent(conn, inquiryNo);
		close(conn);
		return q;
	}

	public int insertInquiry(Inquiry q, List<String> filesNames) {
		Connection conn=getConnection();
		int result=dao.insertInquiry(conn, q);
		int fileresult=0;
		for(String file:filesNames) {
			fileresult+=dao.insertInquiryFile(conn, file);
		}
		if(result>0&&fileresult==filesNames.size()) commit(conn);
		else rollback(conn);
		return result;
	}

}
