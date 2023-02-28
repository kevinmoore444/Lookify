<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/style.css"/>

</head>
<body>
	<div class="content">
	<h1 style="text-decoration: underline">Song Details</h1>
		<h4>Title: <c:out value="${song.songTitle}"/></h4>
		<h4>Artist: <c:out value="${song.artist}"/></h4>
		<h4>Rating: <c:out value="${song.rating}"/></h4>
		<a href="/songs"><button class="btn btn-warning">Dashboard</button></a>
	</div>
</body>
</html>