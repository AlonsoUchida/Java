<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html ng-app="myApp">
<head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bodegas Perú - Panel de Administración</title>

<link href="https://cdn.rawgit.com/cornflourblue/angular-registration-login-example/master/app-content/app.css" rel="stylesheet" />
		
	<link rel="stylesheet" href="https://cdn.gitcdn.link/cdn/angular/bower-material/v1.1.0-rc.5/angular-material.css"/>
	<link rel="stylesheet" href="https://material.angularjs.org/1.1.0-rc.5/docs.css"/>
	<!--  <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.0/css/font-awesome.css" />-->
	
	<!-- Jquery -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js"></script>
	
	<!-- Angular Material requires Angular.js Libraries -->
  <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.5.3/angular.min.js"></script>
  <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.5.3/angular-animate.min.js"></script>
  <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.5.3/angular-aria.min.js"></script>
  <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.5.3/angular-messages.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular-route.js"></script>

  <!-- Angular Material Library -->
  <script src="https://cdn.gitcdn.link/cdn/angular/bower-material/v1.1.0-rc.5/angular-material.js"></script>  
  <script src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/t-114/svg-assets-cache.js"></script>
  
  <!-- Moment JS -->
 <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.6/moment.js"></script>
	
  <script src="https://ajax.aspnetcdn.com/ajax/4.0/1/MicrosoftAjax.js"></script>
  <script src="<c:url value='/static/js/libs/ng-file-upload-bower/ng-file-upload-shim.js' />"></script>
  <script src="<c:url value='/static/js/libs/ng-file-upload-bower/ng-file-upload.js' />"></script>
  
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
  
  <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
  
</head>
<body ng-controller="LoginController as self">
	
	<div class="container">
	<div id="logo-login" class="text-center">
		<img src="<c:url value='/static/image/logo-BP.png' />" />
	</div>
<div class="jumbotron">

	<form name="form" ng-submit="self.login()" role="form">
		<div class="form-group">
			<label for="username">Usuario</label> <i class="fa fa-key"></i> <input
				type="text" name="username" id="username" class="form-control"
				ng-model="self.username" required /> <span
				ng-show="form.username.$dirty && form.username.$error.required"
				class="help-block">Usuario es requerido</span>
		</div>
		<div class="form-group">
			<label for="password">Contraseña</label> <i class="fa fa-lock"></i> <input
				type="password" name="password" id="password" class="form-control"
				ng-model="self.password" required /> <span
				ng-show="form.password.$dirty && form.password.$error.required"
				class="help-block">Contraseña es requerida</span>
		</div>
		<div class="form-actions">
			<button type="submit" ng-disabled="form.$invalid || dataLoading"
				class="btn btn-success">Ingresar</button>		
		</div>
	</form>
	</div>
</div>
	<script src="<c:url value='/static/js/app.js' />"></script>
	<script src="<c:url value='/static/js/service/login_service.js' />"></script>
	<script src="<c:url value='/static/js/controller/login_controller.js' />"></script>

</body>
</html>
