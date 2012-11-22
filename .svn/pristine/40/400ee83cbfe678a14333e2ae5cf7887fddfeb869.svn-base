Ext.application({
	name: 'PR',
	appFolder: '../app',
	controllers: ['AgregarRoles'],
	
	launch: function() {
		var form = Ext.ClassManager.instantiate('PR.view.usuario.AgregarRol', {
			renderTo: 'form-agregar-rol'
		});
		var grid = Ext.ClassManager.instantiate('PR.view.usuario.ModulosGrid',{
			renderTo:'form-grid-modulo'
		});
		this.getController('AgregarRoles').widgets.push(form);
		this.getController('AgregarRoles').widgets.push(grid);
	}
});