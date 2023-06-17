<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.semi.mypage.model.vo.ProductList" %>
<%@ include file="/views/common/header.jsp"%>
<%@ include file="/views/mypage/myPageCategory.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/mypage/buyList.css" />
<%
	List<ProductList> product = (List)request.getAttribute("buyProduct");
%>
<!-- 오른쪽 구매내역 section -->
    <div class="mypageMain">
      <!-- 구매내역 헤더 div -->
      <div class="mypageMainHeader">
        <h3>구매 내역</h3>
        <div class="sortContainer">
          <!-- <select class="sort form-select">
            <option value="new">최신 순</option>
            <option value="old">오래된 순</option>
          </select> -->
          <a href="" class="aTag sort">최신 순</a>
          <p style="font-size: 12px;">|</p>
          <a href="" class="aTag sort">오래된 순</a>
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
                class="aTag grayFont"><%=p.getSubcategoryName() %></a></h5>
            <h4 class="contentMargin"><a href="" class="aTag productTitle"><%=p.getProductTitle() %></a></h4>
            <h3><%=p.getPrice() %>원</h3>
          </div>
          <div class="buyDate">
            <p><%=p.getTrade().getSellDate() %></p>
          </div>
        </div>
        <hr color="#eeeeee" noshade style="margin-top: 23px; margin-bottom: 23px;" />
       <%}
        } else { %>
        <span>구매한 상품이 없습니다.</span>
        <%} %>
      </div>
      <!-- 페이지 버튼 -->
      <div class="pageAll">
        <ul class="page">
            <li><a href="#">
                    <</a>
            </li>
            <li><a href="#" class="nowPage">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li><a href="#">></a></li>
        </ul>
    </div>
    </div>
</section>
<%@ include file="/views/common/footer.jsp"%>