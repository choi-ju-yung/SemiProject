package com.semi.sc.report.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.member.model.vo.Member;
import com.semi.product.model.vo.Product;
import com.semi.sc.service.ReportService;


@WebServlet("/service/reportInsert.do")
public class ReportInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ReportInsertServlet() {
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = ((HttpServletRequest)request).getSession();
		String loginId = ((Member)session.getAttribute("loginMember")).getUserId();
		
		List<Product> buyList=new ReportService().selectBuyList(loginId);
		request.setAttribute("buyList", buyList);
		request.getRequestDispatcher("/views/service/reportInsertByBuylist.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}