<%@page import="java.util.ArrayList"%>
<%@page import="Bean.bean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/kognise/water.css@latest/dist/dark.min.css">

</head>
<body>

<a href="/keijibankadai/toukou2">topへ戻る</a>

<table  border="1">


	<%
	ArrayList<bean> List = (ArrayList<bean>)request.getAttribute("list");
	for(int i = 0 ; i < List.size() ; i++){
		bean toukou = List.get(i);
	%>
	<tr>
			<td>
			<%=toukou.getNumber() %>:<%=toukou.getNaiyou() %><br>投稿者:<%=toukou.getName() %>
			　投稿時間:<%=toukou.getTime() %>　編集時間:<%=toukou.getTime2() %>
			<button onclick="location.href='/keijibankadai/kanri?id=<%=toukou.getNumber() %>'">削除</button>
			</td>

		</tr>
	<%
	}
	%>
	</table>


</body>
</html>



