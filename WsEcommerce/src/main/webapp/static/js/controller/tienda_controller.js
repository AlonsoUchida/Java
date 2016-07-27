'use strict';
 
App.controller('TiendaController', ['$scope', 'TiendaService', function($scope, TiendaService) {
          var self = this;
          
          self.tienda = {id:null, nombre:'',ruc:'',telefono_local:'', telefono_movil:'', horarioAtencion:'', 
        		  paginaweb:'', tarjeta: 2, id_banco: [] };
          
          $scope.tarjetas = [{"id" : 1, "nombre": "Si Utilizo"},{"id" : 2, "nombre": "No Utilizo"}];
          $scope.bancos = {};
          
          /*$scope.horarios = [{"nombre": "1:00 AM"},{"nombre": "2:00 AM"},{"nombre": "3:00 AM"},{"nombre": "4:00 AM"},{"nombre": "5:00 AM"},{"nombre": "6:00 AM"},
                             {"nombre": "7:00 AM"},{"nombre": "8:00 AM"},{"nombre": "9:00 AM"},{"nombre": "10:00 AM"},{"nombre": "11:00 AM"},{"nombre": "12:00 PM"},
                             {"nombre": "1:00 PM"},{"nombre": "2:00 PM"},{"nombre": "3:00 PM"},{"nombre": "4:00 PM"},{"nombre": "5:00 PM"},{"nombre": "6:00 PM"},
                             {"nombre": "7:00 PM"},{"nombre": "8:00 PM"},{"nombre": "9:00 PM"},{"nombre": "10:00 PM"},{"nombre": "11:00 PM"},{"nombre": "12:00 AM"}];*/
         
          self.tarjeta = $scope.tarjetas[1];
          self.banco = "";
          /*self.horarioApertura = "";
          self.horarioCierre = "";
          self.horarioString= "";        
          self.horarioArray = ["", ""];       
          
          $scope.actualizarHorario = function (horario, tipoHorario) {
        	  if(tipoHorario==1){
        		  self.horarioArray[0] = horario.nombre;
        	  }else if(tipoHorario==2){
        		  self.horarioArray[1] = horario.nombre;
        	  }
        	 self.horarioString = self.horarioArray[0] + " - " + self.horarioArray[1];

             self.tienda.horarioAtencion = self.horarioString;
             console.log(self.tienda.horarioAtencion);
             
          };*/


          $scope.actualizarBanco = function (banco) {
        	  self.tienda.id_banco = [];
             for(var i=0; i < banco.length; i++){
            	 self.tienda.id_banco.push(banco[i].id);
             };
             console.log("self.tienda.id_banco", self.tienda.id_banco);
          };
          
          $scope.actualizarTarjeta = function (tarjeta) {
              self.tienda.tarjeta = tarjeta.id;
              console.log(self.tienda.tarjeta);
           };

          self.listarBancos = function(){
        	  TiendaService.listarBancos()
                  .then(
                               function(d) {  
                            	   $scope.bancos = d;
                            	   $scope.$apply();
                                   console.log("usuario bancos:" + $scope.bancos);        
                               },
                                function(errResponse){
                                    console.error('Error while fetching Currencies');
                                }
                       );
          };
          
          
          self.listar = function(){
        	  TiendaService.listar()
                  .then(
                               function(d) {  
                            	   $scope.tiendas = d;
                            	   $scope.$apply();
                                   console.log("tienda controller:" + $scope.tiendas);        
                               },
                                function(errResponse){
                                    console.error('Error while fetching Currencies');
                                }
                       );
          };
            
          self.agregar = function(tienda){
        	  console.log(tienda);
        	  TiendaService.agregar(tienda)
                      .then(
                    		  self.listar, 
                              function(errResponse){
                                   console.error('Error while creating Tienda.');
                              } 
                  );
          };
 
         self.actualizar = function(tienda){
        	 console.log(tienda);
        	 TiendaService.actualizar(tienda)
                      .then(
                              self.listar, 
                              function(errResponse){
                                   console.error('Error while updating Tienda.');
                              } 
                  );
          };
 
         self.eliminar = function(id){
        	 TiendaService.eliminar(id)
                      .then(
                              self.listar, 
                              function(errResponse){
                                   console.error('Error while deleting Tienda.');
                              } 
                  );
          };
 

          self.listar();
          self.listarBancos();
          
          self.submit = function() {
              if(self.tienda.id===null){
                  console.log('Saving New tienda', self.tienda);    
                  self.agregar(self.tienda);
              }else{
                  self.actualizar(self.tienda, self.tienda.id);
                  console.log('tienda updated with id ', self.tienda.id);
              }
              self.reset();
          };
               
          self.edit = function(id){
              console.log('id to be edited', id);
              console.log($scope.tiendas[i]);
              for(var i = 0; i < $scope.tiendas.length; i++){
                  if($scope.tiendas[i].id === id) {
                	 console.log($scope.tiendas[i]);
                	 self.tienda.id = $scope.tiendas[i].id;
                	 self.tienda.nombre = $scope.tiendas[i].nombre;
                	 self.tienda.ruc = $scope.tiendas[i].ruc;
                	 self.tienda.telefono_local = parseInt($scope.tiendas[i].telefono_local);
                	 self.tienda.telefono_movil = parseInt($scope.tiendas[i].telefono_movil);
                	 self.tienda.horarioAtencion = $scope.tiendas[i].horarioAtencion;
                	 self.tienda.paginaweb = $scope.tiendas[i].paginaweb;
                	 
                	 for(var j = 0; j < $scope.tarjetas.length; j++){
                  		  console.log("$scope.tarjetas[j].id " + $scope.tarjetas[j].id);
                  		  console.log("$scope.tiendas[i].tarjeta " + $scope.tiendas[i].tarjeta);
                  		  if($scope.tarjetas[j].id == $scope.tiendas[i].tarjeta){
                  			  self.tarjeta = $scope.tarjetas[j];
                  			  self.tienda.tarjeta = self.tarjeta.id;
                  			  console.log("setted: " + self.tienda.tarjeta);
                  		  }
                	 }
                	 var _bancos = [];
                	 for(var j = 0; j < $scope.bancos.length; j++){
                		 for(var z = 0; z < $scope.tiendas[i].bancos.length; z++){
                			 if($scope.tiendas[i].bancos[z].id == $scope.bancos[j].id){
                				 _bancos.push($scope.bancos[j]);
                			 }
                		 }
                	 }
                	 self.banco = _bancos;
                	 $scope.actualizarBanco(self.banco);
                  }
              }
          };
               
          self.remove = function(id){
              console.log('id to be deleted', id);
              if(self.tienda.id === id) {
                 self.reset();
              }
              self.eliminar(id);
          };
 
           
          self.reset = function(){
        	  self.tienda = {id:null, nombre:'',ruc:'',telefono_local:'', telefono_movil:'', horarioAtencion:'', 
            		  paginaweb:'', tarjeta:1, id_banco: '' };
        	  self.tarjeta = "";
              self.banco = "";
              /*self.horarioApertura = "";
              self.horarioCierre = "";
              self.horarioString = "";
              self.horarioArray = ["", ""];*/
              $scope.myForm.$setPristine(); //reset Form
          };
 
      }]);