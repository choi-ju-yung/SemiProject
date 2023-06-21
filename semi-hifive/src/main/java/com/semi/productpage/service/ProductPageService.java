package com.semi.productpage.service;

import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.commit;
import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.Date;
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
	
	public List<ProductComment> selectProductComment(int id){
		Connection conn=getConnection();
		List<ProductComment> list=dao.selectProductComment(conn,id);
		close(conn);
		return list;
	}
	
	public ProductComment selectAjaxProductComment(int id){
		Connection conn=getConnection();
		ProductComment p=dao.selectAjaxProductComment(conn,id);
		close(conn);
		return p;
	}
	
	public ProductComment selectReAjaxProductComment(int id){
		Connection conn=getConnection();
		ProductComment p=dao.selectReAjaxProductComment(conn,id);
		close(conn);
		return p;
	}
	
	public int insertAjaxProductComment(ProductComment pc) {
		Connection conn=getConnection();
		int result=dao.insertAjaxProductComment(conn,pc);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public int updateAjaxProductComment(ProductComment pc, int cn) {
		Connection conn=getConnection();
		int result=dao.updateAjaxProductComment(conn,pc,cn);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public ProductComment updateSelectAjaxProductComment(int cn){
		Connection conn=getConnection();
		ProductComment p=dao.updateSelectAjaxProductComment(conn,cn);
		close(conn);
		return p;
	}
	
	public int deleteAjaxProductComment(int cn) {
		Connection conn=getConnection();
		int result=dao.deleteAjaxProductComment(conn,cn);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
}
