
	   <div class="generic-container" ng-controller="ReporteController as ctrl">
          <div class="panel panel-default">
              <div class="panel-heading">
              
              	 	<span class="lead">Historial de Registros</span> 
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">Lista de Registros</span></div>
              <div class="tablecontainer">
              	<input ng-model="q" id="search" class="form-control" placeholder="Filter text" style='margin-top: 12px'>
			    <select ng-model="pageSize" id="pageSize" class="form-control" style='margin-top: 12px'>
			        <option value="5">5</option>
			        <option value="10">10</option>
			        <option value="15">15</option>
			        <option value="20">20</option>
			     </select>
			    
        		  
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>Bodeguero</th>
                              <th>Tienda</th>
                              <th>Horario</th>
                              <th>Dirección</th>
                              <th>Distrito</th>
                              <th>Fecha Registro</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="r in reportes | filter:q | startFrom:currentPage*pageSize | limitTo:pageSize">
                              <td><span ng-bind="r.nombre + ' ' + r.apellido"></span></td>
                              <td><span ng-bind="r.tienda"></span></td>
                              <td><span ng-bind="r.horario"></span></td>
                              <td><span ng-bind="r.direccion"></span></td>
                              <td><span ng-bind="r.distrito"></span></td>
                              <td><span ng-bind="r.fechaRegistro"></span></td>
                          </tr>
                      </tbody>
                  </table>
                  <div style="padding: 0.3cm">
                         <button ng-disabled="currentPage == 0" ng-click="currentPage=currentPage-1" class="btn btn-default">
					        Anterior
					    </button>
					    {{currentPage+1}}/{{numberOfPages()}}
					    <button ng-disabled="getData()!=null ? currentPage >= getData().length/pageSize - 1 : true" ng-click="currentPage=currentPage+1" class="btn btn-default">
					        Siguiente
					    </button>
					   </div>
              	</div>
              </div>
          </div>
      </div>

      