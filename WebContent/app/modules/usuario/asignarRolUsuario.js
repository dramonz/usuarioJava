Ext.application({
	name: 'PR',
	appFolder: 'app',
	controllers: ['AsignarRolUsuarios'],
	
	launch: function() {
		var form = Ext.ClassManager.instantiate('PR.view.usuario.AsignarRolUsuarioForm', {
			renderTo: 'form-agregar-usuario'
		});
		var grid = Ext.ClassManager.instantiate('PR.view.usuario.AsignarRolUsuarioGrid',{
			renderTo:'grid-rol-usuario'
		});
		this.getController('AsignarRolUsuarios').widgets.push(form);
		this.getController('AsignarRolUsuarios').widgets.push(grid);
	}
});