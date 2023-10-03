<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%
		String error="";
		
				if(request.getAttribute("error")!=null){
					error=(String)request.getAttribute("error");
				}
	%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Library-Login</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
  <link rel="stylesheet" href="<c:url value="/resources/CSS/style.css" />" />
</head>
<body>
	 <header>
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <div   class="text-end fs-3 col-8" >
             <b class="me-5">Library Management Tool</b>
            </div>
             <div class=" text-end col-4 row ">
                  <p class="col-9 mt-2 "></p>           
                  <a class="nav-link me-3 col" href="#"><button class="btn btn-light"></button></a>
             </div>
          </nav>
    </header>
	<section>
        <div class="container col-6 mt-5 pt-5">
            <p class="error text-end"><%= error %></p>
            <div class="text-bg-secondary p-3 fs-4">Login</div>
            <form class="bg-light" action="loginpath">
                <div class="mb-3 pt-3 ps-5 pe-5">
                  <label for="exampleInputEmail1" class="form-label">Username</label>
                  <input type="text" class="form-control" name="user" id="exampleInputEmail1" aria-describedby="emailHelp">
                </div>
                <div class="mb-3 pb-3 ps-5 pe-5">
                  <label for="exampleInputPassword1" class="form-label">Password</label>
                  <input type="password" class="form-control" name="pass" id="exampleInputPassword1">
                </div>
                <div class="text-bg-secondary p-3 fs-4">
                    <button type="submit" class="btn btn-light">Login</button>
                </div>
              </form>
        </div>
    </section>
     <jsp:include page="footer.jsp" />
      <script src="<c:url value="/resources/JS/script.js" />"></script>
</body>
</html>