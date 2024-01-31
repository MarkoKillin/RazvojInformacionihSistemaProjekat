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
<title>Prikaz Detalja</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/styles.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/predmeti.css">
</head>
<body>

	<sec:authorize access="hasRole('Profesor')">
		<%@include file="headers/profesor_header.jsp"%>
	</sec:authorize>

	<c:if test="${!empty listaResenja}">

		<c:if test="${predmet != null}">
			<h2>${predmet.naziv} - Spisak Resenja:</h2>
		</c:if>

		<table>
			<tr>
				<th style="width: 260px;">Naziv zadatka</th>
				<th style="width: 100px;">Ime Studenta</th>
				<th style="width: 100px;">Fajl</th>
				<th>Sadrzaj</th>
			</tr>
			<c:forEach items="${listaResenja}" var="r">
				<tr>
					<td>${r.zadatak.naziv}</td>
					<td>${r.korisnik.ime} ${r.korisnik.prezime}</td>
					<td><a href="/Mudl/profesor/preuzmi?idZadatakKorisnik=${r.idZadatakKorisnik}">Preuzmi</a></td>
					<td>${r.sadrzaj}</td>
				</tr>
			</c:forEach>
		</table>

	</c:if>

</body>
</html>