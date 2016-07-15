'use strict';
 
App.factory('LoginService', ['$http', '$q', 'token', '$location', '$window', function($http, $q, token, $location, $window){
 
    return {
    	  login: function (email, password) {
    		  console.log("login service");
              $.ajax({
                  url: 'http://localhost:8080/ecommerce/authenticate',
                  type: 'POST',
                  dataType: 'json',
                  beforeSend: function (xhr) {
                      //kendo.mobile.application.showLoading();
                      xhr.setRequestHeader(
                          'Authorization',
                          'Basic ' + btoa(email + ":" + password));
                  },
                  complete: function (datos) {
                	  var token = "";
                      //kendo.mobile.application.hideLoading();
                      //$("#emailLogin, #passLogin").parent().removeClass("error");
                      switch (datos.status) {
                          case 401:
                              // No autorizado
                        	  console.log(" 1 ");
                              break;
                          case 404:
                              // No existe el usuario
                        	  console.log(" 1 ");
                              break;
                          case 204:
                              // No existe el usuario
                        	  console.log(" 1 ");
                              break;
                          case 500:
                              /*$("#contentAlertHome").html("Error interno del servidor");
                              openModal('modalview-alert-home');*/
                        	  console.log(" 1 ");
                              break;
                          case 200:
                              var data = JSON.parse(datos.responseText);
                              token = data.token;
                              console.log(" 1 " + token);  
                              //$location.path("/static/usuario");
                              //console.log($location.path());
                              //console.log($window.location.href);
                              $window.location.href = "UsuarioManagement";

                              break;
                          default:
                              // Sin internet
                        	  console.log(" 1 Sin internet");
                              break;
                      }
                  },
                  error: function (xhr, ajaxOptions, thrownError) {
                	  console.log(" 1 xhr");
                  }
              });
          }       
         
    };
 
}]);