<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Bae!!!!프로젝트 회원가입</h1>
	<hr>
	<form action="/enroll.do" method="post">
		ID : <input type="text" name="memberId"><br>
		PW : <input type="password" name="memberPw"><br>
		NAME : <input type="text" name="memberName"><br>
		ADDR : <input type="text" name="memberAddr"><br>
		<input type="submit" value="회원가입">
	</form>
	
</body>
</html>