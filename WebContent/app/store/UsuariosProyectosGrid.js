
Ext.define('PR.store.UsuariosProyectosGrid', {
	extend: 'Ext.data.Store',
	model: 'PR.model.UsuarioProyecto',
	autosync: false,
	autoLoad: false,
	proxy: {
		type: 'rest',
		url: Namespace.namespace + 'usuarios/consulta/consultaProyectoCveUsuario',
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