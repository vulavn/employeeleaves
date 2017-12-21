<!DOCTYPE>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns:c="http://java.sun.com/jsp/jstl/core">
<head>
	<meta charset="UTF-8">
	<title>Login</title>
</head>

<body>
	<div>
		<c:forEach items="${errorMessage}" var="message">
			<label style="color:red">${message}</label><br>
		</c:forEach>
	</div>

	<br>

	<div>
		<form action="home" method="post">
			<table>
				<tr>
					<td><label><b>Account</b></label></td>
					<td><input type="text" name="txtAccount" placeholder="Enter Username" value="${param.txtAccount}"></td>
				</tr>
				<tr>
					<td><label><b>Password</b></label></td>
					<td><input type="password" name="txtPassword" placeholder="Enter Password" value="${param.txtPassword}"></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:right;">
						<input type="submit" value="Login">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>