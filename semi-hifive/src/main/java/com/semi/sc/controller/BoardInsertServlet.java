package com.semi.sc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.semi.sc.model.dto.Board;
import com.semi.sc.service.BoardService;


@WebServlet("/service/boardInsert.do")
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BoardInsertServlet() {
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//multipart/form-data 형식의 요청인지 확인
		if (!(ServletFileUpload.isMultipartContent(request))) {
			// 해당 타입이 맞으면 true, 아니면 false를 반환
			request.setAttribute("msg", "잘못된 접근입니다. 관리자에게 문의하세요.");
			request.setAttribute("loc", "/"); //해당 페이지로 다시 돌아감
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return; // multipart타입이 아니면 리턴 처리
		}
		String path=getServletContext().getRealPath("/upload/board");
		int maxSize=1024*1024*500; //500MB
		String encode="UTF-8";
		DefaultFileRenamePolicy dfr=new DefaultFileRenamePolicy();
		MultipartRequest mr=new MultipartRequest(request, path, maxSize, encode, dfr);
		String renamedFilename=mr.getFilesystemName(mr.getParameter("board_file"));
		
		Board b=Board.builder()
				.boardWriter(mr.getParameter("login"))
				.noticeYn(mr.getParameter("titleCategory").charAt(0))
				.boardCategory(mr.getParameter("QACategory"))
				.boardTitle(mr.getParameter("boardTitle"))
				.boardContent(mr.getParameter("boardContent"))
				.boardOriginalFileName(mr.getParameter("boardOriginalFile"))
				.boardRenamedFileName(renamedFilename)
				.build();
		
		int result=new BoardService().insertBoard(b);
		if(result==0) {
			response.sendRedirect(request.getHeader("referer"));
		}else {
			response.sendRedirect(request.getContextPath()+"/service/boardList.do?notice=Y");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
