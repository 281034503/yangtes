<%@ tag language="java"   pageEncoding="UTF-8"%>

	<%@ attribute name="title" required="false" type="java.lang.String" %>
	<%@ attribute name="containerId" required="false" type="java.lang.String" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="_title" />
<c:if test="${empty title}">
<c:set var="_title" value="Mini" />
</c:if>
<c:if test="${!empty title}">
<c:set var="_title" value="${title}" />
</c:if>
	
<c:set var="_containcrId" />
<c:if test="${empty containerId}">
<c:set var="_containcrId" value="miniContainer" />
</c:if>
<c:if test="${!empty containerId}">
<c:set var="_containcrId" value="${containerId}" />
</c:if>

	
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>${_title}</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/bootstrap-3.3.6/css/bootstrap.css">
<!--[if lt IE 9]
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5 

 	
<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js 

"></script>
<![endif]-->
<script
	src="<%=request.getContextPath()%>/resources/jquery-1.11.1/jquery.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/bootstrap-3.3.6/js/bootstrap.js"></script>
<style type="text/css">
</style>
</head>
<body>
	<div id="${_containcrId}" class="container">
	<jsp:doBody />
	
	
	</div>
	</body>
	</html>