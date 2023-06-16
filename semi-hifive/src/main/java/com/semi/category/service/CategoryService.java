package com.semi.category.service;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Properties;
import static com.semi.common.JDBCTemplate.*;

import com.semi.category.dao.CategoryDao;
import com.semi.category.model.vo.CategoryDto;
import com.semi.product.model.dao.ProductChartPageDao;

public class CategoryService {
	private CategoryDao dao = new CategoryDao();
	
	public List<CategoryDto> CategoryList() {
		Connection conn = getConnection();
		List<CategoryDto> categorylist = dao.CategoryList(conn);
		close(conn);
		return categorylist;
	}
}
