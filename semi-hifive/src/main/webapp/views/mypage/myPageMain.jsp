<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<%@ include file="/views/mypage/myPageCategory.jsp" %>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/mypage/myPageMain.css" />
<%
	Member mypageMember = (Member)request.getAttribute("mypageMember");
%>
<!-- section -->

        <!-- 오른쪽 section -->
        <div class="myPageMainAll">
            <div class="profileMain">
                <div class="profileInfo">
                    <img src="./img/프로필사진.png" alt=""
                        style="width: 130px; height: 130px; border-radius: 300px; margin-left: 90px; border: #f2f2f2 1px solid;">
                    <div class="nameNdate">
                        <div class="profileName">
                            <h1><%=mypageMember.getNickName() %> 님</h1>
                            <div class="temperature">
                                <h4><%=mypageMember.getTemperature() %> ℃</h4>
                            </div>
                        </div>
                        <div class="enrollDate">
                            <h4>가입일</h4>
                            <span><%=mypageMember.getEnrollDate() %></span>
                        </div>
                    </div>
                </div>
                <div class="countTrade">
                    <h3>성사된 거래</h3>
                    <div class="countTradeInfo">
                        <span>10</span>
                        <h4>건</h4>
                    </div>
                </div>
            </div>
            <div class="notificationMain">
                <h3>알림</h3>
                <hr width="1050px" color="#313030" noshade style="margin-top: 15px;" />
                <div class="notificationAll">
                    <div class="notification">
                        <a href=""><span>‘상품명을 작성해주세요.’ 글에 새 댓글이 등록되었습니다.</span></a>
                        <span class="notiDate">2023.05.11 AM 02 : 30</span>
                    </div>
                    <hr width="1050px" color="#eee" />
                    <div class="notification">
                        <a href=""><span>‘연락주세요’ 댓글에 새 댓글이 등록되었습니다.</span></a>
                        <span class="notiDate">2023.05.11 AM 02 : 30</span>
                    </div>
                    <hr width="1050px" color="#eee" />
                    <div class="notification">
                        <a href=""><span>관심상품 ‘상품명을 작성해주세요.’ 정보가 수정되었습니다.</span></a>
                        <span class="notiDate">2023.05.11 AM 02 : 30</span>
                    </div>
                    <hr width="1050px" color="#eee" />
                    <div class="notification">
                        <a href="" class="notiRead"><span>‘상품명을 작성해주세요.’ 글에 새 댓글이 등록되었습니다.</span></a>
                        <span class="notiDate">2023.05.11 AM 02 : 30</span>
                    </div>
                    <hr width="1050px" color="#eee" />
                    <div class="notification">
                        <a href="" class="notiRead"><span>‘상품명을 작성해주세요.’ 글에 새 댓글이 등록되었습니다.</span></a>
                        <span class="notiDate">2023.05.11 AM 02 : 30</span>
                    </div>
                </div>
                <hr width="1050px" color="#313030" noshade style="margin-bottom: 50px;" />
            </div>

        </div>
</section>
<%@ include file="/views/common/footer.jsp" %>