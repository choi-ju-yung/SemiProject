 package com.semi.member.dao;

import static com.semi.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.semi.member.model.vo.Member;


public class MemberDao {
	private Properties sql=new Properties(); // Properties 파일객체 만듬
	{
		String path=MemberDao.class.getResource("/sql/member/member_sql.properties").getPath();
		try {
			sql.load(new FileReader(path)); // 해당경로에 객체 파일 연결
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	// 아이디는 기본키이기때문에 하나만나옴
	public Member selectByUserIdAndPw(Connection conn,
			String userId, String password) {
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		Member m=null;
		try {
			pstmt=conn.prepareStatement(
					sql.getProperty("selectByUserIdAndPw"));
			pstmt.setString(1, userId);
			pstmt.setString(2, password);
			rs=pstmt.executeQuery(); 
			
			if(rs.next()) {
				m=getMember(rs);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return m;
	}
	
	
	public int insertMember(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		int result =0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("insertMember"));
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getEmail());
			pstmt.setString(3, m.getNickName());
			pstmt.setString(4, m.getPassword());
			pstmt.setString(5, m.getUserName());
//			pstmt.setString(9, String.join(",",m.getHobby()));  // 배열을 ,구분해서 문자열로만듬
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
	
	
	
	//public static 하는 이유 : 다른 패키지에서도 이 메소드 사용하기 위해서
	public static Member getMember(ResultSet rs) throws SQLException{ 
		return Member.builder()
	            .userId(rs.getString("user_Id"))
	            .email(rs.getString("email"))
	            .nickName(rs.getString("nickname"))
	            .password(rs.getString("password"))
	            .userName(rs.getString("user_name"))
	            .declareCount(rs.getInt("declare_Count"))
	            .enrollDate(rs.getDate("enroll_Date"))
	            .auth(rs.getString("auth"))
	            .temperature(rs.getDouble("temperature"))
	            .profileImg(rs.getString("profile_Img"))
	            .build();
		//	.gender(rs.getString("gender").charAt(0))
		//	.hobby(rs.getString("hobby")!=null?rs.getString("hobby").split(","):null)
	}
}	
