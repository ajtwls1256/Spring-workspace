<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>MyPage</h1>
	<form action="/update.do" method="post">
	NO : <input type="text" name="memberNo" readonly value="${member.memberNo }"><br>
	ID : <input type="text" name="memberId" readonly value="${member.memberId }"><br>
	PW : <input type="password" name="memberPw" value="${member.memberPw }"><br>
	NAME : <input type="text" name="memberName" value="${member.memberName }"><br>
	ADDR : <input type="text" name="memberAddr" value="${member.memberAddr }"><br>
	<input type="submit" value="정보수정">
	</form>
</body>
</html>