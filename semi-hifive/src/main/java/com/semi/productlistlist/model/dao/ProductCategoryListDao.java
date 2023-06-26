package com.semi.productlistlist.model.dao;

import static com.semi.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import com.semi.category.model.vo.Category;
import com.semi.category.model.vo.SubCategory;
import com.semi.productlist.model.vo.ProductCategoryList;
import com.semi.productlist.model.vo.ProductCategoryTimeList;

public class ProductCategoryListDao {
	private Properties sql = new Properties();
	{
		String path = ProductCategoryListDao.class.getResource("/sql/product/productchartpage.sql.properties").getPath();
		
		try {
			sql.load(new FileReader(path));
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static ProductCategoryTimeList getProduct(ResultSet rs) throws SQLException {
		return ProductCategoryTimeList.builder()
		.elapsedTime(rs.getLong("ELAPSED_TIME"))
//		.productAndSubCategoryname(rs.getString("PRODUCT_SUBCATEGORY_NAME"))
//		.categorySubCategoryname(rs.getString("CATEGORY_SUBCATEGORY_NAME"))
		.productCategoryList(ProductCategoryList.builder()
				.productId(rs.getInt("PRODUCT_ID"))
				.userId(rs.getString("USER_ID"))
				.productTitle(rs.getString("PRODUCT_TITLE"))
				.productStatus(rs.getString("PRODUCT_STATUS"))
				.sellStatus(rs.getString("SELL_STATUS"))
				.price(rs.getInt("PRICE"))
				.registTime(rs.getDate("REGIST_TIME"))
				.viewCount(rs.getInt("VIEW_COUNT"))
				.explanation(rs.getString("EXPLANATION"))
				.keyword(rs.getString("KEYWORD")!= null ? rs.getString("KEYWORD").split(",") : null)
				.subcategoryName(rs.getString("SUBCATEGORY_NAME"))
				.areaName(rs.getString("AREA_NAME")).build())
		.category(Category.builder()
					.categoryId(rs.getString("CATEGORY_ID"))
					.categoryName(rs.getString("CATEGORY_NAME")).build())
		.subCategory(SubCategory.builder()
					.subcategoryName(rs.getString("SUBCATEGORY_NAME")).build())
		.build();
	}
	// 전체 상품리스트 가져오기 카테고리, 세부카테고리 모두 join해서 가져온것
	public List<ProductCategoryTimeList> CategoryProductList(Connection conn, int cPage, int numPerpage) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ProductCategoryTimeList> productlist = new ArrayList<>();
	
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
	
//	전체 상품리스트 가져오기 카테고리, 세부카테고리 모두 join해서 가져온것 페이징처리 	
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
	public ProductCategoryTimeList SelectProduct(Connection conn, int productId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductCategoryTimeList p = null;
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
	//선택한 서브카테고리이름으로 찾아서 상품리스트 화면 출력
	public List<ProductCategoryTimeList> SelectSubCategoryList(Connection conn, int cPage, int numPerpage ,String subcategoryname) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ProductCategoryTimeList> selectcategorylist = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql.getProperty("SelectSubCategoryList"));
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
	
	public int SelectSubCategoryProductListCount(Connection conn, String subcategoryname) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql.getProperty("SelectSubCategoryProductListCount"));
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
		public List<ProductCategoryTimeList> CategoryList(Connection conn, int cPage, int numPerpage, String categoryname){
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<ProductCategoryTimeList> categorylist = new ArrayList<>();
			
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
		public List<ProductCategoryTimeList> GetProductCondition(Connection conn, int cPage, int numPerpage, String conditions) {
			PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    List<ProductCategoryTimeList> selectgetproduct = new ArrayList<>();
		    
		    String query=sql.getProperty("GetProductCondition").replace("#CONDITIONS#", conditions);
		    try {
				pstmt = conn.prepareStatement(query);
				
				pstmt.setInt(1, (cPage-1) * numPerpage + 1);
				pstmt.setInt(2, cPage * numPerpage);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					selectgetproduct.add(getProduct(rs));
				}
						
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(pstmt);
			}return selectgetproduct;
		}
		public int GetProductConditionCount(Connection conn, String conditions) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int result = 0;
			try {
				pstmt = conn.prepareStatement(sql.getProperty("GetProductConditionCount").replace("#CONDITIONS#", conditions));
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
		public List<ProductCategoryTimeList> MaxpriceList(Connection conn, int cPage, int numPerpage, String conditions) {
			PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    List<ProductCategoryTimeList> selectgetproduct = new ArrayList<>();
		    
		    String query=sql.getProperty("MaxpriceList").replace("#Max#", conditions);
		    try {
				pstmt = conn.prepareStatement(query);
				
				pstmt.setInt(1, (cPage-1) * numPerpage + 1);
				pstmt.setInt(2, cPage * numPerpage);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					selectgetproduct.add(getProduct(rs));
				}
						
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(pstmt);
			}return selectgetproduct;
		}
		public int MaxpriceListCount(Connection conn, String conditions ) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int result = 0;
			try {
				pstmt = conn.prepareStatement(sql.getProperty("MaxpriceListCount").replace("#Max#", conditions));
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
		public List<ProductCategoryTimeList> MinpriceList(Connection conn, int cPage, int numPerpage, String conditions) {
			PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    List<ProductCategoryTimeList> selectgetproduct = new ArrayList<>();
		    
		    String query=sql.getProperty("MinpriceList").replace("#Min#", conditions);
		    try {
				pstmt = conn.prepareStatement(query);
				
				pstmt.setInt(1, (cPage-1) * numPerpage + 1);
				pstmt.setInt(2, cPage * numPerpage);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					selectgetproduct.add(getProduct(rs));
				}
						
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(pstmt);
			}return selectgetproduct;
		}
		public int MinpriceListCount(Connection conn, String conditions ) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int result = 0;
			try {
				pstmt = conn.prepareStatement(sql.getProperty("MinpriceListCount").replace("#Min#", conditions));
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
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		public List<ProductCategoryTimeList> Test(Connection conn, int cPage, int numPerpage, String test) {
			PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    List<ProductCategoryTimeList> selectgetproduct = new ArrayList<>();
		    
		    String query=sql.getProperty("Test").replace("#TEST#", test);
		    try {
				pstmt = conn.prepareStatement(query);
				
				pstmt.setInt(1, (cPage-1) * numPerpage + 1);
				pstmt.setInt(2, cPage * numPerpage);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					selectgetproduct.add(getProduct(rs));
				}
						
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(pstmt);
			}return selectgetproduct;
		}
		public int TestCount(Connection conn, String test) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int result = 0;
			try {
				pstmt = conn.prepareStatement(sql.getProperty("TestCount").replace("#TEST#", test));
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
