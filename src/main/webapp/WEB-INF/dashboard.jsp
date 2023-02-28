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
<title>Dashboard</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/style.css"/>

</head>
<body>
	<div style="display: flex; margin-top: 20px; margin-bottom: 30px; justify-content: center">
		<a href="/songs/new"><button style="margin-right: 10px">Add New Song</button></a>
		<a href="/songs/top5"><button style="margin-right: 30px">Top Songs</button></a>
		<form action="/songs/search" method="post">
  			<input type="text" placeholder="Artist" name="artist">
  			<button class="btn btn-primary" type="submit">Search</button>
		</form>
	</div>
	<div class="content">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Song Title</th>
					<th>Artist</th>
					<th>Rating</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="eachSong" items="${songList}">
					<tr>
						<td style="vertical-align: middle"><a href="/songs/${eachSong.id}"><c:out value="${eachSong.songTitle}"/></a></td>
						<td style="vertical-align: middle"><c:out value="${eachSong.artist}"/></td>
						<td style="vertical-align: middle"><c:out value="${eachSong.rating}"/></td>
						<td style="display: flex; vertical-align: middle"><a href="/songs/${eachSong.id}/edit"><button style="margin-right: 10px; font-size:8px" class="btn btn-warning">edit</button></a> 
							<form action="/songs/${eachSong.id}" method="post">
	    						<input type="hidden" name="_method" value="delete">
	    						<button style="font-size:8px" class="btn btn-danger">Delete</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>