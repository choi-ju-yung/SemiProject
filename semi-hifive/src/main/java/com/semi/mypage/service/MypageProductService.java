package com.semi.mypage.service;

import static com.semi.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.semi.mypage.dao.MypageProductDao;
import com.semi.mypage.model.vo.MemberShopPage;
import com.semi.mypage.model.vo.Product;
import com.semi.mypage.model.vo.ProductList;

public class MypageProductService {
	private MypageProductDao dao = new MypageProductDao();

	// 판매목록
	public List<ProductList> selectSellListByUserId(int cPage, int numPerpage, String userId) {
		Connection conn = getConnection();
		List<ProductList> p = dao.selectSellListByUserId(conn, cPage, numPerpage, userId);
		close(conn);
		return p;
	}
	
	// 구매목록
	public List<ProductList> selectBuyListByUserId(int cPage, int numPerpage, String userId) {
		Connection conn = getConnection();
		List<ProductList> p = dao.selectBuyListByUserId(conn, cPage, numPerpage, userId);
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

	// 판매상태 카운트(판매중, 예약중, 판매완료)
	public int countSellStatusSell(String userId, String status) {
		Connection conn = getConnection();
		int count = dao.countSellStatusSell(conn, userId, status);
		close(conn);
		return count;
	}
	
	// 성사된 거래수
	public int countTrade(String userId) {
		Connection conn = getConnection();
		int count = dao.countTrade(conn, userId);
		close(conn);
		return count;
	}
	
	// 구매내역 오래된순
	public List<ProductList> BuyListSortAsc(int cPage, int numPerpage, String userId) {
		Connection conn = getConnection();
		List<ProductList> p = dao.BuyListSortAsc(conn, cPage, numPerpage, userId);
		close(conn);
		return p;
	}
	
	// 페이징(전체 상품수)
	public int countBuyList(String userId) {
		Connection conn = getConnection();
		int count = dao.countBuyList(conn, userId);
		close(conn);
		return count;
	}
	
	// 판매상태 변경(ajax)
	public int changeSelectValue(String value, String productId) {
		Connection conn = getConnection();
		int result = dao.changeSelectValue(conn, value, productId);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
}
