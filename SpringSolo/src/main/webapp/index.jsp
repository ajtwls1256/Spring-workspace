<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/index.css'/>" />
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body class="login">
    <div class="l-container">
        <div class="l-header">
            <h1>LOGIN</h1>
            <h1>'${check }'</h1>
        </div>
	    <div class="l-body">
            <form action="login.do" method="post">
                <p>아이디</p>
                <input type="text" placeholder="아이디를 입력해주세요." name="memberId">
                <br>
                <p>비밀번호</p>
                <input type="password" placeholder="비밀번호를 입력해주세요." name="memberPw">
                <br>
                <div class="l-body-button">
                    <input type="submit" value="로그인">
                    <input type="button" value="회원가입"> 
                </div>
            </form>
        </div>
        <div class="l-footer">
            
        </div>
	</div>
	
	
	<script>
	
	$(function(){
		
		alert("왜안떠");
		alert('${check}');
		
		
		
		
	});
	
	</script>

	
	
</body>







</html>