'use strict';
 
App.factory('TiendaService', ['$http', '$q', 'token', function($http, $q, token){
 
    return {
    		
		    listarBancos: function() {
		            var settings = {
		                 "async": true,
		                 "crossDomain": true,
		                 "url": "http://localhost:8080/ecommerce/banco/listar",
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
		     },
            listar: function() {
                   var settings = {
                        "async": true,
                        "crossDomain": true,
                        "url": "http://localhost:8080/ecommerce/tienda/listar",
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
            },
            
            obtenerPorId: function(id) {
               var settings = {
                "async": true,
                "crossDomain": true,
                "url": "http://localhost:8080/ecommerce/tienda/obtenerPorId?id="+id,
                "method": "GET",
                "headers": {
                "cache-control": "no-cache",
                "token": token,
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

            },
             
            agregar: function(tienda){
                   var settings = {
                    "async": true,
                    "crossDomain": true,
                    "url": "http://localhost:8080/ecommerce/tienda/agregar",
                    "method": "POST",
                    "headers": {
                    "token": token,
                    "content-type": "application/json",
                    "cache-control": "no-cache"
                    },
                    "processData": false,
                    "data": JSON.stringify(tienda)
                    }

                   return $.ajax(settings)
                   .done(
                   		function(response, statusText, xhr){
                   			  var status = xhr.status;   
                   			if(status==201){
                 				  alert("Tienda creada satisfactoriamente");
                 			  }
                   			  console.log(status);
                   			})
                   .error( function(jqXHR, textStatus, errorThrown) {
                	   var status = jqXHR.status; 
                	   if(status==401){
                		   alert("Sus crendenciales han expirado. Por favor, ingrese nuevamente.");
                	   }
                	   if(status==409){
                		   alert("Tienda ya existe");
                	   }
        			  	 console.log(status);
                      return $q.reject(errResponse);
                	});

            },
             
            actualizar: function(tienda, id){
            	console.log("actualizar:" + tienda);
                    var settings = {
                    "async": true,
                    "crossDomain": true,
                    "url": "http://localhost:8080/ecommerce/tienda/actualizar",
                    "method": "PUT",
                    "headers": {
                    "content-type": "application/json",
                    "token": token,
                    "cache-control": "no-cache"
                    },
                    "processData": false,
                    "data": JSON.stringify(tienda)
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

            },
             
            eliminar: function(id){
                    var settings = {
                        "async": true,
                        "crossDomain": true,
                        "url": "http://localhost:8080/ecommerce/tienda/eliminar?id="+id,
                        "method": "DELETE",
                        "headers": {
                        "token": token,
                        "cache-control": "no-cache"
                        }
                    }

                    return $.ajax(settings)
                    .done(
                    		function(response, statusText, xhr){
                    			  var status = xhr.status;
                    			  if(status==204)
                    			  {
                    				  console.log("Elimino satisfactoriamente");
                    			  }
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