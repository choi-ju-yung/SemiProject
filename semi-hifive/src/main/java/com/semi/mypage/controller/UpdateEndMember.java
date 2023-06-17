package com.semi.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.semi.mypage.model.vo.MemberShopPage;
import com.semi.mypage.model.vo.ShopPage;
import com.semi.mypage.service.MypageMemberService;

/**
 * Servlet implementation class UpdateEndMember
 */
@WebServlet("/member/updateEndMember.do")
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
		// 파일업로드 설정
		String path = getServletContext().getRealPath("/upload/profileImg");
		int maxSize = 1024 * 1024 * 50;
		String encode = "UTF-8";
		DefaultFileRenamePolicy dfr = new DefaultFileRenamePolicy();
		MultipartRequest mr = new MultipartRequest(request, path, maxSize, encode, dfr);
		
		
		// 파일제외 업데이트
		MemberShopPage m = MemberShopPage.builder()
				.userId(mr.getParameter("myPageUserId"))
				.nickName(mr.getParameter("myPageNickname"))
				.profileImg(mr.getFilesystemName("uploadProfile"))
				.shopPage(ShopPage.builder()
						.introduce(mr.getParameter("myPageIntroduce")).build())
				.build();
		int result = new MypageMemberService().updateMemberNickname(m);
		int result2 = new MypageMemberService().updateMemberIntroduce(m);

		String msg="",loc="";
		
		if(result>0 && result2>0) {
			// 성공
			msg="회원정보가 수정되었습니다.";
			loc="/mypage/mypageUpdate.do?userId="+m.getUserId();
		} else {
			// 실패
			msg="회원정보 수정에 실패했습니다.";
			loc="/mypage/mypageUpdate.do?userId="+m.getUserId();
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
