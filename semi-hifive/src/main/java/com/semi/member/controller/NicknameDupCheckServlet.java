package com.semi.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.member.service.MemberService;

@WebServlet("/duplicateNickname.do")
public class NicknameDupCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public NicknameDupCheckServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String userNickname = request.getParameter("userNickname");
			
			// 1 , 2 , 3
			int result = new MemberService().checkNickname(userNickname);
			
			response.getWriter().print(result);  // getWriter -> jsp의 data로 들어감
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
