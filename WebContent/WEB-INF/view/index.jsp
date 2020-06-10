<%@page import="java.util.ArrayList"%>
<%@page import="Bean.bean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>掲示板</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/kognise/water.css@latest/dist/dark.min.css">
</head>
<body>
	<a href="/keijibankadai/kanri" class="button">管理画面</a>

	<form method="POST" enctype="multipart/form-data" action="/keijibankadai/UploadServlet2">
		<input type="text" name="id">
		<input type="file" name="file"/><br />
		<input type="submit" value="アップロード" />
	</form>

	<form action="/keijibankadai/toukou2" method="post">
		投稿者名<br>
		<input type="text" name="toukouname"><br>
		mailアドレス<br>
		<input type="email" name="mail"><br>
		内容<br>
		<textarea name="naiyou" cols="30" rows="7"></textarea><br>
		<input type="submit" value="投稿">
	</form>

	<table  border="1">


	<%

	ArrayList<bean> List = (ArrayList<bean>)request.getAttribute("list");
	if(List != null){
	for(int i = 0 ; i < List.size() ; i++){
		bean toukou = List.get(i);
	%>
	<tr>
			<td><%=toukou.getNumber() %>:<%=toukou.getNaiyou() %><br><img src="./upload/" alt="画像"><br>投稿者:<%=toukou.getName() %>　投稿時間:<%=toukou.getTime() %>　編集時間:<%=toukou.getTime2() %></td>

		</tr>
	<%
	}
	}
	%>
	</table>


</body>
</html>



