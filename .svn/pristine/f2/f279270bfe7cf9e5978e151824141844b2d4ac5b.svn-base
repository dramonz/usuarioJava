/**
  * @author Daniel Ramon Zapata
 * @version 2011-10-07
 */
Ext.ClassManager.create('PR.controller.EditarRoles', {
	extend: 'Ext.app.Controller',
	views: ['usuario.AgregarRol','usuario.RolGrid',
	        'usuario.ModulosGrid'],
	stores:['Roles','Modulos'],
	models:['Rol','Modulo'],
	requires: ['PR.util.Namespace'],
	
	widgets: [],
	
	init: function() {
		this.getStore('Modulos').load();
		this.control({
			'button[id = idAgregarRol]': {
				click:this.onAgregarRol
			},
			'combobox[id = idRolUsuario]': {
				select:this.onBuscarRol
			},
			'rolGrid': {
				select:this.onSelectGrid
			},
			'agregarrolform': {
				render:this.onRenderForm
			}
		});
		
		Ext.EventManager.onWindowResize(this.onWindowResizeListener, this);
	},
	
	onSelectGrid:function(selectgrid, record, index,eOpts){
		Ext.getCmp('nomre-rol').setDisabled(true); 
		Ext.getCmp('nomre-rol').setValue(record.data.rol);
		Ext.getCmp('descripcion-rol').setValue(record.data.descripcion);
		Ext.getCmp('activoRol').setValue(record.data.activo.toString());
		var grid = 	Ext.ComponentQuery.query('#modulo-grid')[0];
		grid.setVisible(true);
		var moduloGrid = function(){
			Ext.Ajax.request({		
	 			url: Namespace.namespace + 'catalogos/rolModulo/listByRol',
	 			method:'GET',
	 			params: {rol: record.data.rol	},
				timeout : 600000000,
				success: function(response) {
					var object = Ext.decode(response.responseText);
					if (object.success) {
						
//						var store = grid.getStore();
//						if(object.data.length>0){
//							var indice = store.find('cve',object.data[0].cveModulo);
//							grid.getSelectionModel().select(indice);
//						}else{
//							grid.getSelectionModel().deselectAll();
//						}
						
						grid.getSelectionModel().selectAll();
						var store = grid.getStore();
						var seleccion=',';
						for(var i=0;i<object.data.length;i++){
				    		seleccion+=object.data[i].cveModulo+',';
				    	}
						for(var i = 0; i<store.getCount();i++){
							var evalua = seleccion.indexOf(','+store.getAt(i).get('cve')+',');
							if(evalua==-1){
								grid.getSelectionModel().deselect(i);
							}
						}
					}else{ 
						Ext.MessageBox.show({
							title: Messages.dialogs.titles.aviso,
							msg: Messages.dialogs.body.errorServidor,
							icon: Ext.MessageBox.INFO,
							buttons: Ext.MessageBox.OK,
							closable:false
						});
					}
				} 			
			});
		};
		moduloGrid();
	},
	
	onBuscarRol:function(){	
		var store = Ext.getStore('Roles');
		store.clearFilter();
		store.filter("rol", Ext.getCmp('idRolUsuario').getValue());
	},
	
	onRenderForm:function(){
		Ext.getCmp('nomre-rol').setReadOnly(true); 
		Ext.getCmp('idAgregarRol').setText('Editar Rol');
	},
	
	onAgregarRol:function() {
		var form = Ext.getCmp('agregarrol');
		var grid = Ext.ComponentQuery.query('#modulo-grid')[0];
		var records = grid.getSelectionModel().getSelection();		
		var cveModulos = [];
		for(var i = 0 ;i<records.length;i++){
			cveModulos.push(records[i].data.cve);
		}
		form.getForm().submit({
			url:Namespace.namespace+ 'usuarios/editarrol',
			params:{cveModulo:cveModulos,nombre:Ext.getCmp('nomre-rol').getValue()},
			waitTitle:'Editar Rol',
	        waitMsg: 'Guardando...',
			success: function (form, action) {	
				Ext.Msg.show({
					title: 'Rol',
					buttons: Ext.Msg.YESNO,
					icon: Ext.Msg.INFO,
					msg: 'El Rol se ha modificado con exito, ¿Desea editar mas roles?',
					fn: function(btn) { 
						if (btn == 'yes') {
							var form = Ext.getCmp('agregarrol');
							Ext.getStore('Roles').load();
							form.getForm().reset();
							grid.getSelectionModel().deselectAll();
							grid.setVisible(false);
						}else{
							window.parent.location = Namespace.namespace;
						}
					}
				});	
			},
			failure: function (form, action) {
				if (!action || !action.result) {
					Ext.MessageBox.alert('Error', 'Problemas en la conexion');
					return;
				}
				Ext.MessageBox.alert('Error', action.result.msg);
			}	
		});
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