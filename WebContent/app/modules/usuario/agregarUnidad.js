Ext.application({
	name: 'PR',
	appFolder: '../app',
	controllers: ['AgregarUnidadUsuarios'],
	
	launch: function() {
		var form = Ext.ClassManager.instantiate('PR.view.usuario.AgregarFormUnidad', {
			renderTo: 'form-buscar'
		});
	
		var gridConsulta = Ext.ClassManager.instantiate('PR.view.usuario.UsuarioUnidadGrid', {
			renderTo: 'grid-buscar',
			listeners: {
				render: function() {
					document.getElementById('presupuesto-loading').style.display = 'none';
				}
			}
		});
		this.getController('AgregarUnidadUsuarios').widgets.push(form);
		this.getController('AgregarUnidadUsuarios').widgets.push(gridConsulta);
	}
});