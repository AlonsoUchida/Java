'use strict';
 
App.factory('LoginService', ['$http', '$q', 'token', '$location', '$window', function($http, $q, token, $location, $window){
	 var token = "";
	 var servidor = "http://localhost:8080/ecommerce";
	 function redirectToIndex() {
		  console.log("redirectToIndex");
          $.ajax({
              url: servidor + "/index",
              type: 'GET',
              beforeSend: function (xhr) {
                  xhr.setRequestHeader('Token', token);
              },
              complete: function (datos) {
            	alert("Ingreso existosamente");
              },
              error: function (xhr, ajaxOptions, thrownError) {
            	  console.log(" 1 xhr");
              }
          });
      };
    return {
    	  login: function (email, password) {
    		  console.log("login service");
              $.ajax({
                  url: servidor + "/authenticate",
                  type: 'POST',
                  dataType: 'json',
                  beforeSend: function (xhr) {
                      //kendo.mobile.application.showLoading();
                      xhr.setRequestHeader(
                          'Authorization',
                          'Basic ' + btoa(email + ":" + password));
                  },
                  complete: function (datos) {
                      //kendo.mobile.application.hideLoading();
                      switch (datos.status) {
                          case 401:
                              // No autorizado
                        	  console.log(" 1 ");
                              break;
                          case 204:
                              // No existe el usuario
                        	  console.log(" 1 ");
                              break;
                          case 500:
                        	  console.log(" 1 ");
                              break;
                          case 200:
                              var data = JSON.parse(datos.responseText);
                              token = data.token;
                              console.log(" 1 " + token);  
                              redirectToIndex();
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

