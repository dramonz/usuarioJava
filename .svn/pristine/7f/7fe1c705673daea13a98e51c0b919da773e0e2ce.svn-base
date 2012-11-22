Ext.define('PR.store.Puesto', {
	extend: 'Ext.data.Store',
	model: 'PR.model.Puesto',
	autoLoad: true,
	proxy: {
		type: 'rest',
		url: Namespace.namespace + '/catalogos/puesto/listarPuesto',
		reader: {
			type: 'json',
			root: 'data'
		}
	}
});