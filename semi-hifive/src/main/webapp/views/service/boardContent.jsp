<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/service/boardContent.css">
<section>
<%@ include file="/views/service/serviceCategory.jsp" %>
	<div class="ServiceCenter">
		<div class="boardContent">
			<div class="contentTitle">
				<h2>boardTitle</h2>
				<button class="backBtn"
					onclick="location.href=''">뒤로 가기</button>
			</div>
			<div class="content">
                <input type="hidden" name="boardNo" value="boardNo">
				<div class="contentTop">
                     <p>작성자 : 이벤트담당자</p>
                     <p>2023/04/25</p>
                </div>
				<p>Q. 자주하는 질문1</p>
				<p>A. 이렇게 해결해보세요</p>
				<img
					src="https://mblogthumb-phinf.pstatic.net/MjAyMjA2MTBfMjM3/MDAxNjU0ODM2MTEzODc5.rStmvGhTIUIZ_eshzIy-2Dv3hbMDgU5xMEgBe_8hxkEg.JLYYhiefyMgFUHAM0J3x5qlmGhxjaRgEBCVDWboxHKsg.PNG.papapapower/Desktop_Screenshot_2022.06.10_-_13.36.22.51.png?type=w800"
					alt="">
			</div>
			<!-- 자주하는 질문은 댓글 없음 -->
			<div class="commentWrite">
				<textarea name="boardComment" id="boardComment" cols="120" rows="5"
					placeholder="댓글을 작성하세요."></textarea>
				<button class="commentBtn">댓글 작성</button>
			</div>
			<div class="comment">
				<div class="commentTop">
					<h4>user01</h4>
					<p>2023/04/05</p>
				</div>
				<div class="commentContent">
					<p>
						댓글 달았어요!<br> 이벤트에 대한 간단한 질문을 남길수도 있습니다
					</p>
					<button class="recommentBtn">댓글</button>
				</div>
				<div class="commentUpdate">
					<a href="">수정</a> <a href="">삭제</a>
				</div>
				<hr>
				<div class="recomment">
					<div class="commentTop">
						<h4>관리자</h4>
						<p>2023/04/05</p>
					</div>
					<div class="commentContent">
						<p>대댓글 달았어요!</p>
					</div>
					<div class="commentUpdate">
						<a href="">수정</a> <a href="">삭제</a>
					</div>
				</div>
				<div class="commentWrite">
					<textarea name="recomment" id="recomment" cols="120" rows="5"
						placeholder="댓글을 작성하세요."></textarea>
					<button class="commentBtn">댓글 작성</button>
				</div>
			</div>
		</div>
	</div>
</section>
<%@ include file="/views/common/footer.jsp" %>