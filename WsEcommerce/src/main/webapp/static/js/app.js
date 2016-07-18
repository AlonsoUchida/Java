'use strict';

var App = angular.module('myApp', [ 'ngRoute' ]);
App.value('token', 0);
App.config(function($routeProvider) {
	$routeProvider
	.when('/', {
		templateUrl : 'views/Login.jsp',
		controller : 'LoginController'
	})
	.when('/usuario', {
		templateUrl : 'views/Usuario.jsp',
		controller : 'UsuarioController'
	}).otherwise({
		redirectTo : '/'
	});
});