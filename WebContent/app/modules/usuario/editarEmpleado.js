/**
 * 
 */
Ext.application({
	name: 'PR',
	appFolder: '../app',
	controllers: ['EditarEmpleados'],
	
	launch: function() {
		var form = Ext.ClassManager.instantiate('PR.view.usuario.AgregarEmpleado', {
			renderTo: 'form-agregar-empleado'
		});
		var grid = Ext.ClassManager.instantiate('PR.view.usuario.EmpleadoGrid', {
			renderTo: 'grid-editar-empleado'
		});
		this.getController('EditarEmpleados').widgets.push(form);
		this.getController('EditarEmpleados').widgets.push(grid);
	}
});