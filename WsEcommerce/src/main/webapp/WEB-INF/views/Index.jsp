<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- SCROLLS -->
<!-- load bootstrap and fontawesome via CDN -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<!--  <link rel="stylesheet"
	href="https://netdna.bootstrapcdn.com/font-awesome/4.0.0/css/font-awesome.css" />-->
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular-route.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular-cookies.js"></script>

<script src="https://ajax.aspnetcdn.com/ajax/4.0/1/MicrosoftAjax.js"></script>
<script src="<c:url value='/static/js/libs/ng-file-upload-bower/ng-file-upload-shim.js' />"></script>
<script src="<c:url value='/static/js/libs/ng-file-upload-bower/ng-file-upload.js' />"></script>

</head>

<body ng-app="myApp">
	<P id="token">${tkn}</P>
	
	<script src="<c:url value='/static/js/app.js' />"></script>
	<script src="<c:url value='/static/js/service/usuario_service.js' />"></script>
	<script
		src="<c:url value='/static/js/controller/usuario_controller.js' />"></script>
	<script src="<c:url value='/static/js/service/tienda_service.js' />"></script>
	<script
		src="<c:url value='/static/js/controller/tienda_controller.js' />"></script>
	<script src="<c:url value='/static/js/service/direccion_service.js' />"></script>
	<script
		src="<c:url value='/static/js/controller/direccion_controller.js' />"></script>
	<script src="<c:url value='/static/js/service/imagen_service.js' />"></script>
	<script
		src="<c:url value='/static/js/controller/imagen_controller.js' />"></script>
	<!-- HEADER AND NAVBAR -->
	<header>
		<nav class="navbar navbar-default">
			<div class="container">
				<div class="navbar-header">
					<a class="navbar-brand" href="/">Administración</a>
				</div>

				<ul class="nav navbar-nav navbar-right">
					<li><a href="#/"><i class="fa fa-home"></i> Inicio </a></li>
					<li><a href="#/usuario"><i class="fa fa-comment"></i>Bodegueros</a></li>
					<li><a href="#/tienda"><i class="fa fa-comment"></i>Tiendas</a></li>
					<li><a href="#/direccion"><i class="fa fa-comment"></i>Direcciones</a></li>
					<li><a href="#/imagen"><i class="fa fa-comment"></i>Imagenes</a></li>
					<li><a href="/ecommerce/"><i class="fa fa-comment"></i>Cerrar Sesión</a></li>
				</ul>
			</div>
		</nav>
	</header>

	<!-- MAIN CONTENT AND INJECTED VIEWS -->
	<div id="main">
		<div ng-view></div>
	</div>

	
</body>
</html>