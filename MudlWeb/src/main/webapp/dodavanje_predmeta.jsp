<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dodavanje Predmeta</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/styles.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/predmeti.css">
</head>
<body>
	<sec:authorize access="hasRole('Admin')">
		<%@include file="headers/admin_header.jsp"%>
	</sec:authorize>

	<form action="/Mudl/admin/addPredmet" method="post">
		<div>
			<h2>Dodavanje predmeta:</h2>
		</div>
		<div>
			<h4>Naziv:</h4>
			<input name="naziv" type="text" style="width: 300px; height: 35px">
		</div>
		<div>
			<button type="submit">Dodaj</button>
		</div>
	</form>


</body>
</html>