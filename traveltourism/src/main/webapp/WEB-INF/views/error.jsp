<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form id="form" action="/" method="post">
		<h2>Message:${error.message}</h2>
		<h2>Message:${error.timestamp}</h2>
		<h2>Message:${error.httpStatus}</h2>
		<a href="/">Back</a><br>
	</form>
</body>
</html>