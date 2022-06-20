<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
   
    

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/mysite4/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="/mysite4/assets/css/guestbook.css" rel="stylesheet" type="text/css">

</head>
<body>
	
	<form action="./add" method= "get">
		<table border="1" width="500">
			<tr>
				<td>이름</td><td><input type="text" name="name"></td>
				<td>비밀번호</td><td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan=4><textarea name="content" cols=60 rows=5></textarea></td>
			</tr>
			<tr>
				<td colspan=4 align=right><button type="submit">등록</button></td>
			</tr>
		</table>
	</form>
	<br/>
	
	<c:forEach items="${gList}" var="guestVo" varStatus ="status">
		<table width=510 border=1>
				<tr>
					<td>${guestVo.no}</td>
					<td>${guestVo.name}</td>
					<td>${guestVo.regDate}</td>
					<td><a href="./deleteForm?no=${guestVo.no}">삭제</a></td>
				</tr>
				<tr>
					<td colspan=4>${guestVo.content}</td>
				</tr>
			</table>
		    <br/>
	</c:forEach>
	
</body>
</html>