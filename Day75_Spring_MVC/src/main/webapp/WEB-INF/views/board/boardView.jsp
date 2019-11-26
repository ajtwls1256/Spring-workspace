<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

	<style>
	h2{
		text-align: center;
	}
	
	body *{
		margin: 0 auto;
	}
	
	
	</style>
</head>
<body>
	<h2>자유게시판</h2>
	<br>
	<table border="1px">
		<tr>
			<th>제목</th>
			<td>${board.boardTitle }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${board.boardWriter }</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${board.boardDate }</td>
		</tr>
		<tr>
			<th>글내용</th>
			<td>${board.boardContent }</td>
		</tr>
	</table>
	<br>
	<center><input type="button" onclick="location.href='boardList.do?reqPage=${reqPage}'" value="목록으로 가기"></center>
</body>
</html>