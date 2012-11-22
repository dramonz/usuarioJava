
Ext.define('PR.store.UsuariosProyectosPerteneceGrid', {
	extend: 'Ext.data.Store',
	model: 'PR.model.UsuarioProyecto',
	autosync: false,
	autoLoad: false,
	proxy: {
		type: 'rest',
		url: Namespace.namespace + 'usuarios/consulta/consultaProyectoPerteneceCveUsuario',
		extraParams:{
			cveUsuario: '',
			ejercicio:'',
			proyecto:'',
			oficioSolicitud:'',
			estatus:'',
			idUnidad:'',
			idDependencia:''
		},

		reader: {
			type: 'json',
			root: 'data'
		}
	}
});