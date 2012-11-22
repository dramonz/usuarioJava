/**
 * 
 */
Ext.application({
	name: 'PR',
	appFolder: '../app',
	controllers: ['AgregarEmpleados'],
	
	launch: function() {
		var form = Ext.ClassManager.instantiate('PR.view.usuario.AgregarEmpleado', {
			renderTo: 'form-agregar-empleado'
		});
		this.getController('AgregarEmpleados').widgets.push(form);
	}
});