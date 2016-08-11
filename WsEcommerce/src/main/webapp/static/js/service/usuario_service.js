'use strict';
 
App.factory('UsuarioService', ['$http', '$q', 'token', 'servidor', function($http, $q, token, servidor){
 
    return {
		    	desencriptar: function(contrasena) {
		            var settings = {
		                 "async": true,
		                 "crossDomain": true,
		                 "url": servidor + "/usuario/desencriptar?cadena="+contrasena,
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
		    listarTipoDocumentos: function() {
		            var settings = {
		                 "async": true,
		                 "crossDomain": true,
		                 "url": servidor + "/tipodocumento/listar",
		                 "method": "GET"
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
		     listarPorVendedor : function(id) {
                 var settings = {
                         "async": true,
                         "crossDomain": true,
                         "url": servidor + "/usuario/listarPorVendedor?id="+id,
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
                        "url": servidor + "/usuario/listar",
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
                "url": servidor + "/cliente/obtenerPorId?id="+id,
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
               .fail(
                function(errResponse, statusText, xhr){
               	 var status = xhr.status;   
      			  	 console.log(status);
                    console.error('Error while getting user');
                    return $q.reject(errResponse);
                });

            },
             
            agregar: function(usuario){
                   var settings = {
                    "async": true,
                    "crossDomain": true,
                    "url": servidor + "/usuario/agregar",
                    "method": "POST",
                    "headers": {
                    "token": token,
                    "content-type": "application/json",
                    "cache-control": "no-cache"
                    },
                    "processData": false,
                    "data": JSON.stringify(usuario)
                    }

                   return $.ajax(settings)
                   .done(
                   		function(response, statusText, xhr){
                   			  var status = xhr.status; 
                   			  if(status==201){
                   				  alert("Bodeguero creado satisfactoriamente");
                   			  }
                   			  console.log(status);
                   			})
                   .error( function(jqXHR, textStatus, errorThrown) {
                	   var status = jqXHR.status; 
                	   if(status==401){
                		   alert("Sus crendenciales han expirado. Por favor, ingrese nuevamente.");
                	   }
                	   if(status==409){
                		   alert("Usuario ya existe");
                	   }
        			  	 console.log(status);
                      console.error('Error while creating users');
                      return $q.reject(errResponse);
                	});

            },
             
            actualizar: function(usuario, id){

                    var settings = {
                    "async": true,
                    "crossDomain": true,
                    "url": servidor + "/usuario/actualizar",
                    "method": "PUT",
                    "headers": {
                    "content-type": "application/json",
                    "token": token,
                    "cache-control": "no-cache"
                    },
                    "processData": false,
                    "data": JSON.stringify(usuario)
                    }

                    return $.ajax(settings)
                    .done(
                    		function(response, statusText, xhr){
                    			  var status = xhr.status;   
                    			  console.log(status);
                    			  if(status==200){
                       				  alert("Bodeguero se ha actualizado satisfactoriamente");
                       			  }
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
                        "url": servidor + "/usuario/eliminar?id="+id,
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
                        			  console.log(status);
                        			  if(status==204)
                        			  {
                        				  console.log("Elimino satisfactoriamente");
                        			  }
                        			})
                        .fail(
                         function(errResponse, statusText, xhr){
                        	 var status = xhr.status;   
               			  	 console.log(status);
                             console.error('Error while deleting users');
                             return $q.reject(errResponse);
                         });

            }     
         
    };
 
}]);