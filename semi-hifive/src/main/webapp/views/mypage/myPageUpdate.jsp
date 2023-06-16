<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<%@ include file="/views/mypage/myPageCategory.jsp"%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/mypage/myPageUpdate.css" />
<%
	ShopPage shoppagemember = (ShopPage)request.getAttribute("shoppagemember");
	Member mypageMember = (Member)request.getAttribute("mypageMember");

%>
<!-- 오른쪽 회원정보관리 section -->
        <div class="mypageMain">
            <!-- 회원정보관리 헤더 div -->
            <div class="mypageMainHeader">
                <h3>회원정보 관리</h3>
            </div>
            <!-- 회원정보관리 div -->
            <div class="updateMember">
                <div class="infoMem">
                    <img src="<%=request.getContextPath() %>/images/mypage/<%=mypageMember.getProfileImg() %>" alt="" style="width: 170px; height: 170px;" class="profileImg">
                    <div class="nickNprofileImg">
                        <div class="nicknameCon">
                            <h1 class="nickname"><%=mypageMember.getNickName() %></h1>
                            <!-- <div class="nicknameInput">
                                <input type="text" class="nicknameValue inputCss" placeholder="새 닉네임">
                                <div class="profileButton nickBtn">
                                    <button class="updateNick">수정</button>
                                    <button class="cancelNick">취소</button>
                                </div>
                            </div><button class="penBtn"><ion-icon name="pencil" class="penIcon"></ion-icon></button> -->
                        </div>
                        <div class="profileButton">
                            <button class="profileImgUpdate">이미지 변경</button>
                            <button class="profileImgDel">삭제</button>
                            <input type="file" accept=".jpg, .png" class="profileImgInput">
                        </div>
                    </div>
                </div>
                <!-- 프로필 수정 input -->
                <hr width="1050px" color="#313030" noshade style="margin-top: 35px;" />

                <form id="updateUserFrm" method="post">
                    <div class="profileUPdateInput">
                        <div class="profilePart">
                            <h4>이메일</h4>
                        </div>
                        <input type="text" placeholder="<%=mypageMember.getEmail() %>" class="inputCssReadOnly" disabled>
                    </div>

                    <hr width="1050px" color="#eee" />
                    <div class="profileUPdateInput">
                        <div class="profilePart">
                            <h4>아이디</h4>
                        </div>
                        <input type="text" placeholder="<%=mypageMember.getUserId() %>" class="inputCssReadOnly idUpdateInput" value="<%=mypageMember.getUserId() %>"
                        name="myPageUserId" readonly>
                    </div>
                    <hr width="1050px" color="#eee" />
                    <div class="profileUPdateInput">
                        <div class="profilePart">
                            <h4>비밀번호 확인</h4>
                        </div>
                        <input type="password" placeholder="" class="inputCss" name="myPagePassword">
                        <button class="checkDB" onclick="fn_updatePassword();">비밀번호 변경</button>
                    </div>
                    <!-- <hr width="1050px" color="#eee" />
                    <div class="profileUPdateInput">
                        <div class="profilePart">
                            <h4>새 비밀번호</h4>
                        </div>
                        <input type="text" placeholder="영문 대소문자/숫자/특수기호 모두 포함, 8글자 이상" class="inputCss">
                    </div>
                    <hr width="1050px" color="#eee" />
                    <div class="profileUPdateInput">
                        <div class="profilePart">
                            <h4>새 비밀번호 확인</h4>
                        </div>
                        <input type="text" placeholder="" class="inputCss">
                    </div> -->
                    <hr width="1050px" color="#eee" />
                    <div class="profileUPdateInput">
                        <div class="profilePart">
                            <h4>닉네임</h4>
                        </div>
                        <input id="nicknameInput" name="myPageNickname" type="text" placeholder="<%=mypageMember.getNickName() %>" class="inputCss nicknameCount">
                        <!-- <button class="checkDB">중복확인</button> -->
                        <span class="nicknameDuplSpan"></span>
                    </div>
                    <hr width="1050px" color="#eee" />
                    <div class="profileUPdateInput">
                        <div class="profilePart">
                            <h4>상점소개글</h4>
                        </div>
                        <input type="text" placeholder="<%=shoppagemember.getIntroduce() %>" class="inputCss" name="myPageIntroduce">
                    </div>
                <hr width="1050px" color="#313030" noshade style="margin-bottom: 20px;" />
                <div class="profileButton btnEndMargin">
                    <button type="submit" class="profileUpdate" onclick="fn_updateUser();">정보 수정</button>
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
const fn_updateUser=()=>{
	$("#updateUserFrm").attr("action","<%=request.getContextPath()%>/member/updateEndMemeber.do").submit();

}
</script>
<script src="<%=request.getContextPath()%>/js/mypage/myPageUpdate.js"></script>
<%@ include file="/views/common/footer.jsp"%>