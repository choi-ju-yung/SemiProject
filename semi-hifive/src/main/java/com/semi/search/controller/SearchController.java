package com.semi.search.controller;

import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.commit;
import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.semi.product.model.vo.Product;
import com.semi.search.dao.SearchDao;
import com.semi.search.model.vo.SearchCount;
public class SearchController {
	
	SearchDao dao=new SearchDao();
	
	public int insertSearch(String content){
		Connection conn=getConnection();
		int result=dao.insertSearch(conn,content);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

	public List<Product> searchTitle(String content){
		Connection conn=getConnection();
		List<Product> searchList=dao.searchTitle(conn,content);
		close(conn);
		return searchList;
	}
	
	public List<Product> searchKeyWord(String content){
		Connection conn=getConnection();
		List<Product> searchList=dao.searchKeyWord(conn,content);
		close(conn);
		return searchList;
	}
	
	public SearchCount searchCount(String content){
		Connection conn=getConnection();
		SearchCount searchCount=dao.searchCount(conn,content);
		close(conn);
		return searchCount;
	}
}
