<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
<section>
<%@ include file="/views/service/serviceCategory.jsp" %>
<div class="ServiceCenter">
      <h2 class="ServietHead">1:1 문의하기</h2>
      <div class="writeTitle">
          <label for="">제목</label>
          <input type="text" id="reportTitle" placeholder="제목을 입력하세요.">
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
          <div class="container">
            <input type="checkbox" class="checkbox" id="checkbox">
            <label class="switch" for="checkbox">
              <span class="slider"></span>
            </label>
          </div>
        </div>
        <p>* 문의글을 비공개로 작성하면 작성자만 확인 가능합니다.</p>
      <div class="serviceInsertBtn">
        <button class="serviceCancelBtn">취소</button>
        <button class="serviceSubmitBtn">완료</button>
      </div>
      <div class="pageBar">
      
      </div>
</div>
</section>
<%@ include file="/views/common/footer.jsp" %>