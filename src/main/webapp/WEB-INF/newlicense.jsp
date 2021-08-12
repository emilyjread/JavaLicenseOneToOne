<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	<title>New License</title>
</head>
<body>

<h1>New License</h1>

<form:form action="/licenses" method="post" modelAttribute="license">
 
    <p>
        <form:label path="person">Person</form:label>
        <form:errors path="person"/>
       	<form:select path="person" items="${persons}" itemLabel="firstName"/>

    </p>
    <p>
        <form:label path="expirationDate">Expiration Date</form:label>
        <form:errors path="expirationDate"/>
        <form:input type="date" path="expirationDate"/>
    </p>
    
    <p>
        <form:label path="state">State</form:label>
        <form:errors path="state"/>
        <form:input path="state"/>
    </p>
 
  
    <input type="submit" value="Submit"/>
</form:form>	
</body>
</html>