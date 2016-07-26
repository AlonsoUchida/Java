'use strict';

var App = angular.module('myApp', [ 'ngRoute', 'ngFileUpload']);
App.value('token',  document.getElementById("token") != null ? document.getElementById("token").innerHTML : null);
App.value('servidor', 'http://localhost:8080/ecommerce');
App.config(function($routeProvider) {
	$routeProvider
	.when('/', {
		templateUrl : 'static/home'
	})
	.when('/usuario', {
		templateUrl : 'static/usuario',
		controller : 'UsuarioController'
	})
	.when('/tienda', {
		templateUrl : 'static/tienda',
		controller : 'TiendaController'
	})
	.when('/direccion', {
		templateUrl : 'static/direccion',
		controller : 'DireccionController'
	})
	.when('/imagen', {
		templateUrl : 'static/imagen',
		controller : 'ImagenController'
	})
	.when('/cerrar', {
		templateUrl : 'static/cerrar'
	})
	.otherwise({
		redirectTo : '/'
	});
	if(document.getElementById("token") != null){
		var divOne = document.getElementById('token');
		divOne.style.display='none';
	};
});

