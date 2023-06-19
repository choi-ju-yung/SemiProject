package com.semi.product.model.service;
import static com.semi.common.JDBCTemplate.*;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
	
	public List<ProductDto> SelectCategoryList(int cPage, int numPerpage ,String categoryid) {
		Connection conn = getConnection();
		List<ProductDto> p = dao.SelectCategoryList(conn, cPage, numPerpage, categoryid);
		close(conn);
		return p;
	}
	
	public int SelectCategoryProductListCount(String categoryid){
		Connection conn = getConnection();
		int result = dao.CategoryProductListCount(conn);
		close(conn);
		return result;
}
	
}
