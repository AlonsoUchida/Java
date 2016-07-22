'use strict';

var App = angular.module('myApp', [ 'ngRoute' ]);
App.value('token',  document.getElementById("token").innerHTML);
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
	.otherwise({
		redirectTo : '/'
	});
	var divOne = document.getElementById('token');
	divOne.style.display='none';
});

