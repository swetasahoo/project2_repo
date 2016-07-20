<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

					<form:form class="form-signin" method="post" action="saveustatus" commandName="status">
					<form:input path="mystatus" class="form-control"/>
					<button	class="btn btn-lg btn-primary btn-block btn-signin"	type="submit">Update</button>
					</form:form>
</body>
</html>