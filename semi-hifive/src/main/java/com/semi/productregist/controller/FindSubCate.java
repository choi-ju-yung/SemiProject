package com.semi.productregist.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.category.model.vo.SubCategory;
import com.semi.productregist.service.ProductRegistService;


@WebServlet("/findSubCate")
public class FindSubCate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FindSubCate() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cateId = request.getParameter("cateId");
		
		
		List<SubCategory> subCategorys = new ProductRegistService().selectSubCate(cateId);
		
		
		
		request.setAttribute("subCategorys", subCategorys);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}