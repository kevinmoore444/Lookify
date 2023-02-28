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
<title>Edit Song</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/style.css"/>

</head>
<body>
	<div class="form">
		<h1>Edit Song</h1>
		<form:form action="/songs/${song.id}/edit" method="post" modelAttribute="song">
		<input type="hidden" name="_method" value="PUT"/>
    	<p>
        <form:input style="text-align: center" path="songTitle" placeholder="Song Title"/>
        <br/>
        <form:errors style="color:red" path="songTitle"/>
    	</p>
    	<p>
        <form:input style="text-align: center" path="artist" placeholder="Artist"/>
        <br/>
        <form:errors style="color:red" path="artist"/>
    	</p>
    	<p>
        <form:input style="text-align: center" type="number" path="rating" placeholder="Rating(1-10)"/>
        <br/>
        <form:errors style="color:red" path="rating"/>
    	</p>
    	<input class="btn btn-primary" type="submit" value="Update"/>
		</form:form> 
		<a href="/songs"><button style="margin-top:20px" class="btn btn-warning">Dashboard</button></a>   
	</div>	
</body>
</html>