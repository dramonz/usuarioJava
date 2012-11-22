Ext.application({
	name: 'PR',
	appFolder: '../app',
	controllers: ['EditarUnidadUsuarios'],
	
	launch: function() {
		var form = Ext.ClassManager.instantiate('PR.view.usuario.AgregarFormUnidad', {
			renderTo: 'form-buscar'
		});
	
		var gridConsulta = Ext.ClassManager.instantiate('PR.view.usuario.UsuarioEditarUnidadGrid', {
			renderTo: 'grid-buscar',
			listeners: {
				render: function() {
					document.getElementById('presupuesto-loading').style.display = 'none';
				}
			}
		});
		this.getController('EditarUnidadUsuarios').widgets.push(form);
		this.getController('EditarUnidadUsuarios').widgets.push(gridConsulta);
	}
});