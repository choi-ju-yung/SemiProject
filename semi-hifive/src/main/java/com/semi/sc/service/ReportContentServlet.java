package com.semi.sc.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.member.model.vo.Member;
import com.semi.sc.model.dto.BoardComment;
import com.semi.sc.model.dto.Report;
import com.semi.sc.model.dto.ServiceFile;

/**
 * Servlet implementation class ReportContentServlet
 */
@WebServlet("/service/reportContent.do")
public class ReportContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ReportContentServlet() {
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = ((HttpServletRequest)request).getSession();
		String loginId = ((Member)session.getAttribute("loginMember")).getNickName();
		if(!request.getParameter("user").equals(loginId)) { //작성자랑 로그인 사용자가 다른 경우
			request.setAttribute("msg", "잘못된 접근입니다.");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}
		int reportNo=Integer.parseInt(request.getParameter("no"));
		//신고글
		Report r=new ReportService().selectReportContent(reportNo);
		System.out.println(r);
		request.setAttribute("report", r);
		
		//첨부파일
		List<ServiceFile> files=new ReportService().selectReportFile(reportNo);
		request.setAttribute("files", files);
		//댓글
		List<BoardComment> comments=new ReportService().selectReportComment(reportNo);
		request.setAttribute("comments", comments);
		
		request.getRequestDispatcher("/views/service/reportContent.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
