package com.semi.category.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.semi.category.model.vo.CategoryDto;
import com.semi.category.service.CategoryService;
import com.semi.mypage.model.vo.Product;
import com.semi.product.model.service.ProductChartPageService;
import com.semi.product.model.vo.ProductDto;

/**
 * Servlet implementation class SelectCategoryListServlet
 */
@WebServlet("/selectcategorylist.do")
public class SelectCategoryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectCategoryListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String categoryname = getInitParameter("subcategory");
		int cPage, numPerpage;
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		}catch(NumberFormatException e){
			cPage = 1;
		}
		try {
			numPerpage = Integer.parseInt(request.getParameter("numPerpage"));
		}catch(NumberFormatException e){
			numPerpage = 32;
		}
		
		String pageBar = "";
		int totalData = new ProductChartPageService().SelectCategoryProductListCount(categoryname);
		int totalPage = (int)Math.ceil((double)totalData/numPerpage);
		int pageBarSize = 10;
		int pageNo = ((cPage - 1)/pageBarSize) * pageBarSize + 1;
		int pageEnd = pageNo + pageBarSize - 1;
		
		if(pageNo == 1) {
			pageBar += "<li><a><<</a></li>";
		}else {
			pageBar += "<li><a href='"+request.getRequestURI()+"?cPage="+(pageNo - 1)+"&numPerpage="+numPerpage+"'><<</a></li>";
		}
		while(!(pageNo > pageEnd || pageNo > totalPage)) {
			if(pageNo == cPage) {
				pageBar += "<li><a>" + pageNo + "</a></li>";
			}else {
				pageBar += "<li><a href='"+request.getRequestURI()+"?cPage="+pageNo+"&numPerpage="+numPerpage+"'>"+pageNo+"</a></li>";
			}
			pageNo++;
		}
		if(pageNo > totalPage) {
			pageBar += "<li><a>>></a></li>";
		}else {
			pageBar += "<li><a href='"+request.getRequestURI()+"?cPage="+pageNo+"&numPerpage="+numPerpage+"'>>></a></li>";
		}
		request.setAttribute("pageBar", pageBar);
		
		ProductDto selectcategorylist = new ProductChartPageService().SelectCategoryList(cPage, numPerpage, categoryname);
		List<CategoryDto> categorylist = new CategoryService().CategoryList();
	
		request.setAttribute("categorylist", categorylist);
		request.setAttribute("selectcategorylist", selectcategorylist);
		request.getRequestDispatcher("/views/productcategorypage/subcategoryproductlist.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
