/**
 * @class Modules
 * 
 * 
 * Viewport de detalle del usuario
 * 
 * @author Daniel Ramon Zapata
 * @version 0.1 2011-09-20
 */
Ext.application({
	name: 'PR',
	appFolder: 'app',
	controllers: ['DetallesUsuarios'],
	
	launch: function() {
		
		var form = Ext.ClassManager.instantiate('PR.view.usuario.DetalleForm', {
			renderTo: 'form-usuario'
			
		});
		this.getController('DetallesUsuarios').widgets.push(form);
	
	}
});