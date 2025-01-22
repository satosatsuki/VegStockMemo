<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録野菜変更確認</title>
<link rel="stylesheet" type="text/css"
	href="/vegetable_stocker/css/style.css" />

</head>
<h1>登録野菜確認</h1>

<h2>こちらの内容でよろしいでしょうか！</h2>
<form action="/vegetable_stocker/FreecomfirmServlet" method="post">
	<table border="1">
		<tr>
			<th>保存場所</th>
			<td>${user.userName}さんの冷凍庫</td>
		</tr>

		<tr>
			<th>野菜</th>
			<td><input type="hidden" name="veg_name" value="${fre.veg_name}">${fre.veg_name}</td>
			<!-- ここパクった -->
		</tr>

		<tr>
			<th>登録日時</th>
			<td><input type="hidden" name="veg_date" value="${fre.veg_date}">${fre.veg_date}</td>
		</tr>

		<tr>
			<th>大きさ</th>
			<td><input type="hidden" name="veg_level"
				value="${fre.veg_level}">${fre.veg_level}</td>
		<tr>
		<tr>
			<th>個数</th>
			<td><input type="hidden" name="veg_count"
				value="${fre.veg_count}">${fre.veg_count}</td>
		<tr>
	</table>

	<input type="submit" value="登録">








	<p>
		<a href="/vegetable_stocker/jsp/vegetable_.jsp">←登録変更に戻る</a>
	</p>

	<body>

	</body>
</html>