<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

  String op = (String)session.getAttribute("op");
   
  
  %>
  
  	<h4><%= op%></h4>
</body>
</html>