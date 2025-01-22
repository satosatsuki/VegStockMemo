<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>冷蔵庫野菜チェッカー</title>
		<link rel="stylesheet" type="text/css" href="/vegetable_stocker/css/style.css"/>
	</head>
	
	<body>
		<h1>冷蔵庫野菜チェッカー</h1>
		<h2>ログイン画面</h2>
	
	<!-- バリデーションエラーメッセージの表示 -->
		<c:if test="${not empty errorMsgList}">
			<div style="color:red;">
				<c:forEach var="msg" items="${errorMsgList}">
					<p>${msg}</p>
				</c:forEach>
			</div>
		</c:if>
		
		<!-- ログイン失敗時のエラーメッセージの表示 -->
		<c:if test="${not empty loginError}">
			<div style="color:red;">
				<p>${loginError}</p>
			</div>
		</c:if>
		
	<form action="/vegetable_stocker/login" method="post">
	
		<table>
			<tr><th>ログインID</th>
			<td><input type="text" name="loginid"></td>
			</tr>
		
			<tr><th>パスワード</th>
			<td><input type="password" name="password"></td>
			</tr>
		</table>
		
		<input type="submit" value="ログイン">
	</form>
		
	<!-- 新規会員登録リンクを追加 -->
	<p>
		<a href="/vegetable_stocker/jsp/register.jsp">新規会員登録はこちら！</a>
	</p>
	
	</body>
</html>