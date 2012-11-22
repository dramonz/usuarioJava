<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
	<link type="text/css" rel="stylesheet" media="screen" href="<c:url value="/resources/css/ext-all.css" />" />
	<link type="text/css" rel="stylesheet" media="screen" href="<c:url value="/resources/css/modules.css" />" />
	<title>Usuario</title>
	
</head>
<body>
	<div class="module-title">
		<div class="title-icon"></div>
		<h1>Usuario </h1>
	</div>
	<div id="form-usuario" class="grid-buscar-proyectos"></div>
	
	<script type="text/javascript" src="<c:url value="/ext/ext-all.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/ext-override.js" />"></script>
	<script type="text/javascript" src="<c:url value="/ext/locale/ext-lang-es.js" />"></script>
	<script type="text/javascript">
	var usuario = "${usuario}";
	var area = "${area}";
	var unidad = "${unidad}";
	var correo = "${correo}";
	var dependencia = "${dependencia}";
	var puesto = "${puesto}";
	var rol = "${rol}";
	var username = "${username}";
		
	Ext.Loader.setConfig({
		enabled : true
	});
	</script>
	<script type="text/javascript" src="<c:url value="/app/modules/usuario/usuarioDetalle.js" />"></script>
</body>
</html>

