<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <style>
    h2{
    	text-align : center;
    }
     
    table{
    	margin: 0 auto;
    }
     
	#pageNavi{
	     text-align : center;
	     width : 80%;
	     margin : 0 auto;
	}
	#pageNavi>*{
	     margin : 10px;
	}
    </style>
</head>
<body>
	<h2>자유게시판</h2>
	<table border="1px">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
		
		<c:if test="${empty pd}">
			<p>넘어오는값없음</p>
		</c:if>
	
		<c:if test="${not empty pd }">
		<c:forEach items="${pd.list }" var="list" varStatus="i">
		<tr onclick="location.href='boardView.do?boardNo=${list.boardNo}&reqPage=${reqPage }'">
			<td>${(reqPage - 1)*5 + i.count}</td>
			<td>${list.boardTitle }</td>
			<td>${list.boardWriter }</td>
			<td>${list.boardDate }</td>
		</tr>
		</c:forEach>
		</c:if>
	</table>
	
	<div id="pageNavi">${pd.pageNavi }</div>
	<div><center><input type="button" value="글쓰기" onclick="location.href=''"></center></div>
	
	
</body>
</html>