<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Sistema Integral de Gestión Gubernamental</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/ext-all.css" />" />
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/modules.css" />" />
	<style type="text/css">
	#permisos-usuario, #permisos {
		float: left
	}
	
	#permisos {
		margin-left: 50px
	}
	</style>
	
</head>
<body>
	<div class="module-title">
		<div class="title-icon"></div>
		<h1>Usuarios &gt; Asignar Roles</h1>
	</div>
	
	<div id="form-buscar-usuario" class="module-widget"></div>
	<div id="arboles-permisos" class="module-widget"></div>
	
	<script type="text/javascript" src="<c:url value="/ext/ext-all-debug.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/ext-override.js" />"></script>
	<script type="text/javascript" src="<c:url value="/ext/locale/ext-lang-es.js" />"></script>
	<script type="text/javascript">
	Ext.Loader.setConfig({enabled: true});
	var appFolder = '<c:url value="/app" />';
	</script>
	<script type="text/javascript" src="<c:url value="/app/modules/usuario/asignarRol.js" />"></script>
</body>
</html>