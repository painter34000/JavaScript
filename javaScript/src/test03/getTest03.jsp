<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.yedam.board.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		//java 문법을 쓸수 있도록 함
		String bNo = request.getParameter("boardno");
		BoardDAO dao = new BoardDAO();
		Board b = dao.getBoardInfo(Integer.parseInt(bNo));

		out.print("<a href =\"getBoardList.html\">List</a>");
	%>
	<table border="1">
		<tr>
			<td>Board_NO</td>
			<td><%=bNo%></td>
		</tr>
		<tr>
			<td>Content</td>
			<td><%=b.getContent()%></td>
		</tr>
		<tr>
			<td>Writer</td>
			<td><%=b.getWriter()%></td>
		</tr>
		<tr>
			<td>CreateDate</td>
			<td><%=b.getCreateDate()%></td>
		</tr>




	</table>
	<h1>
		<a href="getBoardList.html"> Board List</a>
	</h1>
	<table border=1>
</body>
</html>