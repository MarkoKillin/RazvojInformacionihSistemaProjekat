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
<title>Prikaz Anketa</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/styles.css">

</head>
<body>
	<sec:authorize access="hasRole('Admin')">
		<%@include file="headers/admin_header.jsp"%>
	</sec:authorize>

	<sec:authorize access="hasRole('Profesor')">
		<%@include file="headers/profesor_header.jsp"%>
	</sec:authorize>

	<sec:authorize access="hasRole('Student')">
		<%@include file="headers/student_header.jsp"%>
	</sec:authorize>

	<c:if test="${predmet != null}">
		<c:if test="${!empty listaAnketa}">
			<form action="/Mudl/profesor/getAnketaResults" method="get">
				<div
					style="display: flex; flex-direction: column; align-items: center; margin-bottom: 10px;">
					<h2 style="margin-bottom: 30px; margin-top: 30px;">${predmet.naziv}
						- Spisak Anketa:</h2>
				</div>
				<div
					style="display: flex; flex-direction: column; align-items: center; margin-bottom: 10px;">
					<select name="idAnketa" style="width: 300px; height: 35px">
						<c:forEach items="${listaAnketa}" var="i">
							<option value="${i.idAnketa}">${i.naziv}</option>
						</c:forEach>
					</select>
				</div>
				<div
					style="display: flex; flex-direction: column; align-items: center; margin-bottom: 10px;">
					<button type="submit">Prikaži</button>
				</div>
			</form>
		</c:if>
	</c:if>

	<c:if test="${anketa != null}">
		<h2 style="margin-top: 30px;">Anketa: ${anketa.naziv }</h2>
	</c:if>
	<div style="display: flex; margin-top: 30px;">
		<c:if test="${predmet != null}">
			<c:if test="${!empty listaIzbora}">
				<table style="width: 250px;">
					<tr>
						<td>Naziv izbora:</td>
					</tr>
					<c:forEach items="${listaIzbora}" var="izbor">
						<tr>
							<td>${izbor.naziv }</td>
						</tr>
					</c:forEach>
				</table>
				<table style="width: 150px;">
					<tr>
						<td>Odabralo:</td>
					</tr>
					<c:forEach items="${listaDuzina}" var="duzina">
						<tr>
							<td>${duzina}</td>
						</tr>
					</c:forEach>
				</table>
				<table style="overflow-x: scroll;">
					<tr>
						<td>Ljudi koji su odabrali:</td>
						<c:forEach items="${max}" var="i">
							<td></td>
						</c:forEach>
					</tr>
					<c:forEach items="${listaRezultata}" var="rezultat">
						<tr>
							<c:forEach items="${rezultat}" var="i">
								<td>${i.ime } ${i.prezime }</td>
							</c:forEach>
							<td></td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
		</c:if>
	</div>
</body>
</html>