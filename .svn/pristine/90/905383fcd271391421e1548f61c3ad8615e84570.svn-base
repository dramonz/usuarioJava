Ext.application({
	name: 'PR',
	appFolder: '../app',
	controllers: ['EditarUsuarios'],
	
	launch: function() {
		var form = Ext.ClassManager.instantiate('PR.view.usuario.AgregarUsuario', {
			renderTo: 'form-editar-usuario'
		});
		var grid = Ext.ClassManager.instantiate('PR.view.usuario.UsuarioGrid',{
			renderTo: 'grid-editar-usuario'
		});
		this.getController('EditarUsuarios').widgets.push(form);
	}
});