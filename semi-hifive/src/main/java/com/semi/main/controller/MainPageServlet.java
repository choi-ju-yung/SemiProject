package com.semi.main.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.semi.category.model.vo.Category;
import com.semi.category.service.CategoryService;
import com.semi.main.model.vo.ProductElapsedTime;
import com.semi.main.service.MainService;

/**
 * Servlet implementation class MainPage
 */
@WebServlet("/main/mainPage.do")
public class MainPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainPageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 인기상품 -> 상품 등록 시간 포함
		List<ProductElapsedTime> popularProduct = new MainService().productListAll();
		
		// 최신상품 -> 상품 등록 시간 포함
		List<ProductElapsedTime> newProduct = new MainService().productListNew();
				
		// 모두 합쳐서 하나의 리스트로 생성하기
		List<ProductElapsedTime> mainList = new ArrayList();
		mainList.addAll(popularProduct);
		mainList.addAll(newProduct);
			
		System.out.println(mainList);
		
		Gson gson = new Gson();
		response.setContentType("application/json; charset=utf-8");
		gson.toJson(mainList, response.getWriter());
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