<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
<section>
<%@ include file="/views/service/serviceCategory.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/service/productInsert.css">
<div class="ServiceCenter">
      <h2 class="ServietHead">판매글 신고하기</h2>
      <div class="writeTitle">
      		제목
          <input type="text" id="reportTitle" placeholder="제목을 입력하세요.">
          <span id="titleTextNum">0/40</span>
      </div>
		<div class="buylistInfo">
			<h4>신고할 판매글</h4>
			<table>
				<tr>
					<th>작성자</th>
					<th>게시글 제목</th>
					<th>작성일</th>
				</tr>
				<tr>
					<td>판매자 닉네임</td>
					<td>판매글 제목입니다.</td>
					<td>2023/05/05</td>
				</tr>
			</table>
		</div>
		<div class="writeBody">
        <textarea class="write" name="reportContent" rows="20" cols="150"
          placeholder="문의할 내용을 입력하세요."></textarea>
      </div>

      <div class="upfile">
        <ion-icon class="uploadIcon" name="images-outline"></ion-icon>
        <input class="form-control" type="file" id="formFileMultiple" multiple>
        <span id="contentTextNum">0/2000</span>
      </div>
      <div class="serviceInsertBtn">
        <button class="serviceCancelBtn">취소</button>
        <button class="serviceSubmitBtn">완료</button>
      </div>
      <div class="pageBar">
      
      </div>
</div>
</section>
<%@ include file="/views/common/footer.jsp" %>