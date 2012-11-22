Ext.define('PR.store.Usuarios', {
	extend: 'Ext.data.Store',
	model: 'PR.model.Usuario',
	autoLoad: true,
	sorters: [
	          {   property : 'nombreUsuario',  direction: 'ASC' }
	      ],
	proxy: {
		type: 'rest',
		url: Namespace.namespace + 'catalogos/combos/data/listUsuarios',
		reader: {
			type: 'json',
			root: 'data'
		}
	}
});