/**
 * 
 */
Ext.define('PR.store.UnidadesComboUsuarios', {
	extend: 'Ext.data.Store',
	model: 'PR.model.UnidadesCombo',
	autosync: false,
	autoLoad: false,
	
	proxy: {
		type: 'rest',
		url: Namespace.namespace + '/catalogos/unidad/listarUnidad',
		reader: {
			type: 'json',
			root: 'data'
		}
	}
});