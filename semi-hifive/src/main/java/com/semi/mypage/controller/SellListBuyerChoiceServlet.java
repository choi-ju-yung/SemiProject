package com.semi.mypage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SellListBuyerChoiceServlet
 */
@WebServlet("/mypage/buyerIdChoice.do")
public class SellListBuyerChoiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellListBuyerChoiceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productId = request.getParameter("productId");
		System.out.println("구매자" + productId);
		
		// 상품코드로 거래테이블 열고
		// 상품코드로 댓글을 남긴 사람 데이터 가져옴(구매자 리스트)
		// 1. 구매자 후보 가져오기(채팅 상대 || 댓글 남긴 사람)
		// jsp통해서 출력
		
		// 다음 서블릿에서 구현
		// 2. insert문에 buyer_id = 구매자, where product_id = productId 주기
		// jsp에서 선택 시 다른 서블릿 이동, 구매자아이디 가져오기
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
