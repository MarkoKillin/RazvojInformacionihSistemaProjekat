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
<title>Dodavanje Izbora</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/styles.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/predmeti.css">
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
		<form action="/Mudl/profesor/addIzbor"
			method="post">
			<c:if test="${!empty listaAnketa}">
				<div>
					<h2>${predmet.naziv} - Spisak Anketa:</h2>
				</div>
				<div>
					<select name="idAnketa" style="width: 300px; height: 35px">
						<c:forEach items="${listaAnketa}" var="z">
							<option value="${z.idAnketa}">${z.naziv}</option>
						</c:forEach>
					</select>
				</div>
				<div>
					<h4>Naziv:</h4>
					<input name="naziv" type="text" style="width: 300px; height: 35px">
				</div>
			</c:if>
			<div>
				<button type="submit">Dodaj</button>
			</div>
		</form>
	</c:if>


</body>
</html>