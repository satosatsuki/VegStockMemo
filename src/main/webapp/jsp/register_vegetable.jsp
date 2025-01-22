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
	<h1>おやさい登録</h1>
	<form action="/vegetable_stocker/regster_veg" method="post">
	<h2><input type="hidden" name="loginId" value="${user.userName}">${user.userName}さんの新規野菜登録</h2>
    
    <table>
                <!-- テーブル選択用のセレクトボックス -->
                <th><label for="tableName">登録先</label></th>
                <td><select name="tableName" id="tableName">
                    <option value="refrigerator">冷蔵庫</option>
                    <option value="freezer">冷凍庫</option>
                </select></td>
        </tr>
        			<tr><th>日付</th>
			<td><input type="date" name="veg_date"></td>
			</tr>
			
			<tr><th>おやさい</th>
			<td><input type="text" name="veg_name"></td>
			</tr>
			
			<tr><th>おやさいの大きさ</th>
			<td>
			
			<select name="veg_level">
			  <option value="1">１</option>
			  <option value="1/2">１/２</option>
			  <option value="1/3">１/３</option>
			</select>
						
			</td>
			</tr>
			
			<tr>
			<th>個数</th>
			<td>
			<label><br>
			<select name="veg_count">
			  <option value="1">１</option>
			  <option value="2">２</option>
			  <option value="3">３</option>
			  <option value="4">４</option>
			  <option value="5">５</option>
			  <option value="6">６</option>
			  <option value="7">７</option>
			  <option value="8">８</option>
			  <option value="9">９</option>
			  <option value="10">１０</option>
			 	</select>
			
			
			</td>
			</tr>
    </table>
    <p><input type="submit" value="登録"></p>
	</form>	
	</body>
</html>