Ext.define('PR.store.Area', {
	extend: 'Ext.data.Store',
	model: 'PR.model.Area',
	autoLoad: true,
	proxy: {
		type: 'rest',
		url: Namespace.namespace + '/catalogos/area/listarArea',
		reader: {
			type: 'json',
			root: 'data'
		}
	}
});