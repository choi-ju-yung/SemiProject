package com.semi.productlist.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.category.model.vo.Category;
import com.semi.category.model.vo.CategorySubCategory;
import com.semi.category.service.CategoryService;
import com.semi.productlist.model.service.ProductCategoryListService;
import com.semi.productlist.model.vo.ProductCategoryTimeList;

/**
 * Servlet implementation class StatusListServlet
 */
@WebServlet("/statuslist")
public class StatusListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatusListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String status = request.getParameter("status");
		System.out.println(status);
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
		int totalData = new ProductCategoryListService().StatusCount(status);
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
		request.setAttribute("totalData", totalData);
		request.setAttribute("pageBar", pageBar);
		

		//카테고리와 서브카테고리 상품 테이블 모두 join해서 가져오는 상품List 객체
		List<ProductCategoryTimeList> statuslist = new ProductCategoryListService().Status(cPage, numPerpage, status);
		//카테고리와 서브카테고리랑만 join해서 가져오는 List객체
		List<CategorySubCategory> categorylist = new CategoryService().SubCategoryList();
		//카테고리만 가져오는 List객체
		List<Category> category = new CategoryService().Category();
		
		//System.out.println(categorylist);
		//System.out.println(category);
		System.out.println("서블릿" + statuslist);
		request.setAttribute("category", category);
		request.setAttribute("categorylist", categorylist);
		request.setAttribute("statuslist", statuslist);
		request.getRequestDispatcher("/views/productcategorypage/statuslist.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
