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
@WebServlet("/subserachcategory.do")
public class SubCategoryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubCategoryListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String subcategoryname = request.getParameter("sub");
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
				numPerpage = 32;
			}
			String pageBar = "";
			int totalData = new ProductChartPageService().SelectCategoryProductListCount(subcategoryname);
			int totalPage = (int)Math.ceil((double)totalData/numPerpage);
			int pageBarSize = 5;
			int pageNo = ((cPage-1)/pageBarSize)*pageBarSize + 1;
			int pageEnd = pageNo + pageBarSize - 1;
			
			if(pageNo == 1) {
				pageBar += "<li><span class='pageMove'>&lt;</span></li>";
			} else {
				pageBar += "<li><a href='javascript:void(0);' onclick='changePage("+(pageNo-1)+");'>&lt;</a></li>";
			}
			while(!(pageNo>pageEnd||pageNo>totalPage)) {
				if(pageNo==cPage) {
					pageBar+="<li><span class='nowPage'>"+pageNo+"</span></li>";
				}else {
					pageBar+="<li><a href='javascript:void(0);' onclick='changePage("+ pageNo + ");'&numPerpage=" +numPerpage + "'>" + pageNo + "</a></li>";
				}
				pageNo++;
			}
			if(pageNo>totalPage) {
				pageBar += "<li><span>&gt;</span></li>";
			} else {
				pageBar += "<li><a href='javascript:void(0);'onclick='changePage("+ pageNo + ");'&numPerpage=" + numPerpage + "'>&gt;</a></li>";
			}
			request.setAttribute("pageBar", pageBar);
	
			
			// 대표카테고리만 가져오기
			List<CategoryDto> category = new CategoryService().Category();
			// 서브카테고리랑 대표카데고리랑만 조인한것
			List<CategoryDto> categorylist = new CategoryService().SubCategoryList();
			// 서브카테고리 이름만 찾아서 상품리스트 가져오기
			List<ProductDto> subcategoryproduct = new ProductChartPageService().SelectCategoryList(cPage, numPerpage, subcategoryname);
			
			System.out.println(subcategoryproduct);
			request.setAttribute("subcategoryproduct", subcategoryproduct);
			request.setAttribute("categorylist", categorylist);
			request.setAttribute("category", category);
			
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
