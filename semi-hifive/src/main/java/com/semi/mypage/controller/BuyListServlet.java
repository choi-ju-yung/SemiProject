package com.semi.mypage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.member.model.vo.Member;
import com.semi.mypage.model.vo.ProductList;
import com.semi.mypage.model.vo.ShopPage;
import com.semi.mypage.service.MypageMemberService;
import com.semi.mypage.service.MypageProductService;

/**
 * Servlet implementation class BuyListServlet
 */
@WebServlet("/myPage/buyList.do")
public class BuyListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BuyListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("userId");
		
		// 페이징
		int cPage, numPerpage;
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		} catch (NumberFormatException e) {
			cPage = 1;
		}
		try {
			numPerpage = Integer.parseInt(request.getParameter("numPerpage"));
		} catch (NumberFormatException e) {
			numPerpage = 5;
		}
		String pageBar = "";
		int totalData = new MypageProductService().countBuyList(userId);
		int totalPage = (int)Math.ceil((double)totalData/numPerpage);
		int pageBarSize = 5;
		int pageNo = ((cPage-1)/pageBarSize)*pageBarSize + 1;
		int pageEnd = pageNo + pageBarSize - 1;
		
		if(pageNo == 1) {
			pageBar += "<span>[이전]<span>";
		} else {
			pageBar += "<a href='" + request.getRequestURI()
				+ "?cPage=" + (pageNo-1) + "&numPerpage=" + numPerpage + "'>[이전]</a>";
		}
		while(!(pageNo>pageEnd||pageNo>totalPage)) {
			if(pageNo==cPage) {
				pageBar+="<span>"+pageNo+"</span>";
			}else {
				pageBar+="<a href='"+request.getRequestURI()
					+"?cPage="+pageNo+"'>"+pageNo+"</a>";
			}
			pageNo++;
		}
		if(pageNo>totalPage) {
			pageBar += "<span>[다음]<span>";
		} else {
			pageBar += "<a href='" + request.getRequestURI()
			+ "?cPage=" + pageNo + "&numPerpage=" + numPerpage + "'>[다음]</a>";
		}
		request.setAttribute("pageBar", pageBar);

		
//		구매목록 가져오기
		List<ProductList> p = new MypageProductService().selectBuyListByUserId(cPage, numPerpage, userId);
		request.setAttribute("buyProduct", p);
		request.setAttribute("userId", userId);
		request.getRequestDispatcher("/views/mypage/buyList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
