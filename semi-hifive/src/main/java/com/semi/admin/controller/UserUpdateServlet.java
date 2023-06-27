package com.semi.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.member.model.vo.Member;
import com.semi.member.service.MemberService;


@WebServlet("/userUpdate.do")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("서블릿");
		String userId = request.getParameter("userId");

		Member m = new MemberService().selectByUserId(userId); // 유저아이디로 회원 정보갖고오기
		
		request.setAttribute("member", m);
		
		request.getRequestDispatcher("views/admin/userUpdate.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
