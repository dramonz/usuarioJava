Ext.define('PR.store.BusquedaUsuarioGrid', {
	extend : 'Ext.data.Store',
	model : 'PR.model.Usuario',
	
	proxy: {
		type: 'rest',
		url: Namespace.namespace + '/usuarios/buscarUsuario',
		extraParams:{
			Busqueda:'',
			fecsol:'',
			estado:''
		},
		reader: {
			type: 'json',
			root: 'data'
		}
	}
	

});