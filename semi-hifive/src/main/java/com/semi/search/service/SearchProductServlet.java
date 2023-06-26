package com.semi.search.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.product.model.vo.Product;
import com.semi.search.controller.SearchController;
import com.semi.search.model.vo.SearchCount;

/**
 * Servlet implementation class SearchFunctionServlet
 */
@WebServlet("/searchProduct")
public class SearchProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String content = request.getParameter("content");
		List<Product> searchList = new ArrayList();
		SearchCount searchCount = new SearchController().searchCount(content);
		
		if (content.length()>2&&content.charAt(1)=='#') {			
			searchList = new SearchController().searchKeyWord(content);
		} else {
			searchList = new SearchController().searchTitle(content);
		}
		request.setAttribute("content", content);
		request.setAttribute("searchList", searchList);
		request.setAttribute("searchCount", searchCount);
		request.getRequestDispatcher("/views/productsearchchartpage/productsearchchartpage2.jsp").forward(request,response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
