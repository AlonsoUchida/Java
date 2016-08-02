'use strict';
App.controller('ImagenController', ['$scope','ImagenService', 'Upload', function($scope, ImagenService, Upload) {
          var self = this;
          self.imagen = {id:null, id_tienda:'',nombre:'',imagen:'', defecto:''};
          
          $scope.defectos = [{"id" : 1, "nombre": "Principal"},{"id" : 2, "nombre": "Secundario"}];
          $scope.picFile = "";
          $scope.tienda = "";
          self.tienda = "";
          self.id_tienda = "";
          self.defecto = "";
          
          $scope.convertToBase64 = function(){
        	  var imagenToString64 = "";
        	  if ($scope.picFile) {
                  var reader = new FileReader();
                  reader.onload = function(readerEvt) {
                      var binaryString = readerEvt.target.result;
                      imagenToString64 = btoa(binaryString);
                      self.imagen.imagen = imagenToString64;
                      console.log('self.imagen.imagen:', self.imagen.imagen);
                  };
                  reader.readAsBinaryString($scope.picFile);
              }             
          };
          
          $scope.actualizarTienda = function (tienda) {
              self.imagen.id_tienda = tienda.id;
              self.id_tienda = self.imagen.id_tienda;
              console.log("self.id_tienda", self.id_tienda);
              self.listarPorTienda(tienda.id);
              for(var i=0; i < $scope.tiendas.length; i++){
            	  if(tienda.id == $scope.tiendas[i].id){
            		  self.tienda = $scope.tiendas[i];
            		  $scope.tienda = self.tienda;          		  
            		  console.log("self.tienda", self.tienda);
            		  console.log("$scope.tienda", $scope.tienda);
            	  }
              }
              console.log("actualizarTienda:" + self.imagen.id_tienda);
              
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
            
            self.listarPorTienda = function(id){
          	  ImagenService.listarPorTienda(id)
                    .then(
                                 function(d) {  
                              	   $scope.imagenes = d;
                              	   self.tienda = $scope.tienda;
                              	   $scope.$apply();      
                              	   console.log("self.tienda -l", self.tienda);
                              	   console.log("$scope.tienda -l", $scope.tienda);
                                 },
                                  function(errResponse){
                                      console.error('Error while fetching Currencies');
                                  }
                         );
            };

            
          self.agregar = function(imagen){
        	  ImagenService.agregar(imagen)
                      .then(
                    		  function() {  
                    			  self.listarPorTienda(self.id_tienda)
                    		  }, 	  
                              function(errResponse){
                                   console.error('Error while creating.');
                              } 
                  );
          };
 
         self.actualizar = function(imagen){
        	 ImagenService.actualizar(imagen)
                      .then(
                    		  function() {  
                    			  self.listarPorTienda(self.id_tienda)
                    		  },           		  
                              function(errResponse){
                                   console.error('Error while updating.');
                              } 
                  );
          };
 
         self.eliminar = function(id){
        	 ImagenService.eliminar(id)
                      .then(
                    		  function() {  
                    			  self.listarPorTienda(self.id_tienda)
                    		  }, 
                              function(errResponse){
                                   console.error('Error while deleting.');
                              } 
                  );
          };
 
          self.listarTiendas();
          
          self.submit = function() {
              if(self.imagen.id===null){
                  console.log('Saving New Imagen', self.imagen);    
                  self.agregar(self.imagen);
              }else{
            	  $scope.convertToBase64();
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
                	  self.imagen.id = $scope.imagenes[i].id;//angular.copy($scope.imagenes[i]);
                	  self.imagen.nombre = $scope.imagenes[i].nombre;
                	  self.imagen.imagen = $scope.imagenes[i].imagen;

                	  $scope.picFile =" data:image/JPEG;base64," +$scope.imagenes[i].imagen;
                	  console.log("$scope.picFile after", $scope.picFile);
                	  
                	 /* 
                	  * for(var j = 0; j < $scope.tiendas.length; j++){     	
                		  if($scope.tiendas[j].id == $scope.imagenes[i].id_tienda){
                			  self.tienda = $scope.tiendas[j];
                			  self.imagen.id_tienda = $scope.tiendas[j].id;
                			  console.log("setted id_tienda: " + self.imagen.id_tienda);
                		  }
                	  }
                	  */
                	  
                	  for(var j = 0; j < $scope.defectos.length; j++){     	
                		  if($scope.defectos[j].id == $scope.imagenes[i].defecto){
                			  self.defecto = $scope.defectos[j];
                			  self.imagen.defecto = $scope.defectos[j].id;
                			  console.log("setted defecto: " + self.imagen.defecto);
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
              $scope.picFile = "";
              self.tienda = "";
              self.defecto = "";
              $scope.myForm.$setPristine(); //reset Form
          };
 
      }]);



