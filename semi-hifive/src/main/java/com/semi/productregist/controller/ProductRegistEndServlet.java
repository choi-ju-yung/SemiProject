package com.semi.productregist.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.member.model.vo.Member;
import com.semi.product.model.vo.Product;
import com.semi.productregist.service.ProductRegistService;

@WebServlet("/productRegistEnd.do")
public class ProductRegistEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductRegistEndServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String replacePrice = request.getParameter("price");
		replacePrice = replacePrice.replace(",","");
		
	
		
		Member m = (Member) session.getAttribute("loginMember");// 세션에서 현재로그인한 정보 갖고옴
		String userId = m.getUserId();
		String title = request.getParameter("title");
		String subCate = request.getParameter("subCate");
		String place = request.getParameter("place");
		String state = request.getParameter("state");
		int price = Integer.parseInt(replacePrice); // 정수일경우 앞에 Integer.parseInt 로 형변환해야함
		String explan = request.getParameter("explan");
		String data1[] = request.getParameterValues("data1"); // getParameterValues -> 여러개값을 받을때 문자열 배열형태로 받음

		String data2 = String.join(",", data1); // 문자열배열을 ,로 구분해서 문자열로 바꿔줌
		
		
		Product p = Product.builder()
					.userId(userId)
					.title(title)
					.productStatus(state)
					.price(price) 
					.explanation(explan) 
					.keyword(data2) 
					.areaName(place)
					.subCategoryName(subCate)
					.build();
		
		
		int result = new ProductRegistService().insertProduct(p,m); // 상품등록 하는 작업
		
		
		/*
		 * int result2 = new ProductRegistService().insertShopPage(userId); // 회원쇼핑페이지
		 * 추가하는 작업
		 */		
		String msg=""; String loc=""; 
		if(result>0) { // db는 결과값이 정수로 나옴
		// 입력성공
			msg="상품등록에 성공하였습니다."; loc="/";
		}else{
			// 입력실패 
			msg="상품등록에 실패했습니다."; loc="/productRegist.do";
		 } 
		
		request.setAttribute("msg", msg); 
		request.setAttribute("loc", loc);
		  
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request,response);
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
