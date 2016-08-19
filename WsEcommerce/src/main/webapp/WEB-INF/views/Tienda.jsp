    <div class="generic-container" ng-controller="TiendaController as ctrl">
          <div class="panel panel-default">
              <div class="panel-heading">
              	 	<span class="lead">Registro de Tienda</span> 
	              	 <div class="form-actions floatRight">
	              	 <button type="button" ng-click="ctrl.reset()" class="btn btn-default" style="float: right;">Refrescar</button>
	              	 </div>
              </div>
              <div class="formcontainer">
                  <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                      <input type="hidden" ng-model="ctrl.tienda.id" />
                      
                       <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="tarjeta">Bodeguero</label>
                              <div class="col-md-7">
                                 <select id="soflow" ng-model="ctrl.bodeguero" ng-options='bodeguero as (bodeguero.nombre + " " + bodeguero.apellido) for bodeguero in bodegueros'
                                 ng-change="actualizarBodeguero(ctrl.bodeguero)" required>
                                 	<option value="">- Seleccione Bodeguero -</option>
                                 </select>
                                 <span ng-show="myForm.uname.$error.required">Este campo es requerido</span>    
                                 <span ng-show="myForm.uname.$invalid">Este campo es inválido</span>
                              </div>

                          </div>
                      </div> 
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="nombre">Nombre</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.tienda.nombre" id="nombre" class="username form-control input-sm" placeholder="Ingresa el nombre" required ng-minlength="3"/>
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
                              <label class="col-md-2 control-lable" for="apellido">RUC</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.tienda.ruc" id="ruc" class="username form-control input-sm" placeholder="Ingresa el RUC" required ng-minlength="3" />
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
                              <label class="col-md-2 control-lable" for="razonSocial">Razón Social</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.tienda.razon_social" id="razonSocial" class="username form-control input-sm" placeholder="Ingresa la Razón Social" required ng-minlength="3" />
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
                              <label class="col-md-2 control-lable" for="correo">Teléfono Local</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.tienda.telefono_local" id="telefonoLocal" class="username form-control input-sm" placeholder="Ingresa el telefono local"  ng-maxlength="10"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                     <span ng-show="myForm.uname.$error.required">Este campo es requerido</span>
                                      <span ng-show="myForm.uname.$error.minlength">El mínimo tamaño es de 3 caracteres</span>
                                      <span ng-show="myForm.uname.$error.maxlength">El mínimo tamaño es de 10 caracteres</span>
                                      <span ng-show="myForm.uname.$invalid">Este campo es inválido</span>
                                  </div>
                              </div>
                          </div>
                      </div>
                       <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="correo">Teléfono Móvil</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.tienda.telefono_movil" id="telefonoMovil" class="username form-control input-sm" placeholder="Ingresa el telefono móvil" ng-maxlength="10" />
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.uname.$error.required">Este campo es requerido</span>
                                      <span ng-show="myForm.uname.$error.minlength">El mínimo tamaño es de 3 caracteres</span>
                                      <span ng-show="myForm.uname.$error.maxlength">El mínimo tamaño es de 10 caracteres</span>
                                      <span ng-show="myForm.uname.$invalid">Este campo es inválido</span>
                                  </div>
                              </div>
                          </div>
                      </div>                   
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="horarioApertura">Horarios</label>
                              
                              <div class="form-group col-md-9">
                              		 <div class="form-group col-md-5">
		                                 <label class="col-md-2 control-lable" for="horarioInicial">Hora</label> 
		                                 <select ng-model="ctrl.horaInicial" ng-options="hora as hora.nombre for hora in horas"
		                                 ng-change="actualizarHorario(ctrl.horaInicial, 1)" required> <option value="">- Hora Inicio -</option> </select> -
		                                 <select ng-model="ctrl.horaFinal" ng-options="hora as hora.nombre for hora in horas"
		                                 ng-change="actualizarHorario(ctrl.horaFinal, 2)" required> <option value="">- Hora Final -</option> </select> 
	                                 </div>
	                                 <div class="form-group col-md-4">
		                                 <label class="col-md-2 control-lable" for="diaInicial">Dia</label>
		                                 <select ng-model="ctrl.diaInicial" ng-options="dia as dia.nombre for dia in dias"
		                                 ng-change="actualizarHorario(ctrl.diaInicial, 3)" required> <option value="">- Dia Inicial -</option> </select> -
		                                 <select  ng-model="ctrl.diaFinal" ng-options="dia as dia.nombre for dia in dias"
		                                 ng-change="actualizarHorario(ctrl.diaFinal, 4)" required> <option value="">- Dia Final -</option> </select>
	                                 </div>
	                                 <div class="form-group col-md-2">
	                                   <td>
			                              <button type="button" ng-click="agregarHorario()" class="btn btn-success btn-sm">Añadir</button>  
                              		 	</td>
                              		 </div>
						              <div class="tablecontainer">
						                  <table class="table table-hover">
						                  	 <thead>
						                          <tr>
						                              <th class="ocultar">Dia Inicial</th>  
						                              <th class="ocultar">Dia Final</th>                              
						                              <th class="ocultar">Hora Inicial</th>
						                              <th class="ocultar">Hora Final</th>
						                              <th width="20%"></th>
						                          </tr>
						                      </thead>
						                      <tbody>
						                          <tr ng-repeat="h in ctrl.horarios_descripcion ">
						                              <td class="ocultar"><span ng-bind="h.dia_inicial"></span></td>
						                              <td class="ocultar"><span ng-bind="h.dia_final"></span></td>
						                              <td class="ocultar"><span ng-bind="h.hora_inicial"></span></td>
						                              <td class="ocultar"><span ng-bind="h.hora_final"></span></td>
						                              <td>
						                              <button type="button" ng-click="eliminarHorario(h.id)" class="btn btn-danger btn-sm">Eliminar</button>
						                              </td>
						                          </tr>
						                      </tbody>
						                  </table>
	                                 <span ng-show="myForm.uname.$error.required">Este campo es requerido</span>
	                                 <span ng-show="myForm.uname.$invalid">Este campo es inválido</span>
                              </div>

                         	 </div>
                      	</div> 

                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="horarioAtencion">Horario de Atención</label>
                               <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.tienda.horarioAtencion" id="horarioAtencion" class="username form-control input-sm" placeholder="Ingrese horario de Atención. Ejm: 00:00 AM - 00:00 PM"/>
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
                              <label class="col-md-2 control-lable" for="paginaweb">Página Web</label>
                               <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.tienda.paginaweb" id="paginaweb" class="username form-control input-sm" placeholder="Ingrese la url de la página web"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.uname.$error.minlength">El mínimo tamaño es de 3 caracteres</span>
                                      <span ng-show="myForm.uname.$invalid">Este campo es inválido</span>
                                  </div>
                              </div>

                          </div>
                      </div> 
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="tarjeta">Uso de Tarjeta</label>
                              <div class="col-md-7">
                                 <select id="soflow" ng-model="ctrl.tarjeta" ng-options="tarjeta as tarjeta.nombre for tarjeta in tarjetas"
                                 ng-change="actualizarTarjeta(ctrl.tarjeta)" required></select>
                                 <span ng-show="myForm.uname.$error.required">Este campo es requerido</span>    
                                 <span ng-show="myForm.uname.$invalid">Este campo es inválido</span>
                              </div>

                          </div>
                      </div> 
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="banco">Banco</label>
                              <div class="col-md-7">
                                 <select ng-model="ctrl.banco" ng-options="banco as banco.nombre for banco in bancos"
                                 ng-change="actualizarBanco(ctrl.banco)" multiple></select>
                                 <span ng-show="myForm.uname.$error.required">Este campo es requerido</span>                         
                                 <span ng-show="myForm.uname.$invalid">Este campo es inválido</span>
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
                              <th>Nombre</th>
                              <th class="ocultar">RUC</th>
                              <th class="ocultar">Razón Social</th>  
                              <th class="ocultar">Teléfono Local</th>                              
                              <th class="ocultar">Horario de Atención</th>
                              <th class="ocultar">Página Web</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="t in tiendas | filter:q | startFrom:currentPage*pageSize | limitTo:pageSize">
                              <td><span ng-bind="t.nombre"></span></td>
                              <td class="ocultar"><span ng-bind="t.ruc"></span></td>
                              <td class="ocultar"><span ng-bind="t.razonSocial"></span></td>
                              <td class="ocultar"><span ng-bind="t.telefono_local"></span></td>
                              <td class="ocultar"><span ng-bind="t.horarioAtencion"></span></td>
                              <td class="ocultar"><span ng-bind="t.paginaweb"></span></td>
                              <td>
                              <button type="button" ng-click="ctrl.edit(t.id)" class="btn btn-success custom-width">Editar</button>  
                              <button type="button" ng-click="ctrl.remove(t.id)" class="btn btn-danger custom-width">Eliminar</button>
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

      
