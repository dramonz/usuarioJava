Ext.define('PR.store.Dependencia', {
	extend: 'Ext.data.Store',
	model: 'PR.model.Dependencia',
	autoLoad: true,
	proxy: {
		type: 'rest',
		url: Namespace.namespace + '/catalogos/dependencia/listarDependencia',
		reader: {
			type: 'json',
			root: 'data'
		}
	}
});