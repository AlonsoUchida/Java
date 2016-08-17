'use strict';
 
App.controller('ReporteController', ['$scope', 'ReporteService', 'usuarioId', function($scope, ReporteService, usuarioId) {
          var self = this;
          
          self.reporte = {id:null, nombre:'', apellido:'', tienda: '', 
        		  horario:'', direccion:'', distrito:'', fechaRegistro: ''};
          $scope.reportes = [];

          self.listar = function(id){
        	  ReporteService.listar(id)
              .then(
                           function(d) {  
                        	   $scope.reportes = d;
                        	   $scope.$apply(); 
                        	   return d;
                           },
                            function(errResponse){
                                console.error('Error while fetching Currencies');
                            }
                   );       	  
          };     
          
          self.listar(usuarioId);
    
      }]);