<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<%@ include file="/views/mypage/myPageCategory.jsp"%>
<%@ page import="com.semi.mypage.model.vo.MemberShopPage" %>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/mypage/myPageUpdate.css" />
<%
	MemberShopPage infoMS = (MemberShopPage) request.getAttribute("infoMemberShopPage");
%>
<!-- 오른쪽 회원정보관리 section -->
<div class="mypageMain">
	<!-- 회원정보관리 헤더 div -->
	<div class="mypageMainHeader">
		<h3>회원정보 관리</h3>
	</div>
	<!-- 회원정보관리 div -->
	<div class="updateMember">
	<form id="updateUserFrm" method="post" enctype="multipart/form-data">
		<div class="infoMem">
			<img
				src="<%=request.getContextPath()%>/upload/profileImg/<%=infoMS.getProfileImg()%>"
				alt="" style="width: 170px; height: 170px;" class="profileImg">
			<div class="nickNprofileImg">
				<div class="nicknameCon">
					<h1 class="nickname"><%=infoMS.getNickName()%></h1>
				</div>
				<div class="profileButton">
					<button class="profileImgUpdate">이미지 변경</button>
					<button class="profileImgDel">삭제</button>
					<input type="file" accept=".jpg, .png" class="profileImgInput" name="uploadProfile">
				</div>
			</div>
		</div>
		<!-- 프로필 수정 input -->
		<hr width="1050px" color="#313030" noshade style="margin-top: 35px;" />
			<div class="profileUPdateInput">
				<div class="profilePart">
					<h4>이메일</h4>
				</div>
				<input type="text" placeholder="<%=infoMS.getEmail()%>"
					class="inputCssReadOnly" disabled>
			</div>

			<hr width="1050px" color="#eee" />
			<div class="profileUPdateInput">
				<div class="profilePart">
					<h4>아이디</h4>
				</div>
				<input type="text" placeholder="<%=infoMS.getUserId()%>"
					class="inputCssReadOnly idUpdateInput"
					value="<%=infoMS.getUserId()%>" name="myPageUserId" readonly>
			</div>
			<hr width="1050px" color="#eee" />
			<div class="profileUPdateInput">
				<div class="profilePart">
					<h4>비밀번호 확인</h4>
				</div>
				<input type="password" placeholder="" class="inputCss"
					name="myPagePassword" required>
				<button class="checkDB" onclick="fn_updatePassword();">비밀번호
					변경</button>
			</div>
			<hr width="1050px" color="#eee" />
			<div class="profileUPdateInput">
				<div class="profilePart">
					<h4>닉네임</h4>
				</div>
				<input id="nicknameInput" name="myPageNickname" type="text"
					placeholder="<%=infoMS.getNickName()%>" value="<%=infoMS.getNickName()%>"
					class="inputCss nicknameCount">
				<!-- <button class="checkDB">중복확인</button> -->
				<span class="nicknameDuplSpan"></span>
			</div>
			<hr width="1050px" color="#eee" />
			<div class="profileUPdateInput">
				<div class="profilePart">
					<h4>상점소개글</h4>
				</div>
				<input type="text" placeholder="<%=infoMS.getShopPage().getIntroduce()%>" value="<%=infoMS.getShopPage().getIntroduce()%>"
					class="inputCss" name="myPageIntroduce">
			</div>
			<hr width="1050px" color="#313030" noshade
				style="margin-bottom: 20px;" />
			<div class="profileButton btnEndMargin">
				<button type="submit" class="profileUpdate" onclick="updateMember();">정보 수정</button>
				<button type="reset" class="resetUpdate">취소</button>
			</div>
		</form>

	</div>
</div>
</section>
<script>
<%-- const fn_updatePassword=()=>{
	//새창으로 패스워드 변경하자.
	open("<%=request.getContextPath()%>/member/updatePassword.do?userId=<%=shoppagemember.getUserId()%>",
			"_blank","width=400,height=210");
} --%>

const updateMember=()=>{
	/* const form = new FormData();
	const fileInput = $(".profileImgInput");
	$.each(fileInput[0].files, (i,f)=>{
		form.append("profileImg" + i,f);
	}); */
	
	$("#updateUserFrm").attr("action","<%=request.getContextPath()%>/member/updateEndMember.do").submit();
} 
</script>
<script src="<%=request.getContextPath()%>/js/mypage/myPageUpdate.js"></script>
<%@ include file="/views/common/footer.jsp"%>