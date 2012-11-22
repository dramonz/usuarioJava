<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
	<title>Header</title>
	<link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/header.css" />" />
	<script type="text/javascript" src="<c:url value="/resources/js/jquery.js" />"></script>
	<script type="text/javascript">
	$(document).ready(function() {
		$(document.getElementById('logout')).click(function() {
			parent.window.location = "j_spring_security_logout";
			return false;
		});
		
		$(document.getElementById('ayuda')).click(function() {
			top.window.document.getElementById('content-frame').src = "ayuda";
			return false;
		});
		$(document.getElementById('home')).click(function() {
			return false;
		});
	});
	</script>
</head>
<body>
	<div class="header">
		<div class="header-content">
			<div class="siafe-logo"></div>
			<div class="main-options">
				<ul>					
					<li class="logout-option"><a id="logout" href="j_spring_security_logout">&nbsp;</a></li>
				</ul>
			</div>
			<div class="clear"></div>
		</div>
	</div>

	<div class="user-bar">
		<div class="user-info"><fmt:message key="welcome.default"/> <sec:authentication property="name" /></div>			
	</div>
</body>
</html>