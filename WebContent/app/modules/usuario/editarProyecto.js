Ext.application({
	name: 'PR',
	appFolder: '../app',
	controllers: ['EditarProyectoUsuarios'],
	
	launch: function() {
		var form = Ext.ClassManager.instantiate('PR.view.usuario.AgregarFormProyecto', {
			renderTo: 'form-buscar'
		});
	
		var gridConsulta = Ext.ClassManager.instantiate('PR.view.usuario.UsuarioEditarProyectoGrid', {
			renderTo: 'grid-buscar',
			listeners: {
				render: function() {
					document.getElementById('presupuesto-loading').style.display = 'none';
				}
			}
		});
		this.getController('EditarProyectoUsuarios').widgets.push(form);
		this.getController('EditarProyectoUsuarios').widgets.push(gridConsulta);
	}
});