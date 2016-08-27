<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'regist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content=" no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <script type="text/javascript" src="jas.js"></script>
  </head>
  
  <body>
    <form id="forminf" action="reg_action" method="get">
    	<table id="tableinf" border="2em">
    	  <tr><td>Name</td>
    	       <td><input type="text" id="name" name="name"></td></tr> 
    	  <tr><td>Password</td>
    	       <td><input type="text" id="password" name="password"></td></tr> 
    	  <tr><td>Gender</td>
    	       <td>Male<input type="radio" id="sex" name="gender" value="male">
    	           Female<input type="radio" id="sex" name="gender" value="female"></td></tr> 
    	  <tr><td>Department</td><td align="center"><select id="department" name="department" >
    	                      <option value="1" selected="selected">first</option>
    	                      <option value="2">second</option>
    	                      <option value="3">third</option>
    	                      <option value="4">forth</option>
    	                    </select></td></tr>  
    	  <tr><td>Role</td><td>Employee<input  type="checkbox" name="role" value="employee" >
    	                       Admin<input type="checkbox" name="role" value="admin">
    	                       Teacher<input type="checkbox" name="role" value="teacher"></td></tr>
    	  <tr><td>Details</td><td><textarea rows="4" cols="25"></textarea></td></tr>
    	  <tr><td colspan="2" align="center">
    	                    <input type="submit" value="submit" onclick="subOnClick();"></td></tr>
    		
    	</table>
    </form>
    
   
  </body>
</html>
