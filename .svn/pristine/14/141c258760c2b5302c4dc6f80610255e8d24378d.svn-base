/**
 * @author Daniel Ramon Zapata
 * @version 2011-10-19
 * @description Modulo de actualizar contraseña
 */
Ext.application({
	name: 'PR',
	appFolder: '../app',
	controllers: ['RecuperarContrasenia'],
	
	launch: function() {
		var form = Ext.ClassManager.instantiate('PR.view.usuario.RecuperarContrasenia', {
			renderTo: 'form-agregar-usuario'
		});
		this.getController('RecuperarContrasenia').widgets.push(form);
	}
});