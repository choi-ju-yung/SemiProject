package com.semi.mypage.service;

import static com.semi.common.JDBCTemplate.*;

import java.sql.Connection;

import com.semi.mypage.dao.ShopPageDao;
import com.semi.mypage.model.vo.ShopPage;

public class ShopPageService {
	private ShopPageDao dao = new ShopPageDao();
	
	public ShopPage searchIntroduceById(String userId) {
		Connection conn = getConnection();
		ShopPage sp = dao.searchIntroduceById(conn, userId);
		close(conn);
		return sp;
	}
	
}
