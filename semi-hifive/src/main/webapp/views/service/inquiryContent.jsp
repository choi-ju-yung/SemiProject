<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/service/reportContent.css">
<section>
<%@ include file="/views/service/serviceCategory.jsp" %>
	<div class="ServiceCenter">
            <div class="reportContent">
                <ion-icon name="lock-closed-outline"></ion-icon> 비공개
                <div class="contentTitle">
                    <h2>질문있어요</h2>
                    <button class="backBtn" onclick="location.href='ServiceCenterNoticeMain.html'">뒤로 가기</button>
                </div>
                <div class="content">
                    <div class="contentTop">
                        <p>작성자 : user01</p>
                        <p>2023/04/25</p>
                    </div>
                    <p>질문 내용...</p>
                    <img src="https://mblogthumb-phinf.pstatic.net/MjAyMjA2MTBfMjM3/MDAxNjU0ODM2MTEzODc5.rStmvGhTIUIZ_eshzIy-2Dv3hbMDgU5xMEgBe_8hxkEg.JLYYhiefyMgFUHAM0J3x5qlmGhxjaRgEBCVDWboxHKsg.PNG.papapapower/Desktop_Screenshot_2022.06.10_-_13.36.22.51.png?type=w800" alt="">
                </div>
                <div class="commentWrite">
                    <textarea name="comment" id="" cols="120" rows="5" placeholder="관리자만 달 수 있습니다."></textarea>
                    <button class="commentBtn">댓글 작성</button>
                </div>
                <div class="comment">
                    <div class="commentTop">
                        <h4>관리자</h4>
                        <p>2023/04/05</p>
                    </div>
                    <div class="commentContent">
                        <p>답변드립니다<br>
                        질문에 대한 답변 내용을 간단히 작성해요</p>
                        <button class="recommentBtn">댓글</button>
                    </div>
                    <div class="commentUpdate">
                        <a href="">수정</a>
                        <a href="">삭제</a>
                    </div>
                    <hr>
                    <div class="recomment">
                        <div class="commentTop">
                            <h4>user01</h4>
                            <p>2023/04/05</p>
                        </div>
                        <div class="commentContent">
                            <p>사용자는 대댓글을 달 수 있습니다.</p>
                        </div>
                        <div class="commentUpdate">
                            <a href="">수정</a>
                            <a href="">삭제</a>
                        </div>
                    </div>
                    <div class="commentWrite">
                        <textarea name="comment" id="" cols="120" rows="5" placeholder="댓글을 작성하세요."></textarea>
                        <button class="commentBtn">댓글 작성</button>
                    </div>
                </div>
            </div>
        </div>
</section>
<%@ include file="/views/common/footer.jsp" %>