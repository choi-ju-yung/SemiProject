<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/service/boardInsert.css">
<section>
<%@ include file="/views/service/serviceCategory.jsp" %>
	<div class="ServiceCenter">
		<h2 class="ServietHead">게시글 작성</h2>
		<div class="writeTitle">
			<div class="titleGroup">
				<select class="titleSelect">
					<option name="" value="notice">공지사항</option>
					<option name="" value="QA">자주하는 질문</option>
				</select>
				<label for="">제목</label>
				<input type="text" name="boardTitle"
					id="baordTitle" placeholder="제목을 입력하세요.">
				<span id="title-text-num">0/40</span>
			</div>
		</div>
		<div class="writeBody">
			<textarea class="writeContent" name="boardContent" id="boardContent" rows="20" cols="150"
				placeholder="작성할 내용을 입력하세요."></textarea>
		</div>

		<div class="upfile">
			<ion-icon class="uploadIcon" name="images-outline"></ion-icon>
			<input class="form-control" type="file" name="boardOriginalFile" id="formFileMultiple"
				multiple> <span id="contentTextNum">0/2000</span>
		</div>
		<div class="serviceInsertBtn">
			<button class="serviceCancelBtn">취소</button>
			<button class="serviceSubmitBtn">완료</button>
		</div>
	</div>
</section>
<%@ include file="/views/common/footer.jsp" %>
