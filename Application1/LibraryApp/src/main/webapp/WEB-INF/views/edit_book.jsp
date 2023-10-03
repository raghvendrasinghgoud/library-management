<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.util.Map"%>
<%@page import="com.nagarro.utility.AppContext"%>
<%@page import="com.nagarro.services.BookService"%>
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
<title>Library-edit book</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
  <link rel="stylesheet" href="<c:url value="/resources/CSS/style.css" />">
</head>
<body>
	<jsp:include page="header.jsp" />
	
		<section>
        <div class="container mt-5">
            <div class="row">
            <div   class="text-center fs-4">
                <b>Edit Book Details</b>
            </div>
        </div>
        <div class="container mt-5 row">
        <%
        	JSONObject jo=(JSONObject)request.getAttribute("bookobj");
        %>
            <form class="col-6" action="editbook" method="post" onsubmit="return formv()">
            <input type="text" name="bcode" id="bcode" value="<%= jo.get("code") %>" class="col-6" hidden="true">
                <div class="row">
                    <label class="col-4" for="bcode">Book Code</label>
                    <input type="text" name="bcode" id="bcode" value="<%= jo.get("code") %>" class="col-6" disabled="disabled">
                    <p class="col-2 error" id="bcodeerror"></p>
                </div>
                <div class="row mt-2">
                    <label class="col-4" for="bname">Book Name</label>
                    <input type="text" name="bname" id="bname" value="<%= jo.get("name")%>" class="col-6" >
                    <p class="col-2 error" id="bnameerror"></p>
                </div>
                <div class="row mt-2">
                    <label class="col-4" for="author">Author</label>
                    <select name="author" id="author" class="col-6">
                        <option value="" disabled="disabled">--Select Author--</option>
                    <%
                    	Map map=(Map)jo.get("author");
                    		String aid=map.get("aid")+"";
                    JSONArray ja= AppContext.getContext().getBean("bookService",BookService.class).getAuthorsFromServer();
                    		for(Object o:ja){
                    			JSONObject newjo=(JSONObject)o;
                    		String name=(String)newjo.get("name");
                    		String newaid=newjo.get("aid")+"";
                    		if(newaid.equals(aid)){
                    %>
                        <option value="<%= newaid %>" <%= "selected" %>><%= name %></option>
                        <%
                    		}else{
                        %>
                        <option value="<%= newaid %>"><%= name %></option>
                        <%
                    			}
                    		}
                        %>
                    </select>
                    <p class="col-2 error" id="authorerror"></p>
                </div>
                <div class="row mt-2">
                    <label class="col-4" for="adon">Added on</label>
                    <input type="text" name="adon" class="col-6" value="<%= jo.get("addedOn") %>" disabled>
                    <input type="text" name="adon" class="col-6" value="<%= jo.get("addedOn") %>" hidden>
                </div> 
                <div class="mt-3">
                   <button class="btn btn-success ms-3" type="submit">Submit</button>
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