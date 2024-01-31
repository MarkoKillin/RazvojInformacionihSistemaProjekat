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
<title>Dodavanje Korisnika</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/styles.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/predmeti.css">
</head>
<body>
	<sec:authorize access="hasRole('Admin')">
		<%@include file="headers/admin_header.jsp"%>
	</sec:authorize>

		<form action="/Mudl/admin/addKorisnik"
			method="post">
			<div>
				<h4>Ime:</h4>
				<input name="ime" type="text" style="width: 300px; height: 35px">
			</div>
			<div>
				<h4>Prezime:</h4>
				<input name="prezime" type="text" style="width: 300px; height: 35px">
			</div>
			<div>
				<h4>Email:</h4>
				<input name="email" type="text" style="width: 300px; height: 35px">
			</div>
			<div>
				<h4>Username:</h4>
				<input name="username" type="text" style="width: 300px; height: 35px">
			</div>
			<div>
				<h4>Password:</h4>
				<input name="password" type="text" style="width: 300px; height: 35px">
			</div>
			<c:if test="${!empty listaUloga}">
				<div>
					<h4>Spisak Uloga:</h4>
				</div>
				<div>
					<select name="idUloga" style="width: 300px; height: 35px">
						<c:forEach items="${listaUloga}" var="p">
							<option value="${p.idUloga}">${p.naziv}</option>
						</c:forEach>
					</select>
				</div>
			</c:if>
			
			<div>
				<button type="submit">Dodaj</button>
			</div>
		</form>


</body>
</html>