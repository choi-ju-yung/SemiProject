package com.semi.admin.dao;

import static com.semi.common.JDBCTemplate.close;
import static com.semi.member.dao.MemberDao.getMember;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.semi.admin.dao.AdminDao;
import com.semi.member.model.vo.Member;

public class AdminDao {
	private Properties sql=new Properties();
	
	
	public AdminDao(){ // 기본생성자로 만들어도되고, 초기화블록으로 만들어도됨
		String path=AdminDao.class.getResource("/sql/admin/admin_sql.properties").getPath();
		try {
			sql.load(new FileReader(path));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	
	   public List<Member> selectMemberAll(Connection conn, int cPage, int numPerpage) {
		      PreparedStatement pstmt = null;
		      ResultSet rs = null;
		      List<Member> result = new ArrayList();
		      try {
		         pstmt = conn.prepareStatement(sql.getProperty("selectMemberAll"));
		         pstmt.setInt(1, (cPage-1)*numPerpage+1);
		         pstmt.setInt(2, cPage*numPerpage);
		         
		         rs = pstmt.executeQuery();
		         while(rs.next()) {
		            result.add(getMember(rs));
		         }
		      } catch(SQLException e) {
		         e.printStackTrace();
		      } finally {
		         close(rs);
		         close(pstmt);
		      } return result;
		   }
		   
		   public int selectMemberCount(Connection conn) {
		      PreparedStatement pstmt = null;
		      ResultSet rs = null;
		      int result = 0;
		      try {
		         pstmt = conn.prepareStatement(sql.getProperty("selectMemberCount"));
		         rs = pstmt.executeQuery();
		         if(rs.next()) {
		            result = rs.getInt(1);
		         }
		      } catch(SQLException e) {
		         e.printStackTrace();
		      } finally {
		         close(rs);
		         close(pstmt);
		      } return result;
		   }
}
