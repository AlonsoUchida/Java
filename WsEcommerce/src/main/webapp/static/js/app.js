'use strict';

var App = angular.module('myApp', [ 'ngRoute', 'ngFileUpload']);
App.value('token',  document.getElementById("token") != null ? document.getElementById("token").innerHTML : null);
App.value('usuarioId', document.getElementById("usuario") != null ? document.getElementById("usuario").innerHTML : null);
App.value('servidor', 'http://localhost:8080/ecommerce');
//App.value('servidor', 'http://192.168.1.201:8080/ecommerce-desarrollo');
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
	.otherwise({
		redirectTo : '/'
	});
	if(document.getElementById("token") != null){
		var divOne = document.getElementById('token');
		divOne.style.display='none';
	};
	if(document.getElementById("usuario") != null){
		var divOne = document.getElementById('usuario');
		divOne.style.display='none';
	};
});

