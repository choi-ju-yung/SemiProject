<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>


		<section>
			<div>
				<input type="hidden" id="hiddenEmail" value="<%=(String)request.getAttribute("userEmail")%>">		
				
				<div class="findPwdResult">
					<input type="text" id="findPwdAuth" placeholder="인증번호 입력" autocomplete="off">
	            	<button type="button" id="findPwdAuthButton">인증하기</button>
	            </div>
			 </div>
			 <span id="findPwdAuthId"></span>
			 <input type="password" id="newPassword" placeholder="새로운 패스워드를 입력하세요" autocomplete="off">
			 <input type="password" id="newPasswordCheck" placeholder="새로운 패스워드를 다시 입력하세요" autocomplete="off">
			 <button id="newPasswordButton">변경하기</button>
		</section>
		

<script src="<%=request.getContextPath()%>/js/member/findPwd.js"></script>
<%@ include file="/views/common/footer.jsp"%>