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
		<h1>やさい登録変更</h1>
		
		<form action="/vegetable_stocker/###" method="post">
		
		<table>
		<!-- DBを選ぶ -->
		<tr>
		<th>▼選んでください 冷蔵庫or 冷凍庫</th>
		<td><input type="button" name="ここにDB情報持ってくる？"></td>
		</tr>
		<!-- DBから取得したお野菜を選ぶセレクトボックス -->
		<tr>
		<th>変えたいおやさいを選んでください</th>
		<td><select name="vag_name">
			  <option value="###">###</option>
			  <option value="###">###</option>
			  <option value="###">###</option>
			  </select></td>
			  </tr>
		<!-- 変更内容の登録 -->
		<tr>
		<th>登録日</th>
		<td><input type="date" name="date"></td>
		</tr>
		
		<tr>
		<th>おやさい</th>
		<td><input type="text" name="vag_name"></td>
		</tr>
		
		<tr><th>おやさいの大きさ</th>
			<td>
			<select name="vag_level">
			  <option value="1">１</option>
			  <option value="1/2">１/２</option>
			  <option value="1/3">１/３</option>
			</select>
		</td>
		</tr>
		
		
		</table>
		</form>
		<input type="submit" value="登録">
		
		<!-- 登録内容を指定して、登録確認画面に行く -->
		
	</body>
</html>