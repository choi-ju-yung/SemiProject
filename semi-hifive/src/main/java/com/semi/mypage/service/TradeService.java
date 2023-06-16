package com.semi.mypage.service;

import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.semi.mypage.dao.TradeDao;
import com.semi.mypage.model.vo.Product;

public class TradeService {
	
	private TradeDao dao = new TradeDao();
	
	// totalData : 거래 테이블 개수
	public int selectTradeCount() {
		Connection conn = getConnection();
		int result = dao.selectTradeCount(conn);
		close(conn);
		return result;
	}
	
	// 아이디로 판매내역 가져오기
	public List<Product> selectSellListById(String userId){
		Connection conn = getConnection();
		List<Product> p = dao.selectSellListById(conn, userId);
		close(conn);
		return p;
	}
	
	// 찜 수 가져오기
	public int interestCount() {
		Connection conn = getConnection();
		int count = dao.interestCount(conn);
		close(conn);
		return count;
	}
	
	// 판매상태 카운트(전체)
	public int countSellStatusAll(String userId) {
		Connection conn = getConnection();
		int count = dao.countSellStatusAll(conn, userId);
		close(conn);
		return count;
	}
	
	// 판매상태 카운트(판매중)
	public int countSellStatusSell(String userId, String status) {
		Connection conn = getConnection();
		int count = dao.countSellStatusSell(conn, userId, status);
		close(conn);
		return count;
	}
	
	
}
