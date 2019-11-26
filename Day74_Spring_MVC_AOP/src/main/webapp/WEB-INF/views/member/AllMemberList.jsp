<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 정보</h1>
	<hr>
	<table>
		<tr>
			<th>번호</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>주소</th>
			<th>가입일</th>
		</tr>
		<c:forEach items="${list }" var="m" varStatus="i">
		<tr>
			<td>${i.count }</td>
			<td>${m.memberId }</td>
			<td>${m.memberPw }</td>
			<td>${m.memberName }</td>
			<td>${m.memberAddr }</td>
			<td>${m.regDate }</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>