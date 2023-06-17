package com.semi.productpage.service;

import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.commit;
import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.semi.productpage.dao.ProductDao;
import com.semi.productpage.model.vo.Product;
import com.semi.productpage.model.vo.ProductComment;

public class ProductPageService {
	
	ProductDao dao=new ProductDao();
	
	public Product selectProduct(int id) {
		Connection conn=getConnection();
		Product result=dao.selectProduct(conn,id);
		close(conn);
		return result;		
	}
	
	public int productPageComment(ProductComment pc) {
		Connection conn=getConnection();
		int result=dao.productPageComment(conn,pc);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	public List<ProductComment> selectComment(int id){
		Connection conn=getConnection();
		List<ProductComment> list=dao.selectBoardComment(conn,id);
		close(conn);
		return list;
	}
	
}
