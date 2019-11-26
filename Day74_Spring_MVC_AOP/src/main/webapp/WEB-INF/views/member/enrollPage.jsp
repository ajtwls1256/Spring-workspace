<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Bae!!!!프로젝트 회원가입</h1>
	<hr>
	
	<form action="/enroll.do" method="post">
		ID : <input type="text" name="memberId" id="memberId">
		<button type="button" id="btn">중복검사</button>
		<span id="chkId"></span>
		<br>
		PW : <input type="password" name="memberPw"><br>
		NAME : <input type="text" name="memberName"><br>
		ADDR : <input type="text" name="memberAddr"><br>
		<input type="submit" value="회원가입">
	</form>
	<script>
		$('#btn').click(function(){
			var id = $("#memberId").val();
			$.ajax({
				url : "/checkId.do",
				data : {id:id},
				type:"get",
				dataType:"json",
				success:function(data){
					
					if(data.result == 1){
						$("#chkId").html('사용가능한 아이디');	
					}else{
						$("#chkId").html('이미 사용중인 아이디');
					}
					
				},
				error:function(){
					console.log("아이디 체크 ajax 실패");
				}
			});
		});
	</script>
	
</body>
</html>