'use strict';
 
App.controller('UsuarioController', ['$scope', 'UsuarioService', 'token', function($scope, UsuarioService, token) {
          var self = this;
          self.usuario = {id:null, nombre:'',apellido:'',correo:'', password:'', genero:'', 
        		  id_tipoDocumento:'', valorDocumento:'' };
          self.usuarios =[];      
          
          console.log('UsuarioController:' + token);
         
          self.listar = function(){
        	  UsuarioService.listar()
                  .then(
                               function(d) {
                                    self.usuarios = d;
                               },
                                function(errResponse){
                                    console.error('Error while fetching Currencies');
                                }
                       );
          };
            
          self.agregar = function(usuario){
        	  UsuarioService.agregar(usuario)
                      .then(
                    		  self.listar, 
                              function(errResponse){
                                   console.error('Error while creating Usuario.');
                              } 
                  );
          };
 
         self.actualizar = function(usuario){
        	 UsuarioService.actualizar(usuario)
                      .then(
                              self.listar, 
                              function(errResponse){
                                   console.error('Error while updating User.');
                              } 
                  );
          };
 
         self.eliminar = function(id){
        	 UsuarioService.eliminar(id)
                      .then(
                              self.listar, 
                              function(errResponse){
                                   console.error('Error while deleting User.');
                              } 
                  );
          };
 
          self.listar();
 
          self.submit = function() {
              if(self.usuario.id===null){
                  console.log('Saving New User', self.usuario);    
                  self.agregar(self.usuario);
              }else{
                  self.actualizar(self.usuario, self.usuario.id);
                  console.log('User updated with id ', self.usuario.id);
              }
              self.reset();
          };
               
          self.edit = function(id){
              console.log('id to be edited', id);
              for(var i = 0; i < self.usuario.length; i++){
                  if(self.usuarios[i].id === id) {
                     self.usuario = angular.copy(self.usuarios[i]);
                     break;
                  }
              }
          };
               
          self.remove = function(id){
              console.log('id to be deleted', id);
              if(self.usuario.id === id) {
                 self.reset();
              }
              self.eliminar(id);
          };
 
           
          self.reset = function(){
              self.usuario= {id:null, nombre:'', apellido:'',correo:'', password:'', genero:'', 
            		  id_tipoDocumento:'', valorDocumento:'' };
              $scope.myForm.$setPristine(); //reset Form
          };
 
      }]);