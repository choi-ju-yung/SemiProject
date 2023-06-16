<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<%@ include file="/views/mypage/myPageCategory.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/mypage/sellList.css" />
<script src="<%=request.getContextPath()%>/js/mypage/sellList.js"></script>

<!-- 오른쪽 판매내역 section -->
    <div class="mypageMain">
        <!-- 판매내역 헤더 div -->
        <div class="mypageMainHeader">
            <h3>판매 내역</h3>
        </div>

        <!-- 판매상태 아이콘 div -->
        <div class="buttonAll">
            <button class="nowButton">전체 3</button>
            <button>판매중 1</button>
            <button>예약중 1</button>
            <button>판매완료 1</button>
        </div>

        <!-- 판매내역 목록 div -->
        <div class="productAll">
            <div class="product">
                <a href=""><img src="./img/구매목록img/예시 이미지.jpg" alt=""></a>
                <div class="proContent">
                    <h5 class="grayFont"><a href="" class="aTag grayFont">의류</a> &rsaquo; <a href=""
                            class="aTag grayFont">상의</a></h5>
                    <h4 class="contentMargin"><a href="" class="aTag productTitle">상품명을 작성해주세요.</a></h4>
                    <h3>35,000원</h3>
                </div>
                <div class="count">
                    <ion-icon name="heart" class="interestIcon"></ion-icon><span>40</span>
                    <ion-icon name="eye" class="viewIcon"></ion-icon><span>16,000</span>
                </div>
                <div class="buttonNcategory">
                    <div class="updateDelete">
                        <button>수정</button>
                        <button class="delMem openBtn" id="popup_open_btn">삭제</button>
                    </div>
                    <div class="selectNow">
                        <select class="select">
                            <option selected value="sell" data-color="#20C997">판매중</option>
                            <option value="reservation" data-color="#FFD800">예약중</option>
                            <option value="soldOut" data-color="#cccccc">판매완료</option>
                        </select>
                    </div>
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
                <div class="count">
                    <ion-icon name="heart" class="interestIcon"></ion-icon><span>40</span>
                    <ion-icon name="eye" class="viewIcon"></ion-icon><span>16,000</span>
                </div>
                <div class="buttonNcategory">
                    <div class="updateDelete">
                        <button>수정</button>
                        <button class="delMem openBtn" id="popup_open_btn">삭제</button>
                    </div>
                    <div class="selectNow">
                        <select class="select">
                            <option selected value="sell" data-color="#20C997">판매중</option>
                            <option value="reservation" data-color="#FFD800">예약중</option>
                            <option value="soldOut" data-color="#cccccc">판매완료</option>
                        </select>
                    </div>
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
                <div class="count">
                    <ion-icon name="heart" class="interestIcon"></ion-icon><span>40</span>
                    <ion-icon name="eye" class="viewIcon"></ion-icon><span>16,000</span>
                </div>
                <div class="buttonNcategory">
                    <div class="updateDelete">
                        <button>수정</button>
                        <button class="delMem openBtn" id="popup_open_btn">삭제</button>
                    </div>
                    <div class="selectNow">
                        <select class="select">
                            <option selected value="sell" data-color="#20C997">판매중</option>
                            <option value="reservation" data-color="#FFD800">예약중</option>
                            <option value="soldOut" data-color="#cccccc">판매완료</option>
                        </select>
                    </div>
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
                <div class="count">
                    <ion-icon name="heart" class="interestIcon"></ion-icon><span>40</span>
                    <ion-icon name="eye" class="viewIcon"></ion-icon><span>16,000</span>
                </div>
                <div class="buttonNcategory">
                    <div class="updateDelete">
                        <button>수정</button>
                        <button class="delMem openBtn" id="popup_open_btn">삭제</button>
                    </div>
                    <div class="selectNow">
                        <select class="select">
                            <option selected value="sell" data-color="#20C997">판매중</option>
                            <option value="reservation" data-color="#FFD800">예약중</option>
                            <option value="soldOut" data-color="#cccccc">판매완료</option>
                        </select>
                    </div>
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
                <div class="count">
                    <ion-icon name="heart" class="interestIcon"></ion-icon><span>40</span>
                    <ion-icon name="eye" class="viewIcon"></ion-icon><span>16,000</span>
                </div>
                <div class="buttonNcategory">
                    <div class="updateDelete">
                        <button>수정</button>
                        <button class="delMem openBtn" id="popup_open_btn">삭제</button>
                    </div>
                    <div class="selectNow">
                        <select class="select">
                            <option selected value="sell" data-color="#20C997">판매중</option>
                            <option value="reservation" data-color="#FFD800">예약중</option>
                            <option value="soldOut" data-color="#cccccc">판매완료</option>
                        </select>
                    </div>
                </div>
            </div>
        </div>
        <!-- 페이지 버튼 -->
        <div class="pageAll">
            <ul class="page">
                <li><a href="#">
                        < </a>
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
<%@ include file="/views/common/footer.jsp"%>