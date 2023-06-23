package com.semi.sc.inquiry.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.member.model.vo.Member;
import com.semi.sc.model.dto.Inquiry;
import com.semi.sc.service.InquiryService;


@WebServlet("/service/inquiryContent.do")
public class InquiryContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public InquiryContentServlet() {
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		char secret=request.getParameter("s").charAt(0);
		
		HttpSession session = ((HttpServletRequest)request).getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		int inquiryNo=Integer.parseInt(request.getParameter("no"));
		Inquiry q=new InquiryService().selectInquiryContent(inquiryNo);
		
		if(secret=='Y'&& //비밀글
				(!loginMember.getNickName().equals(q.getInquiryWriter())|| //작성자 일치
						!loginMember.getAuth().equals("M"))) { //혹은 관리자 권한
			request.setAttribute("msg", "조회 권한이 없습니다.");
			request.setAttribute("loc", "/service/inquiryList.do");
			request.getRequestDispatcher("views/common/msg.jsp").forward(request, response);
		}
		
		request.setAttribute("inquiry", q);
		
		request.getRequestDispatcher("/views/service/inquiryContent.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
