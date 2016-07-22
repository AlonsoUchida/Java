'use strict';
App.controller('ImagenController', ['$scope', 'ImagenService', function($scope, ImagenService) {
          var self = this;
          self.imagen = {id:null, id_tienda:'',nombre:'',imagen:'', defecto:''};
          
          $scope.defectos = [{"id" : 1, "nombre": "Principal"},{"id" : 2, "nombre": "Secundario"}];
          $scope.myFile = "";
          self.tienda = "";
          self.defecto = "";
          
          $scope.uploadFile = function(){
              var file = $scope.myFile;
              console.log('file is ' );
              console.dir(file);
              self.imagen.imagen = file;
              console.log('file', self.imagen.imagen);
          };
          v
          
          $scope.actualizarImagen = function (imagen) {
             self.imagen = imagen.id;
             console.log("actualizarImagen:" + self.imagen);           
          };
          
          $scope.actualizarDefecto = function (defecto) {
              self.imagen.defecto = defecto.id;
              console.log(self.imagen.defecto);
           };

          self.listarTiendas = function(){
          	  ImagenService.listarTiendas()
                    .then(
                                 function(d) {  
                              	   $scope.tiendas = d;
                              	   $scope.$apply();        
                                 },
                                  function(errResponse){
                                      console.error('Error while fetching Currencies');
                                  }
                         );
            };
                
          self.listar = function(){
        	  ImagenService.listar()
                  .then(
                               function(d) {  
                            	   $scope.imagenes = d;
                            	   $scope.$apply();       
                               },
                                function(errResponse){
                                    console.error('Error while fetching Currencies');
                                }
                       );
          };
            
          self.agregar = function(imagen){
        	  ImagenService.agregar(imagen)
                      .then(
                    		  self.listar, 
                              function(errResponse){
                                   console.error('Error while creating.');
                              } 
                  );
          };
 
         self.actualizar = function(imagen){
        	 ImagenService.actualizar(imagen)
                      .then(
                              self.listar, 
                              function(errResponse){
                                   console.error('Error while updating.');
                              } 
                  );
          };
 
         self.eliminar = function(id){
        	 ImagenService.eliminar(id)
                      .then(
                              self.listar, 
                              function(errResponse){
                                   console.error('Error while deleting.');
                              } 
                  );
          };
 

          self.listar();
          self.listarTiendas();
          
          self.submit = function() {
        	  if(self.myFile!=null){
        		  self.tienda.imagen = self.myFile;
        		  console.log();
        	  }
              if(self.imagen.id===null){
                  console.log('Saving New User', self.imagen);    
                  self.agregar(self.imagen);
              }else{
                  self.actualizar(self.imagen, self.imagen.id);
                  console.log('User updated with id ', self.imagen.id);
              }
              self.reset();
          };
               
          self.edit = function(id){
              console.log('id to be edited', id);
              console.log(self.imagenes);
              for(var i = 0; i < $scope.imagenes.length; i++){
                  if($scope.imagenes[i].id === id) {
                	  console.log($scope.imagenes[i]);
                	  self.usuario = angular.copy($scope.imagenes[i]);
                	  
                	  for(var j = 0; j < $scope.tiendas.length; j++){     	
                		  if($scope.tiendas[j].id == self.imagen.id_tienda){
                			  self.tienda = $scope.tiendas[j];
                			  self.imagen.id_tienda = $scope.tiendas[j].id;
                			  console.log("setted: " + self.imagen.id_tienda);
                		  }
                	}
                	  
                     break;
                  }
              }
          };
               
          self.remove = function(id){
              console.log('id to be deleted', id);
              if(self.imagen.id === id) {
                 self.reset();
              }
              self.eliminar(id);
          };
 
           
          self.reset = function(){
              self.imagen = {id:null, id_tienda:'',nombre:'',imagen:'', defecto:''};
              self.tienda = "";
              $scope.myForm.$setPristine(); //reset Form
          };
 
      }]);

App.directive('fileModel', ['$parse', function ($parse) {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;
            
            element.bind('change', function(){
                scope.$apply(function(){
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
}]);



