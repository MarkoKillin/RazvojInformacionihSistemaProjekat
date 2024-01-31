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
<title>Uredi Profil</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/styles.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/predmeti.css">
</head>
<body>
	<sec:authorize access="hasRole('Admin')">
		<%@include file="headers/admin_header.jsp"%>
		<c:if test="${profil != null}">
			<form action="/Mudl/admin/updateProfile" method="post">
				<div>
					<h4>Ime:</h4>
					<input name="ime" type="text" style="width: 300px; height: 35px"
						value="${profil.ime}" required="required">
				</div>
				<div>
					<h4>Prezime:</h4>
					<input name="prezime" type="text"
						style="width: 300px; height: 35px" value="${profil.prezime }" required="required">
				</div>
				<div>
					<h4>Email:</h4>
					<input name="email" type="text" style="width: 300px; height: 35px" value="${profil.email }" required="required">
				</div>
				<div>
					<h4>Korisničko ime:</h4>
					<input name="username" type="text"
						style="width: 300px; height: 35px" value="${profil.username }" required="required">
				</div>
				<div>
					<h4>Lozinka:</h4>
					<input name="password" type="password"
						style="width: 300px; height: 35px" required="required">
				</div>
				<div>
					<h4>Nova lozinka:</h4>
					<input name="npassword" type="password"
						style="width: 300px; height: 35px">
				</div>

				<div>
					<button type="submit">Sačuvaj</button>
				</div>
			</form>
		</c:if>
	</sec:authorize>

	<sec:authorize access="hasRole('Profesor')">
		<%@include file="headers/profesor_header.jsp"%>
		<c:if test="${profil != null}">
			<form action="/Mudl/profesor/updateProfile" method="post">
				<div>
					<h4>Ime:</h4>
					<input name="ime" type="text" style="width: 300px; height: 35px"
						value="${profil.ime}" required="required">
				</div>
				<div>
					<h4>Prezime:</h4>
					<input name="prezime" type="text"
						style="width: 300px; height: 35px" value="${profil.prezime }" required="required">
				</div>
				<div>
					<h4>Email:</h4>
					<input name="email" type="text" style="width: 300px; height: 35px" value="${profil.email }" required="required">
				</div>
				<div>
					<h4>Korisničko ime:</h4>
					<input name="username" type="text"
						style="width: 300px; height: 35px" value="${profil.username }" required="required">
				</div>
				<div>
					<h4>Lozinka:</h4>
					<input name="password" type="password"
						style="width: 300px; height: 35px" required="required">
				</div>
				<div>
					<h4>Nova Lozinka:</h4>
					<input name="npassword" type="password"
						style="width: 300px; height: 35px">
				</div>

				<div>
					<button type="submit">Sačuvaj</button>
				</div>
			</form>
		</c:if>
	</sec:authorize>

	<sec:authorize access="hasRole('Student')">
		<%@include file="headers/student_header.jsp"%>
		<c:if test="${profil != null}">
			<form action="/Mudl/student/updateProfile" method="post">
				<div>
					<h4>Ime:</h4>
					<input name="ime" type="text" style="width: 300px; height: 35px"
						value="${profil.ime}" required="required">
				</div>
				<div>
					<h4>Prezime:</h4>
					<input name="prezime" type="text"
						style="width: 300px; height: 35px" value="${profil.prezime }" required="required">
				</div>
				<div>
					<h4>Email:</h4>
					<input name="email" type="text" style="width: 300px; height: 35px" value="${profil.email }" required="required">
				</div>
				<div>
					<h4>Korisničko ime:</h4>
					<input name="username" type="text"
						style="width: 300px; height: 35px" value="${profil.username }" required="required">
				</div>
				<div>
					<h4>Lozinka:</h4>
					<input name="password" type="password"
						style="width: 300px; height: 35px" required="required">
				</div>
				<div>
					<h4>Nova Lozinka:</h4>
					<input name="npassword" type="password"
						style="width: 300px; height: 35px">
				</div>

				<div>
					<button type="submit">Sačuvaj</button>
				</div>
			</form>
		</c:if>
	</sec:authorize>



</body>
</html>