'use strict';
App.controller('DireccionController', ['$scope', '$filter', 'DireccionService', 
                                       function($scope, $filter, DireccionService) {
          var self = this;
          self.direccion = {id:null, id_distrito:null, domcilio:'',numero:'', referencia:'', latitud:'', 
        		  longitud:'', id_tienda: null};
        
          self.distrito = "";
          self.departamento = "";
          self.provincia = "";
          self.tienda = "";
          
          $scope.actualizarTienda = function (tienda) {
        	  if(tienda!=null){
	              self.direccion.id_tienda = tienda.id;
	              self.listarPorTienda(tienda.id);
	              console.log("actualizarTienda: " + self.direccion.id_tienda);
        	  }
              
           };
          
          $scope.actualizarDistrito = function (distrito) {
        	  if(distrito!=null){
	             self.direccion.id_distrito = distrito.id;
	             console.log("actualizarDistrito: " + self.direccion.id_distrito);
        	  }
             
          };

          $scope.actualizarDepartamento = function (departamento) {
        	  if(departamento!=null){
	             self.listarProvinciasPorDepartamento(departamento.id); 
	             console.log("actualizarDepartamento: ");
        	  }
          };
          
          $scope.actualizarProvincia = function (provincia) {
        	  if(provincia!=null){
	              self.listarDistritosPorProvincia(provincia.id); 
	              console.log("actualizarProvincia:");
        	  }
           };
           
           self.listarTiendas = function(){
          	  DireccionService.listarTiendas()
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
           
           self.listarDepartamentos = function(){
         	  DireccionService.listarDepartamentos()
                   .then(
                                function(d) {  
                             	   $scope.departamentos = d;                           	   
                             	   $scope.$apply(); 
                             	   //Setear por defecto miraflores
                             	   self.departamento = $scope.departamentos[14];
                             	   //console.log('self.departamento', self.departamento);
                                },
                                 function(errResponse){
                                     console.error('Error while fetching Currencies');
                                 }
                        );
           };
           
           self.listarProvincias = function(){
          	  DireccionService.listarProvincias()
                    .then(
                                 function(d) {  
                              	   $scope.provincias = d;
                              	   $scope.$apply();  
                              	   //Setear por defecto miraflores
                              	   self.provincia = $scope.provincias[126];
                              	   //console.log('self.provincia', self.provincia);
                                 },
                                  function(errResponse){
                                      console.error('Error while fetching Currencies');
                                  }
                         );
            };
            
            self.listarDistritos = function(){
           	  DireccionService.listarDistritos()
                     .then(
                                  function(d) {  
                               	   $scope.distritos = d;
                               	   $scope.$apply(); 
                               	   //Setear por defecto miraflores
                               	   self.distrito = $scope.distritos[1271];
                               	   self.direccion.id_distrito = self.distrito.id;
                               	   //console.log('self.distrito', self.distrito);
                                  },
                                   function(errResponse){
                                       console.error('Error while fetching Currencies');
                                   }
                          );
             };

          self.listarProvinciasPorDepartamento = function(departamento){
        	  DireccionService.listarProvinciasPorDepartamento(departamento)
                  .then(
                               function(d) {  
                            	   $scope.provincias = d;
                            	   $scope.$apply();        
                               },
                                function(errResponse){
                                    console.error('Error while fetching Currencies');
                                }
                       );
          };
          
          self.listarDistritosPorProvincia = function(provincia){
        	  DireccionService.listarDistritosPorProvincia(provincia)
                  .then(
                               function(d) {  
                            	   $scope.distritos = d;
                            	   $scope.$apply();        
                               },
                                function(errResponse){
                                    console.error('Error while fetching Currencies');
                                }
                       );
          };
              
          self.listarPorTienda = function(id){
        	  DireccionService.listarPorTienda(id)
                  .then(
                               function(d) {                           	   
                            	   $scope.direcciones = d;
                            	   $scope.$apply();      
                            	   console.log("$scope.direcciones", $scope.direcciones);
                               },
                                function(errResponse){
                                    console.error('Error while fetching Currencies');
                                }
                       );
          };
            
          self.agregar = function(direccion){
        	  DireccionService.agregar(direccion)
                      .then(
                    		  function() {                           	   
                    			  self.listarPorTienda(self.tienda.id)
                              },
                    		 
                              function(errResponse){
                                   console.error('Error while creating Usuario.');
                              } 
                  );
          };
 
         self.actualizar = function(direccion){
        	 DireccionService.actualizar(direccion)
                      .then(
                    		  function() {                           	   
                    			  self.listarPorTienda(self.tienda.id)
                              },
                              function(errResponse){
                                   console.error('Error while updating User.');
                              } 
                  );
          };
 
         self.eliminar = function(id){
        	 DireccionService.eliminar(id)
                      .then(
                    		  function() {                           	   
                    			  self.listarPorTienda(self.tienda.id)
                              },
                              function(errResponse){
                                   console.error('Error while deleting User.');
                              } 
                  );
          };

          self.listarDepartamentos();
          self.listarProvincias();
          self.listarDistritos();
          self.listarTiendas();
          
          self.submit = function() {
              if(self.direccion.id===null){
                  console.log('Saving New Direccion', self.direccion);    
                  self.agregar(self.direccion);
              }else{
                  self.actualizar(self.direccion, self.direccion.id);
                  console.log('User updated with id ', self.direccion.id);
              }            
              self.reset();  
          };
               
          self.edit = function(id){
              console.log('id to be edited', id);
              console.log('self.direccion',self.direccion);
              console.log('$scope.direcciones', $scope.direcciones);
              for(var i = 0; i < $scope.direcciones.length; i++){
                  if($scope.direcciones[i].id === id) {
                	  console.log($scope.direcciones[i]);
                		  
                	self.direccion.id =   $scope.direcciones[i].id;
                	self.direccion.domicilio =   $scope.direcciones[i].domicilio;
                	self.direccion.numero =   parseInt($scope.direcciones[i].numero);
                	self.direccion.latitud = $scope.direcciones[i].latitud;
                	self.direccion.longitud = $scope.direcciones[i].longitud;
                	self.direccion.referencia = $scope.direcciones[i].referencia;
                	
                	for(var j = 0; j < $scope.distritos.length; j++){
              		/*console.log("$scope.distritos[j].id " + $scope.distritos[j].id);
              		console.log("$scope.direcciones[i].distrito.id", $scope.direcciones[i].distrito.id);*/
              		  if($scope.distritos[j].id == $scope.direcciones[i].distrito.id){
	              			self.distrito = $scope.distritos[j];
	              			console.log("setted:1 ", self.distrito);
              			
              			  for(var z = 0; z < $scope.provincias.length; z++){
	              			  if($scope.direcciones[i].distrito.provincia.id == $scope.provincias[z].id)
	              			  {
	              				self.provincia = $scope.provincias[z];
	              				console.log("setted:2 ", self.provincia);
	              			  }
              			  }
              			  
              			  for(var z = 0; z < $scope.departamentos.length; z++){
	              			  if($scope.direcciones[i].distrito.provincia.departamento.id == $scope.departamentos[z].id)
	              			  {
	              				self.departamento = $scope.departamentos[z];
	              				console.log("setted:3 ", self.departamento );
	              			  }
            			  }
      			  
              			  self.direccion.id_distrito = $scope.distritos[j].id;             			  

              		  }
              	  	}
                	
                	for(var j = 0; j < $scope.tiendas.length; j++){     	
                		  if($scope.tiendas[j].id == self.direccion.id_tienda){
                			  self.tienda = $scope.tiendas[j];
                			  self.direccion.id_tienda = $scope.tiendas[j].id;
                			  console.log("setted: " + self.direccion.id_tienda);
                		  }
                	}
                    break;
                  }
              }
          };
               
          self.remove = function(id){
              console.log('id to be deleted', id);
              if(self.direccion.id === id) {
                 self.reset();
              }
              self.eliminar(id);
          };
 
           
          self.reset = function(){
        	  self.direccion = {id:null, id_distrito:null, domcilio:'',numero:'', referencia:'', latitud:'', 
            		  longitud:'', id_tienda: self.direccion.id_tienda};
        	  self.distrito = "";
              self.departamento = "";
              self.provincia = "";
              $scope.provincias = "";
              $scope.distritos = "";
              self.listarDepartamentos();
              self.listarProvincias();
              self.listarDistritos();
              $scope.myForm.$setPristine(); 
          };
          
          /********Paging*******/
          $scope.currentPage = 0;
          $scope.pageSize = 10;
          $scope.q = '';
          
          $scope.getData = function () {
            // https://docs.angularjs.org/api/ng/filter/filter        	  
        	if($scope.direcciones!=null){
        		return $filter('filter')($scope.direcciones, $scope.q);
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

