package com.semi.mypage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.mypage.model.vo.ProductList;
import com.semi.mypage.service.MypageProductService;

/**
 * Servlet implementation class SellList
 */
@WebServlet("/myPage/sellList.do")
public class SellListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		
		// 판매목록 가져오기
		List<ProductList> p = new MypageProductService().selectSellListByUserId(userId);
		request.setAttribute("sellProduct", p);
		
		// 판매상태 카운트(전체)
		int total = new MypageProductService().countSellStatusAll(userId);
		request.setAttribute("countAll", total);
		
		// 판매상태 카운트(판매중, 예약중, 판매완료)
		String selling = "판매중";
		int countStatusSell = new MypageProductService().countSellStatusSell(userId, selling);
		String reserve = "예약중";
		int countStatusRes = new MypageProductService().countSellStatusSell(userId, reserve);
		String soldOut = "판매완료";
		int countStatusSol = new MypageProductService().countSellStatusSell(userId, soldOut);
		request.setAttribute("countStatusSell", countStatusSell);
		request.setAttribute("countStatusRes", countStatusRes);
		request.setAttribute("countStatusSol", countStatusSol);
		
		request.getRequestDispatcher("/views/mypage/sellList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
