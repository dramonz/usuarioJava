Ext.define('PR.store.DependenciasComboUsuarios', {
	extend: 'Ext.data.Store',
	model: 'PR.model.Dependencia',
	autosync: false,
	autoLoad: false,
	  sorters: [ {
	    	property: 'nombre',
	        direction: 'ASC'
	    }],
	proxy: {
		type: 'rest',
		url: Namespace.namespace + 'usuarios/catalogo/dependencia',
		reader: {
			type: 'json',
			root: 'data'
		}
	}
});