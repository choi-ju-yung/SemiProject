package com.semi.productpage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.productpage.model.vo.Product;
import com.semi.productpage.model.vo.ProductComment;
import com.semi.productpage.service.ProductPageService;

/**
 * Servlet implementation class ProductPageServlet
 */
@WebServlet("/productpage")
public class ProductPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductPageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Product테이블 데이터 가져오기
		int no = Integer.parseInt(request.getParameter("no"));
		System.out.println("서블릿" + no);
		Product p = new ProductPageService().selectProduct(no);
		System.out.println("서블릿" + p);
		
		List<ProductComment> comments = new ProductPageService().selectAllProductComment(no);
		request.setAttribute("product", p);
		request.setAttribute("comments", comments);
		// 출력할 화면 선택
		request.getRequestDispatcher("/views/productpage/ProductPage.jsp").forward(request, response);	
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
