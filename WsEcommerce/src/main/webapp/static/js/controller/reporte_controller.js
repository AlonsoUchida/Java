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