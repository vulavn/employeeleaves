<!DOCTYPE html>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html xmlns:c="http://java.sun.com/jsp/jstl/core">
<head>
	<meta charset="UTF-8">
	<title>Add Leave</title>
</head>
<body>
	<h2><b>ADD NEW LEAVE</b></h2>
	<br>

	<c:forEach items="${listMessage}" var="message">
		<p style="color:red">${message}</p>
	</c:forEach>

	<form action="addLeave" method="post">
		<div>
			<table>
				<tr>
					<td><label><b>Leave Type</b></label></td>
					<select name="selLeaveType">
						<c:forEach items="${listLeaveType}" var="item">
							<option value=${item.id}>${item.leaveName}</option>
						</c:forEach>
					</select>
				</tr>
				<tr>
					<td><label><b>Start</b></label></td>
					<td><input type="date" name="dtStart"></td>
					<td style="text-align:right;">
						<select name="selStartTime">
							<option value="08:00">08:00</option>
							<option value="13:00">13:00</option>
						</select>
					</td>
				</tr>
				<tr>
					<td><label><b>End</b></label></td>
					<td><input type="date" name="dtEnd"></td>
					<td style="text-align:right;">
						<select name="selEndTime">
							<option value="17:00">17:00</option>
							<option value="13:00">13:00</option>
						</select>
					</td>
				</tr>
				<tr>
					<td><label><b>reason</b></label></td>
					<td colspan="2"><textarea rows="4" cols="30" name="txtReason"></textarea></td>
				</tr>
				<tr>
					<td colspan="4" style="text-align:right;">
						<input type="submit" value="Add">
						<input type="hidden" name="hdnAccount" value="${hdnAccount}">
					</td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>