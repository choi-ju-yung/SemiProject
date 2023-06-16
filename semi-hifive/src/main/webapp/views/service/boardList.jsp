<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.semi.sc.model.dto.Board" %>
<%@ include file="/views/common/header.jsp" %>
<!-- 게시글 스타일 적용 -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/service/boardList.css">
<%
	List<Board> boardList=(List)request.getAttribute("boardLsit");
	System.out.println(boardList);
	char notice='Y';
	if(boardList!=null&&boardList.get(0).getNoticeYn()=='N') notice='N';
%>
<section>
	<%@ include file="/views/service/serviceCategory.jsp" %>
	<div class="ServiceCenter">
      <h2 class="ServicetHead">공지사항</h2>
      <% if(loginMember!=null&&loginMember.getUserId().equals("admin")){ %>
      <button class="contentBtn" onclick="location.href='<%=request.getContextPath()%>'">글 작성</button>
      <% } %>
      <% if(notice=='N'){ %>
      	<div class="QACategory">
          <button class="QABtn">회원정보</button>
          <button class="QABtn">구매</button>
          <button class="QABtn">판매</button>
          <button class="QABtn">그 외</button>
        </div>
      <% } %>
      <div class="boardContainer">
        <table>
        <% if(boardList!=null){ %>
	        <% for(Board b:boardList){ %>
		        <% if(notice=='Y'){ %>
					<tr onclick="location.href='<%=request.getContextPath()%>/service/boardContent.do?boardNo='">
						<td><%=b.getBoardNo() %></td>
						<td class="noticeTitle"><%=b.getBoardTitle() %></td>
						<td><%=b.getBoardDate() %></td>
					</tr>
					<tr class="tableLine">
						<td colspan="3"></td>
					</tr>
					<% }else{ %>
					<tr onclick="location.href='<%=request.getContextPath()%>/service/boardContent.do?boardNo='">
						<td><%=b.getBoardNo() %></td>
						<td class="QATitle">[<%=b.getBoardCategory() %>]<%=b.getBoardTitle() %></td>
					</tr>
					<tr class="tableLine">
						<td colspan="3"></td>
					</tr>
				<% }%>
			<% } %>
		<% }else{ %>
		<tr><td>조회된 데이터가 없습니다.</td></tr>
		<% } %>
        </table>
        <div class="pageBar">
         	<%=request.getAttribute("pageBar") %>
        </div>
      </div>
    </div>
</section>
<%@ include file="/views/common/footer.jsp" %>