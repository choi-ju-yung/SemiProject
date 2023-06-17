package com.semi.sc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.sc.model.dto.Board;
import com.semi.sc.service.BoardService;


@WebServlet("/service/boardContent.do")
public class BoardContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BoardContentServlet() {
    }

	//board_no를 가지고 해당 게시글을 조회하는 서블릿
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNo=Integer.parseInt(request.getParameter("boardNo")); //board_no 저장
		Board b=new BoardService().selectBoardContent(boardNo);
		request.setAttribute("board", b);
		request.getRequestDispatcher("/views/service/boardContent.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
