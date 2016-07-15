'use strict';

var App = angular.module('myApp', [ 'ngRoute' ]);
App.value('token', 0);
App.config(function($routeProvider) {
	$routeProvider
	.when('/', {
		templateUrl : 'views/home.jsp',
		controller : 'HomeController'
	})
	.when('/login', {
		templateUrl : 'views/Login.jsp',
		controller : 'LoginController'
	})
	.when('/usuario', {
		templateUrl : 'views/UsuarioManagement.jsp',
		controller : 'UsuarioController'
	}).otherwise({
		redirectTo : '/'
	});
});