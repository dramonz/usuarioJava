/**
 * @author José Luis Landero
 */
Ext.ClassManager.create('PR.store.PermisosRolTree', {
	extend: 'Ext.data.TreeStore',
	
	root: {
		expanded: true,
		children: []
	},
	
	proxy: {
		type: 'ajax',
		timeout:360000,
		url: Namespace.namespace + 'roles/obtener-permisos-rol',
		reader: 'json'
	}
});