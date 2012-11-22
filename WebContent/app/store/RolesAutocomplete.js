/**
 * @author José Luis Landero
 */
Ext.ClassManager.create('PR.store.RolesAutocomplete', {
	extend: 'Ext.data.Store',
	model: 'PR.model.Rol',
	
	proxy: {
		type: 'ajax',
//		url: Namespace.namespace + 'roles/buscar-rol',
		url: Namespace.namespace + 'roles/buscar-rolModulo',
		reader: {
			type: 'json',
			root: 'data'
		}
	}
});