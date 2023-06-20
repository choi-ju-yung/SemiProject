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
import com.semi.sc.model.dto.BoardFile;
import com.semi.sc.service.BoardService;


@WebServlet("/service/boardInsertEnd.do")
public class BoardInsertEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BoardInsertEndServlet() {
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
		String path=request.getServletContext().getRealPath("/upload/board");
		int maxSize=1024*1024*300; //300MB
		String encode="UTF-8";
		DefaultFileRenamePolicy dfr=new DefaultFileRenamePolicy();
		MultipartRequest mr=new MultipartRequest(request, path, maxSize, encode, dfr);
		//게시판 저장
		Board b=Board.builder()
				.boardWriter(mr.getParameter("login"))
				.noticeYn(mr.getParameter("titleCategory").charAt(0))
				.boardCategory(mr.getParameter("QACategory"))
				.boardTitle(mr.getParameter("boardTitle"))
				.boardContent(mr.getParameter("boardContent").replaceAll("\n", "<br>"))
				.build();
		int result=new BoardService().insertBoard(b);
		
		//boardNo
		int boardNo=new BoardService().selectBoardList(1, 1, mr.getParameter("titleCategory")).get(0).getBoardNo();
		
		//파일 저장
		int fileResult=0;
		if(result==1) { //file이 존재하는 경우에만 실행
				String renamedFilename=mr.getFilesystemName("boardFile");
				System.out.println("filename:"+renamedFilename);
				BoardFile bf=BoardFile.builder()
						.boardFileName(renamedFilename)
						.boardNo(boardNo)
						.build();
				fileResult+=new BoardService().insertBoardFile(bf);
		}else {
			System.out.println("file 안들어옴");
			fileResult=1;
		}
		if(result>0&&fileResult==1) {
			response.sendRedirect(request.getContextPath()+"/service/boardList.do?notice=Y");
		}else {
			System.out.println("게시글 추가 실패");
			response.sendRedirect(request.getHeader("referer"));
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
