package com.semi.product.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import static com.semi.common.JDBCTemplate.*;


import javax.naming.spi.DirStateFactory.Result;

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
		.elapsedtime(rs.getLong("ELAPSED_TIME"))
		.viewcount(rs.getInt("VIEW_COUNT"))
		.explanation(rs.getString("EXPLANATION"))
		.keyword(rs.getString("KEYWORD"))
		.subcategoryid(rs.getInt("SUBCATEGORY_ID"))
		.goonguareaid(rs.getInt("GOONGUAREA_ID")).build();
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
	
//	// 경과 시간 변환 메서드
//	private static String formatElapsed(long elapsed) {
//	    long seconds = elapsed / 1000; 
//
//	    if (seconds < 60) {
//	        return seconds + "초 전";
//	    } else if (seconds < 3600) {
//	        long minutes = seconds / 60;
//	        return minutes + "분 전";
//	    } else if (seconds < 86400) {
//	        long hours = seconds / 3600;
//	        return hours + "시간 전";
//	    } else if (seconds < 2592000) {
//	        long days = seconds / 86400;
//	        return days + "일 전";
//	    } else if (seconds < 31536000) {
//	        long months = seconds / 2592000;
//	        return months + "개월 전";
//	    } else {
//	        long years = seconds / 31536000;
//	        return years + "년 전";
//	    }
//	}
//	
	
	
}
