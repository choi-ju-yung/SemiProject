package com.semi.productregist.service;

import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.semi.category.model.vo.Category;
import com.semi.member.model.vo.Member;
import com.semi.product.model.vo.Product;
import com.semi.productregist.dao.ProductRegistDao;

public class ProductRegistService {
	private ProductRegistDao dao = new ProductRegistDao();

	
	// 대표카테고리 찾는 작업
	public List<Category> selectAll() {
		Connection conn = getConnection(); // jdbc 연결객체
		List<Category> categorys = dao.selectAll(conn);
		close(conn);
		return categorys;
	}

	// 서브카테고리 찾는 작업
	public List<String> selectSubCate(String cateId){
		Connection conn = getConnection(); // jdbc 연결객체
		List<String> subCategorys = dao.selectSubCate(conn,cateId);
		close(conn);
		return subCategorys;
	}
	
	
	public int insertProduct(Product p, Member m) {
		Connection conn = getConnection(); // jdbc 연결객체
		int result = dao.insertProduct(conn,p,m);
		close(conn);
		return result;
	}
	
	
	
}
