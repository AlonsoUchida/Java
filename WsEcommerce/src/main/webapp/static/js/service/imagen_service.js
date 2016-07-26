'use strict';
 
App.factory('ImagenService', ['$http', '$q', 'token', 'servidor', function($http, $q, token, servidor){
 
    return {
    		
	    	listarPorTienda : function(id) {
				var settings = {
					"async" : true,
					"crossDomain" : true,
					"url" : servidor
							+ "/tienda/imagen/listarImagenesPorTienda?id="+ id,
					"method" : "GET",
					"headers" : {
						"token" : token,
						"cache-control" : "no-cache",
					}
				}
	
				return $
						.ajax(settings)
						.done(
								function(response,
										statusText, xhr) {
									var status = xhr.status;
									console.log(status);
								})
						.error(
								function(jqXHR, textStatus,
										errorThrown) {
									var status = jqXHR.status;
									if (status == 401) {
										alert("Sus crendenciales han expirado. Por favor, ingrese nuevamente.");
									}
									console.log(status);
									return $q
											.reject(errResponse);
								});
			},
	    	listarTiendas : function() {
				var settings = {
					"async" : true,
					"crossDomain" : true,
					"url" : servidor + "/tienda/listar",
					"method" : "GET",
					"headers" : {
						"token" : token,
						"cache-control" : "no-cache",
					}
				}
	
				return $
						.ajax(settings)
						.done(
								function(response,
										statusText, xhr) {
									var status = xhr.status;
									console.log(status);
								})
						.error(
								function(jqXHR, textStatus,
										errorThrown) {
									var status = jqXHR.status;
									if (status == 401) {
										alert("Sus crendenciales han expirado. Por favor, ingrese nuevamente.");
									}
									console.log(status);
									return $q
											.reject(errResponse);
								});
			},
            listar: function() {
                   var settings = {
                        "async": true,
                        "crossDomain": true,
                        "url": servidor + "/tienda/imagen/listar",
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
                "url": servidor + "/tienda/imagen/obtenerPorId?id="+id,
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
                    console.error('Error while getting imagen');
                    return $q.reject(errResponse);
                });

            },
             
            agregar: function(usuario){
                   var settings = {
                    "async": true,
                    "crossDomain": true,
                    "url": servidor +"/tienda/imagen/agregar",
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
                   				  alert("La imagen creado satisfactoriamente");
                   			  }
                   			  console.log(status);
                   			})
                   .error( function(jqXHR, textStatus, errorThrown) {
                	   var status = jqXHR.status; 
                	   if(status==401){
                		   alert("Sus crendenciales han expirado. Por favor, ingrese nuevamente.");
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
                    "url": servidor + "/tienda/imagen/actualizar",
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
                       				  alert("La imagen se ha actualizado satisfactoriamente");
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
                        "url": servidor + "/tienda/imagen/eliminar?id="+id,
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
                             console.error('Error while deleting imagenes');
                             return $q.reject(errResponse);
                         });

            }     
         
    };
 
}]);