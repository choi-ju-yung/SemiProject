package com.semi.productregist.service;

import static com.semi.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.semi.category.model.vo.Category;
import com.semi.product.model.vo.Product;
import com.semi.product.model.vo.ProductFile;
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
	
	
	public int insertProduct(Product p, String userId) {
		Connection conn = getConnection(); // jdbc 연결객체
		int result = dao.insertProduct(conn,p,userId);

		List<ProductFile> files=p.getFiles();
		System.out.println(files);

		
		int count = 0;
		if(p.getFiles().size()>0) {
			for(ProductFile f: files) {
				f.setImageName(f.getImageName());
				f.setMainImageYn('N');
				if(count == 0) {
					f.setMainImageYn('Y');
				}
				result=dao.insertProductFile(conn,f);
				count++;
				if(result>0)commit(conn);
				else rollback(conn);
			}
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	
	
}
