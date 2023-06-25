package com.semi.productpage.service;

import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.commit;
import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.semi.productpage.dao.ProductDao;
import com.semi.productpage.model.vo.AjaxProductComment;
import com.semi.productpage.model.vo.ProductCategory;
import com.semi.productpage.model.vo.ProductCommentUser;

public class ProductPageService {
	
	ProductDao dao=new ProductDao();
	
	public ProductCategory selectProduct(int id) {
		Connection conn=getConnection();
		ProductCategory result=dao.selectProduct(conn,id);
		close(conn);
		return result;		
	}
	
	public List<ProductCommentUser> selectAllProductComment(int id){
		Connection conn=getConnection();
		List<ProductCommentUser> list=dao.selectAllProductComment(conn,id);
		close(conn);
		return list;
	}
	
	public AjaxProductComment selectAjaxProductComment(int id){
		Connection conn=getConnection();
		AjaxProductComment p=dao.selectAjaxProductComment(conn,id);
		close(conn);
		return p;
	}
	
	public AjaxProductComment selectReAjaxProductComment(int id){
		Connection conn=getConnection();
		AjaxProductComment p=dao.selectReAjaxProductComment(conn,id);
		close(conn);
		return p;
	}
	
	public int insertAjaxProductComment(ProductCommentUser pc) {
		Connection conn=getConnection();
		int result=dao.insertAjaxProductComment(conn,pc);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public int updateAjaxProductComment(ProductCommentUser pc, int cn) {
		Connection conn=getConnection();
		int result=dao.updateAjaxProductComment(conn,pc,cn);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public AjaxProductComment updateSelectAjaxProductComment(int cn){
		Connection conn=getConnection();
		AjaxProductComment p=dao.updateSelectAjaxProductComment(conn,cn);
		close(conn);
		return p;
	}
	
	public int deleteProductComment(int cn) {
		Connection conn=getConnection();
		int result=dao.deleteProductComment(conn,cn);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

}
