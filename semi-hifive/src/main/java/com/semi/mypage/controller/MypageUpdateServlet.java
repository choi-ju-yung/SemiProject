package com.semi.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.member.model.vo.Member;
import com.semi.mypage.model.vo.MemberShopPage;
import com.semi.mypage.model.vo.ShopPage;
import com.semi.mypage.service.MypageMemberService;

/**
 * Servlet implementation class MypageUpdateServlet
 */
@WebServlet(urlPatterns = "/mypage/mypageUpdate.do")
public class MypageUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		MemberShopPage ms = new MypageMemberService().selectByUserId(userId);
		
		request.setAttribute("infoMemberShopPage", ms);
		
		request.getRequestDispatcher("/views/mypage/myPageUpdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
