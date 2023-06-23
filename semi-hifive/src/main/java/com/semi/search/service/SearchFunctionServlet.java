package com.semi.search.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.product.model.vo.Product;
import com.semi.search.controller.SearchController;
import com.semi.search.model.vo.Search;

/**
 * Servlet implementation class SearchFunctionServlet
 */
@WebServlet("/search")
public class SearchFunctionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchFunctionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String data=request.getParameter("productname");
		String id=request.getParameter("id");
		
		List<Product> p=new SearchController().searchFunction(data);
		
		 List<Search> search=new SearchController().recentSearch(id);
		 
		 HttpSession session=request.getSession(); 
		 session.setAttribute("search",search);
		 
		
		request.setAttribute("product",p);
		request.getRequestDispatcher("/views/productsearchchartpage/productsearchchartpage2.jsp").forward(request, response);	
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
