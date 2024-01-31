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
<title>Dodavanje na Predmet</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/styles.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/predmeti.css">
</head>
<body>

	<sec:authorize access="hasRole('Student')">
		<%@include file="headers/student_header.jsp"%>
	</sec:authorize>

	<c:choose>
		<c:when test="${!empty listaPredmeta}">
			<form action="/Mudl/student/addToPredmet" method="post">
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
				<div>
					<button type="submit">Dodaj</button>
				</div>
			</form>
		</c:when>
		<c:otherwise>
			<div>
				<h2>Ne možete se prijaviti ni na jedan predmet.</h2>
			</div>
		</c:otherwise>
	</c:choose>

</body>
</html>