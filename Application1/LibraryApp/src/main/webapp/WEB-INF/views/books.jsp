<%@page import="com.nagarro.utility.AppContext"%>
<%@page import="com.nagarro.services.BookService"%>
<%@page import="java.util.Map"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
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
<title>Library-books</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
 <link rel="stylesheet" href="<c:url value="/resources/CSS/style.css" />">
</head>
<body>
	 <jsp:include page="header.jsp" />
	  	<section>
        <div class="container mt-5">
            <div class="row">
            <div   class="text-center fs-4 col-10">
                <b>Books Listing</b>
            </div>
            <div class="col-2" >
                <a href="addbookpath" ><button class="btn btn-primary">Add book</button></a>
            </div>
        </div>
        <div class="container mt-5">
            <table class="table table-bordered text-center">
                <thead>
                    <tr>
                        <th>Book Code</th>
                        <th>Book Name</th>
                        <th>Author</th>
                        <th>Data Added</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                <%
                	JSONArray ja= AppContext.getContext().getBean("bookService",BookService.class).getBooksFromServer();
                	
                if(ja!=null && ja.size()>0){
                	for(Object o:ja){
                		JSONObject jo=(JSONObject)o;
                		String code=jo.get("code")+"";
                		String name=(String)jo.get("name");
                		 Map author = ((Map)jo.get("author"));
                		 String authorName=(String)author.get("name");
                		String addedOn=(String)jo.get("addedOn");
         
                	
                %>
                    <tr>
                        <td><%= code %></td>
                        <td><%= name %></td>
                        <td><%= authorName %></td>
                        <td><%= addedOn %></td>
                        <td><a href="editbookpath?bcode=<%= code %>" ><button class="btn btn-success">Edit</button></a>
                            <a href="deletebook?bcode=<%= code %>" ><button class="btn btn-danger">Delete</button></a></td>
                    </tr>
                    <% 
                	}
                }else{
                    %>
                    <h3>No books in db</h3>
                    <%
                }
                    %>
                </tbody>

            </table>
        </div>
        </div>        
            
    </section>
	  
	  <jsp:include page="footer.jsp" />
	   <script src="<c:url value="/resources/JS/script.js" />"></script>

</body>
</html>