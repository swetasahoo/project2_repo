<%@page import="java.security.Principal"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html lang="en">
<head>
<title>Home page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<style>
/* Set height of the grid so .sidenav can be 100% (adjust if needed) */
.row.content {
	height: 1500px
}

/* Set gray background color and 100% height */
.sidenav {
	background-color: #f1f1f1;
	height: 100%;
}

/* Set black background color, white text and some padding */
footer {
	background-color: #555;
	color: white;
	padding: 15px;
}

/* On small screens, set height to 'auto' for sidenav and grid */
@media screen and (max-width: 767px) {
	.sidenav {
		height: auto;
		padding: 15px;
	}
	.row.content {
		height: auto;
	}
}
</style>
</head>
<body>

	<div class="container-fluid">
		<div class="row content">


			<%@include file='header.jsp'%>

			<div class="col-sm-9">
				<h4>You are Logged in:${uname}</h4>
				<h5>
					<a href="profileupdate">User Profile</a>
				</h5>
				<table>
					<tr>
					<td width="20%"><img src="<c:url value="C://test111/${name}.jpg" />"
							alt="Upload Picture" height="150" width="150" />
							<div>
								<a href="uploadimage">Upload Image</a>
							</div></td>
					
					
					</tr>
					<tr>
					<div>
					<td width="80%">
						
					<a href="updateStatus">Update Status</a>
					</div>
					</td>
					</tr>
					
				</table>
				
			<div>
			<table border="1">
			<tr><th>User Status</th><th> On Date</th></tr>
				<c:forEach var="userstaus" items="${userstatus}">
						<tr><td>${userstaus.mystatus}</td><td>${userstaus.datetime}</td></tr>
					</c:forEach>
					</table>
				<!-- Second Blog Post -->
			</div>	
			</div>
		</div>
	</div>

	<footer class="container-fluid">

		<%@include file="footer.jsp"%>
	</footer>

</body>
</html>
