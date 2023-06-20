package com.semi.productpage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.JsonObject;
import com.semi.productpage.model.vo.Product;
import com.semi.productpage.model.vo.ProductComment;
import com.semi.productpage.service.ProductPageService;

/**
 * Servlet implementation class ProductPageServlet
 */
@WebServlet("/productpage")
public class ProductPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Product테이블 데이터 가져오기
		int no=Integer.parseInt(request.getParameter("no"));
		Product p=new ProductPageService().selectProduct(no);
		
		
		//ajax 방식으로 댓글 보내기
		List<ProductComment> comments=new ProductPageService().selectProductComment(no);
		
		//JSONArray 사용 
		//리스트방식으로 JSONObject 저장후 JSONArray에 add()를 이용해서 저장
		
		/*
		 * JSONArray commentList=new JSONArray();
		 * 
		 * for(ProductComment pc : comments ) { JSONObject c=new JSONObject();
		 * c.put("userId",pc.getUserId()); c.put("productId",pc.getProductId());
		 * c.put("nickName", pc.getNickName()); c.put("commentNo",pc.getCommentNo());
		 * c.put("commentLevel",pc.getCommentLevel()); c.put("content",pc.getContent());
		 * c.put("commentRef",pc.getCommentRef());
		 * c.put("enrollDate",pc.getEnrollDate()); commentList.add(c); }
		 * System.out.println(commentList);
		 */
		
		
		//상품 데이터 저장
		request.setAttribute("comments", comments);
		request.setAttribute("product",p);
		//출력할 화면 선택
		request.getRequestDispatcher("/views/productpage/ProductPage.jsp").forward(request, response);
		
		//인코딩해서 json 데이터 보내기
//				response.setCharacterEncoding("application/json;charset=utf-8");
				//toString이 있어야 String값이 넘어감 없으면 주소값이 넘어감
//				response.getWriter().print(commentList.toJSONString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
