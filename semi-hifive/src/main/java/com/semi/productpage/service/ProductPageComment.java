package com.semi.productpage.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.productpage.model.vo.ProductComment;

/**
 * Servlet implementation class ProductPageComment
 */
@WebServlet("/insertComment")
public class ProductPageComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductPageComment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductComment pc=ProductComment.builder()
				.productId(Integer.parseInt(request.getParameter("productId")))
				.commentLevel(Integer.parseInt(request.getParameter("level")))
				.userId(request.getParameter("userId"))
				.content(request.getParameter("content"))
				.commentRef(Integer.parseInt(request.getParameter("CommentRef")))
				.build();
		int result=new ProductPageService().productPageComment(pc);
		
		String view;
		if(result>0) {
			view = request.getContextPath()+"/productpage?no="+pc.getProductId();
			response.sendRedirect(view);
		}else {			
//			request.setAttribute("loc", "/board/boardView.do?no="+bc.getBoardRef());
//			view="/views/common/msg.jsp";
//			request.getRequestDispatcher(view).forward(request,response);
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