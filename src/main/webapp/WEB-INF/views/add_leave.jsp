<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Add Leave</title>
</head>
<body>
	<div>
		<table>
			<tr>
				<td><label><b>Leave Type</b></label></td>
				<td>
					<select>
						<option>AL</option>
						<option>Sick leave</option>
						<option>Leave without pay</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><label><b>Start</b></label></td>
				<td><input type="date"></td>
				<td style="text-align:right;">
					<select>
						<option>08:00</option>
						<option>13:00</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><label><b>End</b></label></td>
				<td><input type="date"></td>
				<td style="text-align:right;">
					<select>
						<option>17:00</option>
						<option>13:00</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><label><b>reason</b></label></td>
				<td colspan="2"><textarea rows="4" cols="30"></textarea></td>
			</tr>
			<tr>
				<td colspan="4" style="text-align:right;">
					<button onClick="window.location='employee.html';">Add</button>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>