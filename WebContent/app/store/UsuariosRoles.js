Ext.define('PR.store.UsuariosRoles', {
	extend: 'Ext.data.Store',
	model: 'PR.model.UsuarioRol',
	proxy: {
		type: 'rest',
		url: Namespace.namespace + 'asignarRolUsuario/listarUsuarioRoles',
		reader: {
			type: 'json',
			root: 'data'
		}
	}
});