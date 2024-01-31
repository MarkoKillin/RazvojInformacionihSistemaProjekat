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
<title>Dodavanje Profesora Predmetu</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/styles.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/predmeti.css">
</head>
<body>
	<sec:authorize access="hasRole('Admin')">
		<%@include file="headers/admin_header.jsp"%>
	</sec:authorize>

		<form action="/Mudl/admin/addProfesorForPredmet"
			method="post">
			<c:if test="${!empty listaPredmeta}">
				<div>
					<h2>Spisak Predmeta:</h2>
				</div>
				<div>
					<select name="idPredmet" style="width: 300px; height: 35px">
						<c:forEach items="${listaPredmeta}" var="p">
							<option value="${p.idPredmet}">${p.naziv}</option>
						</c:forEach>
					</select>
				</div>
			</c:if>
			<c:if test="${!empty listaProfesora}">
				<div>
					<h2>Spisak Profesora:</h2>
				</div>
				<div>
					<select name="idKorisnik" style="width: 300px; height: 35px">
						<c:forEach items="${listaProfesora}" var="p">
							<option value="${p.idKorisnik}">${p.ime} ${p.prezime }</option>
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