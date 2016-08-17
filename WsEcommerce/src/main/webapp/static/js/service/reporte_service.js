'use strict';
 
App.factory('ReporteService', ['$http', '$q', 'token', 'servidor', function($http, $q, token, servidor){
    return {
    	 
    	listar: function(id) {
            var settings = {
                 "async": true,
                 "crossDomain": true,
                 "url": servidor + "/reporte/listarReporteRegistrosPorVendedor?id=" +id,
                 "method": "GET",
                 "headers": {
                        "token": token,
                        "cache-control": "no-cache",
                 }
             }

            return $.ajax(settings)
               .done(
               		function(response, statusText, xhr){
               			  var status = xhr.status;   
               			  console.log(status);
               			})
               .error( function(jqXHR, textStatus, errorThrown) {
            	   var status = jqXHR.status; 
            	   if(status==401){
            		   alert("Sus crendenciales han expirado. Por favor, ingrese nuevamente.");
            	   }
    			  	 console.log(status);
    			  	 return $q.reject(errResponse);
            	});
     }
         
    };
 
}]);