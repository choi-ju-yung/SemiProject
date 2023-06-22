package com.semi.search.controller;

import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.commit;
import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.semi.productpage.model.vo.ProductComment;
import com.semi.search.dao.SearchDao;
import com.semi.search.model.vo.Search;
public class SearchController {
	
	SearchDao dao=new SearchDao();
	
	public List<Search> recentSearch(String id){
		Connection conn=getConnection();
		List<Search> list=dao.recentSearch(conn,id);
		close(conn);
		return list;
	}
	
	public int insertSearch(String data,String id){
		Connection conn=getConnection();
		int result=dao.insertSearch(conn,data,id);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public int deleteSearch(String data,String id){
		Connection conn=getConnection();
		int result=dao.deleteSearch(conn,data,id);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	
	
}
