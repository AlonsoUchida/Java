
	   <div class="generic-container" ng-controller="ImagenController as ctrl">
          <div class="panel panel-default">
              <div class="panel-heading"><span class="lead">Registro de Imagen Por Tienda</span></div>
              <div class="formcontainer">
                  <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                      <input type="hidden" ng-model="ctrl.imagen.id" />
                      
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
                              <label class="col-md-2 control-lable" for="nombre">Nombre</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.imagen.nombre" id="nombre" class="username form-control input-sm" placeholder="Ingresa el nombre" required ng-minlength="3"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                     	              <span ng-show="myForm.uname.$error.required">Este campo es requerido</span>
                                      <span ng-show="myForm.uname.$error.minlength">El minimo tamaño es de 3 caracteres</span>
                                      <span ng-show="myForm.uname.$invalid">Este campo es invalido</span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      
                      <!-- IMAGEN -->
                      <div class="row">
                      		<div class="form-group col-md-12">
		                      	 <label class="col-md-2 control-lable" for="departamento">Imagen</label>
		                      	 <input type="file" file-model="myFile"/>
		    					 <button ng-click="uploadFile()">subir</button>
		    					 <div id="dialog" title="Basic dialog">
								  <p>Image:</p>
								   <img ng-src="{{image.path}}" style="width: {{image.width}}px; height: {{image.height}}px" />
								
								</div>
									    					
		    					<div class="has-error" ng-show="myForm.$dirty">
	                     	              <span ng-show="myForm.uname.$error.required">Este campo es requerido</span>
	                                      <span ng-show="myForm.uname.$error.minlength">El minimo tamaño es de 3 caracteres</span>
	                                      <span ng-show="myForm.uname.$invalid">Este campo es invalido</span>
	                            </div>
                            </div>
                      </div> 
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="departamento">Defecto</label>
                              <div class="col-md-7">
                                 <select ng-model="ctrl.defecto" ng-options="defecto as defecto.nombre for defecto in defectos"
                                 ng-change="actualizarDefecto(ctrl.defecto)" required></select>
                                 <span ng-show="myForm.uname.$error.required">Este campo es requerido</span>
                                 <span ng-show="myForm.uname.$invalid">Este campo es invalido</span>
                              </div>

                          </div>
                      </div> 
             
                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"  value="{{!ctrl.imagen.id ? 'Agregar' : 'Actualizar'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                              <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Limpiar</button>
                          </div>
                      </div>
                  </form>
              </div>
          </div>
          <div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">Lista de Imagenes</span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>ID.</th>
                              <th>Nombre</th>
                              <th>Imagen</th>
                              <th>Defecto</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="i in imagenes">
                              <td><span ng-bind="i.id"></span></td>
                              <td><span ng-bind="i.nombre"></span></td>
                              <td><span ng-bind="i.imagen"></span></td>
                              <td><span ng-bind="i.defecto"></span></td>
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

      