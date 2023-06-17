<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<%@ include file="/views/mypage/myPageCategory.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/mypage/buyList.css" />

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
        <div class="product">
          <a href=""><img src="./img/구매목록img/예시 이미지.jpg" alt=""></a>
          <div class="proContent">
            <h5 class="grayFont"><a href="" class="aTag grayFont">의류</a> &rsaquo; <a href=""
                class="aTag grayFont">상의</a></h5>
            <h4 class="contentMargin"><a href="" class="aTag productTitle">상품명을 작성해주세요.</a></h4>
            <h3>35,000원</h3>
          </div>
          <div class="buyDate">
            <p>2023.05.10</p>
          </div>
        </div>
        <hr color="#eeeeee" noshade style="margin-top: 23px; margin-bottom: 23px;" />
        <div class="product">
          <a href=""><img src="./img/구매목록img/예시 이미지.jpg" alt=""></a>
          <div class="proContent">
            <h5 class="grayFont"><a href="" class="aTag grayFont">의류</a> &rsaquo; <a href=""
                class="aTag grayFont">상의</a></h5>
            <h4 class="contentMargin"><a href="" class="aTag productTitle">상품명을 작성해주세요.</a></h4>
            <h3>35,000원</h3>
          </div>
          <div class="buyDate">
            <p>2023.04.18</p>
          </div>
        </div>
        <hr color="#eeeeee" noshade style="margin-top: 23px; margin-bottom: 23px;" />
        <div class="product">
          <a href=""><img src="./img/구매목록img/예시 이미지.jpg" alt=""></a>
          <div class="proContent">
            <h5 class="grayFont"><a href="" class="aTag grayFont">의류</a> &rsaquo; <a href=""
                class="aTag grayFont">상의</a></h5>
            <h4 class="contentMargin"><a href="" class="aTag productTitle">상품명을 작성해주세요.</a></h4>
            <h3>35,000원</h3>
          </div>
          <div class="buyDate">
            <p>2023.02.27</p>
          </div>
        </div>
        <hr color="#eeeeee" noshade style="margin-top: 23px; margin-bottom: 23px;" />
        <div class="product">
          <a href=""><img src="./img/구매목록img/예시 이미지.jpg" alt=""></a>
          <div class="proContent">
            <h5 class="grayFont"><a href="" class="aTag grayFont">의류</a> &rsaquo; <a href=""
                class="aTag grayFont">상의</a></h5>
            <h4 class="contentMargin"><a href="" class="aTag productTitle">상품명을 작성해주세요.</a></h4>
            <h3>35,000원</h3>
          </div>
          <div class="buyDate">
            <p>2023.02.05</p>
          </div>
        </div>
        <hr color="#eeeeee" noshade style="margin-top: 23px; margin-bottom: 23px;" />
        <div class="product">
          <a href=""><img src="./img/구매목록img/예시 이미지.jpg" alt=""></a>
          <div class="proContent">
            <h5 class="grayFont"><a href="" class="aTag grayFont">의류</a> &rsaquo; <a href=""
                class="aTag grayFont">상의</a></h5>
            <h4 class="contentMargin"><a href="" class="aTag productTitle">상품명을 작성해주세요.</a></h4>
            <h3>35,000원</h3>
          </div>
          <div class="buyDate">
            <p>2022.11.20</p>
          </div>
        </div>
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