package com.semi.productpage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.productpage.model.vo.ProductComment;
import com.semi.productpage.service.ProductPageService;

/**
 * Servlet implementation class ProductChangeCommentServlet
 */
@WebServlet("/changeComment")
public class ProductChangeCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductChangeCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cn=Integer.parseInt(request.getParameter("commentNo"));
		ProductComment pc=ProductComment.builder()
				.productId(Integer.parseInt(request.getParameter("productId")))
				.content(request.getParameter("content"))
				.build();
		int result=new ProductPageService().changeProductComment(pc,cn);
		String view;
		if(result>0) {
			view = request.getContextPath()+"/productpage?no="+pc.getProductId();
			response.sendRedirect(view);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
