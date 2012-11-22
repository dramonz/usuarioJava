<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
	<title><fmt:message key="title.default"/></title>
	<link rel="shortcut icon"  href="<c:url value="/resources/images/icon.png" />"/>
	<link type="text/css" rel="stylesheet" href="<c:url value="/ext/resources/css/ext-all.css" />" />
	<link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/presupuesto.css" />" />
	<link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/modules.css" />" />
	<!--Se agrega para el tiempo de inactividad  -->
	<script type="text/javascript" src="<c:url value="/resources/js/sessionTimer.js" />"></script>
	<script type="text/javascript">
	window.onload = function() {
		timeIt();
	}
	</script>
</head>
<body>
<!--Se agrega para el tiempo de inactividad  -->
 <form name="timerform">
		<input type="hidden" name="timerSession" size="7" value="${respuesta.sessionTimeout}:00" />
		<input type="hidden" name="originalmin" value="" />
		<input type="hidden" name="originalsec" value="" />
	</form>
	<div id="presupuesto-loading" class="presupuesto-loading">
		<div class="icono-loading"></div>
	</div>
	<script type="text/javascript" src="<c:url value="/ext/ext-all.js" />"></script>
	<script type="text/javascript">
	Ext.Loader.setConfig({enabled: true});
	var ejercicioActual = Ext.Date.format(new Date(), 'Y');
	var ejercicioSiguiente = parseInt(ejercicioActual) + 1;
	</script>
	<script type="text/javascript" src="<c:url value="/app/modules/index.js" />"></script>

</body>
</html>