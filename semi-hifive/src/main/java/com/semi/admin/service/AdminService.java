package com.semi.admin.service;

import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.semi.admin.dao.AdminDao;
import com.semi.member.model.vo.Member;

public class AdminService {
	
	private AdminDao dao = new AdminDao();
	
	public List<Member> selectMemberAll(int cPage, int numPerpage) {
		Connection conn=getConnection();
		List<Member> m = dao.selectMemberAll(conn,cPage,numPerpage);
		close(conn);
		return m;
	}
	
	public int selectMemberCount() {
		Connection conn=getConnection();
		int result = dao.selectMemberCount(conn);
		close(conn);
		return result;
	}
	
	public int userRemove(String email){
		Connection conn=getConnection();
		int result = dao.userRemove(conn,email);
		close(conn);
		return result;
	}
	

	
	public int allUserRemove() {
		Connection conn=getConnection();
		int result = dao.allUserRemove(conn);
		close(conn);
		return result;
	}
	//userName,nickName,declareCount,enrollDate,temp,email
	
	public int updateMember(String userName,String nickName,String declareCount, String enrollDate, String temp, String email) {
		Connection conn=getConnection();
		int result = dao.updateMember(conn,userName,nickName,declareCount,enrollDate,temp,email);
		close(conn);
		return result;
	}
	
	
}

