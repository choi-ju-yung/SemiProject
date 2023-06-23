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

import com.semi.product.model.vo.Product;
import com.semi.productpage.dao.ProductDao;
import com.semi.search.model.vo.Search;
import com.semi.search.model.vo.SearchFunction;
import com.semi.search.model.vo.SearchFunction.SearchFunctionBuilder;

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
			pstmt.setString(1,id);
			pstmt.setString(2,data);
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
			pstmt.setString(1,id);
			pstmt.setString(2,data);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
	
	public List<Product> searchFunction(Connection conn,String data){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Product> p=new ArrayList();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("searchFunction"));
			pstmt.setString(1, "%"+data+"%");
			rs=pstmt.executeQuery();
			while(rs.next())
				p.add(getProduct(rs));
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return p;
	}
	
	
	private Search getSearch(ResultSet rs) throws SQLException{
		return Search.builder()
				.searchKeyword(rs.getString("search_keyword"))
				.searchDate(rs.getDate("search_date"))	
				.userId(rs.getString("user_id"))
				.build();
	}
	
	private Product getProduct(ResultSet rs) throws SQLException{
		return Product.builder()
				.productId(rs.getInt("product_id"))
				.userId(rs.getString("user_id"))
				.title(rs.getString("product_title"))
				.sellStatus(rs.getString("product_status"))
				.sellStatus(rs.getString("sell_status"))
				.price(rs.getInt("price"))
				.registTime(rs.getDate("regist_time"))
				.viewCount(rs.getInt("view_count"))
				.explanation(rs.getString("explanation"))
				.keyword(rs.getString("keyword"))
				.subCategoryName(rs.getString("subcategory_name"))
				.areaName(rs.getString("area_name"))
				.build();
	}
}
