<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="/vegetable_stocker/css/###.css" />
</head>
<body>
	<h3>【冷蔵庫】</h3>
	<table border="1">
		<tr>
			<th>野菜名</th>
			<th>登録日</th>
			<th>大きさ</th>
			<th>個数</th>
		</tr>
		<c:forEach var="fre" items="${fre}">
			<tr>
				<td>${fre.veg_name}</td>
				<td>${fre.veg_date}</td>
				<td>${fre.veg_level}</td>
				<td>${fre.veg_count}</td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>