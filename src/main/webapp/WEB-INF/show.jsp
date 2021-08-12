<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Show Person</title>
</head>
<body>
<h1><c:out value="${person.firstName}"/> <c:out value="${person.lastName}"/></h1>
<ul>
	<li><c:out value="${licenseNumber}"/> </li>
	<li><c:out value="${person.license.expirationDate}"/></li>
	<li><c:out value="${person.license.state}"/></li>
</ul>
	
</body>
</html>