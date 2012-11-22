/**
 * @class PR.controller.DetallesUsuarios
 * @extends Ext.app.Controller
 * 
 * Controlador de Detalles del usuario
 * 
 * @author Daniel Ramon Zapata
 * @version 0.1 2011-09-20
 */
Ext.define('PR.controller.DetallesUsuarios', {
	extend: 'Ext.app.Controller',
	views: ['usuario.DetalleForm'],
	
	requires: ['PR.util.Namespace'],
	widgets: [],
	
	init: function() {
			this.control({
			
			'form[id=idDetalleForm]':{render:this.onRendered}
			
				
		});
		
	
	},
	onRendered:function(){
		Ext.getCmp('idNombre').setValue(usuario);
		Ext.getCmp('idArea').setValue(area);
		Ext.getCmp('idUnidad').setValue(unidad);
		Ext.getCmp('idCorreo').setValue(correo);
		Ext.getCmp('idDependencia').setValue(dependencia);
		Ext.getCmp('idPuesto').setValue(puesto);
		Ext.getCmp('idRol').setValue(rol);
		Ext.getCmp('idUsername').setValue(username);
	}
});

