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
<title>Odabir Izbora</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/styles.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/predmeti.css">
</head>
<body>

	<sec:authorize access="hasRole('Student')">
		<%@include file="headers/student_header.jsp"%>
	</sec:authorize>

	<c:if test="${predmet != null}">
		<c:if test="${!empty listaAnketa}">
			<form action="/Mudl/student/getAddIzbor2" method="get">
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
					<button type="submit">Odaberi Anketu</button>
				</div>
			</form>
		</c:if>
		<c:if test="${!empty listaIzbora}">
			<form action="/Mudl/student/addIzborNaAnketi" method="post">
				<div>
					<h2>${anketa.naziv} - Spisak Izbora:</h2>
				</div>
				<div>
					<select name="idIzbor" style="width: 300px; height: 35px">
						<c:forEach items="${listaIzbora}" var="z">
							<option value="${z.idIzbor}">${z.naziv}</option>
						</c:forEach>
					</select>
				</div>
				<div>
					<button type="submit">Odaberi Izbor</button>
				</div>
			</form>
		</c:if>
	</c:if>


</body>
</html>