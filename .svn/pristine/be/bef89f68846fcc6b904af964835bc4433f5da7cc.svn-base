Ext.application({
	name: 'PR',
	appFolder: '../app',
	controllers: ['AgregarProyectoUsuarios'],
	
	launch: function() {
		var form = Ext.ClassManager.instantiate('PR.view.usuario.AgregarFormProyecto', {
			renderTo: 'form-buscar'
		});
	
		var gridConsulta = Ext.ClassManager.instantiate('PR.view.usuario.UsuarioProyectoGrid', {
			renderTo: 'grid-buscar',
			listeners: {
				render: function() {
					document.getElementById('presupuesto-loading').style.display = 'none';
				}
			}
		});
		this.getController('AgregarProyectoUsuarios').widgets.push(form);
		this.getController('AgregarProyectoUsuarios').widgets.push(gridConsulta);
	}
});