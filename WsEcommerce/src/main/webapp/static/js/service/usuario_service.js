'use strict';
 
App.factory('UsuarioService', ['$http', '$q', 'token', function($http, $q, token){
 
    return {
    		
		    listarTipoDocumentos: function() {
		            var settings = {
		                 "async": true,
		                 "crossDomain": true,
		                 "url": "http://localhost:8080/ecommerce/tipodocumento/listar",
		                 "method": "GET"
		             }
		
		             return $.ajax(settings)
		                 .done(
		                     function (response) {
		                         console.log(response);
		                         return response.data;
		                     })
		                 .fail(
		                  function(errResponse){
		                                 console.error('Error while tipodocumento users');
		                                 return $q.reject(errResponse);
		                  });
		     },
            listar: function() {
                   var settings = {
                        "async": true,
                        "crossDomain": true,
                        "url": "http://localhost:8080/ecommerce/usuario/listar",
                        "method": "GET",
                        "headers": {
                        "token": token,
                        "cache-control": "no-cache",
                        }
                    }

                    return $.ajax(settings)
                        .done(
                            function (response) {
                                console.log(response);
                                return response.data;
                            })
                        .fail(
                         function(errResponse){
                                        console.error('Error while fetching users');
                                        return $q.reject(errResponse);
                         });
            },
            
            obtenerPorId: function(id) {
               var settings = {
                "async": true,
                "crossDomain": true,
                "url": "http://localhost:8080/ecommerce/cliente/obtenerPorId?id="+id,
                "method": "GET",
                "headers": {
                "cache-control": "no-cache",
                "token": token,
                }
                }

               return $.ajax(settings)
                        .done(
                            function (response) {
                                console.log(response);
                                return response.data;
                            })
                        .fail(
                         function(errResponse){
                                        console.error('Error while getting users');
                                        return $q.reject(errResponse);
                         });

            },
             
            agregar: function(usuario){
                   var settings = {
                    "async": true,
                    "crossDomain": true,
                    "url": "http://localhost:8080/ecommerce/usuario/agregar",
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
                            function (response) {
                                console.log(response);
                                return response.data;
                            })
                        .fail(
                         function(errResponse){
                                        console.error('Error while creating users');
                                        return $q.reject(errResponse);
                         });

            },
             
            actualizar: function(usuario, id){

                    var settings = {
                    "async": true,
                    "crossDomain": true,
                    "url": "http://localhost:8080/ecommerce/usuario/actualizar",
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
                            function (response) {
                                console.log(response);
                                return response.data;
                            })
                        .fail(
                         function(errResponse){
                                        console.error('Error while updating users');
                                        return $q.reject(errResponse);
                         });

            },
             
            eliminar: function(id){
                    var settings = {
                        "async": true,
                        "crossDomain": true,
                        "url": "http://localhost:8080/ecommerce/usuario/eliminar?id="+id,
                        "method": "DELETE",
                        "headers": {
                        "token": token,
                        "cache-control": "no-cache",
                        "postman-token": "b15f0ac1-16de-065c-cf3b-f8b34d751b5f"
                        }
                    }

                    return $.ajax(settings)
                        .done(
                            function (response) {
                                console.log(response);
                                return response.data;
                            })
                        .fail(
                         function(errResponse){
                                        console.error('Error while deleting users');
                                        return $q.reject(errResponse);
                         });

            }     
         
    };
 
}]);