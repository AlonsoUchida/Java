
	   <div class="generic-container" ng-controller="DireccionController as ctrl">
          <div class="panel panel-default">
          		
              <div class="panel-heading">
              
              	 	<span class="lead">Registro de Direcci�n Por Tienda</span> 
	              	 <div class="form-actions floatRight">
	              	 <button type="button" ng-click="ctrl.reset()" class="btn btn-default" style="float: right;">Refrescar</button>
	              	 </div>
          </div>
              <div class="formcontainer">
                  <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                      <input type="hidden" ng-model="ctrl.direccion.id" />
                      
                       <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="tienda">Tienda</label>
                              <div class="col-md-7">
                                 <select id="soflow" ng-model="ctrl.tienda" ng-options="tienda as tienda.nombre for tienda in tiendas"
                                 ng-change="actualizarTienda(ctrl.tienda)" required>
                                 <option value="">- Seleccione Tienda -</option>
                                 </select>
                                 <span ng-show="myForm.uname.$error.required">Este campo es requerido</span>
                                 <span ng-show="myForm.uname.$invalid">Este campo es inv�lido</span>
                              </div>

                          </div>
                      </div> 
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="domicilio">Direcci�n</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.direccion.domicilio" id="domicilio" class="username form-control input-sm" placeholder="Ingresa tu direcci�n" required ng-minlength="3"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                     	              <span ng-show="myForm.uname.$error.required">Este campo es requerido</span>
                                      <span ng-show="myForm.uname.$error.minlength">El m�nimo tama�o es de 3 caracteres</span>
                                      <span ng-show="myForm.uname.$invalid">Este campo es inv�lido</span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="numero">N�mero</label>
                              <div class="col-md-7">
                                  <input type="number" ng-model="ctrl.direccion.numero" id="numero" class="username form-control input-sm" placeholder="Ingresa tu n�mero" required ng-minlength="3"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.uname.$error.required">Este campo es requerido</span>
                                      <span ng-show="myForm.uname.$error.minlength">El m�nimo tama�o es de 3 caracteres</span>
                                      <span ng-show="myForm.uname.$invalid">Este campo es inv�lido</span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="departamento">Departamento</label>
                              <div class="col-md-7">
                                 <select id="soflow" ng-model="ctrl.departamento" ng-options="departamento as departamento.nombre for departamento in departamentos"
                                 ng-change="actualizarDepartamento(ctrl.departamento)" required>
                                 </select>
                                 <span ng-show="myForm.uname.$error.required">Este campo es requerido</span>
                                 <span ng-show="myForm.uname.$invalid">Este campo es inv�lido</span>
                              </div>

                          </div>
                      </div> 
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="provincia">Provincia</label>
                              <div class="col-md-7">
                                 <select id="soflow" ng-model="ctrl.provincia" ng-options="provincia as provincia.nombre for provincia in provincias"
                                 ng-change="actualizarProvincia(ctrl.provincia)" required></select>
                                 <span ng-show="myForm.uname.$error.required">Este campo es requerido</span>
                                 <span ng-show="myForm.uname.$invalid">Este campo es inv�lido</span>
                              </div>

                          </div>
                      </div> 
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="distrito">Distrito</label>
                              <div class="col-md-7">
                                 <select id="soflow" ng-model="ctrl.distrito" ng-options="distrito as distrito.nombre for distrito in distritos"
                                 ng-change="actualizarDistrito(ctrl.distrito)" required></select>
                                 <span ng-show="myForm.uname.$error.required">Este campo es requerido</span>
                                 <span ng-show="myForm.uname.$invalid">Este campo es inv�lido</span>
                              </div>

                          </div>
                      </div> 
                      
       				 <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="referencia">Referencia</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.direccion.referencia" id="referencia" class="username form-control input-sm" placeholder="Ingresa Referencia" required ng-minlength="3"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                     	              <span ng-show="myForm.uname.$error.required">Este campo es requerido</span>
                                      <span ng-show="myForm.uname.$error.minlength">El m�nimo tama�o es de 3 caracteres</span>
                                      <span ng-show="myForm.uname.$invalid">Este campo es inv�lido</span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="latitud">Latitud</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.direccion.latitud" id="latitud" class="username form-control input-sm" placeholder="Ingresa Latitud"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.uname.$invalid">Este campo es inv�lido</span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="longitud">Longitud</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.direccion.longitud" id="longitud" class="username form-control input-sm" placeholder="Ingresa Longitud"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.uname.$invalid">Este campo es inv�lido</span>
                                  </div>
                              </div>
                          </div>
                      </div>
                   
                      
                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"  value="{{!ctrl.direccion.id ? 'Agregar' : 'Actualizar'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                              <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Limpiar</button>
                          </div>
                      </div>
                  </form>
              </div>
          </div>
          <div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">Lista de Direcciones</span></div>
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
                              <th>Direcci�n</th>
                              <th>N�mero</th>
                              <th class="ocultar">Referencia</th>
                              <th class="ocultar">Latitud</th>
                              <th class="ocultar">Longitud</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="d in direcciones | filter:q | startFrom:currentPage*pageSize | limitTo:pageSize">
                              <td><span ng-bind="d.domicilio"></span></td>
                              <td><span ng-bind="d.numero"></span></td>
                              <td class="ocultar"><span ng-bind="d.referencia"></span></td>
                              <td class="ocultar"><span ng-bind="d.latitud"></span></td>
                              <td class="ocultar"><span ng-bind="d.longitud"></span></td>
                              <td>
                              <button type="button" ng-click="ctrl.edit(d.id)" class="btn btn-success custom-width">Editar</button>  
                              <button type="button" ng-click="ctrl.remove(d.id)" class="btn btn-danger custom-width">Eliminar</button>
                              </td>
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

      