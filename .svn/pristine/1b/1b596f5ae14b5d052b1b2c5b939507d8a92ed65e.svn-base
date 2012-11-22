/**
 * @class PR.controller.AgregarRoles
 * @extends Ext.app.Controller
 * 
 * @author Jose Luis Landero
 * @version 2011-09-28
 */
Ext.ClassManager.create('PR.controller.AgregarRoles', {
	extend: 'Ext.app.Controller',
	views: ['usuario.AgregarRol',
	        'usuario.ModulosGrid'],
	stores:['Modulos'],
	models:['Modulo'],
	requires: ['PR.util.Namespace'],
	
	widgets: [],
	
	init: function() {
		this.getStore('Modulos').load();
		this.control({
			'button[id = idAgregarRol]': {
				click:this.onAgregarRol
			} 
		});
		Ext.EventManager.onWindowResize(this.onWindowResizeListener, this);
	},
	
	onAgregarRol:function() {
		var form = Ext.getCmp('agregarrol');
		var grid = Ext.ComponentQuery.query('#modulo-grid')[0];
		var records = grid.getSelectionModel().getSelection();		
		var cveModulos = [];
		if(records.length >0){
		for(var i = 0 ;i<records.length;i++){
			cveModulos.push(records[i].data.cve);
		}
		
		form.getForm().submit({
			url: Namespace.namespace+ 'usuarios/agregarrol',
			params:{cveModulo:cveModulos},
			waitTitle: 'Agregando Rol',
	        waitMsg: 'Guardando...',
	        success: function (form, action) {	
	        	if(action.result.existe){
	        		Ext.MessageBox.alert('Aviso', action.result.msg);
	        	}else{
	        		Ext.Msg.show({
						title: 'Rol',
						buttons: Ext.Msg.YESNO,
						icon: Ext.Msg.INFO,
						msg:action.result.msg,
						fn: function(btn) { 
							if (btn == 'yes') {
								var form = Ext.getCmp('agregarrol');
								form.getForm().reset();
								grid.getSelectionModel().deselectAll();
							}else{
								window.parent.location = Namespace.namespace;
							}
						}
					});	
	        	}
				
			},
			failure: function (form, action) {				
				if (!action || !action.result) {
					Ext.MessageBox.alert('Error', 'Problemas en la conexion');
					return;
				} 
				Ext.MessageBox.alert('Error', action.result.msg);
			}
		});
		}
		else
			Ext.MessageBox.alert('Error', "Es Necesario Seleccionar un Modulo");
			
	}, 
	
	/**
	 * Función que escucha al evento onWindowResize, es la encargada de aplicar
	 * el redimensionado a los widgets contenidos en {widget}.
	 */
	onWindowResizeListener: function() {
		for (var i = 0, l = this.widgets.length; i < l; i++) {
			this.widgets[i].doComponentLayout();
		}
	}
});