<%@page import="java.security.Principal"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
						<td><img src="<c:url value="C://test111/${name}.jpg" />"
							alt="Upload Picture" height="150" width="150" /></td>

						

					</tr>
					<tr>
						<td><div>
								<a href="uploadimage">Upload Image</a>
							</div></td>



					</tr>


				</table>



				<!-- Second Blog Post -->
<table>
<tr>
<form:form action="statusupdate" method="post">
							<td><form:input path="status" placeholder="Update Status" /></td>
							<td><input type="submit" value="Update" /></td>
						</form:form>

</tr>
</table>

				<div class="row"></div>
			</div>
		</div>
	</div>

	<footer class="container-fluid">

		<%@include file="footer.jsp"%>
	</footer>

</body>
</html>
