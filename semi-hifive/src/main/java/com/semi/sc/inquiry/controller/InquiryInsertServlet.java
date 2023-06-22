package com.semi.sc.inquiry.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.member.model.vo.Member;


@WebServlet("/service/inquiryInsert.do")
public class InquiryInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public InquiryInsertServlet() {
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String loginId=null;
		if(session!=null) {
			Member loginMember=(Member)session.getAttribute("loginMember");
			loginId=loginMember.getUserId();
		}
		request.setAttribute("loginId", loginId);
		request.getRequestDispatcher("/views/service/InquiryInsert.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
