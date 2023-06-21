package com.semi.product.model.service;
import static com.semi.common.JDBCTemplate.*;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.semi.category.model.vo.CategoryDto;
import com.semi.product.model.dao.ProductChartPageDao;
import com.semi.product.model.vo.ProductDto;


public class ProductChartPageService {
	private ProductChartPageDao dao = new ProductChartPageDao();
	
	public List<ProductDto> CategoryProductList(int cPage, int numPerpage){
		Connection conn = getConnection();
		List<ProductDto> list = dao.CategoryProductList(conn, cPage, numPerpage);
		close(conn);
		return list;
	}
	
	public int CategoryProductListCount() {
		Connection conn = getConnection();
		int result = dao.CategoryProductListCount(conn);
		close(conn);
		return result;
	}
	
	public ProductDto SelectProduct(int productId) {
		Connection conn = getConnection();
		ProductDto p = dao.SelectProduct(conn, productId);
		close(conn);
		return p;
	}
	
	//서브카테고리 이름을 찾아서 가져오기
	public List<ProductDto> SelectCategoryList(int cPage, int numPerpage ,String subcategoryname) {
		Connection conn = getConnection();
		List<ProductDto> p = dao.SelectCategoryList(conn, cPage, numPerpage, subcategoryname);
		close(conn);
		return p;
	}
	
	public int SelectCategoryProductListCount(String subcategoryname){
		Connection conn = getConnection();
		int result = dao.SelectCategoryProductListCount(conn, subcategoryname);
		close(conn);
		return result;
	}
	
	//카테고리 선택시 카테고리 상품리스트 출력
	public List<ProductDto> CategoryList(int cPage, int numPerpage, String categoryname) {
			Connection conn = getConnection();
			List<ProductDto> categorylist = dao.CategoryList(conn, cPage, numPerpage, categoryname);
			close(conn);
			return categorylist;
	}
		
	public int CategoryCount(String categoryname) {
			Connection conn = getConnection();
			int selectcategory = dao.CategoryCount(conn, categoryname);
			close(conn);
			return selectcategory;
	}
	
}
