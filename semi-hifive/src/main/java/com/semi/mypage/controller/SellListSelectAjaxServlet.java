package com.semi.mypage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.mypage.service.MypageProductService;

/**
 * Servlet implementation class SellListSelectAjaxServlet
 */
@WebServlet("/mypage/ajaxSelect.do")
public class SellListSelectAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellListSelectAjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String selectValue;
		String productId = request.getParameter("productId");
		
		if(request.getParameter("selectValue").equals("sell")) {
			selectValue = "판매중";
		} else if (request.getParameter("selectValue").equals("reservation")) {
			selectValue = "예약중";
		} else {
			selectValue = "판매완료";
		}
		
		int result = new MypageProductService().changeSelectValue(selectValue, productId);
		
		//response.setContentType("text/csv; charset=utf-8");
		//response.getWriter().print(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
