<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録野菜の削除</title>
<form action="/vegetable_stocker/deleteVegetableServlet" method="post">
	<p>
		<input type="hidden" name="loginId" value="${user.userName}">${user.userName}さんの登録野菜の削除</p>
</head>
<body>
	<table id="refrigerator" border="1">
		<thead>
			<tr>
				<th>日付</th>
				<th>おやさい</th>
				<th>大きさ</th>
				<th>個数</th>
			</tr>
		</thead>
		<tbody>
			<%-- サーバー側でデータをループして表示 --%>
			<c:forEach var="ref" items="${refs}">
				<tr data-id="${loginid}">
					<td>${ref.veg_name}</td>
					<td>${ref.veg_date}</td>
					<td>${ref.veg_level}</td>
					<td>${ref.veg_count}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<table id="freezer" border="1">
		<thead>
			<tr>
				<th>日付</th>
				<th>おやさい</th>
				<th>大きさ</th>
				<th>個数</th>
			</tr>
		</thead>
		<tbody>
			<%-- サーバー側でデータをループして表示 --%>
			<c:forEach var="fre" items="${fre}">
				<tr data-id="${loginid}">
					<td>${fre.veg_date}</td>
					<td>${fre.veg_name}</td>
					<td>${fre.veg_level}</td>
					<td>${fre.veg_count}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>
		<input type="submit" value="削除">
	</p>

</body>
</html>