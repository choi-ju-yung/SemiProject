package com.semi.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.member.model.vo.Member;
import com.semi.mypage.service.MypageMemberService;

/**
 * Servlet implementation class MypageDuplicateNicknameServlet
 */
@WebServlet("/mypage/duplicateNickname.do")
public class MypageDuplicateNicknameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageDuplicateNicknameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ajax 응답서블릿 -> 닉네임 중복확인
		String nickname = request.getParameter("nickname"); 
		
		Member m = new MypageMemberService().selectByNickname(nickname);
		// m이 null이면 사용가능 닉네임, null이 아니면 이미 있는 닉네임
		
		
		response.setContentType("text/csv; charset=utf-8");
		response.getWriter().print(m==null?true:false);
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
