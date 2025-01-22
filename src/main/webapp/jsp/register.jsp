<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>新規会員登録</title>
		<link rel="stylesheet" type="text/css" href="/vegetable_stocker/css/style.css"/>
		</head>
		
	<body>
	${errorMsg}
	<h1>新規会員登録</h1>
	<p>下記のフォームより、ユーザー情報をご登録ください</p>
	<c:if test="${errorMsg.size() > 0 }">
	<ul>
	<c:forEach var="msg" items="${erroerMsg}">
	<li style="coler: red;">${msg}</li>
	</c:forEach>
	</ul>
	</c:if>
	
	<h2>会員登録フォーム</h2>
	<form action="/vegetable_stocker/register" method="post">
	<table border="1">
	<tr>
	<th>ユーザーID</th>
	<td><input type="text" name="loginid" placeholder="4～50文字"></td>
	</tr>
	
	<tr>
	<th>パスワード</th>
	<td><input type="text" name="password" placeholder="8～50文字"></td>
	</tr>
	
	<tr>
	<th>お名前</th>
	<td><input type="text" name="name" placeholder="2～50文字"></td>
	</tr>
	
	</table>
	
	<input type="submit" value="登録">
	
	</form>
	</body>
</html>