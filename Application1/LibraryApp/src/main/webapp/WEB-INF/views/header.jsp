<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
	String username="";
	String logout="";
	String log="";
	HttpSession ss=request.getSession();
	String user=(String)ss.getAttribute("user");
	if(user!=null){
		username="Hi "+user;
		logout="logoutpath";
		log="logout";
	}
%>
<!DOCTYPE html>

<header>
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <div   class="text-end fs-3 col-8" >
             <b class="me-5">Library Management Tool</b>
            </div>
             <div class=" text-end col-4 row ">
                  <p class="col-9 mt-2 "><%= username %></p>           
                  <a class="nav-link me-3 col" href="<%= logout %>"><button class="btn btn-light"><%= log %></button></a>
             </div>
          </nav>
    </header>