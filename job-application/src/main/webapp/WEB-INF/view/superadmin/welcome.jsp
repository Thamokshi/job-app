<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to SuperAdmin Panel</title>
</head>
<body>

	<h3>SuperAdmin Panel</h3>
	Welcome ${pageContext.request.userPrincipal.name}
	<br>
	<a href="${pageContext.request.contextPath }/superadmin-panel/logout">Logout</a>

</body>
</html>