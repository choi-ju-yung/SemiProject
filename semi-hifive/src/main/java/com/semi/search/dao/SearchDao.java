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
import com.semi.search.model.vo.SearchCount;

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
	
	
	public int insertSearch(Connection conn, String content) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("insertSearch"));
			pstmt.setString(1,content);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
		
	public List<Product> searchTitle(Connection conn,String content){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Product> searchList=new ArrayList();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("searchTitle"));
			pstmt.setString(1, "%"+content+"%");
			rs=pstmt.executeQuery();
			while(rs.next())
				searchList.add(getProduct(rs));
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return searchList;
	}
	
	public List<Product> searchKeyWord(Connection conn,String content){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Product> searchList=new ArrayList();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("searchKeyWord"));
			pstmt.setString(1, "%"+content+"%");
			rs=pstmt.executeQuery();
			while(rs.next())
				searchList.add(getProduct(rs));
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return searchList;
	}
	
	public SearchCount searchCount(Connection conn,String content){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		SearchCount searchCount=null;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("searchCount"));
			pstmt.setString(1, "%"+content+"%");
			rs=pstmt.executeQuery();
			if(rs.next()) {
				searchCount = new SearchCount();
				searchCount.setCount(rs.getInt("count"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return searchCount;
	}
	
	public List<Search> printSearch(Connection conn){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Search> ps=new ArrayList();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("printSearch"));
			rs=pstmt.executeQuery();
			while(rs.next())
				ps.add(getSearch(rs));
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return ps;
	}
	
	
	private Search getSearch(ResultSet rs) throws SQLException{
		return Search.builder()
				.searchKeyword(rs.getString("search_keyword"))
				//.searchDate(rs.getDate("search_date"))	
				.build();
	}
	
	private Product getProduct(ResultSet rs) throws SQLException{
		return Product.builder()
				.productId(rs.getInt("product_id"))
				.userId(rs.getString("user_id"))
				.title(rs.getString("product_title"))
				.productStatus(rs.getString("product_status"))
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
