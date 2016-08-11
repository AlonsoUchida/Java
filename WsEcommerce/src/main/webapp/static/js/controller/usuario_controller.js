'use strict';
App.controller('UsuarioController', ['$scope', '$filter', 'UsuarioService', 'usuarioId', 'tipoUsuario', 
                                     function($scope, $filter, UsuarioService, usuarioId, tipoUsuario) {
          var self = this;
          self.usuario = {id:null, nombre:'',apellido:'',correo:'', password:'', genero:'', 
        		  id_tipoDocumento:'', valorDocumento:'', direccionFiscal: '', fechaNacimiento: '', id_vendedor: ''  };
        
          $scope.fechaNacimiento = new Date();
          $scope.generos = [{"id" : "M", "descripcion" : "Hombre"},{"id" : "F", "descripcion" : "Mujer"}];
          self.genero = "";
          self.tipoDocumento = "";

          $scope.actualizarGenero = function (genero) {
             self.usuario.genero = genero.id;
             console.log("actualizarGenero:" + self.usuario.genero);             
          };

          $scope.actualizarTipoDocumento = function (tipoDocumento) {
        	  console.log(tipoDocumento);
             self.usuario.id_tipoDocumento = tipoDocumento.id;
             console.log("actualizarTipoDocumento:" + self.usuario.id_tipoDocumento);
          };

          self.listarTipoDocumentos = function(){
        	  UsuarioService.listarTipoDocumentos()
                  .then(
                               function(d) {  
                            	   $scope.tipoDocumentos = d;
                            	   $scope.$apply();        
                               },
                                function(errResponse){
                                    console.error('Error while fetching Currencies');
                                }
                       );
          };
          
          
          self.listar = function(){
        	  UsuarioService.listar()
                  .then(
                               function(d) {  
                            	   $scope.usuarios = d;                           	  
                            	   $scope.$apply();       
                               },
                                function(errResponse){
                                    console.error('Error while fetching Currencies');
                                }
                       );
          };
          
          self.listarPorVendedor = function(id){
        	  UsuarioService.listarPorVendedor(id)
                  .then(
                               function(d) {  
                            	   $scope.usuarios = d;
                            	   $scope.$apply();       
                               },
                                function(errResponse){
                                    console.error('Error while fetching Currencies');
                                }
                       );
          };
            
          self.agregar = function(usuario){
        	  UsuarioService.agregar(usuario)
                      .then(
                    		  function(){
                    			  self.listarUsuarios(usuarioId, tipoUsuario);
                    		  }, 
                              function(errResponse){
                                   console.error('Error while creating Usuario.');
                              } 
                  );
          };
 
         self.actualizar = function(usuario){
        	 UsuarioService.actualizar(usuario)
                      .then(
                    		  function(){
                    			  self.listarUsuarios(usuarioId, tipoUsuario);
                    		  }, 
                              function(errResponse){
                                   console.error('Error while updating User.');
                              } 
                  );
          };
 
         self.eliminar = function(id){
        	 UsuarioService.eliminar(id)
                      .then(
                    		  function(){
                    			  self.listarUsuarios(usuarioId, tipoUsuario);
                    		  },  
                              function(errResponse){
                                   console.error('Error while deleting User.');
                              } 
                  );
          };
          
          self.desencriptar = function(contrasena){
         	 UsuarioService.desencriptar(contrasena)
                       .then(
                     		  function(password){
                     			  self.usuario.password = password;
                     			  console.log('desencriptar password', self.usuario.password);
                     		  }, 
                               function(errResponse){
                                    console.error('Error while updating User.');
                               } 
                   );
           };
           	
          self.listarUsuarios = function(id, tipo){
        	  console.log('listarUsuario', id, tipo);
	        if(tipo==0){
	        		  self.listar();	        	  
	          }else{
	        	  self.listarPorVendedor(id);
	          }
          }
          
          self.listarUsuarios(usuarioId, tipoUsuario);
          self.listarTipoDocumentos();
          
          self.submit = function() {
        	  self.usuario.id_vendedor = usuarioId;
              if(self.usuario.id===null){
            	  self.usuario.fechaNacimiento = $scope.fechaNacimiento;            	  
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
              console.log(self.usuarios);
              for(var i = 0; i < $scope.usuarios.length; i++){
                  if($scope.usuarios[i].id === id) {
                	  console.log($scope.usuarios[i]);
                	  self.usuario = angular.copy($scope.usuarios[i]);
                	  console.log('self.usuario.password', self.usuario.password);
                	  self.desencriptar(self.usuario.password);
                	  
                	  for(var j = 0; j < $scope.generos.length; j++){
                		  console.log("$scope.generos[j].id " + $scope.generos[j].id);
                		  console.log("$scope.usuarios[i].genero " + $scope.usuarios[i].genero);
                		  if($scope.generos[j].id == $scope.usuarios[i].genero){
                			  self.genero = $scope.generos[j];
                			  self.usuario.genero = $scope.generos[j].id;
                			  console.log("setted: " + self.usuario.genero);
                		  }
                	  }
                	  for(var j = 0; j < $scope.tipoDocumentos.length; j++){
                		  console.log("$scope.tipoDocumentos[j].id " + $scope.tipoDocumentos[j].id);
                		  console.log("$scope.usuarios[i].id_tipoDocumento " + $scope.usuarios[i].tipoDocumento.id);
                		  if($scope.tipoDocumentos[j].id == $scope.usuarios[i].tipoDocumento.id){
                			  self.tipoDocumento = $scope.tipoDocumentos[j];
                			  self.usuario.id_tipoDocumento = self.tipoDocumento.id;
                			  console.log("setted: " + self.usuario.id_tipoDocumento);
                		  }
                	  }          
                	 var date = new Date($scope.usuarios[i].fechaNacimiento);
                	 console.log("date: " +date);
                	 $scope.fechaNacimiento =  date;
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
            		  id_tipoDocumento:'', valorDocumento:'', direccionFiscal: '', fechaNacimiento: ''};
              self.genero = "";
              self.tipoDocumento = "";
              $scope.fechaNacimiento = new Date();
              $scope.datepickerFechaNacimiento =  ""; 
              $scope.myForm.$setPristine(); 
          };
      
          /********Paging*******/
          $scope.currentPage = 0;
          $scope.pageSize = 10;
          $scope.q = '';
          
          $scope.getData = function () {
            // https://docs.angularjs.org/api/ng/filter/filter        	  
        	if($scope.usuarios!=null){
        		return $filter('filter')($scope.usuarios, $scope.q);
        	}else{
        		return null;
        	}
          }
          
          $scope.numberOfPages=function(){
        	  if($scope.getData()!=null){
        		  return Math.ceil($scope.getData().length/$scope.pageSize);  
        	  }else{
        		  return 0;
        	  }
          }
 
      }]);

/*
App.directive("datepicker", function () {
	  return {
	    restrict: "A",
	    require: "ngModel",
	    link: function (scope, elem, attrs, ngModelCtrl) {
	      var updateModel = function (dateText) {
	        scope.$apply(function (dateText) {
	          ngModelCtrl.$setViewValue(dateText);
	        });
	      };
	      var options = {
	        dateFormat: "dd/mm/yy",
	        onSelect: function (dateText) {
	          console.log(dateText);
	          scope.fechaNacimiento = dateText;
	          updateModel(dateText);
	        }
	      };
	      elem.datepicker(options);
	    }
	  }
	});*/