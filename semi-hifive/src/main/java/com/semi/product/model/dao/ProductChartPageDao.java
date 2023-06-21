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
	//선택한 서브카테고리이름으로 찾아서 상품이동
	public List<ProductDto> SelectCategoryList(Connection conn, int cPage, int numPerpage ,String subcategoryname) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ProductDto> selectcategorylist = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql.getProperty("SelectCategoryList"));
			pstmt.setString(1, subcategoryname);
			pstmt.setInt(2, (cPage-1) * numPerpage + 1);
			pstmt.setInt(3, cPage * numPerpage);
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
	
	public int SelectCategoryProductListCount(Connection conn, String subcategoryname) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql.getProperty("SelectCategoryProductListCount"));
			pstmt.setString(1, subcategoryname);
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
	
	//대표카테고리 클릭시 대표카테고리상품리스트들 출력
		public List<ProductDto> CategoryList(Connection conn, int cPage, int numPerpage, String categoryname){
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<ProductDto> categorylist = new ArrayList<>();
			
			try {
				pstmt = conn.prepareStatement(sql.getProperty("CategoryList"));
				pstmt.setString(1, categoryname);
				pstmt.setInt(2, (cPage-1) * numPerpage + 1);
				pstmt.setInt(3, cPage * numPerpage);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					categorylist.add(getProduct(rs));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(pstmt);
			}
			return categorylist;
		}
		//대표카테고리 클릭시 대표카테고리상품리스트들 출력 화면에 출력할 페이징
		public int CategoryCount(Connection conn, String categoryname) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int result = 0;
			
			try {
				pstmt = conn.prepareStatement(sql.getProperty("CategoryCount"));
				pstmt.setString(1, categoryname);
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
