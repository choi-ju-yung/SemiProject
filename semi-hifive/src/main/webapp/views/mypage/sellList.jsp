<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.semi.mypage.model.vo.ProductList, java.text.DecimalFormat" %>
<%@ include file="/views/common/header.jsp"%>
<%@ include file="/views/mypage/myPageCategory.jsp" %>
<%
	List<ProductList> product = (List)request.getAttribute("sellProduct");
	int countAll = (int)request.getAttribute("countAll");
	int countStatusSell = (int)request.getAttribute("countStatusSell");
	int countStatusRes = (int)request.getAttribute("countStatusRes");
	int countStatusSol = (int)request.getAttribute("countStatusSol");
%>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/mypage/sellList.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/page.css" />

<!-- 오른쪽 판매내역 section -->
    <div class="mypageMain">
        <!-- 판매내역 헤더 div -->
        <div class="mypageMainHeader">
            <h3>판매 내역</h3>
        </div>

        <!-- 판매상태 아이콘 div -->
        <div class="buttonAll">
            <button id="allBtn" class="nowButton">전체 <%=countAll%></button>
            <button id="sellBtn">판매중 <%=countStatusSell%></button>
            <button id="resBtn">예약중 <%=countStatusRes%></button>
            <button id="solBtn">판매완료 <%=countStatusSol%></button>
        </div>

        <!-- 판매내역 목록 div -->
        <div class="productAll">
        <% if(!product.isEmpty()) {
                        	for(ProductList p : product){
        %>
            <div class="product">
                <a href=""><img src="<%=request.getContextPath() %>/img/구매목록img/예시 이미지.jpg" alt=""></a>
                <div class="proContent">
                    <h5 class="grayFont"><a href="" class="aTag grayFont"><%=p.getCategory().getCategoryName() %></a> &rsaquo; <a href=""
                            class="aTag grayFont"><%=p.getSubcategoryName() %></a></h5>
                    <h4 class="contentMargin"><a href="" class="aTag productTitle"><%=p.getProductTitle() %></a></h4>
                    <h3><%=new DecimalFormat("###,###").format(p.getPrice()) %>원</h3>
                </div>
                <div class="count">
                    <ion-icon name="heart" class="interestIcon"></ion-icon><span>40</span>
                    <ion-icon name="eye" class="viewIcon"></ion-icon><span><%=new DecimalFormat("###,###").format(p.getViewCount()) %></span>
                </div>
                <div class="buttonNcategory">
                    <div class="updateDelete">
                        <button>수정</button>
                        <button class="delMem openBtn" id="popup_open_btn">삭제</button>
                    </div>
                    <div class="selectNow">
                        <select class="<%=p.getSellStatus().equals("판매중")?"selectIng":p.getSellStatus().equals("예약중")?"selectRes":"selectSol"%> selectStatus">
                            <option id="<%=p.getProductId() %>" value="sell" data-color="#20C997" <%=p.getSellStatus().equals("판매중")?"selected":""%>>판매중</option>
                            <option id="<%=p.getProductId() %>" value="reservation" data-color="#FFD800" <%=p.getSellStatus().equals("예약중")?"selected":""%>>예약중</option>
                            <option id="<%=p.getProductId() %>" value="soldOut" data-color="#cccccc" <%=p.getSellStatus().equals("판매완료")?"selected":""%>>판매완료</option>
                        </select>
                    </div>
                </div>
            </div>
            <hr color="#eeeeee" noshade style="margin-top: 23px; margin-bottom: 23px;" />
        <%}
        } else { %>
        	<span>판매중인 상품이 없습니다.</span>
        <%} %>
        </div>
        <!-- 페이지 버튼 -->
        <div class="pageBar">
            <%=request.getAttribute("pageBar") %>
        </div>
    </div>

    <div class="modal hidden">
        <div class="bg"></div>
        <div class="modal_delMem">
            <div class="trashIcon">
                <ion-icon name="trash-outline" style="font-size: 32px; color: white;"></ion-icon>
            </div>
            <h3>정말 삭제하시겠습니까?</h3>
            <p>삭제 시, 상품은 삭제되며<br>
                복구되지 않습니다.</p>
            <div class="modal_button">
                <button class="modalBtn">삭제</button>
                <button class="closeBtn modalBtn">취소</button>
            </div>
        </div>
    </div>

    <div class="modal hidden modal2 hidden2">
        <div class="bg"></div>
        <div class="modal_delMem">
            <div class="trashIcon">
                <ion-icon name="trash-outline" style="font-size: 32px; color: white;"></ion-icon>
            </div>
            <h3>정말?</h3>
            <p>탈퇴 시, 계정은 삭제되며<br>
                복구되지 않습니다.</p>
            <div class="modal_button">
                <button>탈퇴</button>
                <button class="closeBtn">취소</button>
            </div>
        </div>
    </div>

</section>
<script src="<%=request.getContextPath()%>/js/mypage/sellList.js"></script>
<%@ include file="/views/common/footer.jsp"%>