<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="BASE" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>创建客户</title>
</head>
<body>

	<form id="crFm" method="POST" action="${pageContext.request.contextPath}/createCustomer" enctype="multipart/form-data">
		NAME: <input name="name" /><br/>
		CONTACT: <input name="contact" /><br/>
		TELEPHONE: <input name="telephone" /><br/>
		EMAIL: <input name="email" /><br/>
		REMARK: <input name="remark" /><br/>
		FILE: <input name="file" type="file" />
		<button type="submit">SUBMIT</button>
	</form>
</body>
</html>