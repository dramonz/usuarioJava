Ext.ClassManager
		.create(
				'PR.controller.BusquedaUsuario',
				{
					extend : 'Ext.app.Controller',
					stores : [ 'DependenciasComboUsuarios', 'BusquedaUsuarioGrid' ],
					models : [ 'Dependencia', 'Usuario' ],
					views : [ 'usuario.BusquedaUsuario',
							'usuario.BusquedaUsuarioGrid' ],
					requires : [ 'PR.util.Namespace' ],
					widgets : [],
					init : function() {
						var value = null;
						var Busqueda = null;
						var nosolicitud = null;
						var fechainstalacion = null;
						var estado = null;
						this.getStore('DependenciasComboUsuarios').load();
						this.control({
							'combobox[id=Busqueda]' : {
								select : this.onSelectBusqueda
							},
							'button[id=idBuscar]' : {
								click : this.onBuscar
							},
							'button[id=idActivar]' : {
								click : this.activarUsuario
							},
							'button[id=idDesactivar]' : {
								click : this.desactivarUsuario
							}
//							
//							'busquedaUsuarioGrid toolbar button' : {
//								click : this.activarUsuario
//							},
//							'busquedaUsuarioGrid toolbar button' : {
//								click : this.desactivarUsuario
//							}
						});
					},
					onSelectBusqueda : function(combo, records) {
						value = combo.getValue();
						if (value != 0) {
							if (value == 1) {
								// Dependencia
								Ext.getCmp('idDependencia').setVisible(true);
							} else {
								Ext.getCmp('idDependencia').setVisible(false);
							}
						} else {
							Ext.getCmp('idDependencia').setVisible(false);
						}
					},
					onBuscar : function() {
//						var Busqueda = Ext.getCmp('Busqueda').getValue();
						var idDependencia = Ext.getCmp('idDependencia')
								.getValue();

						Ext.getCmp('idDependencia').setDisabled(true);
//						Ext.getCmp('Busqueda').setDisabled(true);

						var gridstore = Ext.getStore('BusquedaUsuarioGrid');
//						gridstore.proxy.extraParams.Busqueda = Busqueda;
						gridstore.proxy.extraParams.idDependencia = idDependencia;

						gridstore.load({
							params : {
								idDependencia : idDependencia,
//								Busqueda : Busqueda
							},
							callback : function(records, operation, success) {
								if (success) {
									Ext.getCmp('idDependencia').setDisabled(
											false);
//									Ext.getCmp('Busqueda').setDisabled(false);
									var count = gridstore.getCount();
									if (count == 0) {
										Ext.MessageBox.alert('Mensaje',
												' Busqueda no exitosa ');

									}
									gridstore.clearFilter();
								}
							}

						});

					},
					activarUsuario : function(btn) {
						var seleccion = Ext.getCmp("busquedaUsuarioGrid").getSelectionModel().getSelection();
						var index = 0;
						var activar = new Array();
						if (seleccion.length > 0)
						{
							for ( var i = 0, l= seleccion.length; i<l; i++) {
								
									if (seleccion[i].get('activo') == 0)

									{	
										activar.push(seleccion[i].data);
										index++;
									}

									}
						Ext.Msg
								.show({
									title : '¿Guardar cambios?',
									msg : '¿Realmente desea guardar cambios?',
									buttons : Ext.Msg.YESNO,
									icon : Ext.Msg.QUESTION,
									closable : false,
									fn : function(boton) {
										if (boton == 'yes') {
											Ext.Ajax.request({
														url : Namespace.namespace
																+ 'usuarios/activarUsuarios',
														jsonData : {
															activos : activar,

														},
														success : function() {
															Ext.getStore('BusquedaUsuarioGrid').load();
														},
														failure : function() {
															Ext.MessageBox
																	.show({
																		msg : 'Ocurrió un error al actualizar los datos de los usuarios',
																		icon : Ext.MessageBox.ERROR,
																		buttons : Ext.MessageBox.OK
																	});
														}
													});
										}
									}
								});
						}
						else
						{
						Ext.MessageBox
						.show({
							msg : 'No ha seleccionado datos para activar',
							icon : Ext.MessageBox.INFO,
							buttons : Ext.MessageBox.OK
						});
						}

					},
					
					desactivarUsuario : function(btn) {
						var seleccion = Ext.getCmp("busquedaUsuarioGrid").getSelectionModel().getSelection();
						var index = 0;
						var desactivar = new Array();
						
						if (seleccion.length !=0)
							{
							
							for ( var i = 0, l= seleccion.length; i<l; i++) {
								
									if (seleccion[i].get('activo') == 1)
											
									{	
										desactivar.push(seleccion[i].data);
										index++;
									}
									}
							
						Ext.Msg
								.show({
									title : '¿Guardar cambios?',
									msg : '¿Realmente desea guardar cambios?',
									buttons : Ext.Msg.YESNO,
									icon : Ext.Msg.QUESTION,
									closable : false,
									fn : function(boton) {
										if (boton == 'yes') {
											Ext.Ajax.request({
														url : Namespace.namespace
																+ 'usuarios/desactivarUsuarios',
														jsonData : {
															inactivos : desactivar
														},
														success : function() {
															Ext.getStore('BusquedaUsuarioGrid').load();
														},
														failure : function() {
															Ext.MessageBox
																	.show({
																		msg : 'Ocurrió un error al actualizar los datos de los usuarios',
																		icon : Ext.MessageBox.ERROR,
																		buttons : Ext.MessageBox.OK
																	});
														}
													});
										}
									}
								});
							}
						else
							{
							Ext.MessageBox
							.show({
								msg : 'No ha seleccionado datos para desactivar',
								icon : Ext.MessageBox.INFO,
								buttons : Ext.MessageBox.OK
							});
							}

					},


					onRender : function() {

					},
					onWindowResizeListener : function() {
						var widgets = this.getWidgets();
						for ( var i = 0, l = widgets.length; i < l; i++) {
							widgets[i].doComponentLayout();
						}
					},
					addWidget : function(widget) {
						this.widgets.push(widget);
					},

					getWidgets : function() {
						return this.widgets;
					}

				});