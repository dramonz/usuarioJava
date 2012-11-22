/**
 * @author José Luis Landero
 */
Ext.ClassManager.create('PR.store.PermisosTree', {
	extend: 'Ext.data.TreeStore',
	
	root: {
		expanded: true,
		children: []
	},
	
	proxy: {
		type: 'ajax',
		timeout:360000,
		url: Namespace.namespace + 'roles/obtener-todos-permisos',
		reader: 'json'
	}
});