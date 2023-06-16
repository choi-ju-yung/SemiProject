package com.semi.productregist.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.member.model.vo.Member;


@WebServlet("/productRegist.do")
public class ProductRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ProductRegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Member loginMember = (Member) session.getAttribute("loginMember");
		if(loginMember == null) {
			request.setAttribute("msg", "로그인 한 후 이용해주세요");
			request.setAttribute("loc", "/views/login/loginview.jsp");
			request.getRequestDispatcher("/views/common/msg.jsp")
			.forward(request, response);
		}else {
			/*
			 * request.getRequestDispatcher("/views/product/productregist.jsp")
			 * .forward(request, response);
			 */
			
			
			
			
			response.sendRedirect(request.getContextPath()+"/views/product/productregist.jsp"); 
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
