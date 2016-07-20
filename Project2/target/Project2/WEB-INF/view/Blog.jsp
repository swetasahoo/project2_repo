<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
  <title>Blog Page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <style>
    /* Set height of the grid so .sidenav can be 100% (adjust if needed) */
    .row.content {height: 1500px}
    
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
      .row.content {height: auto;} 
    }
  </style>
</head>
<body>

<div class="container-fluid">
  <div class="row content">
  
    <%@include file="header.jsp" %>
    
    <div class="col-sm-9">
    <div>
     <h4>${uname} Blog</h4><form:form action="addblog" method="post">
    	<button type="submit" class="btn btn-primary">Add New Blog</button>
    </form:form>
    
   
   
      <h2>
     	<c:forEach items="${approvedblog}" var="p">
					<h3><div class="media-body">${p.blogtitle}</div></h3>
					<h4>${p.blogcontent}</h4>
					
			<h4>Leave a Comment:</h4>
      		<form role="form">
        		<div class="form-group">
         			 <textarea class="form-control" rows="1" required></textarea>
       			 </div>
       			 <button type="submit" class="btn btn-success">Submit</button>
      		</form>
      <br><br>
      
      <p><span class="badge">2</span> Comments:</p><br>
				</c:forEach>
      
     
<!-- Pager -->
                <ul class="pager">
                    <li class="previous">
                        <a href="#">&larr; Older</a>
                    </li>
                    <li class="next">
                        <a href="#">Newer &rarr;</a>
                    </li>
                </ul>


      <div class="row">
        
        
        
      </div>
    </div>
  </div>
</div>

<footer class="container-fluid">
  
<%@include file="footer.jsp" %>
</footer>

</body>
</html>
