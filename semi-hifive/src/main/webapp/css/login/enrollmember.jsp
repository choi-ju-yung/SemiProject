<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/views/common/header.jsp"%>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/member/enrollmember.css" />

<!--<form action="" class="container"> -->
	<form action="<%=request.getContextPath()%>/enrollMemberEnd.do" class="container" method="post"> 
        <br>
        <div class="memberinfo">
            <br>
            <!-- 회원 정보 -->
            <h2>회원정보를 입력해주세요</h2>
            <br>
        </div>


        <!-- 회원 정보 -->
        <div class="MemberInfo_box">


            <!-- 이메일 주소 -->
            <div class="email">
                <input type="email" placeholder="이메일 주소" name="email" required>
                &nbsp;
                &nbsp;
                
                <div>
                  <input type="button" onclick="fn_emailAuth();" value="이메일 인증">
                 </div>
            </div>

            <!-- 아이디  -->
            <div class="id">
                <input type="text" placeholder="아이디" name="userId" required>
                &nbsp;
                &nbsp;
                
              <div>
                <input type="button" onclick="fn_duplicatedId();" value="증복확인">
              </div>
            </div>

            <!-- 비밀번호 -->
            <div>
                <input type="password" placeholder="비밀번호" name="password" required>
            </div>

            <!-- 비밀번호 확인 -->
            <div>
                <input type="password" placeholder="비밀번호 확인" required>
            </div>

            <!-- 이름 -->
            <div>
                <input type="text" placeholder="이름" name="userName" required >
            </div>

            <!-- 닉네임 -->
            <div>
                <input type="text" placeholder="닉네임" name="nickName" required>
            </div>

            <div>
                <!-- 회원가입 -->
                <button>회원가입</button>
            </div>

        </div>

                <!-- 이용약관 -->
              <!-- <div>
                  <h2>약관 동의</h2>
              </div> -->
      
              <!-- terms and conditions -->
              <div class="TandC">
                  <!-- 전체 동의 -->
                  <div style="border-bottom: 1px solid gray;">
                      <span>전체 동의</span>
                      <input type="checkbox" name="selectall" onclick='selectAll(this)'>
                  </div>
      
                  <!-- 필수 1 -->
                  <div>
                      <span><strong>(필수)</strong> 이용 약관에 동의 <button onclick="fn_viewDetail1();">상세 보기</button></span>
                      <input type="checkbox" name="agree" onclick='checkSelectAll()' required>
                  </div>
      
                  <!-- 필수 2 -->
                  <div>
                      <span><strong>(필수)</strong> 개인정보 수집 및 이용에 동의 <button onclick="fn_viewDetail2();">상세 보기</button></span>
                      <input type="checkbox" name="agree" onclick='checkSelectAll()' required>
                  </div>
      
                  <!-- 선택 1 -->
                  <div>
                      <span>(선택) 마케팅 정보 수신 동의 - 이메일 <button onclick="fn_viewDetail3();">상세 보기</button></span>
                      <input type="checkbox" name="agree" onclick='checkSelectAll()'>
                  </div>
      
                  <!-- 선택 2 -->
                  <div>
                      <span>(선택) 마케팅 정보 수신 동의 - SMS/MMS <button onclick="fn_viewDetail14();">상세 보기</button></span>
                      <input type="checkbox" name="agree" onclick='checkSelectAll()'>
                  </div>
              </div>
    </form>

<script src="<%=request.getContextPath() %>/js/member/enrollmember.js"></script>
<%@ include file="/views/common/footer.jsp"%>
    
