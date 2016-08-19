'use strict';
 
App.controller('TiendaController', ['$scope', '$filter', 'TiendaService', 'UsuarioService', 'usuarioId', 'tipoUsuario', 
                                    function($scope, $filter, TiendaService, UsuarioService, usuarioId, tipoUsuario) {
          var self = this;
          
          self.tienda = {id:null, nombre:'',ruc:'', razon_social: '', telefono_local:'', telefono_movil:'', horarioAtencion:'', 
        		  paginaweb:'', tarjeta: 2, id_banco: [], id_usuarios: [], horarios: []};
          self.horario = {dia_inicial : null, dia_final : null, hora_inicial: null, hora_final:null};
          self.horario_descripcion = {id:null, dia_inicial : null, dia_final : null, hora_inicial: null, hora_final:null};
         
          $scope.tarjetas = [{"id" : 1, "nombre": "Si Utilizo"},{"id" : 2, "nombre": "No Utilizo"}];
          $scope.bancos = {};         
          $scope.horas = {};
          $scope.dias = {};
          self.horarios_descripcion = [];

          self.tarjeta = $scope.tarjetas[1];
          self.banco = "";
          self.bodegueroid = "";
          self.horaInicial = "";
          self.horaFinal = "";
          self.diaInicial = "";
          self.diaFinal = "";
          
          $scope.actualizarHorario = function (horario, tipoHorario) {
        	  if(tipoHorario==1){
        		  self.horario.hora_inicial = horario.id;
        		  self.horario_descripcion.hora_inicial = horario.nombre;
        	  }else if(tipoHorario==2){
        		  self.horario.hora_final = horario.id;
        		  self.horario_descripcion.hora_final = horario.nombre;
        	  }else if (tipoHorario==3){
        		  self.horario.dia_inicial = horario.id;
        		  self.horario_descripcion.dia_inicial = horario.nombre;
        	  }else if(tipoHorario==4){
        		  self.horario.dia_final = horario.id;
        		  self.horario_descripcion.dia_final = horario.nombre;
        	  }

             console.log("self.horario", self.horario);
             console.log("self.horario_descripcion", self.horario_descripcion);
             
          };
          
          $scope.agregarHorario = function (){

        	  self.horario_descripcion.id = self.tienda.horario_descripcion.length + 1;
        	  
        	  self.tienda.horarios.push(self.horario);
        	  self.horarios_descripcion.push(self.horario_descripcion);
        	  self.horario = [];
        	  self.horario_descripcion = [];
        	  console.log("self.tienda.horarios", self.tienda.horarios);
        	  console.log("self.horarios_descripcion", self.horarios_descripcion);
          }
          
          $scope.eliminarHorario = function (id){
        	  self.horario.splice(id, 1);  
        	  self.horario_descripcion.splice(id, 1);
        	  self.tienda.horarios.splice(id, 1);
        	  console.log("self.tienda.horarios", self.tienda.horarios);
        	  console.log("self.tienda.horarios", self.tienda.horarios);
        	  console.log("self.horarios_descripcion", self.horarios_descripcion);
          }
          
          $scope.actualizarBodeguero = function (bodeguero) {
        	  self.tienda.id_usuarios = [];
              self.tienda.id_usuarios.push(bodeguero.id);
              self.bodegueroid = bodeguero.id;
              console.log('self.tienda.id_usuarios', self.tienda.id_usuarios);
              self.listarPorBodeguero(self.bodegueroid);
              
           };
           
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
           
           self.listarHoras = function(){
         	  TiendaService.listarHoras()
                   .then(
                                function(d) {  
                             	   $scope.horas = d;
                             	   $scope.$apply();
                                    console.log("horas:" + $scope.horas);        
                                },
                                 function(errResponse){
                                     console.error('Error while fetching Currencies');
                                 }
                        );
           };
           
           self.listarDias = function(){
          	  TiendaService.listarDias()
                    .then(
                                 function(d) {  
                              	   $scope.dias = d;
                              	   $scope.$apply();
                                     console.log("dias:" + $scope.dias);        
                                 },
                                  function(errResponse){
                                      console.error('Error while fetching Currencies');
                                  }
                         );
            };

          self.listarBancos = function(){
        	  TiendaService.listarBancos()
                  .then(
                               function(d) {  
                            	   $scope.bancos = d;
                            	   $scope.$apply();
                                   console.log("bancos:" + $scope.bancos);        
                               },
                                function(errResponse){
                                    console.error('Error while fetching Currencies');
                                }
                       );
          };
          
          self.listarBodegueros = function(id){
        	  TiendaService.listarBodegueros(id)
                  .then(
                               function(d) {  
                            	   $scope.bodegueros = d;
                            	   $scope.$apply();
                                   console.log("usuario bodegueros:" + $scope.bodegueros);        
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
                            	   $scope.bodegueros = d;
                            	   $scope.$apply();
                                   console.log("usuario bodegueros:" + $scope.bodegueros);        
                               },
                                function(errResponse){
                                    console.error('Error while fetching Currencies');
                                }
                       );
          };
         
          
          self.listarPorBodeguero = function(id){
        	  TiendaService.listarPorBodeguero(id)
                  .then(
                               function(d) {  
                            	   $scope.tiendas = d;
                            	   $scope.$apply();
                                   console.log("tienda controller:" , $scope.tiendas);        
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
                    		  function(){
                    			  self.listarPorBodeguero(self.bodegueroid)
                    		  }, 
                              function(errResponse){
                                   console.error('Error while creating Tienda.');
                              } 
                  );
          };
 
         self.actualizar = function(tienda){
        	 console.log(tienda);
        	 TiendaService.actualizar(tienda)
                      .then(
                    		  function(){
                    			  self.listarPorBodeguero(self.bodegueroid)
                    		  }, 
                              function(errResponse){
                                   console.error('Error while updating Tienda.');
                              } 
                  );
          };
 
         self.eliminar = function(id){
        	 TiendaService.eliminar(id)
                      .then(
                    		  function(){
                    			  self.listarPorBodeguero(self.bodegueroid)
                    		  }, 
                              function(errResponse){
                                   console.error('Error while deleting Tienda.');
                              } 
                  );
          };
           
          if(tipoUsuario==0){
        	  self.listar();
          }else{
        	  self.listarBodegueros(usuarioId);
          }
          
          self.listarBancos();
          self.listarHoras();
          self.listarDias();
        
          self.submit = function() {
        	  //Se asigna el usuario vendedor
        	  self.tienda.id_usuarios.push(usuarioId);
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
                	 self.tienda.razon_social = $scope.tiendas[i].razonSocial;
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
        	  self.tienda = {id:null, nombre:'',ruc:'', razon_social: '', telefono_local:'', telefono_movil:'', horarioAtencion:'', 
            		  paginaweb:'', tarjeta:1, id_banco: [], id_usuarios: [] };
        	  self.tarjeta = $scope.tarjetas[1];
              self.banco = "";
              self.tienda.id_usuarios = [];
              self.tienda.id_usuarios.push(self.bodegueroid);
              /*self.horarioApertura = "";
              self.horarioCierre = "";
              self.horarioString = "";
              self.horarioArray = ["", ""];*/
              $scope.myForm.$setPristine(); //reset Form
          };
          
          
          /********Paging*******/
          $scope.currentPage = 0;
          $scope.pageSize = 10;
          $scope.q = '';
          
          $scope.getData = function () {
            // https://docs.angularjs.org/api/ng/filter/filter        	  
        	if($scope.tiendas!=null){
        		return $filter('filter')($scope.tiendas, $scope.q);
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