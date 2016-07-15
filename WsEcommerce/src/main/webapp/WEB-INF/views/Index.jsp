<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- SCROLLS -->
<!-- load bootstrap and fontawesome via CDN -->
<link rel="stylesheet"
	href="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="https://netdna.bootstrapcdn.com/font-awesome/4.0.0/css/font-awesome.css" />

	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular-route.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular-cookies.js"></script>

	<script src="<c:url value='/static/js/app.js' />"></script>
	<script src="<c:url value='/static/js/service/login_service.js' />"></script>
	<script src="<c:url value='/static/js/controller/login_controller.js' />"></script>
</head>
<body ng-app="myApp">

	<!-- HEADER AND NAVBAR -->
	<header>
		<nav class="navbar navbar-default">
			<div class="container">
				<div class="navbar-header">
					<a class="navbar-brand" href="/">Angular Routing Example</a>
				</div>

				<ul class="nav navbar-nav navbar-right">
					<li><a href="#"><i class="fa fa-home"></i> Home </a></li>
					<li><a href="#login"><i class="fa fa-shield"></i> Login </a></li>
					<li><a href="#usuario"><i class="fa fa-comment"></i>Administración
							de Usuario</a></li>
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