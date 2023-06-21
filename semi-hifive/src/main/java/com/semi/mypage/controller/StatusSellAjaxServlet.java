package com.semi.mypage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.semi.mypage.model.vo.ProductList;
import com.semi.mypage.service.MypageProductService;

/**
 * Servlet implementation class StatusAllAjaxServlet
 */
@WebServlet("/mypage/sellBtn.do")
public class StatusSellAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatusSellAjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		List<ProductList> p = new MypageProductService().sellStatusSell(userId);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		String json = new Gson().toJson(p);
		response.getWriter().write(json);
		//new Gson().toJson(p, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
