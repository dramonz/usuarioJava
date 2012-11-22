Ext.define('PR.controller.AgregarProyectoUsuarios', {
	extend: 'Ext.app.Controller',
	views: ['usuario.AgregarFormProyecto',
	        'usuario.UsuarioProyectoGrid'],
	stores: ['UsuariosProyectosGrid','EditarUsuariosGrid',
	         'UnidadesComboUsuarios',
	         'DependenciasComboUsuarios','Ejercicios'],
	models:['UsuarioProyecto','EditarUsuarioGrid','UnidadesCombo',
	        'Dependencia','Ejercicio'],
	requires: ['PR.util.Namespace','PR.util.Messages'],
	
	widgets: [],
	
	init: function() {
		Ext.EventManager.onWindowResize(this.onWindowResizeListener, this);
		 this.control({
			 '#btbuscar':{click:this.onBuscarUnidad},
			 '#id-Agregar-Proyectos':{click:this.onAgregarUnidad},
			 '#btlimpiar':{click:this.onLimpiar},
			 '#idEjercicio':{select:this.onSelectEjercicio},
			 '#id-usuario':{keypress:this.onKeyPressUsuario}
		 });
	},
	/**
	 * Carga el store con los tres primeros caracteres que optiene
	 * @param _this
	 * @param event
	 */
	onKeyPressUsuario:function(_this,event){
		if(_this.rawValue.length>5) return;
		var str = _this.rawValue+String.fromCharCode(event.getKey());
		if(str.length==5){
			_this.store.load({params:{usuario:str}});
		}else if(str.length<6){
			_this.store.removeAll();
		}
	},
	onSelectEjercicio:function(cmb){
		Ext.getStore('UnidadesComboUsuarios').load({params:{ejercicio:cmb.getValue()}});
		Ext.getStore('DependenciasComboUsuarios').load({params:{ejercicio:cmb.getValue()}});
	},
	onLimpiar:function(){
		var form = Ext.ComponentQuery.query('#idAgregarFormProyecto')[0];
		form.getForm().reset();
		var gridstore=Ext.getStore('UsuariosProyectosGrid');
		gridstore.proxy.extraParams.cveUsuario='';		
		gridstore.proxy.extraParams.ejercicio = '';
		gridstore.proxy.extraParams.proyecto = '';
		gridstore.proxy.extraParams.oficioSolicitud = '';
		gridstore.proxy.extraParams.estatus = '';
		gridstore.proxy.extraParams.idUnidad = '';
		gridstore.proxy.extraParams.idDependencia = '';
		Ext.getStore('UnidadesComboUsuarios').removeAll();
		Ext.getStore('DependenciasComboUsuarios').removeAll();
		Ext.getStore('UsuariosProyectosGrid').removeAll();		
	},
	onAgregarUnidad:function(){
		var store = Ext.getStore('UsuariosProyectosGrid');
		var cveUsuario = store.proxy.extraParams.cveUsuario;
		
		var grid = Ext.ComponentQuery.query('usuarioProyectoGrid')[0];
		var row = grid.getSelectionModel().getSelection();
		var count = grid.getSelectionModel().getCount();
		if (count==0){
			Ext.MessageBox.show({
				title: Messages.dialogs.titles.aviso,
				msg: Messages.dialogs.body.seleccionUnaMasfilas,
				icon: Ext.MessageBox.INFO,
				buttons: Ext.MessageBox.OK,
				closable:false
					});
			return;
		}		
		var idProyecto = new Array(count);
		for ( var i = 0; i < count; i++) {
			idProyecto[i] = row[i].get('idProyecto');
		}
		
		Ext.MessageBox.show({
			title: Messages.dialogs.titles.esperePorFavor,
			msg: Messages.dialogs.body.procesandoDatos,
			progressText: Messages.dialogs.body.enviando,
			width:300,
			height:80,
			progress:false,
			closable:false,
			modal:true,
			wait:true
			});
		
		Ext.Ajax.request({
 			url: Namespace.namespace + 'usuarios/agregarProyectos',
 			params: {
 				cveUsuario:cveUsuario,idProyecto:idProyecto
 			},
 			timeout :9999999,
 			success: function(response) {
 				var object = Ext.JSON.decode(response.responseText);
 				if (object.success) {
 					Ext.MessageBox.show({
					title: Messages.dialogs.titles.aviso,
					msg:Messages.dialogs.body.datosProcesaronExito,
					icon: Ext.MessageBox.INFO,
					buttons: Ext.MessageBox.OK,
					closable:false,
					fn: function() {}
 					});
 					var store = Ext.getStore('UsuariosProyectosGrid');
					store.load();						
 				}else{   						
 					Ext.MessageBox.show({
 						title: Messages.dialogs.titles.error,
 						msg: Messages.dialogs.body.errorServidor,
 						icon: Ext.MessageBox.INFO,
 						buttons: Ext.MessageBox.OK,
 						closable:false,
 						fn: function() {}
 					});
 				}
 			}
 		});
	},

	onBuscarUnidad: function(button){
	 
			var usuario = Ext.ComponentQuery.query('#id-usuario')[0].getValue();
	
	    	 var gridstore=Ext.getStore('UsuariosProyectosGrid');
    	 
			gridstore.proxy.extraParams.cveUsuario=usuario;
		
			gridstore.proxy.extraParams.ejercicio = Ext.ComponentQuery.query('#idEjercicio')[0].getValue();
			gridstore.proxy.extraParams.proyecto = Ext.ComponentQuery.query('#idProyecto')[0].getValue();
			gridstore.proxy.extraParams.oficioSolicitud = Ext.ComponentQuery.query('#idOficioSolicitud')[0].getValue();
			gridstore.proxy.extraParams.estatus = Ext.ComponentQuery.query('#idEstatus')[0].getValue();
			gridstore.proxy.extraParams.idUnidad = Ext.ComponentQuery.query('#id-unidades-combo')[0].getValue();
			gridstore.proxy.extraParams.idDependencia = Ext.ComponentQuery.query('#id-dependencia-combo')[0].getValue();
			gridstore.load({
					callback:function(records, operation, success) {
						if (success) {
						if(records.length<=0){
							Ext.MessageBox.show({
								title: Messages.dialogs.titles.aviso,
								msg: Messages.dialogs.body.noEncontraronDatos,
								icon: Ext.MessageBox.INFO,
								buttons: Ext.MessageBox.OK,
								closable:false,
								fn: function() {}
							});
							}
						}
					}
               });
       
	},
	onWindowResizeListener: function() {
		for (var i = 0, l = this.widgets.length; i < l; i++) {
			this.widgets[i].doLayout();
		}
	},

	reloads: function(grid, record) {}
});

