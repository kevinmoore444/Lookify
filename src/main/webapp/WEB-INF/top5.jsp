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
			<h1>Top 5!</h1>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Song Title</th>
							<th>Artist</th>
							<th>Rating</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="eachSong" items="${songList}">
							<tr>
								<td style="vertical-align: middle"><a href="/songs/${eachSong.id}"><c:out value="${eachSong.songTitle}"/></a></td>
								<td style="vertical-align: middle"><c:out value="${eachSong.artist}"/></td>
								<td style="vertical-align: middle"><c:out value="${eachSong.rating}"/></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
		</div>
	</body>
</html>