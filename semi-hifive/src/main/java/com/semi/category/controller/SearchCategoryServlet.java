package com.semi.category.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.category.model.vo.CategoryDto;
import com.semi.category.service.CategoryService;
import com.semi.product.model.service.ProductChartPageService;
import com.semi.product.model.vo.ProductDto;

/**
 * Servlet implementation class HeaderCategoryServlet
 */
@WebServlet("/serachcategory.do")
public class SearchCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String categoryname = request.getParameter("Cid");
		
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
		int totalData = new ProductChartPageService().CategoryCount(categoryname);
		int totalPage = (int)Math.ceil((double)totalData/numPerpage);
		int pageBarSize = 5;
		int pageNo = ((cPage-1)/pageBarSize)*pageBarSize + 1;
		int pageEnd = pageNo + pageBarSize - 1;
		
		if(pageNo == 1) {
			pageBar += "<li><span class='pageMove'>&lt;</span></li>";
		} else {
			pageBar += "<li><a href='" + request.getContextPath() + "/searchcategory.do?Cid=" + categoryname + "?cPage=" + (pageNo-1) + "&numPerpage=" + numPerpage + "'>&lt;</a></li>";
		}
		while(!(pageNo>pageEnd||pageNo>totalPage)) {
			if(pageNo==cPage) {
				pageBar+="<li><span class='nowPage'>"+pageNo+"</span></li>";
			}else {
				pageBar+="<li><a href='"+request.getContextPath() + "/searchcategory.do?Cid=" + categoryname +"?cPage=" + pageNo + "&numPerpage=" +numPerpage + "'>" + pageNo + "</a></li>";
			}
			pageNo++;
		}
		if(pageNo>totalPage) {
			pageBar += "<li><span>&gt;</span></li>";
		} else {
			pageBar += "<li><a href='" + request.getContextPath() + "/searchcategory.do?Cid=" + categoryname + "?cPage=" + pageNo + "&numPerpage=" + numPerpage + "'>&gt;</a></li>";
		}
		request.setAttribute("pageBar", pageBar);
		
		
		
		List<ProductDto> searchcategory = new ProductChartPageService().CategoryList(cPage, numPerpage, categoryname);
		System.out.println(searchcategory);
		request.setAttribute("categoryproduct", searchcategory);
		request.getRequestDispatcher("/views/productcategorypage/test.jsp").forward(request, response);
		   
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
