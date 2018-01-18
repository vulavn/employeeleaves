<!DOCTYPE>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns:c="http://java.sun.com/jsp/jstl/core">

<head>
	<meta charset="UTF-8">
	<title>Manager</title>
</head>
<body>
	<h2><b>MANAGER</b></h2>
	<br>
	<table>
		<tr>
			<td><label><b>Full name</b></label></td>
			<td><input type="text" readonly="readonly" value="${manager.lastName} ${manager.firstName}"></td>
		</tr>
		<tr>
			<td><label><b>Email</b></label></td>
			<td><input type="text" readonly="readonly" value="${manager.email}"></td>
		</tr>
		<tr>
			<td><label><b>Phone</b></label></td>
			<td><input type="text" readonly="readonly" value="${manager.phone}"></td>
		</tr>
		<tr>
			<td><label><b>Department</b></label></td>
			<td><input type="text" readonly="readonly" value="${manager.department.departmentName}"></td>
		</tr>
		<tr>
			<td><label><b>Available leave</b></label></td>
			<td><input type="text" readonly="readonly" value="${manager.availableLeave}"></td>
		</tr>
	</table>
	
	<br>

	<c:if test="${not empty listMember}">
		<label><b>List member</b></label>
		<table border="1">
			<tr>
				<th>Account</th>
				<th>Name</th>
				<th>Department</th>
				<th>Email</th>
				<th>Phone</th>
				<th>Available leave</th>
			</tr>
			<c:forEach items="${listMember}" var="item">
				<tr>
					<td>${item.account}</td>
					<td>${item.lastName} ${item.firstName}</td>
					<td>${item.department.departmentName}</td>
					<td>${item.email}</td>
					<td>${item.phone}</td>
					<td>${item.availableLeave}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
		
	<br>
	<div><button onClick="window.location='approve.html';">Approve Leave</button></div>
	<br>
	<div><button onClick="window.location='new_employee.html';">Add New Employee</button></div>
</body>
</html>