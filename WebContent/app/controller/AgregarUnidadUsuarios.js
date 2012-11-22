Ext.define('PR.controller.AgregarUnidadUsuarios', {
	extend: 'Ext.app.Controller',
	views: ['usuario.AgregarFormUnidad',
	        'usuario.UsuarioUnidadGrid'],
	stores: ['UsuariosUnidadesGrid','Ejercicios',
	         'EditarUsuariosGrid',
	         'UnidadesComboUsuarios',
	         'DependenciasComboUsuarios'],
	models:['UsuarioUnidad','Ejercicio',
	        'EditarUsuarioGrid',
	        'UnidadesCombo',
	        'Dependencia'],
	requires: ['PR.util.Namespace','PR.util.Messages'],
	
	widgets: [],
	
	init: function() {
		Ext.EventManager.onWindowResize(this.onWindowResizeListener, this);
		
		 this.control({
			 '#id-usuario':{keypress:this.onKeyPressUsuario},
			 '#btbuscar':{click:this.onBuscarUnidad},
			 '#btlimpiar':{click:this.onLimpiar},
			 '#id-Agregar-Unidades':{click:this.onAgregarUnidad},
			 '#id-ejercicio':{select:this.onSelectEjercicio}
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
	onAgregarUnidad:function(){
		var store = Ext.getStore('UsuariosUnidadesGrid');
		var cveUsuario = store.proxy.extraParams.cveUsuario;
		var grid = Ext.ComponentQuery.query('usuarioUnidadGrid')[0];
		var row = grid.getSelectionModel().getSelection();
		var count = grid.getSelectionModel().getCount();
		if (count==0){
			Ext.MessageBox.show({
				title: 'Aviso',
				msg: 'Seleccione una Unidad',
				icon: Ext.MessageBox.INFO,
				buttons: Ext.MessageBox.OK,
				closable:false
					});
			return;
		}		
		var idUnidad = new Array(count);
		for ( var i = 0; i < count; i++) {
			idUnidad[i] = row[i].get('idUnidad');
		}
		
		Ext.MessageBox.show({
			title: 'Espere Por favor',
			msg: 'Procesando Datos...',
			progressText: 'Enviando...',
			width:300,
			height:80,
			progress:false,
			closable:false,
			modal:true,
			wait:true
			});
		
		Ext.Ajax.request({
 			url: Namespace.namespace + 'usuarios/agregarUnidades',
 			params: {
 				cveUsuario:cveUsuario,idUnidad:idUnidad
 			},
 			timeout :9999999,
 			success: function(response) {
 				var object = Ext.JSON.decode(response.responseText);
 				if (object.success) {
 					Ext.MessageBox.show({
					title: 'Aviso',
					msg: 'Los datos se procesaron con exito',
					icon: Ext.MessageBox.INFO,
					buttons: Ext.MessageBox.OK,
					closable:false,
					fn: function() {}
 					});
 					var store = Ext.getStore('UsuariosUnidadesGrid');
					store.load();						
 				}else{   						
 					Ext.MessageBox.show({
 						title: 'Aviso',
 						msg: 'Ocurrió un error en el proceso',
 						icon: Ext.MessageBox.INFO,
 						buttons: Ext.MessageBox.OK,
 						closable:false,
 						fn: function() {}
 					});
 				}
 			}
 		});
	},
	onLimpiar: function(){
		var form = Ext.ComponentQuery.query('agregarFormUnidad')[0];
		form.getForm().reset();
		var gridstore=Ext.getStore('UsuariosUnidadesGrid');
		gridstore.removeAll();
		gridstore.proxy.extraParams.cveUsuario='';
		gridstore.proxy.extraParams.idUnidad = '';
		gridstore.proxy.extraParams.idDependencia = '';
		gridstore.proxy.extraParams.ejercicio = null;
		Ext.getStore('UnidadesComboUsuarios').removeAll();
		Ext.getStore('DependenciasComboUsuarios').removeAll();
	},
	onBuscarUnidad: function(button){
	 
			var usuario  = Ext.ComponentQuery.query('#id-usuario')[0].getValue();
			var idUnidad = Ext.ComponentQuery.query('#id-unidades-combo')[0].getValue();
			var idDependencia = Ext.ComponentQuery.query('#id-dependencia-combo')[0].getValue();
			var ejercicio = Ext.ComponentQuery.query('#id-ejercicio')[0].getValue();
			
	    	var gridstore=Ext.getStore('UsuariosUnidadesGrid');
    	 
			gridstore.proxy.extraParams.cveUsuario		= usuario;
			gridstore.proxy.extraParams.idUnidad 		= idUnidad;
			gridstore.proxy.extraParams.idDependencia 	= idDependencia;
			gridstore.proxy.extraParams.ejercicio = ejercicio;
			gridstore.load({
					callback:function(records, operation, success) {
						if (success) {
						if(records.length<=0){
							Ext.MessageBox.show({
								title: 'Aviso',
								msg: 'No se encontraron datos',
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

