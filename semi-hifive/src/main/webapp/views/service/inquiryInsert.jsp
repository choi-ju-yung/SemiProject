<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
<section>
<%@ include file="/views/service/serviceCategory.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/service/inquiryInsert.css">
<form action="<%=request.getContextPath()%>/service/boardInsertEnd.do?login=admin"
		onsubmit="return titleCheck();" method="post" enctype="multipart/form-data">
<div class="ServiceCenter">
      <h2 class="ServietHead">1:1 문의하기</h2>
      <div class="writeTitle">
          <label for="">제목</label>
          <input type="text" id="contentTitle" name="contentTitle" placeholder="제목을 입력하세요.">
          <span id="titleTextNum">0/40</span>
      </div>
      <div class="writeBody">
        <textarea class="write" id="reportContent" rows="20" cols="150"
          placeholder="문의할 내용을 입력하세요."></textarea>
      </div>

      <div class="upfile">
        <ion-icon class="uploadIcon" name="images-outline"></ion-icon>
        <input class="form-control" type="file" id="formFileMultiple" multiple>
        <span id="contentTextNum">0/2000</span>
      </div>
      
      <div class="contentPrivate">
        <ion-icon name="lock-closed-outline"></ion-icon>
          <div class="slideContainer">
           	 	<label class="list-label">
                  <input type="checkbox" checked>
                  <div class="secretCk"></div>
               	</label>
          </div>
        </div>
        <p>* 문의글을 비공개로 작성하면 작성자만 확인 가능합니다.</p>
      <div class="serviceInsertBtn">
        <button class="serviceCancelBtn">취소</button>
        <button class="serviceSubmitBtn">완료</button>
      </div>
</div>
</form>
</section>
<script type="text/javascript">

</script>
<script src="<%=request.getContextPath()%>/js/service/inquiryInsert.js"></script>
<%@ include file="/views/common/footer.jsp" %>