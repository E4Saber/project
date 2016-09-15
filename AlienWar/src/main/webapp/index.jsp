<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  	<div>
  		Courrent Locale : ${pageContext.response.locale}
  		<br/>
  		accept-language　header ：${header["accept-language"] }
  	</div>
   <%-- 国际化失败！！！ <h1><s:message code="alien.welcome"/></h1> <br>  --%>
       <h1>Welcome</h1>
    <form action="login">
    	AlienNo:<input type="text" name="alienNo" /><br/>
    	AlienName:<input type="text" name="alienName" /><br/>
    	AlienRace:<input type="text" name="alienRace" />
    	<input type="submit" value="submit"/>
    </form>
     <form action="save">
    	AlienNo:<input type="text" name="alienNo" /><br/>
    	AlienName:<input type="text" name="alienName" /><br/>
    	AlienRace:<input type="text" name="alienRace" />
    	<input type="submit" value="submit"/>
    </form>
    
    <h2>文件上传</h2><br/>
   <div>
    	<sf:form commandName="alienFile" action="fileUpload" method="post" enctype="multipart/form-data">
    		<fieldset>
    			<legend>Add A AlienFile</legend>
    			<p>
    				<label for="alienNo">AlienNo:</label>
    				<sf:input path="alienNo" cssErrorClass="error"/>
    				<sf:errors path="alienNo" cssClass="error"/>
    			</p>
    			<p>
    				<label for="fileUpload">FileUpload:</label>
    				<input type="file" name="imageFile[0]">
    			</p>
    			<p id="buttons">
    				<input id="reset" type="reset" tabindex="4">
    				<input id="submit" type="submit" tabindex="5">
    			</p>
    		</fieldset>
   		 </sf:form>
   	</div>
    
  </body>
</html>
