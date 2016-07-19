'use strict';

var App = angular.module('myApp', [ 'ngRoute' ]);
App.value('token',  document.getElementById("token").innerHTML);
App.config(function($routeProvider) {
	$routeProvider
	.when('/', {
		templateUrl : 'static/home'
	})
	.when('/usuario', {
		templateUrl : 'static/usuario',
		controller : 'UsuarioController'
	}).otherwise({
		redirectTo : '/'
	});
	var divOne = document.getElementById('token');
	divOne.style.display='none';
});