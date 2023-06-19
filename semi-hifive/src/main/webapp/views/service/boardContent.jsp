<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.semi.sc.model.dto.*, java.util.List" %>
<%@ include file="/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/service/boardContent.css">
<section>
<%@ include file="/views/service/serviceCategory.jsp" %>
<%
	Board b=(Board)request.getAttribute("board"); //게시판 객체
	List<BoardComment> comments=(List)request.getAttribute("comments");
%>
	<div class="ServiceCenter">
		<div class="boardContent">
			<div class="contentTitle">
				<%if(b.getNoticeYn()=='Y'){ %>
				<h2><%=b.getBoardTitle() %></h2>
				<%}else{ %>
				<h2>[<%=b.getBoardCategory() %>]<%=b.getBoardTitle() %></h2>
				<%} %>
				<button class="backBtn"
					onclick="history.back();">뒤로 가기</button>
			</div>
			<div class="content">
                <input type="hidden" name="boardNo" value="boardNo">
				<div class="contentTop">
                     <p>작성자 : <%=b.getBoardWriter() %></p>
                     <p><%=b.getBoardDate() %></p>
                </div>
				<p><%=b.getBoardContent() %></p>
				<p></p>
				<img
					src="https://mblogthumb-phinf.pstatic.net/MjAyMjA2MTBfMjM3/MDAxNjU0ODM2MTEzODc5.rStmvGhTIUIZ_eshzIy-2Dv3hbMDgU5xMEgBe_8hxkEg.JLYYhiefyMgFUHAM0J3x5qlmGhxjaRgEBCVDWboxHKsg.PNG.papapapower/Desktop_Screenshot_2022.06.10_-_13.36.22.51.png?type=w800"
					alt="">
				
			</div>
			<%if(b.getNoticeYn()=='Y'&&loginMember!=null){ %>
				<div class="commentWrite">
					<textarea name="boardComment" class="boardComment" cols="120" rows="5"
						placeholder="댓글을 작성하세요."></textarea>
					<button class="commentBtn">댓글 작성</button>
				</div>
			<%} %>
				<div class="comment">
			<%if(comments!=null){
				for(BoardComment bc:comments){
					if(bc.getCommentNoFK()==0){%>
					<div class="commentTop">
						<input type="hidden" value="0" class="commentFK">
						<h4><%=bc.getCommentWriter() %></h4>
						<p><%=bc.getCommentDate() %></p>
					</div>
					<div class="commentContent">
						<p>
							<%=bc.getCommentContent() %>
						</p>
						<button class="recommentBtn">댓글</button>
					</div>
					<%if(loginMember!=null&&(bc.getCommentWriter().equals(loginMember.getUserId())
						||loginMember.getAuth().equals("M"))){ %>
						<div class="commentUpdate">
							<a href="">수정</a> <a href="">삭제</a>
						</div>
					<%}%>
					<hr>
				<%}%>
					<div class="recomment">
					<%for(BoardComment brc:comments){
						if(bc.getCommentNo()==brc.getCommentNoFK()){%>
					<input type="hidden" value="<%=brc.getCommentNoFK() %>" class="commentFK">
						<div class="commentTop">
							<h4><%=brc.getCommentWriter() %></h4>
							<p><%=brc.getCommentDate() %></p>
						</div>
						<div class="commentContent">
							<p><%=brc.getCommentContent() %></p>
						</div>
						<%if(loginMember!=null&&(brc.getCommentWriter().equals(loginMember.getUserId())
								||loginMember.getAuth().equals("M"))){ %>
							<div class="commentUpdate">
								<a href="">수정</a> <a href="">삭제</a>
							</div>
						<%} %>
						<hr>
						<%}
					}%>
						<%if(loginMember!=null){ %>
						<div class="commentWrite">
							<textarea name="recomment" class="boardComment" cols="120" rows="5"
								placeholder="댓글을 작성하세요."></textarea>
							<button class="commentBtn">댓글 작성</button>
						</div>
					<%}%>
					</div>
			<%} //for문
			}%>
				</div>
		</div>
	</div>
</section>
<script src="<%=request.getContextPath()%>/js/service/boardContent.js"></script>
<script>
	$(".commentBtn").click(e=>{
		const comment=$(e.target).parent().find("textarea");
		$.ajax({
			url : "<%=request.getContextPath()%>/service/commentInsert.do",
			data : {
				"writer" : "<%=loginMember!=null?loginMember.getUserId():""%>",
				"boardNo":<%=b.getBoardNo()%>,
				"commentContent":comment.val(),
				/* "commentFK":$(e.target).closest("input.commentFK").val() */
			},
			type : "post",
			success : function(result) {
				if (result == "success") {
					console.log(data.commentFK)
					alert("등록성공");
				}
				comment.val(''); //댓글 등록시 댓글 등록창 초기화
				getReplyComment(); //등록후 댓글 목록 불러오기 함수 실행
			},
			error : function() {
				alert("등록 실패");

			}
		})
	});
	
	function getReplyComment(){ //댓글 등록 성공 후 실행할 함수
		
	}
</script>
<%@ include file="/views/common/footer.jsp" %>