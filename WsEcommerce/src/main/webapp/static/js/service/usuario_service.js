'use strict';
 
App.factory('UsuarioService', ['$http', '$q', 'token', function($http, $q, token){
 
    return {
         
            listar: function() {
                    return $http.get('http://localhost:8080/ecommerce/usuario/listar')
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching users');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
            
            obtenerPorId: function(id) {
                return $http.get('http://localhost:8080/ecommerce/usuario/obtenerPorId', id)
                        .then(
                                function(response){
                                    return response.data;
                                }, 
                                function(errResponse){
                                    console.error('Error while fetching users');
                                    return $q.reject(errResponse);
                                }
                        );
            },
             
            agregar: function(usuario){
                    return $http.post('http://localhost:8080/ecommerce/usuario/agregar', usuario)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while creating user');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            actualizar: function(usuario, id){
                    return $http.put('http://localhost:8080/ecommerce/usuario/actualizar', usuario)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while updating user');
                                        return $q.reject(errResponse);
                                    }
                            );
            }/*,
             
            eliminar: function(id){
                    return $http.delete('http://localhost:8080/ecommerce/usuario/eliminar', id)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while deleting user');
                                        return $q.reject(errResponse);
                                    }
                            );
            }*/
         
    };
 
}]);