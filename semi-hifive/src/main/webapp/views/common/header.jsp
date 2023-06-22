<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.semi.category.model.vo.Category"%>
<%@page import="java.util.List"%>
<%@ page import="com.semi.member.model.vo.Member"%>
<%
Member loginMember = (Member) session.getAttribute("loginMember");//여기 로그인멤버 
Cookie[] cookies = request.getCookies(); // 존재하는 쿠키들 다 갖고옴 
String saveId = null;
if (cookies != null) {
	for (Cookie c : cookies) {
		if (c.getName().equals("saveId")) {
	saveId = c.getValue();
	break;
		}
	}
}
%>
<script>
	//로그인한 아이디 sessionStorage에 저장하자..ㅋㅋㅋ
	sessionStorage.setItem("loginId",'<%=loginMember != null ? loginMember.getUserId() : ""%>');
</script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!-- css 파일 -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/default.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/searchPage.css" />
<link rel="icon"
	href="<%=request.getContextPath()%>/images/common/fivicon.png"
	type="image/x-icon" />
<!-- js 파일 -->
<script type="module"
	src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule
	src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery-3.7.0.min.js"></script>
<!--  -->
<title>중고 거래 HiFive</title>
</head>
<body>
	<header>
		<div id="headerContainer">
			<div id="fixedContainer">
				<%
				if (loginMember == null) {
				%>
				<div class="loginSerivce">
					<a href="<%=request.getContextPath()%>/loginView.do" id="login">로그인</a>
					<a href="<%=request.getContextPath()%>/enrollMember.do" id="enroll">회원가입</a>
					<a
						href="<%=request.getContextPath()%>/service/boardList.do?notice=Y"
						id="service">고객센터</a>
				</div>
				<%
				} else {
				%>
				<div class="loginSerivce">
					<a href="#"
						onclick="location.replace('<%=request.getContextPath()%>/logout.do')"
						id="logout">로그아웃</a> <a
						href="<%=request.getContextPath()%>/service/boardList.do?notice=Y"
						id="service">고객센터</a>
				</div>
				<%
				}
				%>

				<div class="headerMain">
					<div class="logo">
						<a href=""> <img
							src="<%=request.getContextPath()%>/images/common/hifiveLogo.png"
							alt="" />
						</a>
					</div>
					<div class="searchBar">
						<div class="searchDetail">
							<input type="search" onsearch="" class="search"
								placeholder="브랜드, 상품명, 상품번호 등" onfocus="this.placeholder = ''"
								onblur="this.placeholder = '브랜드, 상품명, 상품번호 등'"/>

							<button class="search">
								<img
									src="<%=request.getContextPath()%>/images/common/magnifier.png"
									alt="" />
							</button>
						</div>
						<div class="searchpage">
							<div class="searchbody">
								<div class="recentsearch">
									<div class="recentsearchchild">
										<div class="recentsearchtext">
											<span>최근검색어</span>
										</div>
										<div class="recentsearchmeun">
											<p>최근 검색어 내역이 없습니다.</p>
										</div>
									</div>
								</div>
								<div class="popularsearch">
									<div class="popularsearchchild">
										<div class="popularsearchheader">
											<span class="popularsearchtitle">인기 검색어</span>
											<div class="popularsearchtitletime">
												<span>05.19 22:00 기준</span>
											</div>
										</div>
										<div class="popularsearchbody">
											<ol class="popularsearchbodychild">
												<li class="popularsearchrank"><span class="ranking">1</span>
													<a href="" class="popularsearchranktext"> <span>인기상품명</span>
												</a></li>
												<li class="popularsearchrank"><span class="ranking">1</span>
													<a href="" class="popularsearchranktext"> <span>인기상품명</span>
												</a></li>
												<li class="popularsearchrank"><span class="ranking">1</span>
													<a href="" class="popularsearchranktext"> <span>인기상품명</span>
												</a></li>
												<li class="popularsearchrank"><span class="ranking">1</span>
													<a href="" class="popularsearchranktext"> <span>인기상품명</span>
												</a></li>
												<li class="popularsearchrank"><span class="ranking">1</span>
													<a href="" class="popularsearchranktext"> <span>인기상품명</span>
												</a></li>
												<li class="popularsearchrank"><span class="ranking">1</span>
													<a href="" class="popularsearchranktext"> <span>인기상품명</span>
												</a></li>
												<li class="popularsearchrank"><span class="ranking">1</span>
													<a href="" class="popularsearchranktext"> <span>인기상품명</span>
												</a></li>
												<li class="popularsearchrank"><span class="ranking">1</span>
													<a href="" class="popularsearchranktext"> <span>인기상품명</span>
												</a></li>
												<li class="popularsearchrank"><span class="ranking">1</span>
													<a href="" class="popularsearchranktext"> <span>인기상품명</span>
												</a></li>
												<li class="popularsearchrank"><span class="ranking">1</span>
													<a href="" class="popularsearchranktext"> <span>인기상품명</span>
												</a></li>
											</ol>
										</div>
									</div>
								</div>
								<div class="searchfooter">
									<div class="searchfooterchild">
										<div class="recentviewarea">
											<span class="recentviewtext">최근 본 상품</span>
											<div class="recentviewremove">
												<a href="">지우기</a>
											</div>
										</div>
										<div class="recetlyviewarea">
											<div class="recentlyviewproducarea">
												<div class="recentlyviewproductlist">
													<a href="" class="recentlyproductlistarea">
														<div class="recentlyprdouctimg">
															<img
																src="./3차 UI코드/img/a_c8f54fa85db64d6ab90503bb94b52250.webp"
																alt="" /> <span>상품명</span>
														</div>
													</a> <a href="" class="recentlyproductlistarea">
														<div class="recentlyprdouctimg">
															<img
																src="./3차 UI코드/img/a_c8f54fa85db64d6ab90503bb94b52250.webp"
																alt="" /> <span>상품명</span>
														</div>
													</a> <a href="" class="recentlyproductlistarea">
														<div class="recentlyprdouctimg">
															<img
																src="./3차 UI코드/img/a_c8f54fa85db64d6ab90503bb94b52250.webp"
																alt="" /> <span>상품명</span>
														</div>
													</a> <a href="" class="recentlyproductlistarea">
														<div class="recentlyprdouctimg">
															<img
																src="./3차 UI코드/img/a_c8f54fa85db64d6ab90503bb94b52250.webp"
																alt="" /> <span>상품명</span>
														</div>
													</a> <a href="" class="recentlyproductlistarea">
														<div class="recentlyprdouctimg">
															<img
																src="./3차 UI코드/img/a_c8f54fa85db64d6ab90503bb94b52250.webp"
																alt="" /> <span>상품명</span>
														</div>
													</a>
												</div>
												<button class="leftbtn">
													<svg xmlns="http://www.w3.org/2000/svg" fill="none"
														viewBox="0 0 24 24" stroke-width="1.5"
														stroke="currentColor" class="w-6 h-6">
                              <path stroke-linecap="round"
															stroke-linejoin="round" d="M15.75 19.5L8.25 12l7.5-7.5" />
                            </svg>
												</button>
												<button class="rightbtn">
													<svg xmlns="http://www.w3.org/2000/svg" fill="none"
														viewBox="0 0 24 24" stroke-width="1.5"
														stroke="currentColor" class="w-6 h-6">
                              <path stroke-linecap="round"
															stroke-linejoin="round" d="M8.25 4.5l7.5 7.5-7.5 7.5" />
                            </svg>
												</button>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="memberIcon">
						<a href="<%=request.getContextPath()%>/productRegist.do"> <ion-icon
								name="storefront-outline" class="storeIcon"></ion-icon> <span>
								판매하기</span>
						</a>
						<%
						if (loginMember != null) {
						%>
						<a
							href="<%=request.getContextPath()%>/myPage/myPageMain.do?userId=<%=loginMember.getUserId()%>">
							<ion-icon name="person-outline" class="myIcon"></ion-icon> 내정보
						</a> <a href=""> <ion-icon name="heart-outline" class="heartIcon"></ion-icon>
							찜한상품
						</a>
						<%
						} else {
						%>
						<a href="<%=request.getContextPath()%>/productRegist.do"> <ion-icon
								name="person-outline" class="myIcon"></ion-icon> 내정보
						</a> <a href="<%=request.getContextPath()%>/productRegist.do"> <ion-icon
								name="heart-outline" class="heartIcon"></ion-icon> 찜한상품
						</a>
						<%
						}
						%>
					</div>
				</div>
				<div class="categoryNrank">
					<input type="checkbox" id="menuIcon" /> <label for="menuIcon"
						class="headercategorybtn"> <span></span> <span></span> <span></span>
					</label>

					<div id="menuList">
						<ul>
							<li><a onclick="Test_btn();" id="category0">전체</a></li>
							<%-- <%if(categorylist.isEmpty()) {%> <%for(CategoryDto c :
                  categorylist){%>
                  <li><a href=""><%=c.getCategoryname()%></a></li>
                  <%} }%> --%>
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
						<img src="<%=request.getContextPath()%>/images/common/ranking.png"
							alt="" id="ranking" height="50px" />
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
	<script>
//카테고리 클릭시 상품리스트 출력 ajax
function Test_btn() {
	$.ajax({
		url: "<%=request.getContextPath()%>/categoryproductlist.do",
				dateType : 'html',
				success : function(data) {
					$("section").html(data);
				}
			});
		}
	</script>
	<script src="<%=request.getContextPath()%>/js/common/header.js"></script>
	<script src="<%=request.getContextPath()%>/js/searchpage/searchPage.js"></script>
</body>
</html>