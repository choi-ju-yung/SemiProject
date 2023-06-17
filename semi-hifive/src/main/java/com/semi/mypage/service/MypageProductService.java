package com.semi.mypage.service;

import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.semi.mypage.dao.MypageProductDao;
import com.semi.mypage.model.vo.MemberShopPage;
import com.semi.mypage.model.vo.Product;
import com.semi.mypage.model.vo.ProductList;

public class MypageProductService {
	private MypageProductDao dao = new MypageProductDao();

	// 판매목록
	public List<ProductList> selectSellListByUserId(String userId) {
		Connection conn = getConnection();
		List<ProductList> p = dao.selectSellListByUserId(conn, userId);
		close(conn);
		return p;
	}
	
	// 구매목록
	public List<ProductList> selectBuyListByUserId(String userId) {
		Connection conn = getConnection();
		List<ProductList> p = dao.selectBuyListByUserId(conn, userId);
		close(conn);
		return p;
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
