<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<section>
	<%@ include file="/views/service/serviceCategory.jsp"%>
	<link rel="stylesheet"
		href="<%=request.getContextPath()%>/css/service/buylistInsert.css">
	<div class="ServiceCenter">
		<h2 class="ServietHead">거래 신고하기</h2>
		<div class="writeTitle">
			<label for="">제목</label> <input type="text" id="reportTitle"
				placeholder="제목을 입력하세요."> <span id="titleTextNum">0/40</span>
		</div>
		<div>
			<div>
				<h4 style="padding-left: 10px;">신고할 거래 목록</h4>
			</div>
			<div class="reportList">
				<table>
					<tr>
						<th>번호</th>
						<th>거래자</th>
						<th>거래 게시물</th>
						<th>거래 날짜</th>
						<th>체크</th>
					</tr>
					<tr>
						<td>1</td>
						<td>닉네임여덟글자임</td>
						<td class="productTitle">게시글 제목입니다</td>
						<td>2023/04/21</td>
						<td><label class="list-label"> <input type="checkbox">
								<div class="list-check"></div>
						</label></td>
					</tr>
					<tr>
						<td>1</td>
						<td>125</td>
						<td class="productTitle">게시글 제목입니다</td>
						<td>2023/04/21</td>
						<td><label class="list-label"> <input type="checkbox">
								<div class="list-check"></div>
						</label></td>
					</tr>
				</table>
			</div>
		</div>

		<div class="writeBody">
			<textarea class="write" name="reportContent" rows="20" cols="150"
				placeholder="문의할 내용을 입력하세요."></textarea>
		</div>

		<div class="upfile">
			<ion-icon class="uploadIcon" name="images-outline"></ion-icon>
			<input class="form-control" type="file" id="formFileMultiple"
				multiple> <span id="contentTextNum">0/2000</span>
		</div>

		<div class="serviceInsertBtn">
			<button class="serviceCancelBtn">취소</button>
			<button class="serviceSubmitBtn">완료</button>
		</div>
		<div class="pageBar"></div>
	</div>
</section>
<%@ include file="/views/common/footer.jsp"%>