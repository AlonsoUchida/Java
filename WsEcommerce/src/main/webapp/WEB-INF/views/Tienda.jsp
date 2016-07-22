    <div class="generic-container" ng-controller="TiendaController as ctrl">
          <div class="panel panel-default">
              <div class="panel-heading"><span class="lead">Registro de Tienda</span></div>
              <div class="formcontainer">
                  <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                      <input type="hidden" ng-model="ctrl.tienda.id" />
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="nombre">Nombre</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.tienda.nombre" id="nombre" class="username form-control input-sm" placeholder="Ingresa el nombre" required ng-minlength="3"/>
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
                              <label class="col-md-2 control-lable" for="apellido">Ruc</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.tienda.ruc" id="ruc" class="username form-control input-sm" placeholder="Ingresa el ruc" required ng-minlength="3"/>
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
                              <label class="col-md-2 control-lable" for="correo">Telefono Local</label>
                              <div class="col-md-7">
                                  <input type="number" ng-model="ctrl.tienda.telefono_local" id="telefonoLocal" class="username form-control input-sm" placeholder="Ingresa el telefono local" required/>
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
                              <label class="col-md-2 control-lable" for="correo">Telefono Movil</label>
                              <div class="col-md-7">
                                  <input type="number" ng-model="ctrl.tienda.telefono_movil" id="telefonoMovil" class="username form-control input-sm" placeholder="Ingresa el telefono movil" required/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.uname.$error.required">Este campo es requerido</span>
                                      <span ng-show="myForm.uname.$error.minlength">El minimo tamaño es de 3 caracteres</span>
                                      <span ng-show="myForm.uname.$invalid">Este campo es invalido</span>
                                  </div>
                              </div>
                          </div>
                      </div>                   
                      
                      <!--  <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="horarioApertura">Horario de Apertura</label>
                              <div class="col-md-7">
                                 <select ng-model="ctrl.horarioApertura" ng-options="horario as horario.nombre for horario in horarios"
                                 ng-change="actualizarHorario(ctrl.horarioApertura, 1)" required></select>
                                 	  <span ng-show="myForm.uname.$error.required">Este campo es requerido</span>
                                      <span ng-show="myForm.uname.$invalid">Este campo es invalido</span>
                              </div>

                          </div>
                      </div> 
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="horarioCierre">Horario de Cierre</label>
                              <div class="col-md-7">
                                 <select ng-model="ctrl.horarioCierre" ng-options="horario as horario.nombre for horario in horarios"
                                 ng-change="actualizarHorario(ctrl.horarioCierre, 2)" required></select>
                                 <span ng-show="myForm.uname.$error.required">Este campo es requerido</span>                               
                                 <span ng-show="myForm.uname.$invalid">Este campo es invalido</span>
                              </div>

                          </div>
                      </div> -->
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="horarioAtencion">Horario de Atencion</label>
                               <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.tienda.horarioAtencion" id="horarioAtencion" class="username form-control input-sm" placeholder="Ingrese horario de Atención. Ejm: 00:00 AM - 00:00 PM" required/>
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
                              <label class="col-md-2 control-lable" for="paginaweb">Pagina Web</label>
                               <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.tienda.paginaweb" id="paginaweb" class="username form-control input-sm" placeholder="Ingrese la url de la pagina web" required/>
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
                              <label class="col-md-2 control-lable" for="tarjeta">Uso de Tarjeta</label>
                              <div class="col-md-7">
                                 <select ng-model="ctrl.tarjeta" ng-options="tarjeta as tarjeta.nombre for tarjeta in tarjetas"
                                 ng-change="actualizarTarjeta(ctrl.tarjeta)" required></select>
                                 <span ng-show="myForm.uname.$error.required">Este campo es requerido</span>    
                                 <span ng-show="myForm.uname.$invalid">Este campo es invalido</span>
                              </div>

                          </div>
                      </div> 
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="banco">Banco</label>
                              <div class="col-md-7">
                                 <select ng-model="ctrl.banco" ng-options="banco as banco.nombre for banco in bancos"
                                 ng-change="actualizarBanco(ctrl.banco)"></select>
                                 <span ng-show="myForm.uname.$error.required">Este campo es requerido</span>                         
                                 <span ng-show="myForm.uname.$invalid">Este campo es invalido</span>
                              </div>

                          </div>
                      </div> 

                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"  value="{{!ctrl.tienda.id ? 'Agregar' : 'Actualizar'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                              <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Limpiar</button>
                          </div>
                      </div>
                  </form>
              </div>
          </div>
          <div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">Lista de Tiendas</span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>ID.</th>
                              <th>Nombre</th>
                              <th>Ruc</th>
                              <th>Telefono Local</th>                              
                              <th>Horario de Atencion</th>
                              <th>Pagina Web</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="t in tiendas">
                              <td><span ng-bind="t.id"></span></td>
                              <td><span ng-bind="t.nombre"></span></td>
                              <td><span ng-bind="t.ruc"></span></td>
                              <td><span ng-bind="t.telefonoLocal"></span></td>
                              <td><span ng-bind="t.horarioAtencion"></span></td>
                              <td><span ng-bind="t.paginaweb"></span></td>
                              <td>
                              <button type="button" ng-click="ctrl.edit(t.id)" class="btn btn-success custom-width">Editar</button>  
                              <button type="button" ng-click="ctrl.remove(t.id)" class="btn btn-danger custom-width">Eliminar</button>
                              </td>
                          </tr>
                      </tbody>
                  </table>
              </div>
          </div>
      </div>

      