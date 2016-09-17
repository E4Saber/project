<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'alienFile.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href='<c:url value="/resource/css/errorAll.css"/>'>
	

  </head>
  
  <body>
  
  		<h3>AlienFile Details</h3>
  		AlienNo: ${alienFile.alienNo}<br/>
  		<p>Following files are uploaded successfully.</p>
  		<ol>
  			<c:forEach items="${alienFile.imageFile }" var="image">
  				<li>
  					${imageFile.originamFilename}
  					<img alt="preview failed" src="<c:url value="/image/"/> ${imageFile.originalFilename}"/>
  				</li>
  			</c:forEach>
  		</ol>
  </body>
</html>
