<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css" />
<section>
        <!-- 광고배너 -->
            <div class="slideContainer">
                <div class="btnContainer">
                    <ul class="slide">
                        <li>
                            <img src="https://pbs.twimg.com/media/FPbY95lVUAkpe7A.jpg:large" alt="" />
                        </li>
                        <li>
                            <img src="https://pbs.twimg.com/media/E8BgJy6VUAYJIOd.jpg:large" alt="" />
                        </li>
                        <li>
                            <img src="https://pbs.twimg.com/media/Ev4VrhDVEAUmdSR.jpg:large" alt="" />
                        </li>
                    </ul>
                    <button class="prevBtn btn"><</button>
                    <button class="nextBtn btn">></button>
                </div>
            </div>
            
            <!-- 카테고리 -->
            <div class="mainCategoryDiv">
                <a href="">
                    <div class="categoryLink">
                        <div class="categoryBg">
                            <ion-icon class="cateIcon" name="book"></ion-icon>
                        </div>
                        <div class="spanDiv">
                            <span class="categoryTitle">전체</span>
                        </div>
                    </div>
                </a>
                <a href="">
                    <div class="categoryLink">
                        <div class="categoryBg">
                            <ion-icon class="cateIcon" name="book"></ion-icon>
                        </div>
                        <div class="spanDiv">
                            <span class="categoryTitle">패션의류</span>
                        </div>
                    </div>
                </a>
                <a href="">
                    <div class="categoryLink">
                        <div class="categoryBg">
                            <ion-icon class="cateIcon" name="book"></ion-icon>
                        </div>
                        <div class="spanDiv">
                            <span class="categoryTitle">패션잡화</span>
                        </div>
                    </div>
                </a>
                <a href="">
                    <div class="categoryLink">
                        <div class="categoryBg">
                            <ion-icon class="cateIcon" name="book"></ion-icon>
                        </div>
                        <div class="spanDiv">
                            <span class="categoryTitle">가전제품</span>
                        </div>
                    </div>
                </a>
                <a href="">
                    <div class="categoryLink">
                        <div class="categoryBg">
                            <ion-icon class="cateIcon" name="book"></ion-icon>
                        </div>
                        <div class="spanDiv">
                            <span class="categoryTitle">PC/모바일</span>
                        </div>
                    </div>
                </a>
                <a href="">
                    <div class="categoryLink">
                        <div class="categoryBg">
                            <ion-icon class="cateIcon" name="book"></ion-icon>
                        </div>
                        <div class="spanDiv">
                            <span class="categoryTitle">가구/인테리어</span>
                        </div>
                    </div>
                </a>
                <a href="">
                    <div class="categoryLink">
                        <div class="categoryBg">
                            <ion-icon class="cateIcon" name="book"></ion-icon>
                        </div>
                        <div class="spanDiv">
                            <span class="categoryTitle">리빙/생활</span>
                        </div>
                    </div>
                </a>
                <a href="">
                    <div class="categoryLink">
                        <div class="categoryBg">
                            <ion-icon class="cateIcon" name="book"></ion-icon>
                        </div>
                        <div class="spanDiv">
                            <span class="categoryTitle">스포츠/레저</span>
                        </div>
                    </div>
                </a>
                <a href="">
                    <div class="categoryLink">
                        <div class="categoryBg">
                            <ion-icon class="cateIcon" name="book"></ion-icon>
                        </div>
                        <div class="spanDiv">
                            <span class="categoryTitle">도서/음반/문구</span>
                        </div>
                    </div>
                </a>
                <a href="">
                    <div class="categoryLink">
                        <div class="categoryBg">
                            <ion-icon class="cateIcon" name="book"></ion-icon>
                        </div>
                        <div class="spanDiv">
                            <span class="categoryTitle">차량/오토바이</span>
                        </div>
                    </div>
                </a>
            </div>
            <!-- 인기상품 -->
            <div class="popularProDiv">
                <div class="proTitleDiv">
                    <h1 class="proTitle">인기상품</h1>
                    <button class="moreBtn">더보기</button>
                </div>
                <div class="productDiv">
                    <div class="productAll">
                        <div class="product">
                            <div class="productImg">
                                <a href=""><img src="" alt=""></a>
                                <label class="container"> <input id="" class="wishCheck" checked="checked"
                                        type="checkbox">
                                    <div class="checkmark">
                                        <svg viewBox="0 0 256 256">
                                            <rect fill="none" height="256" width="256"></rect>
                                            <path
                                                d="M224.6,51.9a59.5,59.5,0,0,0-43-19.9,60.5,60.5,0,0,0-44,17.6L128,59.1l-7.5-7.4C97.2,28.3,59.2,26.3,35.9,47.4a59.9,59.9,0,0,0-2.3,87l83.1,83.1a15.9,15.9,0,0,0,22.6,0l81-81C243.7,113.2,245.6,75.2,224.6,51.9Z"
                                                stroke-width="20px" stroke="#FFF" fill="none"></path>
                                        </svg>
                                    </div>
                                </label>
                            </div>
                            <div class="proContent">
                                <h4 class="contentMargin">
                                    <a href="" class="aTag productTitle">상품명</a>
                                </h4>
                                <div class="PriceNStatus">
                                    <h3>000원</h3>
                                    <div class="statusBtnDiv">
                                        <span class="statusBtn">NEW 미개봉</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="productAll">
                        <div class="product">
                            <div class="productImg">
                                <a href=""><img src="" alt=""></a>
                                <label class="container"> <input id="" class="wishCheck" checked="checked"
                                        type="checkbox">
                                    <div class="checkmark">
                                        <svg viewBox="0 0 256 256">
                                            <rect fill="none" height="256" width="256"></rect>
                                            <path
                                                d="M224.6,51.9a59.5,59.5,0,0,0-43-19.9,60.5,60.5,0,0,0-44,17.6L128,59.1l-7.5-7.4C97.2,28.3,59.2,26.3,35.9,47.4a59.9,59.9,0,0,0-2.3,87l83.1,83.1a15.9,15.9,0,0,0,22.6,0l81-81C243.7,113.2,245.6,75.2,224.6,51.9Z"
                                                stroke-width="20px" stroke="#FFF" fill="none"></path>
                                        </svg>
                                    </div>
                                </label>
                            </div>
                            <div class="proContent">
                                <h4 class="contentMargin">
                                    <a href="" class="aTag productTitle">상품명</a>
                                </h4>
                                <div class="PriceNStatus">
                                    <h3>000원</h3>
                                    <div class="statusBtnDiv">
                                        <span class="statusBtn">NEW 미개봉</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="productAll">
                        <div class="product">
                            <div class="productImg">
                                <a href=""><img src="" alt=""></a>
                                <label class="container"> <input id="" class="wishCheck" checked="checked"
                                        type="checkbox">
                                    <div class="checkmark">
                                        <svg viewBox="0 0 256 256">
                                            <rect fill="none" height="256" width="256"></rect>
                                            <path
                                                d="M224.6,51.9a59.5,59.5,0,0,0-43-19.9,60.5,60.5,0,0,0-44,17.6L128,59.1l-7.5-7.4C97.2,28.3,59.2,26.3,35.9,47.4a59.9,59.9,0,0,0-2.3,87l83.1,83.1a15.9,15.9,0,0,0,22.6,0l81-81C243.7,113.2,245.6,75.2,224.6,51.9Z"
                                                stroke-width="20px" stroke="#FFF" fill="none"></path>
                                        </svg>
                                    </div>
                                </label>
                            </div>
                            <div class="proContent">
                                <h4 class="contentMargin">
                                    <a href="" class="aTag productTitle">상품명</a>
                                </h4>
                                <div class="PriceNStatus">
                                    <h3>000원</h3>
                                    <div class="statusBtnDiv">
                                        <span class="statusBtn">NEW 미개봉</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="productAll">
                        <div class="product">
                            <div class="productImg">
                                <a href=""><img src="" alt=""></a>
                                <label class="container"> <input id="" class="wishCheck" checked="checked"
                                        type="checkbox">
                                    <div class="checkmark">
                                        <svg viewBox="0 0 256 256">
                                            <rect fill="none" height="256" width="256"></rect>
                                            <path
                                                d="M224.6,51.9a59.5,59.5,0,0,0-43-19.9,60.5,60.5,0,0,0-44,17.6L128,59.1l-7.5-7.4C97.2,28.3,59.2,26.3,35.9,47.4a59.9,59.9,0,0,0-2.3,87l83.1,83.1a15.9,15.9,0,0,0,22.6,0l81-81C243.7,113.2,245.6,75.2,224.6,51.9Z"
                                                stroke-width="20px" stroke="#FFF" fill="none"></path>
                                        </svg>
                                    </div>
                                </label>
                            </div>
                            <div class="proContent">
                                <h4 class="contentMargin">
                                    <a href="" class="aTag productTitle">상품명</a>
                                </h4>
                                <div class="PriceNStatus">
                                    <h3>000원</h3>
                                    <div class="statusBtnDiv">
                                        <span class="statusBtn">NEW 미개봉</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="productAll">
                        <div class="product">
                            <div class="productImg">
                                <a href=""><img src="" alt=""></a>
                                <label class="container"> <input id="" class="wishCheck" checked="checked"
                                        type="checkbox">
                                    <div class="checkmark">
                                        <svg viewBox="0 0 256 256">
                                            <rect fill="none" height="256" width="256"></rect>
                                            <path
                                                d="M224.6,51.9a59.5,59.5,0,0,0-43-19.9,60.5,60.5,0,0,0-44,17.6L128,59.1l-7.5-7.4C97.2,28.3,59.2,26.3,35.9,47.4a59.9,59.9,0,0,0-2.3,87l83.1,83.1a15.9,15.9,0,0,0,22.6,0l81-81C243.7,113.2,245.6,75.2,224.6,51.9Z"
                                                stroke-width="20px" stroke="#FFF" fill="none"></path>
                                        </svg>
                                    </div>
                                </label>
                            </div>
                            <div class="proContent">
                                <h4 class="contentMargin">
                                    <a href="" class="aTag productTitle">상품명</a>
                                </h4>
                                <div class="PriceNStatus">
                                    <h3>000원</h3>
                                    <div class="statusBtnDiv">
                                        <span class="statusBtn">NEW 미개봉</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="productAll">
                        <div class="product">
                            <div class="productImg">
                                <a href=""><img src="" alt=""></a>
                                <label class="container"> <input id="" class="wishCheck" checked="checked"
                                        type="checkbox">
                                    <div class="checkmark">
                                        <svg viewBox="0 0 256 256">
                                            <rect fill="none" height="256" width="256"></rect>
                                            <path
                                                d="M224.6,51.9a59.5,59.5,0,0,0-43-19.9,60.5,60.5,0,0,0-44,17.6L128,59.1l-7.5-7.4C97.2,28.3,59.2,26.3,35.9,47.4a59.9,59.9,0,0,0-2.3,87l83.1,83.1a15.9,15.9,0,0,0,22.6,0l81-81C243.7,113.2,245.6,75.2,224.6,51.9Z"
                                                stroke-width="20px" stroke="#FFF" fill="none"></path>
                                        </svg>
                                    </div>
                                </label>
                            </div>
                            <div class="proContent">
                                <h4 class="contentMargin">
                                    <a href="" class="aTag productTitle">상품명</a>
                                </h4>
                                <div class="PriceNStatus">
                                    <h3>000원</h3>
                                    <div class="statusBtnDiv">
                                        <span class="statusBtn">NEW 미개봉</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="productAll">
                        <div class="product">
                            <div class="productImg">
                                <a href=""><img src="" alt=""></a>
                                <label class="container"> <input id="" class="wishCheck" checked="checked"
                                        type="checkbox">
                                    <div class="checkmark">
                                        <svg viewBox="0 0 256 256">
                                            <rect fill="none" height="256" width="256"></rect>
                                            <path
                                                d="M224.6,51.9a59.5,59.5,0,0,0-43-19.9,60.5,60.5,0,0,0-44,17.6L128,59.1l-7.5-7.4C97.2,28.3,59.2,26.3,35.9,47.4a59.9,59.9,0,0,0-2.3,87l83.1,83.1a15.9,15.9,0,0,0,22.6,0l81-81C243.7,113.2,245.6,75.2,224.6,51.9Z"
                                                stroke-width="20px" stroke="#FFF" fill="none"></path>
                                        </svg>
                                    </div>
                                </label>
                            </div>
                            <div class="proContent">
                                <h4 class="contentMargin">
                                    <a href="" class="aTag productTitle">상품명</a>
                                </h4>
                                <div class="PriceNStatus">
                                    <h3>000원</h3>
                                    <div class="statusBtnDiv">
                                        <span class="statusBtn">NEW 미개봉</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="productAll">
                        <div class="product">
                            <div class="productImg">
                                <a href=""><img src="" alt=""></a>
                                <label class="container"> <input id="" class="wishCheck" checked="checked"
                                        type="checkbox">
                                    <div class="checkmark">
                                        <svg viewBox="0 0 256 256">
                                            <rect fill="none" height="256" width="256"></rect>
                                            <path
                                                d="M224.6,51.9a59.5,59.5,0,0,0-43-19.9,60.5,60.5,0,0,0-44,17.6L128,59.1l-7.5-7.4C97.2,28.3,59.2,26.3,35.9,47.4a59.9,59.9,0,0,0-2.3,87l83.1,83.1a15.9,15.9,0,0,0,22.6,0l81-81C243.7,113.2,245.6,75.2,224.6,51.9Z"
                                                stroke-width="20px" stroke="#FFF" fill="none"></path>
                                        </svg>
                                    </div>
                                </label>
                            </div>
                            <div class="proContent">
                                <h4 class="contentMargin">
                                    <a href="" class="aTag productTitle">상품명</a>
                                </h4>
                                <div class="PriceNStatus">
                                    <h3>000원</h3>
                                    <div class="statusBtnDiv">
                                        <span class="statusBtn">NEW 미개봉</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <hr color="#eeeeee" noshade style="margin-top: 16px; margin-bottom: 30px;" />
            <!-- 최신상품 -->
            <div class="popularProDiv">
                <div class="proTitleDiv">
                    <h1 class="proTitle">최신상품</h1>
                    <button class="moreBtn">더보기</button>
                </div>
                <div class="productDiv">
                    <div class="productAll">
                        <div class="product">
                            <div class="productImg">
                                <a href=""><img src="" alt=""></a>
                                <label class="container"> <input id="" class="wishCheck" checked="checked"
                                        type="checkbox">
                                    <div class="checkmark">
                                        <svg viewBox="0 0 256 256">
                                            <rect fill="none" height="256" width="256"></rect>
                                            <path
                                                d="M224.6,51.9a59.5,59.5,0,0,0-43-19.9,60.5,60.5,0,0,0-44,17.6L128,59.1l-7.5-7.4C97.2,28.3,59.2,26.3,35.9,47.4a59.9,59.9,0,0,0-2.3,87l83.1,83.1a15.9,15.9,0,0,0,22.6,0l81-81C243.7,113.2,245.6,75.2,224.6,51.9Z"
                                                stroke-width="20px" stroke="#FFF" fill="none"></path>
                                        </svg>
                                    </div>
                                </label>
                            </div>
                            <div class="proContent">
                                <h4 class="contentMargin">
                                    <a href="" class="aTag productTitle">상품명</a>
                                </h4>
                                <div class="PriceNStatus">
                                    <h3>000원</h3>
                                    <div class="statusBtnDiv">
                                        <span class="statusBtn">NEW 미개봉</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="productAll">
                        <div class="product">
                            <div class="productImg">
                                <a href=""><img src="" alt=""></a>
                                <label class="container"> <input id="" class="wishCheck" checked="checked"
                                        type="checkbox">
                                    <div class="checkmark">
                                        <svg viewBox="0 0 256 256">
                                            <rect fill="none" height="256" width="256"></rect>
                                            <path
                                                d="M224.6,51.9a59.5,59.5,0,0,0-43-19.9,60.5,60.5,0,0,0-44,17.6L128,59.1l-7.5-7.4C97.2,28.3,59.2,26.3,35.9,47.4a59.9,59.9,0,0,0-2.3,87l83.1,83.1a15.9,15.9,0,0,0,22.6,0l81-81C243.7,113.2,245.6,75.2,224.6,51.9Z"
                                                stroke-width="20px" stroke="#FFF" fill="none"></path>
                                        </svg>
                                    </div>
                                </label>
                            </div>
                            <div class="proContent">
                                <h4 class="contentMargin">
                                    <a href="" class="aTag productTitle">상품명</a>
                                </h4>
                                <div class="PriceNStatus">
                                    <h3>000원</h3>
                                    <div class="statusBtnDiv">
                                        <span class="statusBtn">NEW 미개봉</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="productAll">
                        <div class="product">
                            <div class="productImg">
                                <a href=""><img src="" alt=""></a>
                                <label class="container"> <input id="" class="wishCheck" checked="checked"
                                        type="checkbox">
                                    <div class="checkmark">
                                        <svg viewBox="0 0 256 256">
                                            <rect fill="none" height="256" width="256"></rect>
                                            <path
                                                d="M224.6,51.9a59.5,59.5,0,0,0-43-19.9,60.5,60.5,0,0,0-44,17.6L128,59.1l-7.5-7.4C97.2,28.3,59.2,26.3,35.9,47.4a59.9,59.9,0,0,0-2.3,87l83.1,83.1a15.9,15.9,0,0,0,22.6,0l81-81C243.7,113.2,245.6,75.2,224.6,51.9Z"
                                                stroke-width="20px" stroke="#FFF" fill="none"></path>
                                        </svg>
                                    </div>
                                </label>
                            </div>
                            <div class="proContent">
                                <h4 class="contentMargin">
                                    <a href="" class="aTag productTitle">상품명</a>
                                </h4>
                                <div class="PriceNStatus">
                                    <h3>000원</h3>
                                    <div class="statusBtnDiv">
                                        <span class="statusBtn">NEW 미개봉</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="productAll">
                        <div class="product">
                            <div class="productImg">
                                <a href=""><img src="" alt=""></a>
                                <label class="container"> <input id="" class="wishCheck" checked="checked"
                                        type="checkbox">
                                    <div class="checkmark">
                                        <svg viewBox="0 0 256 256">
                                            <rect fill="none" height="256" width="256"></rect>
                                            <path
                                                d="M224.6,51.9a59.5,59.5,0,0,0-43-19.9,60.5,60.5,0,0,0-44,17.6L128,59.1l-7.5-7.4C97.2,28.3,59.2,26.3,35.9,47.4a59.9,59.9,0,0,0-2.3,87l83.1,83.1a15.9,15.9,0,0,0,22.6,0l81-81C243.7,113.2,245.6,75.2,224.6,51.9Z"
                                                stroke-width="20px" stroke="#FFF" fill="none"></path>
                                        </svg>
                                    </div>
                                </label>
                            </div>
                            <div class="proContent">
                                <h4 class="contentMargin">
                                    <a href="" class="aTag productTitle">상품명</a>
                                </h4>
                                <div class="PriceNStatus">
                                    <h3>000원</h3>
                                    <div class="statusBtnDiv">
                                        <span class="statusBtn">NEW 미개봉</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="productAll">
                        <div class="product">
                            <div class="productImg">
                                <a href=""><img src="" alt=""></a>
                                <label class="container"> <input id="" class="wishCheck" checked="checked"
                                        type="checkbox">
                                    <div class="checkmark">
                                        <svg viewBox="0 0 256 256">
                                            <rect fill="none" height="256" width="256"></rect>
                                            <path
                                                d="M224.6,51.9a59.5,59.5,0,0,0-43-19.9,60.5,60.5,0,0,0-44,17.6L128,59.1l-7.5-7.4C97.2,28.3,59.2,26.3,35.9,47.4a59.9,59.9,0,0,0-2.3,87l83.1,83.1a15.9,15.9,0,0,0,22.6,0l81-81C243.7,113.2,245.6,75.2,224.6,51.9Z"
                                                stroke-width="20px" stroke="#FFF" fill="none"></path>
                                        </svg>
                                    </div>
                                </label>
                            </div>
                            <div class="proContent">
                                <h4 class="contentMargin">
                                    <a href="" class="aTag productTitle">상품명</a>
                                </h4>
                                <div class="PriceNStatus">
                                    <h3>000원</h3>
                                    <div class="statusBtnDiv">
                                        <span class="statusBtn">NEW 미개봉</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="productAll">
                        <div class="product">
                            <div class="productImg">
                                <a href=""><img src="" alt=""></a>
                                <label class="container"> <input id="" class="wishCheck" checked="checked"
                                        type="checkbox">
                                    <div class="checkmark">
                                        <svg viewBox="0 0 256 256">
                                            <rect fill="none" height="256" width="256"></rect>
                                            <path
                                                d="M224.6,51.9a59.5,59.5,0,0,0-43-19.9,60.5,60.5,0,0,0-44,17.6L128,59.1l-7.5-7.4C97.2,28.3,59.2,26.3,35.9,47.4a59.9,59.9,0,0,0-2.3,87l83.1,83.1a15.9,15.9,0,0,0,22.6,0l81-81C243.7,113.2,245.6,75.2,224.6,51.9Z"
                                                stroke-width="20px" stroke="#FFF" fill="none"></path>
                                        </svg>
                                    </div>
                                </label>
                            </div>
                            <div class="proContent">
                                <h4 class="contentMargin">
                                    <a href="" class="aTag productTitle">상품명</a>
                                </h4>
                                <div class="PriceNStatus">
                                    <h3>000원</h3>
                                    <div class="statusBtnDiv">
                                        <span class="statusBtn">NEW 미개봉</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="productAll">
                        <div class="product">
                            <div class="productImg">
                                <a href=""><img src="" alt=""></a>
                                <label class="container"> <input id="" class="wishCheck" checked="checked"
                                        type="checkbox">
                                    <div class="checkmark">
                                        <svg viewBox="0 0 256 256">
                                            <rect fill="none" height="256" width="256"></rect>
                                            <path
                                                d="M224.6,51.9a59.5,59.5,0,0,0-43-19.9,60.5,60.5,0,0,0-44,17.6L128,59.1l-7.5-7.4C97.2,28.3,59.2,26.3,35.9,47.4a59.9,59.9,0,0,0-2.3,87l83.1,83.1a15.9,15.9,0,0,0,22.6,0l81-81C243.7,113.2,245.6,75.2,224.6,51.9Z"
                                                stroke-width="20px" stroke="#FFF" fill="none"></path>
                                        </svg>
                                    </div>
                                </label>
                            </div>
                            <div class="proContent">
                                <h4 class="contentMargin">
                                    <a href="" class="aTag productTitle">상품명</a>
                                </h4>
                                <div class="PriceNStatus">
                                    <h3>000원</h3>
                                    <div class="statusBtnDiv">
                                        <span class="statusBtn">NEW 미개봉</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="productAll">
                        <div class="product">
                            <div class="productImg">
                                <a href=""><img src="" alt=""></a>
                                <label class="container"> <input id="" class="wishCheck" checked="checked"
                                        type="checkbox">
                                    <div class="checkmark">
                                        <svg viewBox="0 0 256 256">
                                            <rect fill="none" height="256" width="256"></rect>
                                            <path
                                                d="M224.6,51.9a59.5,59.5,0,0,0-43-19.9,60.5,60.5,0,0,0-44,17.6L128,59.1l-7.5-7.4C97.2,28.3,59.2,26.3,35.9,47.4a59.9,59.9,0,0,0-2.3,87l83.1,83.1a15.9,15.9,0,0,0,22.6,0l81-81C243.7,113.2,245.6,75.2,224.6,51.9Z"
                                                stroke-width="20px" stroke="#FFF" fill="none"></path>
                                        </svg>
                                    </div>
                                </label>
                            </div>
                            <div class="proContent">
                                <h4 class="contentMargin">
                                    <a href="" class="aTag productTitle">상품명</a>
                                </h4>
                                <div class="PriceNStatus">
                                    <h3>000원</h3>
                                    <div class="statusBtnDiv">
                                        <span class="statusBtn">NEW 미개봉</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        
        
        
    </section>
<script src="<%=request.getContextPath()%>/js/common/main.js"></script>
<%@ include file="/views/common/footer.jsp" %>