package com.semi.mypage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.mypage.model.vo.ProductList;
import com.semi.mypage.service.MypageProductService;

/**
 * Servlet implementation class StatusAllAjaxServlet
 */
@WebServlet("/mypage/allBtn.do")
public class StatusAllAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatusAllAjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String userId = request.getParameter("userId");
//
//		// 페이징
//		int cPage, numPerpage;
//		try {
//			cPage = Integer.parseInt(request.getParameter("cPage"));
//		} catch (NumberFormatException e) {
//			cPage = 1;
//		}
//		try {
//			numPerpage = Integer.parseInt(request.getParameter("numPerpage"));
//		} catch (NumberFormatException e) {
//			numPerpage = 5;
//		}
//		String pageBar = "";
//		int totalData = new MypageProductService().countBuyList(userId);
//		int totalPage = (int) Math.ceil((double) totalData / numPerpage);
//		int pageBarSize = 5;
//		int pageNo = ((cPage - 1) / pageBarSize) * pageBarSize + 1;
//		int pageEnd = pageNo + pageBarSize - 1;
//
//		if (pageNo == 1) {
//			pageBar += "<li><span class='pageMove'>&lt;</span></li>";
//		} else {
//			pageBar += "<li><a href='" + request.getRequestURI() + "?cPage=" + (pageNo - 1) + "&numPerpage="
//					+ numPerpage + "'>&lt;</a></li>";
//		}
//		while (!(pageNo > pageEnd || pageNo > totalPage)) {
//			if (pageNo == cPage) {
//				pageBar += "<li><span class='nowPage'>" + pageNo + "</span></li>";
//			} else {
//				pageBar += "<li><a href='" + request.getRequestURI() + "?cPage=" + pageNo + "&userId=" + userId + "'>"
//						+ pageNo + "</a></li>";
//			}
//			pageNo++;
//		}
//		if (pageNo > totalPage) {
//			pageBar += "<li><span>&gt;</span></li>";
//		} else {
//			pageBar += "<li><a href='" + request.getRequestURI() + "?cPage=" + pageNo + "&numPerpage=" + numPerpage
//					+ "'>&gt;</a></li>";
//		}
//		request.setAttribute("pageBar", pageBar);
//
//		// 판매목록 가져오기
//		List<ProductList> p = new MypageProductService().selectSellListByUserId(cPage, numPerpage, userId);
//		request.setAttribute("sellProduct", p);
//
//		// 판매상태 카운트(전체)
//		int total = new MypageProductService().countSellStatusAll(userId);
//		request.setAttribute("countAll", total);
//
//		// 판매상태 카운트(판매중, 예약중, 판매완료)
//		String selling = "판매중";
//		int countStatusSell = new MypageProductService().countSellStatusSell(userId, selling);
//		String reserve = "예약중";
//		int countStatusRes = new MypageProductService().countSellStatusSell(userId, reserve);
//		String soldOut = "판매완료";
//		int countStatusSol = new MypageProductService().countSellStatusSell(userId, soldOut);
//		request.setAttribute("countStatusSell", countStatusSell);
//		request.setAttribute("countStatusRes", countStatusRes);
//		request.setAttribute("countStatusSol", countStatusSol);
//
//		response.setContentType("text/csv; charset=utf-8");
//		response.getWriter().print(p);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
