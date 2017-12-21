<!DOCTYPE>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns:c="http://java.sun.com/jsp/jstl/core">
<head>
	<meta charset="UTF-8">
	<title>Employee</title>
</head>
<body>
	<h2><b>MEMBER</b></h2>
	<br>
	<div>
		<table>
			<tr>
				<td><label><b>Full name</b></label></td>
				<td><input type="text" readonly="readonly" value="${member.lastName} ${member.firstName}"></td>
			</tr>
			<tr>
				<td><label><b>Email</b></label></td>
				<td><input type="text" readonly="readonly" value="${member.email}"></td>
			</tr>
			<tr>
				<td><label><b>Phone</b></label></td>
				<td><input type="text" readonly="readonly" value="${member.phone}"></td>
			</tr>
			<tr>
				<td><label><b>Manager</b></label></td>
				<td><input type="text" readonly="readonly" value="${member.manager}"></td>
			</tr>
			<tr>
				<td><label><b>Department</b></label></td>
				<td><input type="text" readonly="readonly" value="${member.department.departmentName}"></td>
			</tr>
			<tr>
				<td><label><b>Available leave</b></label></td>
				<td><input type="text" readonly="readonly" value="${member.availableLeave}"></td>
			</tr>
		</table>
		
		<br>

		<c:if test="${not empty listLeaveHistory}">
			<label><b>Leave history</b></label>

			<table border="1">
				<tr>
					<th>Start</th>
					<th>End</th>
					<th>Duration</th>
					<th>Reason</th>
					<th>Leave type</th>
					<th>Apply date</th>
					<th>Status</th>
				</tr>
				<c:forEach items="${listLeaveHistory}" var="item">
					<tr>
						<td>${item.start}</td>
						<td>${item.end}</td>
						<td></td>
						<td>${item.reason}</td>
						<td>${item.leaveType.leaveName}</td>
						<td>${item.applyDate}</td>

						<c:choose>
							<c:when test="${item.status == 0}">
								<td>Waiting</td>
							</c:when>
							<c:otherwise>
								<td>Approved</td>
							</c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
	
	<br>
	<div><button onClick="window.location='add_leave.html';">Add New Leave</button></div>
</body>
</html>