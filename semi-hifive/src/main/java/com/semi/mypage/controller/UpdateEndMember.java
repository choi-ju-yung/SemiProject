package com.semi.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.mypage.model.vo.MemberShopPage;
import com.semi.mypage.model.vo.ShopPage;
import com.semi.mypage.service.MypageMemberService;

/**
 * Servlet implementation class UpdateEndMember
 */
@WebServlet("/member/updateEndMemeber.do")
public class UpdateEndMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEndMember() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberShopPage msp = MemberShopPage.builder()
				.userId(request.getParameter("myPageUserId"))
				.nickName(request.getParameter("myPageNickname"))
				.introduce(request.getParameter("myPageIntroduce"))
				.build();
		int result = new MypageMemberService().updateMember(msp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
