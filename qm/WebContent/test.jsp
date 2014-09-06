<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.xtu.qm.pojo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>测试</title>
</head>
<body>
<%
AccountInfo account = (AccountInfo)session.getAttribute("AccountInfo");
UserInfo user = account.getUserinfo();
PersonalSpace zone = user.getPersonalspace();
%>
这是一个伪主页，呵呵~！<br>
<table>
	<tr>
	<td> 用户头像 </td>
	<td> <img alt="" src="<%= user.getUserLogo().getSmallimageUrl() %>" /> </td>
	</tr>
	<tr>
	<td> 用户名 </td>
	<td> <%= account.getUsername() %> </td>
	</tr>
</table>
直接点击<a href="setting.jsp">这里</a>去设置页面
</body>
</html>