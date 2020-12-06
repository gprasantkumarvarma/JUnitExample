<%@page import="java.io.BufferedReader"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%System.out.println("i am in side the jsp"); %>

<%String inputData =  request.getParameter("test"); 

BufferedReader br = request.getReader();


System.out.println("data :: "+inputData);
String line = "";
System.out.println("----BODY-----");
while((line = br.readLine()) != null) {
	System.out.println(line);
}


%>
<%= line %>
</body>
</html>