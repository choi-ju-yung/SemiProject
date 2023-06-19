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
	public List<CategoryDto> SelectCategory(){
		Connection conn = getConnection();
		List<CategoryDto> category = dao.SelectCategory(conn);
		close(conn);
		return category;
	}
	
	public List<CategoryDto> SubCategoryList(){
		Connection conn = getConnection();
		List<CategoryDto> category = dao.SubCategoryList(conn);
		close(conn);
		return category;
	}
}
