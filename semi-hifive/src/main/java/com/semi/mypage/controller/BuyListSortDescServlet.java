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
 * Servlet implementation class buyListSortDescServlet
 */
@WebServlet("/sortDesc.do")
public class BuyListSortDescServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyListSortDescServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String userId = request.getParameter("userId");
//		List<ProductList> sortDesc = new MypageProductService().selectBuyListByUserId(userId);
//		
//		request.setAttribute("buyProduct", sortDesc);
//		request.getRequestDispatcher("/views/mypage/buyList.jsp").forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
