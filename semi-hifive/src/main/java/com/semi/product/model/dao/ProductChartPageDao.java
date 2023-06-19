package com.semi.product.model.dao;

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

import com.semi.product.model.vo.ProductDto;

public class ProductChartPageDao {
	private Properties sql = new Properties();
	{
		String path = ProductChartPageDao.class.getResource("/sql/product/productchartpage.sql.properties").getPath();
		
		try {
			sql.load(new FileReader(path));
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static ProductDto getProduct(ResultSet rs) throws SQLException {
		return ProductDto.builder()		
		.productId(rs.getInt("PRODUCT_ID"))
		.userId(rs.getString("USER_ID"))
		.producttitle(rs.getString("PRODUCT_TITLE"))
		.productstatus(rs.getString("PRODUCT_STATUS"))
		.sellstatus(rs.getString("SELL_STATUS"))
		.price(rs.getInt("PRICE"))
		.registtime(rs.getDate("REGIST_TIME"))
		.viewcount(rs.getInt("VIEW_COUNT"))
		.explanation(rs.getString("EXPLANATION"))
		.keyword(rs.getString("KEYWORD"))
		.goonguareaid(rs.getInt("GOONGUAREA_ID"))
		.subcategoryname(rs.getString("SUBCATEGORY_NAME"))
		.elapsedtime(rs.getLong("ELAPSED_TIME"))
		.categoryid(rs.getString("CATEGORY_ID"))
		.categoryname(rs.getString("CATEGORY_NAME"))
		.build();
	}
	
	public List<ProductDto> CategoryProductList(Connection conn, int cPage, int numPerpage) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ProductDto> productlist = new ArrayList<>();
	
	try {
		pstmt = conn.prepareStatement(sql.getProperty("CategoryProductList"));
		pstmt.setInt(1, (cPage-1) * numPerpage + 1);
		pstmt.setInt(2, cPage * numPerpage);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			productlist.add(getProduct(rs));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		close(rs);
		close(pstmt);
	}return productlist;
	}
	
//	페이징처리 	
	public int CategoryProductListCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql.getProperty("CategoryProductListCount"));
			rs = pstmt.executeQuery();
			if(rs.next()){
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return result;
	}
	
	// 선택한 상품페이지이동 메소드
	public ProductDto SelectProduct(Connection conn, int productId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductDto p = null;
		try {
			pstmt = conn.prepareStatement(sql.getProperty("SelectProduct"));
			pstmt.setInt(1, productId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				p = getProduct(rs);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return p;
	}
	
	//선택한 카테고리 상품이동
	public List<ProductDto> SelectCategoryList(Connection conn, int cPage, int numPerpage ,String categoryid) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ProductDto> selectcategorylist = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql.getProperty("SelectCategoryList"));
			pstmt.setInt(1, (cPage-1) * numPerpage + 1);
			pstmt.setInt(2, cPage * numPerpage);
			pstmt.setString(3, categoryid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				selectcategorylist.add(getProduct(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return selectcategorylist;
	}
	
	public int SelectCategoryProductListCount(Connection conn, String categoryid) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql.getProperty("CategoryProductListCount"));
			pstmt.setString(1, categoryid);
			rs = pstmt.executeQuery();
			if(rs.next()){
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return result;
	}
	
	
}
