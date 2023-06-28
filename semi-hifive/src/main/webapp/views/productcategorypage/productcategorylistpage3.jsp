<%@page import="com.semi.productlist.model.vo.ProductCategoryTimeList"%>
<%@page import="com.semi.category.model.vo.Category"%>
<%@page import="com.semi.category.model.vo.CategorySubCategory"%>
<%@ page import="com.semi.member.model.vo.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<ProductCategoryTimeList> getselectproduct = (List)request.getAttribute("getselectproduct");
%>
<%
	List<CategorySubCategory> categorylist = (List)request.getAttribute("categorylist");
%>
<%
	List<Category> selectcategory = (List)request.getAttribute("category");
%>
 
	          <div id="productImgContainer">
	          
	      		<%for(ProductCategoryTimeList p : getselectproduct){%>
	            <div id="pimgWraper" onclick="location.assign('<%=request.getContextPath()%>/productpage?no=<%=p.getProductCategoryList().getProductId()%>'); ResentlyProduct('<%=p.getProductCategoryList().getProductId()%>');">
	              <div class="con-like">
	                <input title="like" type="checkbox" class="like" onclick="Like_btn('<%=p.getProductCategoryList().getProductId()%>', sessionStorage.getItem('loginId'));"/>
	                <div class="checkmark">
	                  <svg
	                    viewBox="0 0 24 24"
	                    class="outline"
	                    xmlns="http://www.w3.org/2000/svg"
	                  >
	                    <path
	                      d="M17.5,1.917a6.4,6.4,0,0,0-5.5,3.3,6.4,6.4,0,0,0-5.5-3.3A6.8,6.8,0,0,0,0,8.967c0,4.547,4.786,9.513,8.8,12.88a4.974,4.974,0,0,0,6.4,0C19.214,18.48,24,13.514,24,8.967A6.8,6.8,0,0,0,17.5,1.917Zm-3.585,18.4a2.973,2.973,0,0,1-3.83,0C4.947,16.006,2,11.87,2,8.967a4.8,4.8,0,0,1,4.5-5.05A4.8,4.8,0,0,1,11,8.967a1,1,0,0,0,2,0,4.8,4.8,0,0,1,4.5-5.05A4.8,4.8,0,0,1,22,8.967C22,11.87,19.053,16.006,13.915,20.313Z"
	                    ></path>
	                  </svg>
	                  <svg
	                    viewBox="0 0 24 24"
	                    class="filled"
	                    xmlns="http://www.w3.org/2000/svg"
	                  >
	                    <path
	                      d="M17.5,1.917a6.4,6.4,0,0,0-5.5,3.3,6.4,6.4,0,0,0-5.5-3.3A6.8,6.8,0,0,0,0,8.967c0,4.547,4.786,9.513,8.8,12.88a4.974,4.974,0,0,0,6.4,0C19.214,18.48,24,13.514,24,8.967A6.8,6.8,0,0,0,17.5,1.917Z"
	                    ></path>
	                  </svg>
	                  <svg
	                    class="celebrate"
	                    width="100"
	                    height="100"
	                    xmlns="http://www.w3.org/2000/svg"
	                  >
	                    <polygon points="10,10 20,20" class="poly"></polygon>
	                    <polygon points="10,50 20,50" class="poly"></polygon>
	                    <polygon points="20,80 30,70" class="poly"></polygon>
	                    <polygon points="90,10 80,20" class="poly"></polygon>
	                    <polygon points="90,50 80,50" class="poly"></polygon>
	                    <polygon points="80,80 70,70" class="poly"></polygon>
	                  </svg>
	                </div>
	              </div>
	
	             
	                <div id="payBtn">
	                  <span>하마페이</span>
	                </div>
	                <img
	                  src="<%=request.getContextPath()%>/upload/productRegist/<%=p.getProductfile().getImageName()%>"
	                  alt=""
	                />
	               <p id="productName"><%=p.getProductCategoryList().getProductTitle()%></p>
                <p id="productPrice"><%=p.getProductCategoryList().getPrice()%>
                <span><%if(p.getElapsedTime() < 60){%>
               		<%=p.getElapsedTime()+ "초 전"%>
               	<%}else if(p.getElapsedTime() >= 60 && p.getElapsedTime() < 3600) {%>
               	<%=(p.getElapsedTime() / 60) + "분 전"%>
               	<%}else if(p.getElapsedTime() >= 3600 && p.getElapsedTime() < 86400) {%>
               		<%=(p.getElapsedTime() / 60) / 60  + "시간 전"%>
               	<%}else if(p.getElapsedTime() >= 86400 && p.getElapsedTime() < 2592000) {%>
               		<%=(p.getElapsedTime() / 60) / 60 / 24 + "일 전"%>
               	<%}else if(p.getElapsedTime() >= 2592000 && p.getElapsedTime() < 31536000) {%>
               		<%=(p.getElapsedTime() / 60) / 60 / 24 / 30 + "개월 전"%>
               	<%}else{%>
               		<%=(p.getElapsedTime() / 60) / 60 / 24 / 30 / 12 + "년 전"%>
               	<%} %></span></p>
                <p id="productPlace">
                  <i class="bi bi-geo-alt"></i>
                  <%=p.getProductCategoryList().getAreaName()%>
	                </p>
	            </div>
	          <%}%>
	          
	          </div>
	          <div class="pageBar">
		     	<ul class="page">
		         <%=request.getAttribute("pageBar") %>
		         </ul>
		   	 </div>	
