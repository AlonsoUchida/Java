    <div class="generic-container" ng-controller="UsuarioController as ctrl">
          <div class="panel panel-default">
              <div class="panel-heading"><span class="lead">Registro de Bodeguero</span></div>
              <div class="formcontainer">
                  <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                      <input type="hidden" ng-model="ctrl.usuario.id" />
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="nombre">Nombre</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.usuario.nombre" id="nombre" class="username form-control input-sm" placeholder="Ingresa tu nombre" required ng-minlength="3"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.uname.$error.required">This is a required field</span>
                                      <span ng-show="myForm.uname.$error.minlength">Minimum length required is 3</span>
                                      <span ng-show="myForm.uname.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="apellido">Apellido</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.usuario.apellido" id="apellido" class="username form-control input-sm" placeholder="Ingresa tu apellido" required ng-minlength="3"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.uname.$error.required">This is a required field</span>
                                      <span ng-show="myForm.uname.$error.minlength">Minimum length required is 3</span>
                                      <span ng-show="myForm.uname.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
                       <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="correo">Correo</label>
                              <div class="col-md-7">
                                  <input type="email" ng-model="ctrl.usuario.correo" id="correo" class="email form-control input-sm" placeholder="Ingresa tu correo" required/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.email.$error.required">This is a required field</span>
                                      <span ng-show="myForm.email.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="password">Password</label>
                              <div class="col-md-7">
                                  <input type="password" ng-model="ctrl.usuario.password" id="password" class="username form-control input-sm" placeholder="Ingresa tu password" required ng-minlength="3"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.uname.$error.required">This is a required field</span>
                                      <span ng-show="myForm.uname.$error.minlength">Minimum length required is 3</span>
                                      <span ng-show="myForm.uname.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="genero">Genero</label>
                              <div class="col-md-7">
                                 <select ng-model="ctrl.usuario.genero" ng-options="genero as genero.descripcion for genero in generos"></select>
                              </div>
                          </div>
                      </div> 
                        
                        <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="tipoDocumento">Tipo Documento</label>
                              
                              <div class="col-md-7">
                              	<select ng-model="ctrl.usuario.id_tipoDocumento" ng-options="tipoDocumento as tipoDocumento.descripcion for tipoDocumento in tipoDocumentos"></select>
                              </div>
                          </div>
                      </div>   
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="valorDocumento">Valor Documento</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.usuario.valorDocumento" id="valorDocumento" class="username form-control input-sm" placeholder="Ingresa el Nro. de Documento" required ng-minlength="3"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.uname.$error.required">This is a required field</span>
                                      <span ng-show="myForm.uname.$error.minlength">Minimum length required is 3</span>
                                      <span ng-show="myForm.uname.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>   
                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"  value="{{!ctrl.usuario.id ? 'Agregar' : 'Actualizar'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                              <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Limpiar</button>
                          </div>
                      </div>
                  </form>
              </div>
          </div>
          <div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">Lista de Usuarios</span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>ID.</th>
                              <th>Nombre</th>
                              <th>Apellido</th>
                              <th>Correo</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="u in usuarios">
                              <td><span ng-bind="u.id"></span></td>
                              <td><span ng-bind="u.nombre"></span></td>
                              <td><span ng-bind="u.apellido"></span></td>
                              <td><span ng-bind="u.correo"></span></td>
                              <td>
                              <button type="button" ng-click="ctrl.edit(u.id)" class="btn btn-success custom-width">Editar</button>  
                              <button type="button" ng-click="ctrl.remove(u.id)" class="btn btn-danger custom-width">Eliminar</button>
                              </td>
                          </tr>
                      </tbody>
                  </table>
              </div>
          </div>
      </div>

      