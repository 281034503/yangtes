<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<title>HTML sample</title>
</head>
<body>
	
<%

String jspName="innerObject.jsp";

String abe="aab";
System.out.print("aab");
pageContext.setAttribute("aaa",new Object());
session.getAttribute("aaa");

response.setContentType("applcation/excel");

out.print("<h1>out</h1>");
application.getAttribute("aaa");
config.getInitParameter("appStatus");

%>
</body>
</html>