<%@ page language="java" import="java.util.*" pageEncoding="US-ASCII"%>
<%@page import="java.util.List" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <meta content = 'text/html; charset=UTF-8' http-equiv = 'content-type'>
    <title>Fail Regisiter</title>

  </head>
  
  <body>
   	<h1>Fail resigister</h1>>
   	<u1 style = 'color:rgb(255,0,0)'>
   	
   	<%
   		List<String> errors = (List<String>)request.getAttribute("errors");
   		for (String e : errors)
   		{
   	%>
   			<li> <%= e %> </li>>
   	
   	<%
   		}
   	 %>
   	 
   	 </u1>>
   	 <a href = 'register.html'>regisiter</a>>
   	
   	
  </body>
</html>
