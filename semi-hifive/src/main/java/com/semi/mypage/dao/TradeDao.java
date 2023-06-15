package com.semi.mypage.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public class TradeDao {
	
	private Properties sql = new Properties();
	
	public TradeDao() {
		String path = TradeDao.class.getResource("/sql/mypage/tradesql.properties").getPath();
		try {
			sql.load(new FileReader(path));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public int selectTradeCount(Connection conn) {
		return 1;
	}
	
}
