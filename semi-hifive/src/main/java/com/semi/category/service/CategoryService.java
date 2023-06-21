package com.semi.category.service;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Properties;

import org.apache.catalina.Contained;

import static com.semi.common.JDBCTemplate.*;

import com.semi.category.dao.CategoryDao;
import com.semi.category.model.vo.CategoryDto;
import com.semi.product.model.dao.ProductChartPageDao;

public class CategoryService {
	private CategoryDao dao = new CategoryDao();
	
	// 대표카테고리만 출력해주는 메소드
	public List<CategoryDto> Category(){
		Connection conn = getConnection();
		List<CategoryDto> category = dao.Category(conn);
		close(conn);
		return category;
	}	
	// 서브카테고리랑 대표카테고리 join한것
	public List<CategoryDto> SubCategoryList(){
		Connection conn = getConnection();
		List<CategoryDto> category = dao.SubCategoryList(conn);
		close(conn);
		return category;
	}
	// 카테고리 테이블에서 카테고리 이름을 찾아서 카테고리 이름과 카테고리 id값 출력해주는 메소드
	public CategoryDto CategoryName(String categoryname) {
		Connection conn = getConnection();
		CategoryDto c = dao.CategoryName(conn, categoryname);
		close(conn);
		return c;
	}
}
