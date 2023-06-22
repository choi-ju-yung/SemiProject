package com.semi.search.dao;

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

import com.semi.productpage.dao.ProductDao;
import com.semi.productpage.model.vo.ProductComment;
import com.semi.search.model.vo.Search;

public class SearchDao {
	
	private Properties sql = new Properties();

	public SearchDao() {
		String path=ProductDao.class.getResource("/sql/search/searchsql.properties").getPath();
		try(FileReader fr=new FileReader(path);){
			sql.load(fr);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Search> recentSearch(Connection conn,String id){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Search> list=new ArrayList();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("recentSearch"));
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			while(rs.next())
				list.add(getSearch(rs));
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return list;
	}
	
	
	public int insertSearch(Connection conn, String data,String id) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("insertSearch"));
			pstmt.setString(1,data);
			pstmt.setString(2,id);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
	
	public int deleteSearch(Connection conn, String data,String id) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("deleteSearch"));
			pstmt.setString(1,data);
			pstmt.setString(2,id);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
	
	
	
	private Search getSearch(ResultSet rs) throws SQLException{
		return Search.builder()
				.searchKeyword(rs.getString("search_keyword"))
				.searchDate(rs.getDate("search_date"))	
				.userId(rs.getString("user_id"))
				.build();
	}
}
