'use strict';

var App = angular.module('myApp', [ 'ngRoute', 'ngFileUpload', 'ngMaterial', 'ngMessages', 'material.svgAssetsCache']);
App.value('token',  document.getElementById("token") != null ? document.getElementById("token").innerHTML : null);
App.value('usuarioId', document.getElementById("usuario") != null ? document.getElementById("usuario").innerHTML : null);
App.value('tipoUsuario', document.getElementById("tipoUsuario") != null ? document.getElementById("tipoUsuario").innerHTML : null);

//NOTA: Cambiar dependiendo del servidor el value, tambien en cerrar sesion en el Index 
App.value('servidor', 'http://localhost:8080/ecommerce');
//App.value('servidor', 'http://54.187.108.240:8080/ecommerce');
//App.value('servidor', 'http://54.187.108.240:8080/ecommerce-desarrollo');

App.config(function($routeProvider, $mdDateLocaleProvider) {
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
	if(document.getElementById("tipoUsuario") != null){
		var divOne = document.getElementById('tipoUsuario');
		divOne.style.display='none';
	};
	
	//Configurando el formato de fecha
	$mdDateLocaleProvider.formatDate = function(date) {
        return moment(date).format('DD/MM/YYYY');
     };
     
});

App.filter('startFrom', function() {
	  return function(input, start) {
	      start = +start; //parse to int
	      if(input!=null){
	    	  return input.slice(start);
	      }else{
	    	  return null;
	      }  
	  }
	});

