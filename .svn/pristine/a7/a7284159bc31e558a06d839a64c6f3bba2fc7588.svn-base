/**
 * @author José Luis Landero
 */
Ext.application({
	name: 'PR',
	appFolder: appFolder,
	controllers: ['AsignarRol'],
	
	launch: function() {
		Ext.ClassManager.instantiateByAlias('widget.formbuscarrol', {
			renderTo: 'form-buscar-usuario'
		});
		
		Ext.ClassManager.instantiateByAlias('widget.rolusuariotree', {
			renderTo: 'arboles-permisos',
			id: 'permisos-usuario',
			title: 'Permisos Asignados'
		});
		
		Ext.ClassManager.instantiateByAlias('widget.permisotree', {
			renderTo: 'arboles-permisos',
			id: 'permisos',
			title: 'Permisos'
		});
	}
});