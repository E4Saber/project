<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
    
    <title>My JSP 'details.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href='<c:url value="/resource/css/errorAll.css"/>'>
	
	

  </head>
  
  <body>
    	<sf:form method="POST" commandName="alienForm">
    		    <sf:errors path="*" element="div" cssClass="errors"></sf:errors> <br/>
    		
    		<sf:label path="alienNo" cssErrorClass="error">	AlienNo:</sf:label>
    			 <sf:input path="alienNo" cssErrorClass="error"/>
    		<sf:label path="alienName" cssErrorClass="error">AlienName:</sf:label>
    			<sf:input path="alienName" cssErrorClass="error"/>
    		<sf:label path="alienRace" cssErrorClass="error">AlienRace:</sf:label>
    			<sf:input path="alienRace" cssErrorClass="error"/>
    		<input type="submit"  value="submit" />
    	</sf:form>
    	
  </body>
</html>
