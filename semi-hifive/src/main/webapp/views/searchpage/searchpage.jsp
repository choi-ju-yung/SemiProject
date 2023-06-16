<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>상품검색창</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/searchpage.css">
    <script src="<%=request.getContextPath()%>/js/searchpage/jquery-3.7.0.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/searchpage/jquery-ui.css"></script>
    <script src="<%=request.getContextPath()%>/js/searchpage/jquery-ui.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js@4.3.0/dist/chart.umd.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/searchpage/js.js"></script>
</head>
<body>
    <div class="searchpage">
        <a href="" class="searchpageremove">
            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6">
                <path stroke-linecap="round" stroke-linejoin="round" d="M6 18L18 6M6 6l12 12" />
            </svg>              
        </a>
        <div class="searchhearder">
            <div class="searchhearderchilde">
                <div class="searchbar">
                    <input type="text" placeholder="브랜드, 상품명, 상품번호 등" title="검색창" class="searchbartext">
                    <button class="removesearch">
                        <svg xmlns="http://www.w3.org/2000/svg" class="ionicon" viewBox="0 0 512 512">
                            <path fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="32" d="M368 368L144 144M368 144L144 368"/>
                        </svg>                     
                    </button>
                </div>
            </div>
        </div>
        <!--<div class="automaticsearch"> 
        
        </div> -->
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
                            <li class="popularsearchrank">
                                <span class="ranking">1</span>
                                <a href="" class="popularsearchranktext">
                                    <span>인기상품명</span>
                                </a>
                            </li>
                            <li class="popularsearchrank">
                                <span class="ranking">1</span>
                                <a href="" class="popularsearchranktext">
                                    <span>인기상품명</span>
                                </a>
                            </li>
                            <li class="popularsearchrank">
                                <span class="ranking">1</span>
                                <a href="" class="popularsearchranktext">
                                    <span>인기상품명</span>
                                </a>
                            </li>
                            <li class="popularsearchrank">
                                <span class="ranking">1</span>
                                <a href="" class="popularsearchranktext">
                                    <span>인기상품명</span>
                                </a>
                            </li>
                            <li class="popularsearchrank">
                                <span class="ranking">1</span>
                                <a href="" class="popularsearchranktext">
                                    <span>인기상품명</span>
                                </a>
                            </li>
                            <li class="popularsearchrank">
                                <span class="ranking">1</span>
                                <a href="" class="popularsearchranktext">
                                    <span>인기상품명</span>
                                </a>
                            </li>
                            <li class="popularsearchrank">
                                <span class="ranking">1</span>
                                <a href="" class="popularsearchranktext">
                                    <span>인기상품명</span>
                                </a>
                            </li>
                            <li class="popularsearchrank">
                                <span class="ranking">1</span>
                                <a href="" class="popularsearchranktext">
                                    <span>인기상품명</span>
                                </a>
                            </li>
                            <li class="popularsearchrank">
                                <span class="ranking">1</span>
                                <a href="" class="popularsearchranktext">
                                    <span>인기상품명</span>
                                </a>
                            </li>
                            <li class="popularsearchrank">
                                <span class="ranking">1</span>
                                <a href="" class="popularsearchranktext">
                                    <span>인기상품명</span>
                                </a>
                            </li>
                            <li class="popularsearchrank">
                                <span class="ranking">1</span>
                                <a href="" class="popularsearchranktext">
                                    <span>인기상품명</span>
                                </a>
                            </li>
                            <li class="popularsearchrank">
                                <span class="ranking">1</span>
                                <a href="" class="popularsearchranktext">
                                    <span>인기상품명</span>
                                </a>
                            </li>
                            <li class="popularsearchrank">
                                <span class="ranking">1</span>
                                <a href="" class="popularsearchranktext">
                                    <span>인기상품명</span>
                                </a>
                            </li>
                            <li class="popularsearchrank">
                                <span class="ranking">1</span>
                                <a href="" class="popularsearchranktext">
                                    <span>인기상품명</span>
                                </a>
                            </li>
                            <li class="popularsearchrank">
                                <span class="ranking">1</span>
                                <a href="" class="popularsearchranktext">
                                    <span>인기상품명</span>
                                </a>
                            </li>
                            <li class="popularsearchrank">
                                <span class="ranking">1</span>
                                <a href="" class="popularsearchranktext">
                                    <span>인기상품명</span>
                                </a>
                            </li>
                            <li class="popularsearchrank">
                                <span class="ranking">1</span>
                                <a href="" class="popularsearchranktext">
                                    <span>인기상품명</span>
                                </a>
                            </li>
                            <li class="popularsearchrank">
                                <span class="ranking">1</span>
                                <a href="" class="popularsearchranktext">
                                    <span>인기상품명</span>
                                </a>
                            </li>
                            <li class="popularsearchrank">
                                <span class="ranking">1</span>
                                <a href="" class="popularsearchranktext">
                                    <span>인기상품명</span>
                                </a>
                            </li>
                            <li class="popularsearchrank">
                                <span class="ranking">1</span>
                                <a href="" class="popularsearchranktext">
                                    <span>인기상품명</span>
                                </a>
                            </li>
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
                                        <img src="./3차 UI코드/img/a_c8f54fa85db64d6ab90503bb94b52250.webp" alt="">
                                        <span>상품명</span>
                                    </div>
                                </a>
                                <a href="" class="recentlyproductlistarea">
                                    <div class="recentlyprdouctimg">
                                        <img src="./3차 UI코드/img/a_c8f54fa85db64d6ab90503bb94b52250.webp" alt="">
                                        <span>상품명</span>
                                    </div>
                                </a>
                                <a href="" class="recentlyproductlistarea">
                                    <div class="recentlyprdouctimg">
                                        <img src="./3차 UI코드/img/a_c8f54fa85db64d6ab90503bb94b52250.webp" alt="">
                                        <span>상품명</span>
                                    </div>
                                </a>
                                <a href="" class="recentlyproductlistarea">
                                    <div class="recentlyprdouctimg">
                                        <img src="./3차 UI코드/img/a_c8f54fa85db64d6ab90503bb94b52250.webp" alt="">
                                        <span>상품명</span>
                                    </div>
                                </a>
                                <a href="" class="recentlyproductlistarea">
                                    <div class="recentlyprdouctimg">
                                        <img src="./3차 UI코드/img/a_c8f54fa85db64d6ab90503bb94b52250.webp" alt="">
                                        <span>상품명</span>
                                    </div>
                                </a>
                                <a href="" class="recentlyproductlistarea">
                                    <div class="recentlyprdouctimg">
                                        <img src="./3차 UI코드/img/a_c8f54fa85db64d6ab90503bb94b52250.webp" alt="">
                                        <span>상품명</span>
                                    </div>
                                </a>
                                <a href="" class="recentlyproductlistarea">
                                    <div class="recentlyprdouctimg">
                                        <img src="./3차 UI코드/img/a_c8f54fa85db64d6ab90503bb94b52250.webp" alt="">
                                        <span>상품명</span>
                                    </div>
                                </a>
                            </div>
                            <button class="leftbtn">
                                <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6">
                                    <path stroke-linecap="round" stroke-linejoin="round" d="M15.75 19.5L8.25 12l7.5-7.5" />
                                  </svg>
                                  
                            </button>
                            <button class="rightbtn">
                                <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6">
                                    <path stroke-linecap="round" stroke-linejoin="round" d="M8.25 4.5l7.5 7.5-7.5 7.5" />
                                  </svg>
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>