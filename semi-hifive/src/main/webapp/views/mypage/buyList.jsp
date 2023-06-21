<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.semi.mypage.model.vo.ProductList,java.util.Date,java.text.SimpleDateFormat, java.text.DecimalFormat" %>
<%@ include file="/views/common/header.jsp"%>
<%@ include file="/views/mypage/myPageCategory.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/mypage/buyList.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/page.css" />
<%
	List<ProductList> product = (List)request.getAttribute("buyProduct");
/* 	String userId = (String)request.getAttribute("userId");
 */%>
<!-- 오른쪽 구매내역 section -->
    <div class="mypageMain">
      <!-- 구매내역 헤더 div -->
      <div class="mypageMainHeader">
        <h3>구매 내역</h3>
        <div class="sortContainer">
          <a href="<%=request.getContextPath() %>/myPage/buyList.do?userId=<%=m.getUserId() %>" class="aTag sort" id="sortDesc">최신 순</a>
          <p style="font-size: 12px;">|</p>
          <a href="<%=request.getContextPath() %>/sortAsc.do?userId=<%=m.getUserId() %>" class="aTag sort" id="sortAsc">오래된 순</a>
        </div>
      </div>
      <!-- 구매내역 목록 div -->
      <div class="productAll">
      <%if(!product.isEmpty()) {
             for(ProductList p : product){
        %>
        <div class="product">
          <a href=""><img src="" alt=""></a>
          <div class="proContent">
            <h5 class="grayFont"><a href="" class="aTag grayFont"><%=p.getCategory().getCategoryName() %></a> &rsaquo; <a href=""
                class="aTag grayFont"><%=p.getProduct().getSubCategory() %></a></h5>
            <h4 class="contentMargin"><a href="" class="aTag productTitle"><%=p.getProduct().getTitle() %></a></h4>
            <h3><%=new DecimalFormat("###,###").format(p.getProduct().getPrice()) %>원</h3>
          </div>
          <div class="buyDate">
            <p><%=new SimpleDateFormat("yyyy.MM.dd").format(new Date(p.getTrade().getSellDate().getTime())) %></p>
          </div>
        </div>
        <hr color="#eeeeee" noshade style="margin-top: 23px; margin-bottom: 23px;" />
       <%}
        } else { %>
        <span>구매한 상품이 없습니다.</span>
        <%} %>
      </div>
      <!-- 페이지 버튼 -->
	     <div class="pageBar">
	     	<ul class="page">
	         <%=request.getAttribute("pageBar") %>
	         </ul>
	    </div>
    </div>
</section>
<%@ include file="/views/common/footer.jsp"%>