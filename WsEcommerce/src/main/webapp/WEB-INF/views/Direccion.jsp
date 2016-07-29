
	   <div class="generic-container" ng-controller="DireccionController as ctrl">
          <div class="panel panel-default">
          		
              <div class="panel-heading">
              <div class="row">
              	 	<span class="lead">Registro de Dirección Por Tienda</span> 
	              	 <div class="form-actions floatRight">
	              	 <button type="button" ng-click="ctrl.reset()" class="btn btn-default" style="float: right;">Refrescar</button>
	              	 </div>
              	 </div>
          </div>
              <div class="formcontainer">
                  <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                      <input type="hidden" ng-model="ctrl.direccion.id" />
                      
                       <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="tienda">Tienda</label>
                              <div class="col-md-7">
                                 <select ng-model="ctrl.tienda" ng-options="tienda as tienda.nombre for tienda in tiendas"
                                 ng-change="actualizarTienda(ctrl.tienda)" required></select>
                                 <span ng-show="myForm.uname.$error.required">Este campo es requerido</span>
                                 <span ng-show="myForm.uname.$invalid">Este campo es invalido</span>
                              </div>

                          </div>
                      </div> 
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="domicilio">Dirección</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.direccion.domicilio" id="domicilio" class="username form-control input-sm" placeholder="Ingresa tu dirección" required ng-minlength="3"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                     	              <span ng-show="myForm.uname.$error.required">Este campo es requerido</span>
                                      <span ng-show="myForm.uname.$error.minlength">El minimo tamaño es de 3 caracteres</span>
                                      <span ng-show="myForm.uname.$invalid">Este campo es invalido</span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="numero">Numero</label>
                              <div class="col-md-7">
                                  <input type="number" ng-model="ctrl.direccion.numero" id="numero" class="username form-control input-sm" placeholder="Ingresa tu numero" required ng-minlength="3"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.uname.$error.required">Este campo es requerido</span>
                                      <span ng-show="myForm.uname.$error.minlength">El minimo tamaño es de 3 caracteres</span>
                                      <span ng-show="myForm.uname.$invalid">Este campo es invalido</span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="departamento">Depertamento</label>
                              <div class="col-md-7">
                                 <select ng-model="ctrl.departamento" ng-options="departamento as departamento.nombre for departamento in departamentos"
                                 ng-change="actualizarDepartamento(ctrl.departamento)" required></select>
                                 <span ng-show="myForm.uname.$error.required">Este campo es requerido</span>
                                 <span ng-show="myForm.uname.$invalid">Este campo es invalido</span>
                              </div>

                          </div>
                      </div> 
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="provincia">Provincia</label>
                              <div class="col-md-7">
                                 <select ng-model="ctrl.provincia" ng-options="provincia as provincia.nombre for provincia in provincias"
                                 ng-change="actualizarProvincia(ctrl.provincia)" required></select>
                                 <span ng-show="myForm.uname.$error.required">Este campo es requerido</span>
                                 <span ng-show="myForm.uname.$invalid">Este campo es invalido</span>
                              </div>

                          </div>
                      </div> 
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="distrito">Distrito</label>
                              <div class="col-md-7">
                                 <select ng-model="ctrl.distrito" ng-options="distrito as distrito.nombre for distrito in distritos"
                                 ng-change="actualizarDistrito(ctrl.distrito)" required></select>
                                 <span ng-show="myForm.uname.$error.required">Este campo es requerido</span>
                                 <span ng-show="myForm.uname.$invalid">Este campo es invalido</span>
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
                                      <span ng-show="myForm.uname.$error.minlength">El minimo tamaño es de 3 caracteres</span>
                                      <span ng-show="myForm.uname.$invalid">Este campo es invalido</span>
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
                                      <span ng-show="myForm.uname.$invalid">Este campo es invalido</span>
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
                                      <span ng-show="myForm.uname.$invalid">Este campo es invalido</span>
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
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>ID.</th>
                              <th>Direccion</th>
                              <th>Numero</th>
                              <th>Referencia</th>
                              <th>Latitud</th>
                              <th>Longitud</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="d in direcciones">
                              <td><span ng-bind="d.id"></span></td>
                              <td><span ng-bind="d.domicilio"></span></td>
                              <td><span ng-bind="d.numero"></span></td>
                              <td><span ng-bind="d.referencia"></span></td>
                              <td><span ng-bind="d.latitud"></span></td>
                              <td><span ng-bind="d.longitud"></span></td>
                              <td>
                              <button type="button" ng-click="ctrl.edit(d.id)" class="btn btn-success custom-width">Editar</button>  
                              <button type="button" ng-click="ctrl.remove(d.id)" class="btn btn-danger custom-width">Eliminar</button>
                              </td>
                          </tr>
                      </tbody>
                  </table>
              </div>
          </div>
      </div>

      