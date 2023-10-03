<%@page import="java.time.LocalDate"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="com.nagarro.utility.AppContext"%>
<%@page import="com.nagarro.services.BookService"%>
<%@page import="java.util.Map"%>
<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
    
    HttpSession ss=request.getSession();
	String user=(String)ss.getAttribute("user");
	if(user==null){
		response.sendRedirect("index");
	}
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Library-add book</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
 <link rel="stylesheet" href="<c:url value="/resources/CSS/style.css" />">
</head>
<body>
	<jsp:include page="header.jsp" />
		 <section >
        <div class="container mt-5">
            <div class="row">
            <div   class="text-center fs-4">
                <b>Add Book Deatils</b>
            </div>
        </div>
        <div class="container mt-5 row">
        <%
		String error="";
		
				if(request.getAttribute("error")!=null){
					error=(String)request.getAttribute("error");
				}
	%>
            <form class="col-6" action="addbook" method="post" onsubmit="return formv()">
				<p class="error text-end"><%= error %></p>
                <div class="row">
                    <label class="col-4" for="bcode">Book Code</label>
                    <input type="text" name="bcode" id="bcode" class="col-6">
                    <p class="col-2 error" id="bcodeerror"></p>
                </div>
                <div class="row mt-2">
                    <label class="col-4" for="bname">Book Name</label>
                    <input type="text" name="bname" id="bname" class="col-6">
                    <p class="col-2 error" id="bnameerror"></p>
                </div>
                <div class="row mt-2">
                    <label class="col-4" for="author">Author</label>
                    <select name="author" id="author" class="col-6">
                        <option value="" disabled="disabled" selected="selected">--Select Author--</option>
                    <%
                    JSONArray ja= AppContext.getContext().getBean("bookService",BookService.class).getAuthorsFromServer();
                    		for(Object o:ja){
                    			JSONObject jo=(JSONObject)o;
                    		String name=(String)jo.get("name");
                    		String aid=jo.get("aid")+"";
                    %>
                        <option value="<%= aid %>"><%= name %></option>
                        <%
                    		}
                        %>
                
                    </select>
                    <p class="col-2 error" id="authorerror"></p>
                </div>
                <div class="row mt-2">
                    <label class="col-4" for="adon">Added on</label>
                    <input type="text" name="adon" class="col-6" value="<%= LocalDate.now() %>" disabled>
                </div> 
                <div class="mt-3">
                    <button type="submit" class="btn btn-success ms-3">Submit</button>
                            <a href="bookspath" ><button class="btn btn-danger ms-3" type="button">Cancel</button></a>
                </div>               
            </form>
        </div>
        </div>        
            
    </section>
	<jsp:include page="footer.jsp" />
	 <script src="<c:url value="/resources/JS/script.js" />"></script>
</body>
</html>