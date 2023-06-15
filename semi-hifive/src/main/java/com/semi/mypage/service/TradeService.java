package com.semi.mypage.service;

import static com.semi.common.JDBCTemplate.*;

import java.sql.Connection;

import com.semi.mypage.dao.TradeDao;

public class TradeService {
	
	private TradeDao dao = new TradeDao();
	
	// totalData : 거래 테이블 개수
	public int selectTradeCount() {
		Connection conn = getConnection();
		int result = dao.selectTradeCount(conn);
		close(conn);
		return result;
	}
}
