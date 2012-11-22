Ext.define('PR.store.Roles', {
	extend: 'Ext.data.Store',
	model: 'PR.model.Rol',
	autoLoad: true,
	proxy: {
		type: 'rest',
		//url: Namespace.namespace + '/catalogos/rol/listarRol',
		url: Namespace.namespace + '/catalogos/rol/listarRolModulo',
		reader: {
			type: 'json',
			root: 'data'
		}
	}
});