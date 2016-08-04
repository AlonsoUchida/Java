'use strict';
 
App.factory('LoginService', ['$http', '$q', '$window', 'servidor', function($http, $q, $window, servidor){
	 var token = "";
	 var idUsuario = "";
	 var tipoUsuario = "";
    return {
    	  cerrar: function () {
    		  console.log("$window.location.href", $window.location.href);
    		  //$window.location.href = $window.location.href;
    	  },
    	  login: function (email, password) {
    		  console.log("login service");
              $.ajax({
                  url: servidor + "/authenticate_vendedor",
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
                        	  alert("Crendenciales Incorrectas");
                              break;
                          case 204:
                              // No existe el usuario
                        	  alert("No existe el usuario");
                              break;
                          case 500:
                        	  alert("Error en el servicio");
                              break;
                          case 200:
                              var data = JSON.parse(datos.responseText);
                              token = data.token;
                              idUsuario = data.idUsuario;
                              tipoUsuario = data.tipo;
                              $window.location.href = $window.location.href + "index?tkn=" + token + "&idUsuario=" +idUsuario + "&tipoUsuario=" + tipoUsuario;
                              break;
                          default:
                              // Sin internet
                          	  alert("Sin internet");
                              break;
                      }
                  },
                  error: function (xhr, ajaxOptions, thrownError) {
                	  console.log("xhr");
                  }
              });
          }
         
    };
 
}]);

