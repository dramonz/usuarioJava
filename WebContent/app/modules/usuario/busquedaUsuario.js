Ext.application({
	name: 'PR',
	appFolder: '../app',
	controllers: ['BusquedaUsuario'],
	
	launch: function() {
		var form = Ext.ClassManager.instantiateByAlias('widget.busquedaUsuario', {
			renderTo: 'busqueda-usuario'
		});
		var grid = Ext.ClassManager.instantiateByAlias('widget.busquedaUsuarioGrid',{
			renderTo:'busqueda-usuario-grid'
			});
		this.getController('BusquedaUsuario').addWidget(form);
		this.getController('BusquedaUsuario').addWidget(grid);
	}
});