<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function join(){
		location.href="/security/user/join.do";
	}
</script>
</head>
<body>
	<h2>로그인하세요</h2>
	<span style="color:red;">${message}</span>
	<form method="post" action="/security/user/login_check.do">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
				<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="userid"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="passwd"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="로그인">
					<button type="button" onclick="join()">회원가입</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
<!-- 		security -->