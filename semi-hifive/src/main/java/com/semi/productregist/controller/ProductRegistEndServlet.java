package com.semi.productregist.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.semi.member.model.vo.Member;
import com.semi.product.model.vo.Product;
import com.semi.product.model.vo.ProductFile;
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
		
		
		/*
		 * if (!(ServletFileUpload.isMultipartContent(request))) { // 해당 타입이 맞으면 true,
		 * 아니면 false를 반환 request.setAttribute("msg", "잘못된 접근입니다. 관리자에게 문의하세요.");
		 * request.setAttribute("loc", "/"); //해당 페이지로 다시 돌아감
		 * request.getRequestDispatcher("/views/common/msg.jsp").forward(request,
		 * response); return; // multipart타입이 아니면 리턴 처리 }
		 */
		

		HttpSession session = request.getSession();
		String path=getServletContext().getRealPath("/upload/productRegist");  // ->  /test 안에다 업로드되는 이미지 넣음
		
		// cos.jar에서 제공하는 클래스 => MultipartRequest
		MultipartRequest mr= new MultipartRequest(request, path, 1024*1024*10,"UTF-8",new DefaultFileRenamePolicy()); 
	
		
		
		String replacePrice = mr.getParameter("price"); 
		replacePrice = replacePrice.replace(",",""); // ,있는 돈 문자열을 ,를 ""로 대체함
		
		Member m = (Member) session.getAttribute("loginMember");// 세션에서 현재로그인한 정보 갖고옴
		String userId = m.getUserId();
		String title = mr.getParameter("title");
		String subCate = mr.getParameter("subCate");
		String place = mr.getParameter("place");
		String state = mr.getParameter("state");
		int price = Integer.parseInt(replacePrice); // 정수일경우 앞에 Integer.parseInt 로 형변환해야함
		String explan = mr.getParameter("explan");
		String tag = mr.getParameter("tag");
		

		
		List<ProductFile> files= new ArrayList();
		
		Enumeration<String> names=mr.getFileNames(); // 해당 파일객체들의 키값을 하나씩 출력 
		while(names.hasMoreElements()) {  // 다중 파일들의 이미지를 접근 가능
			String key=names.nextElement();  // key-> 해당 파일은 객체로 저장되잇음 각각 파일의 키를 저장함
//			mr.getFilesystemName(key));  new 파일
//			mr.getOriginalFileName(key)); ori파일

			files.add(ProductFile.builder().imageName(mr.getFilesystemName(key)).build());
		}
		
		 Product p = Product.builder().title(title).productStatus(state).price(price).explanation(explan)
				 .keyword(tag).areaName(place).subCategoryName(subCate).files(files).build();


		 	int result = new ProductRegistService().insertProduct(p,userId); // 상품등록 하는 작업
		 	response.getWriter().print(result);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
