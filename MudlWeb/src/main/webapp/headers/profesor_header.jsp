<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Profesor Mudl</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>

	<header>
	<div>
	    <sec:authorize access="isAuthenticated()">
    		<h2> Dobrodošli na Mudl,	<sec:authentication property="principal.u.ime"/></h2>
 		</sec:authorize>
	</div>
	
	<nav> 
		<a href="/Mudl/profesor/getPredmetForProfesor"><button>Prikaz Predmeta</button></a>
		<a href="/Mudl/profesor/getUpdateProfile"><button style="margin-bottom: 15px;">Uredi Profil</button></a>
		<a href="/Mudl/profesor/o_nama"><button>O nama</button></a>
		<a href="/Mudl/logout"><button>Izloguj se</button></a> 
	</nav>

	</header>

</body>
</html>
