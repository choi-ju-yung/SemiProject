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

import com.semi.member.model.vo.Member;

public class AdminDao {
	private Properties sql = new Properties();

	public AdminDao() { // 기본생성자로 만들어도되고, 초기화블록으로 만들어도됨
		String path = AdminDao.class.getResource("/sql/admin/admin_sql.properties").getPath();
		try {
			sql.load(new FileReader(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public List<Member> selectMemberAll(Connection conn, int cPage, int numPerpage) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Member> result = new ArrayList();
		try {
			pstmt = conn.prepareStatement(sql.getProperty("selectMemberAll"));
			pstmt.setInt(1, (cPage - 1) * numPerpage + 1);
			pstmt.setInt(2, cPage * numPerpage);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				result.add(getMember(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}

	
	public int selectMemberCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql.getProperty("selectMemberCount"));
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}

	
	public int userRemove(Connection conn, String email) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql.getProperty("userRemove"));
			pstmt.setString(1, email);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	
	public int allUserRemove(Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql.getProperty("allUserRemove"));
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	
	
	public int updateMember(Connection conn,String userName,String nickName,String declareCount, String enrollDate, String temp, String email) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql.getProperty("updateMember"));
			pstmt.setString(1, nickName);
			pstmt.setString(2, userName);
			pstmt.setString(3, declareCount);
			pstmt.setString(4, enrollDate);
			pstmt.setString(5, temp);
			pstmt.setString(6, email);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	
	
	public int deleteCheckMember(Connection conn,String dsql) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql.getProperty("deleteCheckMember").replace("#data", dsql));
//			pstmt.setString(1, dsql);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	
	
	public List<Member> selectMemberByKeyword(Connection conn, String type, String keyword, int cPage, int numPerPage){
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		String query=sql.getProperty("selectMemberByKeyword");
		query=query.replace("#COL", type);  // properties파일안의 ?에 문자열을 인식시키기위해서 사용
		List<Member> members = new ArrayList();
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1,"%"+keyword+"%");
			// type이 성별일때는 % 없이 처리가능하며, 나머지 속성같은경우에는 부분검색이므로 %가 들어감
			pstmt.setInt(2,(cPage-1)*numPerPage+1);
			pstmt.setInt(3, cPage*numPerPage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				members.add(getMember(rs));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return members;
	}
	
	
	public int selectMemberByKeywordCount(Connection conn, String type, String keyword) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		String query=sql.getProperty("selectMemberByKeywordCount").replace("#COL", type);
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1,"%"+keyword+"%");
			rs=pstmt.executeQuery();
			if(rs.next()) {
				result=rs.getInt(1);						
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return result;
	}
	
	
	public int deleteCheckBoard(Connection conn, String bsql) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql.getProperty("deleteCheckBoard").replace("#data", bsql));
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	
	
	public int boardRemove(Connection conn, String boardNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql.getProperty("boardRemove"));
			pstmt.setString(1, boardNo);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	
	
	public int updateBoard(Connection conn,String boardTitle,String boardContent,String boardDate, String boardCategory, String boardNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql.getProperty("updateBoard"));
			pstmt.setString(1, boardTitle);
			pstmt.setString(2, boardContent);
			pstmt.setString(3, boardDate);
			pstmt.setString(4, boardCategory);
			pstmt.setString(5, boardNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	
}
