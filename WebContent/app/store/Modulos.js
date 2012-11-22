Ext.define('PR.store.Modulos', {
	extend: 'Ext.data.Store',
	model : 'PR.model.Modulo',
	proxy: {
		type: 'rest',
		url: Namespace.namespace + 'catalogos/modulo/listarModulos',
		reader: {
			type: 'json',
			root: 'data'
		}
	}
	
});