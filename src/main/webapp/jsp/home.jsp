<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="domain.user"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ホーム画面</title>
<link rel="stylesheet" type="text/css"
	href="/vegetable_stocker/css/style.css" />
</head>
<body>
	<h1>ホーム画面</h1>
	<h2>おやさい一覧</h2>
	<p>ようこそ、${user.userName}さん、今の冷蔵庫・冷凍庫はこんな感じになっています～</p>
	<%--<% user u = (user)session.getAttribute("username"); out.println(u.getUserName()) %> --%>
	<%-- <p>ようこそ、<%= session.getAttribute("user").getUserName() %>さん、今の冷蔵庫・冷凍庫はこんな感じになっています～</p> --%>

	<!-- 冷蔵庫内容参照 -->
	<%@ include file="/jsp/refrigerator_table.jsp"%>

	<!-- 冷凍庫内容参照 -->
	<%@ include file="/jsp/freezer_table.jsp"%>


	<p>
		<a href="/vegetable_stocker/jsp/register_vegetable.jsp">おやさいの新規登録</a>
	</p>

	<p>
		<a href="/vegetable_stocker/jsp/###.jsp">【工事中】おやさいの削除</a>
	</p>


	<p>
		<a href="/vegetable_stocker/jsp/###.jsp">【工事中】おやさいの編集</a>
	</p>

	<p>
		<a href="/vegetable_stocker/jsp/logout.jsp">ログアウト</a>
	</p>

</body>
</html>