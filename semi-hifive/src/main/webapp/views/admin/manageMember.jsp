<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.semi.member.model.vo.Member"%>
<%
	List<Member> members = (List) request.getAttribute("members");
%>    
<style>
body {
  padding:1.5em;
  background: #f5f5f5
}

table {
  border: 1px #a39485 solid;
  font-size: .9em;
  box-shadow: 0 2px 5px rgba(0,0,0,.25);
  width: 100%;
  border-collapse: collapse;
  border-radius: 5px;
  overflow: hidden;
}

th {
  text-align: left;
}
  
thead {
  font-weight: bold;
  color: #fff;
  background: #73685d;
}
  
 td, th {
  padding: 1em .5em;
  vertical-align: middle;
}
  
 td {
  border-bottom: 1px solid rgba(0,0,0,.1);
  background: #fff;
}

a {
  color: #73685d;
}
  
 @media all and (max-width: 768px) {
    
  table, thead, tbody, th, td, tr {
    display: block;
  }
  
  th {
    text-align: right;
  }
  
  table {
    position: relative; 
    padding-bottom: 0;
    border: none;
    box-shadow: 0 0 10px rgba(0,0,0,.2);
  }
  
  thead {
    float: left;
    white-space: nowrap;
  }
  
  tbody {
    overflow-x: auto;
    overflow-y: hidden;
    position: relative;
    white-space: nowrap;
  }
  
  tr {
    display: inline-block;
    vertical-align: top;
  }
  
  th {
    border-bottom: 1px solid #a39485;
  }
  
  td {
    border-bottom: 1px solid #e5e5e5;
  }
</style>

    <table id="tbl-member">
		<thead>
			<tr>
				<th>이메일</th>
				<th>아이디</th>
				<th>이름</th>
				<th>별명</th>
				<th>신고누적수</th>
				<th>가입일</th>
				<th>온도</th>
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
				<td><%=m.getEmail()%></td>
				<td><%=m.getUserId()%></td>
				<td><%=m.getUserName()%></td>
				<td><%=m.getNickName()%></td>
				<td><%=m.getDeclareCount()%></td>
				<td><%=m.getEnrollDate()%></td>
				<td><%=m.getTemperature()%></td>
			</tr>
			<%
			}
			}
			%>
		</tbody>
	</table>
	<div id="pageBar">
		<%=request.getAttribute("pageBar")%>
	</div>