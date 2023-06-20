<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
<%
	String writer="";
	if(loginMember!=null){
		writer=loginMember.getUserId();
	}
%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/service/boardInsert.css">
<section>
<%@ include file="/views/service/serviceCategory.jsp" %>
	<form action="<%=request.getContextPath()%>/service/boardInsertEnd.do?login=admin"
		onsubmit="return titleCheck();" method="post" enctype="multipart/form-data">
	<div class="ServiceCenter">
		<h2 class="ServietHead">게시글 작성</h2>
		<div class="writeTitle">
			<div class="titleGroup">
				<select class="titleSelect" name="titleCategory">
					<option value="Y" selected>공지사항</option>
					<option value="N">자주하는 질문</option>
				</select>
				<select class="QASelect" name="QACategory">
					<option value="" selected disabled>필수 선택</option>
					<option value="회원정보">회원정보</option>
					<option value="거래">거래</option>
					<option value="구매">구매</option>
					<option value="거래">기타</option>
				</select>
				<br>
				<label for="">제목</label>
				<input type="text" name="boardTitle"
					id="baordTitle" placeholder="제목을 입력하세요.">
				<span id="titleTextNum">0/40</span>
				<div id="titleCheck"></div>
			</div>
		</div>
		<div class="writeBody">
			<textarea class="writeContent" name="boardContent" id="boardContent" rows="20" cols="150"
				placeholder="작성할 내용을 입력하세요."></textarea>
		</div>

		<div class="upfile">
			<ion-icon class="uploadIcon" name="images-outline"></ion-icon>
			<input class="form-control" type="file" name="boardFile" id="formFileMultiple"
				multiple> <span id="contentTextNum">0/2000</span>
		</div>
		<div class="serviceInsertBtn">
			<input type="reset"  class="serviceCancelBtn" value="취소">
			<input type="submit"  class="serviceSubmitBtn" value="완료">
		</div>
	</div>
	</form>
</section>
<script>
$("#formFileMultiple").change(function(){
    const files=$("#formFileMultiple")[0].files;
    $.ajax({
        url         :   "",
        dataType    :   "json",
        contentType :   "application/; charset=UTF-8",
        type        :   "post",
        data        :   objParams,
        success     :   function(retVal){

            if(retVal.code == "OK") {
                alert(retVal.message);
            } else {
                alert(retVal.message);
            }
             
        },
        error       :   function(request, status, error){
            console.log("AJAX_ERROR");
        }
    });
    for(var i= 0; i<files.length; i++){
    	console.log(files[i].name);
    }
    
});
</script>
<script src="<%=request.getContextPath()%>/js/service/boardInsert.js"></script>
<%@ include file="/views/common/footer.jsp" %>
