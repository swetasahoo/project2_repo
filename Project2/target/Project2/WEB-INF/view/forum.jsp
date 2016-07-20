<!DOCTYPE html>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html lang="en">
<head>
<title>Forum Page</title>
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
			<h1>'s forum</h1>

			<div class="col-sm-9">
				<div>

					<a href="addforum">Add New Forum</a>

				</div>
				
				<hr>
				
				<c:forEach items="${forum}" var="p">
					<h3><div class="media-body">${p.forumtitle}</div></h3>
					<h4>${p.forumcomments}</h4>
					<div><button type="button" class="btn btn-info">Up</button> <button type="button" class="btn btn-info">Down</button><button type="button" class="btn btn-info">Likes</button></div>
					<h4>Leave a Comment:</h4>
			
			<form:form commandName="commentspage"  method="post" action="saveComments">
				<div class="form-group">
				
				<!--<form:input type="text" path="forumid" value="${p.forumId }"/>-->
					<form:input type="textarea" path="mycomment" class="form-control" placeholder="Comments"/>
				</div>
				<button type="submit" class="btn btn-success">Submit</button>
				</form:form>
				</c:forEach>
			
				
			</div>
			
			<br>

		
			<br>
			<br>

		
		
	</div>
	</div>

	<footer class="container-fluid">
		<%@include file="footer.jsp"%>

	</footer>

</body>
</html>
