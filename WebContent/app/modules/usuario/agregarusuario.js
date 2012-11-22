/**
 * 
 */
Ext.application({
	name: 'PR',
	appFolder: '../app',
	controllers: ['AgregarUsuarios'],
	
	launch: function() {
		var form = Ext.ClassManager.instantiate('PR.view.usuario.AgregarUsuario', {
			renderTo: 'form-agregar-usuario'
		});
		this.getController('AgregarUsuarios').widgets.push(form);
	}
});