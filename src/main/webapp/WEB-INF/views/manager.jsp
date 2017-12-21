<!DOCTYPE html>
<html>
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
			<td><input type="text" readonly="readonly" value="${manager.manager}"></td>
		</tr>
		<tr>
			<td><label><b>Available leave</b></label></td>
			<td><input type="text" readonly="readonly" value="${manager.availableLeave}"></td>
		</tr>
	</table>
	
	<br>

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
			<tr>
				<td>AnhLV</td>
				<td>le Van Anh</td>
				<td>Production</td>
				<td>aaa@aaa.com</td>
				<td>0123789456</td>
				<td>10</td>
			</tr>
			<tr>
				<td>KhangTM</td>
				<td>Tran Minh Khang</td>
				<td>Production</td>
				<td>bbb@bbb.com</td>
				<td>0589423678</td>
				<td>0</td>
			</tr>
		</table>
		
		<br>
		<div><button onClick="window.location='approve.html';">Approve Leave</button></div>
		<br>
		<div><button onClick="window.location='new_employee.html';">Add New Employee</button></div>
</body>
</html>