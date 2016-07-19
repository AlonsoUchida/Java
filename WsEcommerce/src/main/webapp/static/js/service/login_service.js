'use strict';
 
App.factory('LoginService', ['$http', '$q', '$location', '$window', function($http, $q, $location, $window){
	 var token = "";
	 var servidor = "http://localhost:8080/ecommerce";
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
                              $window.location.href = $window.location.href + "index?tkn=" + token;
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

