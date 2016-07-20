<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div class="col-sm-3 sidenav">
      <!-- <h4>John's Blog</h4> -->
      <ul class="nav nav-pills nav-stacked">
        <li class="active"><a href="home">Wall</a></li>
        <li><a href="Blog">Blog</a></li>
        <li><a href="forum">Forum</a></li>
        <li><a href="application">Chat</a></li>
	 <li><a href="<c:url value="/j_spring_security_logout" />">Logout</a></li>
      </ul><br>
      
      
       <div class="input-group">
        <input type="text" class="form-control" placeholder="Search Blog..">
        <span class="input-group-btn">
          <button class="btn btn-default" type="button">
            <span class="glyphicon glyphicon-search"></span>
          </button>
        </span>
      </div>									
    
      </div>

</body>
</html>