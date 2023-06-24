package com.semi.mypage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.mypage.model.vo.ReviewTrade;
import com.semi.mypage.service.MypageProductService;

/**
 * Servlet implementation class BuyListReviewListAjaxServlet
 */
@WebServlet("/mypage/reviewList.do")
public class BuyListReviewListAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyListReviewListAjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String productId = request.getParameter("productId");
//		ReviewTrade rt = new MypageProductService().selectReview(productId);
//		
//		String result = ""; 
//		if (rt == null) {
//			// 등록된 후기 없음
//		} else {
//			// 이미 등록된 후기 있음
//			result = "이미 등록된 거래후기가 있습니다.";
//		}
//		response.setContentType("text/plain");
//		response.setCharacterEncoding("UTF-8");
//		response.getWriter().write(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
