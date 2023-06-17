package com.semi.mypage.dao;

import static com.semi.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.semi.member.model.vo.Member;
import com.semi.mypage.model.vo.ShopPage;

public class ShopPageDao {

	private Properties sql = new Properties();
	
	public ShopPageDao() {
		String path = ShopPageDao.class.getResource("/sql/mypage/shoppagesql.properties").getPath();
		try(FileReader fr = new FileReader(path)){
			sql.load(fr);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public ShopPage searchIntroduceById(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ShopPage sp = null;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("searchIntroduceById"));
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				sp=getMember(rs);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return sp;
	}
	
	
	public static ShopPage getMember(ResultSet rs) throws SQLException{
		return ShopPage.builder()
				.userId(rs.getString("user_Id"))
				.introduce(rs.getString("introduce"))
				.build();
	}
}
