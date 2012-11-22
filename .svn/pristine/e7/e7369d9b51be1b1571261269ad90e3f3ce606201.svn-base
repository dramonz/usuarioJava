/**
  * @author Daniel Ramon Zapata
 * @version 2011-10-14
 */
Ext.ClassManager.create('PR.controller.PermisoRol', {
	extend: 'Ext.app.Controller',
	views: ['usuario.PermisoRolForm','usuario.PermisoRolGrid','usuario.PermisoRolTree'],
	stores:['Roles','RolesTree','MapasPeticiones'],
	models:['Rol','MapaPeticion','Tree'],
	requires: ['PR.util.Namespace'],
	
	widgets: [],
	
	init: function() {
		this.control({
			'button[id = idBuscar]': {
				click:this.onBuscarRol
			},
			'button[id = idGuardar]': {
				click:this.onGuardar
			},
			'actioncolumn[id = idEliminar]': {
				click: this.onColumnaAcciones
			}
		});
		Ext.EventManager.onWindowResize(this.onWindowResizeListener, this);
	},
	/**
	 * @author Daniel Ramon Zapata
	 * @version 2011-10-15
	 * @description Elimina el la url del rol
	 * */
	onColumnaAcciones: function(grid,cell,rowIndex,colIndex,e){
		Ext.Msg.show({
			title: 'Aviso',
			buttons: Ext.Msg.YESNO,
			icon: Ext.Msg.WANING,
			msg: '¿Quiere Eliminar Url del Rol?',
			fn: function(btn) {	
				if (btn == 'yes') {
					Ext.Ajax.request({
   						url: Namespace.namespace + "usuarios/permisosroles/eliminar",
   			 			method:'POST',
    					params: {
       			 			"ruta": grid.getStore().getAt(rowIndex).get('url'),
       			 			"rol": rol
    					},
    					waitTitle:'Eliminando el rol',
	        			waitMsg:'Cargando...',
   			 			success: function(response){
   			 				Ext.Msg.show({
   			 					title: 'Aviso',
								buttons: Ext.Msg.OK,
								icon: Ext.Msg.INFO,
								msg: 'Se Eliminaron los datos con exito'
							});
					
      			 			var text = response.responseText;
      			  			if (text) {
      				  			Ext.getStore('MapasPeticiones').load({
      				  				params: {
      				  					rol: grid.getStore().getAt(rowIndex).get('rol')
      				  				}
      				  			});	
      			 			} else {
      				  			Ext.MessageBox.alert('Error', 'Error al eliminar los datos');
      			  			};
   						 },
   						failure: function (form, action) {
   							if (!action || !action.result) {
   								Ext.MessageBox.alert('Error', 'Error en la conexion');
   								return;
   							}
   							Ext.MessageBox.alert('Error', action.result.msg);
   						}
    				});
				}				
			}
		});
	},
	
	/**
	 * @author Daniel Ramon Zapata
	 * @version 2011-10-15
	 * @description Guarda el rol y las url asignadas a ese rol
	 * */
	onGuardar: function(btn) {
		var array = btn.up().up().getChecked(),
			rol   = Ext.getCmp('idRol').getValue();
		
		if(rol == ""|| rol == null || array.length <= 0) {
			return;
		}
		
		var cveCatPeticion = new Array(array.length);
	
		for (var i = 0; i<array.length; i++) {
			cveCatPeticion[i] = array[i].data.id;
		}
		
		Ext.Ajax.request({
			url: Namespace.namespace + "usuarios/permisosroles/agregar",
    		params: {
    			"rol": rol,
    			"cveCatPeticion":cveCatPeticion
    		},
    		waitTitle: 'Guardando el rol',
	        waitMsg: 'Cargando...',
   			success: function(response){
   			 	Ext.Msg.show({
					title: 'Aviso',
					buttons: Ext.Msg.OK,
					icon: Ext.Msg.INFO,
					msg: 'Se guadaron los datos con exito'
				});
					
   			 	var text = response.responseText;
      			if (text) {
      				Ext.getStore('MapasPeticiones').load({
      					params: {
      						rol:rol
      					}
      				});	
      			} else {
      				Ext.MessageBox.alert('Error', 'Error al guardar los datos');
      			};
   			},
   			failure: function (form, action) {
   				if (!action || !action.result) {
   					Ext.MessageBox.alert('Error', 'Error en la conexion');
   					return;
				}
   				Ext.MessageBox.alert('Error', action.result.msg);
   			}
		});
	},
	
	/**
	 * @author Daniel Ramon Zapata
	 * @version 2011-10-15
	 * @description caarga la busqueda del grid de roles apartir de la seleccion de combo
	 * */
	
	onBuscarRol: function() {		
		var store = Ext.getStore('MapasPeticiones');
		store.load({
			params: {
				rol: Ext.getCmp('idRol').getValue()
			}
		});	
		rol = Ext.getCmp('idRol').getValue();
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