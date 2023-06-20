<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
<section>
<%@ include file="/views/service/serviceCategory.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/service/QAList.css">
<div class="ServiceCenter">
      <h2 class="ServiceHead">자주하는 질문</h2>
      <div class="QAList">
        <div class="QACategory">
          <!-- js로 해당 버튼에 대한 카테고리 Q&A만 조회되도록 할 것 -->
          <button class="QABtn">회원정보</button>
          <button class="QABtn">구매</button>
          <button class="QABtn">판매</button>
          <button class="QABtn">그 외</button>
        </div>
        <table>
          <tr>
            <td>1<input type="hidden" value="QABoardNo넣기"></td>            
            <td class="QATitle"><a href="">Q.구매는 어떻게 진행되나요?</a></td>
          </tr>
          <tr class="tableLine"><td colspan="3"></td></tr>
        </table>
        <div class="pageBar">
          
        </div>
      </div>
    </div>
</section>
<%@ include file="/views/common/footer.jsp" %>