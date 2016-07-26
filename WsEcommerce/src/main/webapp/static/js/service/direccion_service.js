'use strict';

App.factory('DireccionService',
				[
						'$http',
						'$q',
						'token',
						'servidor',
						function($http, $q, token, servidor) {

							return {

								listarTiendas : function() {
									var settings = {
										"async" : true,
										"crossDomain" : true,
										"url" : servidor + "/tienda/listar",
										"method" : "GET",
										"headers" : {
											"token" : token,
											"cache-control" : "no-cache",
										}
									}

									return $
											.ajax(settings)
											.done(
													function(response,
															statusText, xhr) {
														var status = xhr.status;
														console.log(status);
													})
											.error(
													function(jqXHR, textStatus,
															errorThrown) {
														var status = jqXHR.status;
														if (status == 401) {
															alert("Sus crendenciales han expirado. Por favor, ingrese nuevamente.");
														}
														console.log(status);
														return $q
																.reject(errResponse);
													});
								},
								listarDepartamentos : function() {
									var settings = {
										"async" : true,
										"crossDomain" : true,
										"url" : servidor
												+ "/departamento/listar",
										"method" : "GET",
										"headers" : {
											"token" : token,
											"cache-control" : "no-cache",
										}
									}

									return $
											.ajax(settings)
											.done(
													function(response,
															statusText, xhr) {
														var status = xhr.status;
														console.log(status);
													})
											.error(
													function(jqXHR, textStatus,
															errorThrown) {
														var status = jqXHR.status;
														if (status == 401) {
															alert("Sus crendenciales han expirado. Por favor, ingrese nuevamente.");
														}
														console.log(status);
														return $q
																.reject(errResponse);
													});
								},
								listarProvincias : function() {
									var settings = {
										"async" : true,
										"crossDomain" : true,
										"url" : servidor
												+ "/provincia/listar",
										"method" : "GET",
										"headers" : {
											"token" : token,
											"cache-control" : "no-cache",
										}
									}

									return $
											.ajax(settings)
											.done(
													function(response,
															statusText, xhr) {
														var status = xhr.status;
														console.log(status);
													})
											.error(
													function(jqXHR, textStatus,
															errorThrown) {
														var status = jqXHR.status;
														if (status == 401) {
															alert("Sus crendenciales han expirado. Por favor, ingrese nuevamente.");
														}
														console.log(status);
														return $q
																.reject(errResponse);
													});
								},
								listarDistritos : function() {
									var settings = {
										"async" : true,
										"crossDomain" : true,
										"url" : servidor
												+ "/distrito/listar",
										"method" : "GET",
										"headers" : {
											"token" : token,
											"cache-control" : "no-cache",
										}
									}

									return $
											.ajax(settings)
											.done(
													function(response,
															statusText, xhr) {
														var status = xhr.status;
														console.log(status);
													})
											.error(
													function(jqXHR, textStatus,
															errorThrown) {
														var status = jqXHR.status;
														if (status == 401) {
															alert("Sus crendenciales han expirado. Por favor, ingrese nuevamente.");
														}
														console.log(status);
														return $q
																.reject(errResponse);
													});
								},
								listarDistritosPorProvincia : function(id) {
									var settings = {
										"async" : true,
										"crossDomain" : true,
										"url" : servidor
												+ "/distrito/listarPorProvincia?id="
												+ id,
										"method" : "GET",
										"headers" : {
											"token" : token,
											"cache-control" : "no-cache",
										}
									}

									return $
											.ajax(settings)
											.done(
													function(response,
															statusText, xhr) {
														var status = xhr.status;
														console.log(status);
													})
											.error(
													function(jqXHR, textStatus,
															errorThrown) {
														var status = jqXHR.status;
														if (status == 401) {
															alert("Sus crendenciales han expirado. Por favor, ingrese nuevamente.");
														}
														console.log(status);
														return $q
																.reject(errResponse);
													});
								},
								listarProvinciasPorDepartamento : function(id) {
									var settings = {
										"async" : true,
										"crossDomain" : true,
										"url" : servidor
												+ "/provincia/listarPorDepartamento?id="
												+ id,
										"method" : "GET",
										"headers" : {
											"token" : token,
											"cache-control" : "no-cache",
										}
									}

									return $
											.ajax(settings)
											.done(
													function(response,
															statusText, xhr) {
														var status = xhr.status;
														console.log(status);
													})
											.error(
													function(jqXHR, textStatus,
															errorThrown) {
														var status = jqXHR.status;
														if (status == 401) {
															alert("Sus crendenciales han expirado. Por favor, ingrese nuevamente.");
														}
														console.log(status);
														return $q
																.reject(errResponse);
													});
								},
								listarPorTienda : function(id) {
									var settings = {
										"async" : true,
										"crossDomain" : true,
										"url" : servidor
												+ "/direccion/listarPorTienda?id="
												+ id,
										"method" : "GET",
										"headers" : {
											"token" : token,
											"cache-control" : "no-cache",
										}
									}

									return $
											.ajax(settings)
											.done(
													function(response,
															statusText, xhr) {
														var status = xhr.status;
														console.log(status);
													})
											.error(
													function(jqXHR, textStatus,
															errorThrown) {
														var status = jqXHR.status;
														if (status == 401) {
															alert("Sus crendenciales han expirado. Por favor, ingrese nuevamente.");
														}
														console.log(status);
														return $q
																.reject(errResponse);
													});
								},

								obtenerPorId : function(id) {
									var settings = {
										"async" : true,
										"crossDomain" : true,
										"url" : servidor
												+ "/direccion/obtenerPorId?id="
												+ id,
										"method" : "GET",
										"headers" : {
											"cache-control" : "no-cache",
											"token" : token,
										}
									}

									return $
											.ajax(settings)
											.done(
													function(response,
															statusText, xhr) {
														var status = xhr.status;
														console.log(status);
													})
											.fail(
													function(errResponse,
															statusText, xhr) {
														var status = xhr.status;
														console.log(status);
														console
																.error('Error while getting direccion');
														return $q
																.reject(errResponse);
													});

								},
								obtenerProvinciaPorDistrito : function(id) {
									var settings = {
										"async" : true,
										"crossDomain" : true,
										"url" : servidor
												+ "/provincia/obtenerProvinciaPorDistrito?id="
												+ id,
										"method" : "GET",
										"headers" : {
											"cache-control" : "no-cache",
											"token" : token,
										}
									}

									return $
											.ajax(settings)
											.done(
													function(response,
															statusText, xhr) {
														var status = xhr.status;
														console.log(status);
													})
											.fail(
													function(errResponse,
															statusText, xhr) {
														var status = xhr.status;
														console.log(status);
														console
																.error('Error while obtenerProvinciaPorDistrito user');
														return $q
																.reject(errResponse);
													});

								},
								obtenerDepartamentoPorProvincia : function(id) {
									var settings = {
										"async" : true,
										"crossDomain" : true,
										"url" : servidor
												+ "/departamento/obtenerDepartamentoPorProvincia?id="+ id,
										"method" : "GET",
										"headers" : {
											"cache-control" : "no-cache",
											"token" : token,
										}
									}

									return $
											.ajax(settings)
											.done(
													function(response,
															statusText, xhr) {
														var status = xhr.status;
														console.log(status);
													})
											.fail(
													function(errResponse,
															statusText, xhr) {
														var status = xhr.status;
														console.log(status);
														console
																.error('Error while obtenerDepartamentoPorProvincia user');
														return $q
																.reject(errResponse);
													});

								},

								agregar : function(tienda) {
									var settings = {
										"async" : true,
										"crossDomain" : true,
										"url" : servidor
												+ "/direccion/agregarPorTienda",
										"method" : "POST",
										"headers" : {
											"token" : token,
											"content-type" : "application/json",
											"cache-control" : "no-cache"
										},
										"processData" : false,
										"data" : JSON.stringify(tienda)
									}

									return $
											.ajax(settings)
											.done(
													function(response,
															statusText, xhr) {
														var status = xhr.status;
														if (status == 201) {
															alert("Creado satisfactoriamente");
														}
														console.log(status);
													})
											.error(
													function(jqXHR, textStatus,
															errorThrown) {
														var status = jqXHR.status;
														if (status == 401) {
															alert("Sus crendenciales han expirado. Por favor, ingrese nuevamente.");
														}
														if (status == 409) {
															alert("Usuario ya existe");
														}
														console.log(status);
														console
																.error('Error while creating users');
														return $q
																.reject(errResponse);
													});

								},

								actualizar : function(tienda, id) {

									var settings = {
										"async" : true,
										"crossDomain" : true,
										"url" : servidor
												+ "/direccion/actualizarPorTienda",
										"method" : "PUT",
										"headers" : {
											"content-type" : "application/json",
											"token" : token,
											"cache-control" : "no-cache"
										},
										"processData" : false,
										"data" : JSON.stringify(tienda)
									}

									return $
											.ajax(settings)
											.done(
													function(response,
															statusText, xhr) {
														var status = xhr.status;
														console.log(status);
														if (status == 200) {
															alert("Se ha actualizado satisfactoriamente");
														}
													})
											.error(
													function(jqXHR, textStatus,
															errorThrown) {
														var status = jqXHR.status;
														if (status == 401) {
															alert("Sus crendenciales han expirado. Por favor, ingrese nuevamente.");
														}
														console.log(status);
														return $q
																.reject(errResponse);
													});

								},

								eliminar : function(id) {
									var settings = {
										"async" : true,
										"crossDomain" : true,
										"url" : servidor
												+ "/direccion/eliminar?id="
												+ id,
										"method" : "DELETE",
										"headers" : {
											"token" : token,
											"cache-control" : "no-cache"
										}
									}

									return $
											.ajax(settings)
											.done(
													function(response,
															statusText, xhr) {
														var status = xhr.status;
														console.log(status);
														if (status == 204) {
															console
																	.log("Elimino satisfactoriamente");
														}
													})
											.fail(
													function(errResponse,
															statusText, xhr) {
														var status = xhr.status;
														console.log(status);
														console
																.error('Error while deleting users');
														return $q
																.reject(errResponse);
													});

								}

							};

						} ]);