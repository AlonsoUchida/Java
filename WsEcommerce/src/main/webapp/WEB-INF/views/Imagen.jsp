
	   <div class="generic-container" ng-controller="ImagenController as ctrl">
          <div class="panel panel-default">
              <div class="panel-heading">
              <div class="row">
              	 	<span class="lead">Registro de Imagen Por Tienda</span> 
	              	 <div class="form-actions floatRight">
	              	 <button type="button" ng-click="ctrl.reset()" class="btn btn-default" style="float: right;">Refrescar</button>
	              	 </div>
              	 </div>
              </div>
              <div class="formcontainer">
                  <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                      <input type="hidden" ng-model="ctrl.imagen.id" />
                      
                       <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="tienda">Tienda</label>
                              <div class="col-md-7">
                                 <select id="soflow" ng-model="ctrl.tienda" ng-options="tienda as tienda.nombre for tienda in tiendas"
                                 ng-change="actualizarTienda(ctrl.tienda)" required>
                                 <option value="">- Seleccione Tienda -</option>
                                 </select>
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
                     
                      
                      <div class="row">
                      		<div class="form-group col-md-12">
							 <label class="col-md-2 control-lable" for="imagen">Imagen</label>
							 <div class="col-md-7">
						      <input type="file" ngf-select ng-model="picFile" id="imagen" name="file"    
						             accept="image/*" ngf-max-size="2MB" required
						             ngf-model-invalid="errorFile" ng-change="convertToBase64()">
						      <div class="has-error" ng-show="myForm.$dirty">
	                     	       <span ng-show="myForm.uname.$error.required">Este campo es requerido</span>
	                          </div>	                          
	                            <img ng-show="myForm.file.$valid" ngf-thumbnail="picFile" class="thumb" height="300" width="300"> 
						      <button ng-click="picFile = null" ng-show="picFile" class="btn btn-primary btn-sm" >Quitar</button>						     
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
                              <th>Imagen</th>
                              <th>Defecto</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="i in imagenes | filter:q | startFrom:currentPage*pageSize | limitTo:pageSize" height="300">
                              <td><span ng-bind="i.nombre"></span></td>
                              <td><img ng-src="data:image/JPEG;base64,{{i.imagen}}"  height="300" width="300"></td>
                              <td><span ng-bind="i.defecto"></span></td>
                              <td>
                              <button type="button" ng-click="ctrl.edit(i.id)" class="btn btn-success custom-width">Editar</button>  
                              <button type="button" ng-click="ctrl.remove(i.id)" class="btn btn-danger custom-width">Eliminar</button>
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

      