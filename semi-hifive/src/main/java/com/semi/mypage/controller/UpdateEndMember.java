package com.semi.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		MemberShopPage m = MemberShopPage.builder()
				.userId(request.getParameter("myPageUserId"))
				.nickName(request.getParameter("myPageNickname"))
				.profileImg(request.getParameter("profile_Img"))
				.shopPage(ShopPage.builder()
						.introduce(request.getParameter("myPageIntroduce")).build())
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
			msg="회원정보 수정실패했습니다.다시 시도하세요";
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
