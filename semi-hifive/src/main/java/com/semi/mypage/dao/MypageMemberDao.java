package com.semi.mypage.dao;

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

import com.semi.member.model.vo.Member;
import com.semi.mypage.model.vo.MemberShopPage;


public class MypageMemberDao {
		
		private Properties sql = new Properties();
		
		public MypageMemberDao() {
			String path = MypageMemberDao.class.getResource("/sql/mypage/membersql.properties").getPath();
			try(FileReader fr = new FileReader(path)){
				sql.load(fr);
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	
		public List<Member> selectMemberAll(Connection conn){
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<Member> list = new ArrayList();
			try {
				pstmt = conn.prepareStatement(sql.getProperty("selectMemberAll"));
				rs = pstmt.executeQuery();
				while(rs.next()) {
					list.add(getMember(rs));
				}
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				close(rs);
				close(pstmt);
			} return list;
		}
		
//		public Member selectByUserIdAndPw(Connection conn,
//				String userId, String password) {
//			PreparedStatement pstmt=null;
//			ResultSet rs=null;
//			Member m=null;
//			try {
//				pstmt=conn.prepareStatement(sql.getProperty("selectByUserIdAndPw"));
//				pstmt.setString(1, userId);
//				pstmt.setString(2, password);
//				rs=pstmt.executeQuery();
//				if(rs.next()) {
//					m=getMember(rs);
//				}
//			}catch(SQLException e) {
//				e.printStackTrace();
//			}finally {
//				close(rs);
//				close(pstmt);
//			}return m;
//		}
		
		public Member selectByUserId(Connection conn, String userId) {
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			Member m=null;
			try {
				pstmt=conn.prepareStatement(sql.getProperty("selectByUserId"));
				pstmt.setString(1, userId);
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
		
		
		public int updateMember(Connection conn, MemberShopPage msp) {
			PreparedStatement pstmt=null;
			int result=0;
			try {
				pstmt=conn.prepareStatement(sql.getProperty("updateMember"));
				pstmt.setString(1, msp.getNickName());
//				pstmt.setString(2, msp.getIntroduce());
				pstmt.setString(3, msp.getUserId());
				result=pstmt.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}return result;
		}
		
		public int updateProfileImg(Connection conn, Member m) {
			PreparedStatement pstmt=null;
			int result=0;
			try {
				pstmt=conn.prepareStatement(sql.getProperty("updateProfileImg"));
				pstmt.setString(1, m.getProfileImg());
				pstmt.setString(2, m.getUserId());
				pstmt.setString(3, m.getPassword());
				result=pstmt.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}return result;
		}
		
		public Member selectByNickname(Connection conn, String nickname) {
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			Member m=null;
			try {
				pstmt=conn.prepareStatement(sql.getProperty("selectByNickname"));
				pstmt.setString(1, nickname);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					m=getMember(rs);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(pstmt);
			}
			return m;
		}
		
//		public int updateMember(Connection conn, String userId) {
//			PreparedStatement pstmt=null;
//			int result=0;
//			try {
//				pstmt=conn.prepareStatement(sql.getProperty("updateMember"));
//				pstmt.setString(1, m.getProfileImg());
//				pstmt.setString(2, m.getUserId());
//				pstmt.setString(3, m.getPassword());
//				result=pstmt.executeUpdate();
//			}catch(SQLException e) {
//				e.printStackTrace();
//			}finally {
//				close(pstmt);
//			}return result;
//		}
		
		
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
		}
		
}
