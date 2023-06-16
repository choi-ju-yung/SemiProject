<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!-- 부트스트랩 -->
<link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
      crossorigin="anonymous"/>
<script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
      crossorigin="anonymous">
</script>
<!-- css 파일 -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/default.css" />
<link rel="icon" href="<%=request.getContextPath()%>/images/common/fivicon.png" type="image/x-icon" />
<!-- js 파일 -->
<script type="module"
	src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule
	src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery-3.7.0.min.js"></script>
<script src="<%=request.getContextPath()%>/js/common/header.js"></script>
<title>중고 거래 HiFive</title>
</head>
<body>
<header>
        <div id="headerContainer">
        <div id="fixedContainer">
          <div class="loginSerivce">
            <a href="" id="login">로그인</a>
            <a href="" id="enroll">회원가입</a>
            <a href="" id="service">고객센터</a>
          </div>
          <div class="headerMain">
            <div class="logo">
              <a href="">
                <img src="<%=request.getContextPath()%>/images/common/hifiveLogo.png" alt="" />
              </a>
            </div>
            <div class="searchBar">
              <div class="searchDetail">
                <input
                  type="search"
                  onsearch=""
                  class="search"
                  placeholder="상품검색"
                  onfocus="this.placeholder = ''"
                  onblur="this.placeholder = '상품검색'"
                  onkeypress="if( event.keyCode == 13 ){searchData();}"
                />

                <button class="search" onclick="searchData()">
                <!-- 돋보기 이미지 -->
                  <img src="<%=request.getContextPath()%>/images/common/magnifier.png" alt="" />
                </button>
              </div>
            </div>
            <div class="memberIcon">
              <a href="">
                <ion-icon
                  name="storefront-outline"
                  class="storeIcon"
                ></ion-icon>
                <span> 판매하기</span>
              </a>
              <a href="">
                <ion-icon name="person-outline" class="myIcon"></ion-icon>
                내정보
              </a>
              <a href="">
                <ion-icon name="heart-outline" class="heartIcon"></ion-icon>
                찜한상품
              </a>
            </div>
          </div>
          <div class="categoryNrank">
            <input type="checkbox" id="menuIcon" />
            <label for="menuIcon">
              <span></span>
              <span></span>
              <span></span>
            </label>

            <div id="menuList">
              <ul>
                <li><a href="#" id="category0">전체</a></li>
                <li><a href="#" id="category1">카테고리1</a></li>
                <li><a href="#" id="category2">카테고리2</a></li>
                <li><a href="#" id="category3">카테고리3</a></li>
                <li><a href="#" id="category4">카테고리4</a></li>
                <li><a href="#" id="category5">카테고리5</a></li>
                <li><a href="#" id="category6">카테고리6</a></li>
                <li><a href="#" id="category7">카테고리7</a></li>
                <li><a href="#" id="category8">카테고리8</a></li>
                <li><a href="#" id="category9">카테고리9</a></li>
                <li><a href="#" id="category10">카테고리10</a></li>
              </ul>
            </div>
            <div class="sideMenu" id="sideMenu-category1">
              <ul>
                <li><a href="#">세부 카테고리1</a></li>
                <li><a href="#">세부 카테고리2</a></li>
                <li><a href="#">세부 카테고리3</a></li>
                <li><a href="#">세부 카테고리4</a></li>
                <li><a href="#">세부 카테고리5</a></li>
              </ul>
            </div>
            <div class="sideMenu" id="sideMenu-category2">
              <ul>
                <li><a href="#">세부 카테고리6</a></li>
                <li><a href="#">세부 카테고리7</a></li>
                <li><a href="#">세부 카테고리8</a></li>
                <li><a href="#">세부 카테고리9</a></li>
                <li><a href="#">세부 카테고리10</a></li>
              </ul>
            </div>
            <div class="sideMenu" id="sideMenu-category3">
              <ul>
                <li><a href="#">세부 카테고리11</a></li>
                <li><a href="#">세부 카테고리12</a></li>
                <li><a href="#">세부 카테고리13</a></li>
                <li><a href="#">세부 카테고리14</a></li>
                <li><a href="#">세부 카테고리15</a></li>
              </ul>
            </div>
            <div class="sideMenu" id="sideMenu-category4">
              <ul>
                <li><a href="#">세부 카테고리16</a></li>
                <li><a href="#">세부 카테고리17</a></li>
                <li><a href="#">세부 카테고리18</a></li>
                <li><a href="#">세부 카테고리19</a></li>
                <li><a href="#">세부 카테고리20</a></li>
              </ul>
            </div>
            <div class="sideMenu" id="sideMenu-category5">
              <ul>
                <li><a href="#">세부 카테고리21</a></li>
                <li><a href="#">세부 카테고리22</a></li>
                <li><a href="#">세부 카테고리23</a></li>
                <li><a href="#">세부 카테고리24</a></li>
                <li><a href="#">세부 카테고리25</a></li>
              </ul>
            </div>
            <div class="sideMenu" id="sideMenu-category6">
              <ul>
                <li><a href="#">세부 카테고리26</a></li>
                <li><a href="#">세부 카테고리27</a></li>
                <li><a href="#">세부 카테고리28</a></li>
                <li><a href="#">세부 카테고리29</a></li>
                <li><a href="#">세부 카테고리30</a></li>
              </ul>
            </div>
            <div class="sideMenu" id="sideMenu-category7">
              <ul>
                <li><a href="#">세부 카테고리31</a></li>
                <li><a href="#">세부 카테고리32</a></li>
                <li><a href="#">세부 카테고리33</a></li>
                <li><a href="#">세부 카테고리34</a></li>
                <li><a href="#">세부 카테고리35</a></li>
              </ul>
            </div>
            <div class="sideMenu" id="sideMenu-category8">
              <ul>
                <li><a href="#">세부 카테고리36</a></li>
                <li><a href="#">세부 카테고리37</a></li>
                <li><a href="#">세부 카테고리38</a></li>
                <li><a href="#">세부 카테고리39</a></li>
                <li><a href="#">세부 카테고리40</a></li>
              </ul>
            </div>
            <div class="sideMenu" id="sideMenu-category9">
              <ul>
                <li><a href="#">세부 카테고리41</a></li>
                <li><a href="#">세부 카테고리42</a></li>
                <li><a href="#">세부 카테고리43</a></li>
                <li><a href="#">세부 카테고리44</a></li>
                <li><a href="#">세부 카테고리45</a></li>
              </ul>
            </div>
            <div class="sideMenu" id="sideMenu-category10">
              <ul>
                <li><a href="#">세부 카테고리46</a></li>
                <li><a href="#">세부 카테고리47</a></li>
                <li><a href="#">세부 카테고리48</a></li>
                <li><a href="#">세부 카테고리49</a></li>
                <li><a href="#">세부 카테고리50</a></li>
              </ul>
            </div>

            <p>카테고리</p>
            <div>
              <img
                src="<%=request.getContextPath()%>/images/common/ranking.png"
                alt=""
                id="ranking"
                height="50px"
              />
            </div>
          </div>
        </div>
        <hr width="1280px" color="#eeeeee" noshade />
      </div>
      <div id="itemBox">
        <div id="recentProduct">
          <p>최근본상품</p>
          <div class="rpCount">0</div>
        </div>
      </div>
    </header>
    </header>