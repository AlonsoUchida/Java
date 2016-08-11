
	   <div class="generic-container" ng-controller="UsuarioController as ctrl">
          <div class="panel panel-default">
              <div class="panel-heading">
              	 	<span class="lead">Registro de Bodeguero</span> 
	              	 <div class="form-actions floatRight">
	              	 <button type="button" ng-click="ctrl.reset()" class="btn btn-default" style="float: right;">Refrescar</button>
	              	 </div>
              </div>
              <div class="formcontainer">
                  <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                      <input type="hidden" ng-model="ctrl.usuario.id" />
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="nombre">Nombre</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.usuario.nombre" id="nombre" class="username form-control input-sm" placeholder="Ingresa tu nombre" required ng-minlength="3"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                     	              <span ng-show="myForm.uname.$error.required">Este campo es requerido</span>
                                      <span ng-show="myForm.uname.$error.minlength">El mínimo tamaño es de 3 caracteres</span>
                                      <span ng-show="myForm.uname.$invalid">Este campo es inválido</span>
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
                                      <span ng-show="myForm.uname.$error.required">Este campo es requerido</span>
                                      <span ng-show="myForm.uname.$error.minlength">El mínimo tamaño es de 3 caracteres</span>
                                      <span ng-show="myForm.uname.$invalid">Este campo es inválido</span>
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
                                      <span ng-show="myForm.email.$error.required">Este campo es requerido</span>
                                      <span ng-show="myForm.email.$invalid">Este campo es inválido</span>
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
                                     <span ng-show="myForm.uname.$error.required">Este campo es requerido</span>
                                      <span ng-show="myForm.uname.$error.minlength">El mínimo tamaño es de 3 caracteres</span>
                                      <span ng-show="myForm.uname.$invalid">Este campo es inválido</span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      
                       <!--  <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="fechaNacimiento">Fecha de Nacimiento</label>
                              <div class="col-md-7">
                              <input type="text" ng-model="datepickerFechaNacimiento" datepicker required />
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.uname.$error.required">Este campo es requerido</span>
                                      <span ng-show="myForm.uname.$invalid">Este campo es inválido</span>
                                  </div>
                              </div>
                          </div>                          
                      </div>  -->
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="fechaNacimiento">Fecha de Nacimiento</label>
                              <div class="col-md-7">
			                      <div  ng-cloak="" class="datepickerdemoBasicUsage">
									  <md-content>
									      <md-datepicker name="dateField" ng-model="fechaNacimiento" md-placeholder="Ingrese la fecha" required=""></md-datepicker>									
									      <div class="validation-messages" ng-messages="myForm.dateField.$error">
									        <div ng-message="valid">Este campo es inválido</div>
									        <div ng-message="required">Este campo es requerido</div>
									      </div>									
									  </md-content>
									</div>
						 	</div>
                          </div>                          
                      </div>  
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="genero">Genero</label>
                              <div class="col-md-7">
                                 <select id="soflow" ng-model="ctrl.genero" ng-options="genero as genero.descripcion for genero in generos"
                                 ng-change="actualizarGenero(ctrl.genero)" required>
                                 <option value="">- Seleccione Genero -</option>
                                 </select>
                                 <span ng-show="myForm.uname.$error.required">Este campo es requerido</span>
                                 <span ng-show="myForm.uname.$invalid">Este campo es inválido</span>
                              </div>

                          </div>

                      </div> 
                        
                        <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="tipoDocumento">Tipo Documento</label>
                              
                              <div class="col-md-7">
                              	<select id="soflow" ng-model="ctrl.tipoDocumento" ng-options="tipoDocumento as tipoDocumento.descripcion for tipoDocumento in tipoDocumentos"
                                ng-change="actualizarTipoDocumento(ctrl.tipoDocumento)" required>
                                <option value="">- Seleccione Tipo Documento -</option>
                                </select>
                                <span ng-show="myForm.uname.$error.required">Este campo es requerido</span>
                                <span ng-show="myForm.uname.$invalid">Este campo es inválido</span>
                              </div>
                          </div>
                      </div>   
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="valorDocumento">Valor Documento</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.usuario.valorDocumento" id="valorDocumento" class="username form-control input-sm" placeholder="Ingresa el Nro. de Documento" required ng-minlength="3"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.uname.$error.required">Este campo es requerido</span>
                                      <span ng-show="myForm.uname.$error.minlength">El mínimo tamaño es de 3 caracteres</span>
                                      <span ng-show="myForm.uname.$invalid">Este campo es inválido</span>
                                  </div>
                              </div>
                          </div>
                      </div>   
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="direccionFiscal">Dirección Fiscal</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.usuario.direccionFiscal" id="direccionFiscal" class="username form-control input-sm" placeholder="Ingresa Dirección Fiscal" required ng-minlength="3"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                     <span ng-show="myForm.uname.$error.required">Este campo es requerido</span>
                                      <span ng-show="myForm.uname.$error.minlength">El mínimo tamaño es de 3 caracteres</span>
                                      <span ng-show="myForm.uname.$invalid">Este campo es inválido</span>
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
               <input ng-model="q" id="search" class="form-control" placeholder="Filter text" style='margin-top: 12px;'>
			    <select ng-model="pageSize" id="pageSize" class="form-control" style='margin-top: 12px;'>
			        <option value="5">5</option>
			        <option value="10">10</option>
			        <option value="15">15</option>
			        <option value="20">20</option>
			     </select>
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>Nombre</th>
                              <th>Apellido</th>
                              <th class="ocultar">Correo</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="u in usuarios | filter:q | startFrom:currentPage*pageSize | limitTo:pageSize">
                              <td><span ng-bind="u.nombre"></span></td>
                              <td><span ng-bind="u.apellido"></span></td>
                              <td class="ocultar"><span ng-bind="u.correo"></span></td>
                              <td>
                              <button type="button" ng-click="ctrl.edit(u.id)" class="btn btn-success custom-width">Editar</button>  
                              <button type="button" ng-click="ctrl.remove(u.id)" class="btn btn-danger custom-width">Eliminar</button>
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

      