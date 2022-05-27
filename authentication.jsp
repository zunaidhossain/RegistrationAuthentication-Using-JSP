<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>This is the Authentication Page!</h3>
	<form action="authenticate" method="post">
		<table>
			<tr>		
				<td>Username</td>
				<td><input type="text" name="uname"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"></td>
			</tr>
				<td></td>
				<td><input type="submit" value="register"></td>
			</tr>
		</table>
	</form>
</body>
</html>