Ext.define('PR.store.jefeEmpleados', {
	extend: 'Ext.data.Store',
	model: 'PR.model.Empleado',
	autoLoad: false,
	proxy: {
		type: 'rest',
		url: Namespace.namespace + 'catalogos/empleado/listarEmpleado',
		reader: {
			type: 'json',
			root: 'data'
		}
	}
});