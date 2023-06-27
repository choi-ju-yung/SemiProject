<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.semi.member.model.vo.Member"%>
<%
List<Member> members = (List) request.getAttribute("members");

%>

 <link rel="stylesheet" href="<%=request.getContextPath()%>/css/admin/manageMember.css" />
<%@ include file="/views/admin/manageMemberHome.jsp"%>



<section class="info">
	
	<div class="userTable">
		<table class="table text-center">
			<thead>
				<tr>
					<th colspan="1">
					<th>이메일</th>
					<th>아이디</th>
					<th>이름</th>
					<th>별명</th>
					<th>신고누적수</th>
					<th>가입일</th>
					<th>온도</th>
					<th>수정/삭제</th>
				</tr>
			</thead>
			<tbody>
				<%
				if (members.isEmpty()) {
				%>
				<tr>
					<td colspan="7">조회된 회원이 없습니다.</td>
					<%
					} else {
					for (Member m : members) {
					%>
				
				<tr>
					<td>
						<input type="checkbox" name="option" />
					</td>
					<td><%=m.getEmail()%></td>
					<td><%=m.getUserId()%></td>
					<td><%=m.getUserName()%></td>
					<td><%=m.getNickName()%></td>
					<td><%=m.getDeclareCount()%></td>
					<td><%=m.getEnrollDate()%></td>
					<td><%=m.getTemperature()%></td>
					<td><button id="<%=m.getUserId() %>" type="button" class="updateBtn btn btn-primary btn-sm">수정</button>
						<button type="button" class="btn btn-danger btn-sm"
							onclick="location.replace('<%=request.getContextPath()%>/userRemove.do?email=<%=m.getEmail()%>');">삭제</button></td>	
				</tr>
				<%
					}
				}
				%>
			</tbody>
		</table>
		<div id="pageBar" class="text-center">
			<%=request.getAttribute("pageBar")%>
		</div>
		<button id="userRemoveAll" type="button" class="btn btn-danger">모든회원삭제</button>
		
	</div>
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
	<script>
	
	$().ready(function () {
        $("#userRemoveAll").click(function () {
            Swal.fire({
                title: '정말로 모든회원을 삭제하시겠습니까?',
                text: "회원을 다시 되돌릴 수 없습니다. 신중히 선택하세요.",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: '승인',
                cancelButtonText: '취소'
            }).then((result) => {
               if (result.isConfirmed) {
                    location.replace("/semi-hifive/allUserRemove.do");
               }
				
            })
        });
    });
	
	$(".updateBtn").click(e=>{
		const userId = $(e.target)[0].id;
		var width = '600';
		var height = '700';
		let left = Math.ceil((window.screen.width - width) / 2);
		let top = Math.ceil((window.screen.height - height) / 2);
		/* 마이페이지 memberdao */
		open("<%=request.getContextPath()%>/userUpdate.do?userId=" + userId, "_blank", 'width=' + width + ', height=' + height + ', left=' + left + ', top = ' + top);
	}
	)
	
	/* function updateUser(){	
		console.log(e);
		$.ajax({
			url: "/userUpdate.do",
			data: { "userId": 
					""
			},
			success: function(result) {
	
			
			},
			error: function() {
				console.log("카테고리 선택 오류발생");
			}
		})
	} */
	
	
	</script>

</section>