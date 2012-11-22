
Ext.define('PR.store.UsuariosUnidadesGrid', {
	extend: 'Ext.data.Store',
	model: 'PR.model.UsuarioUnidad',
	autosync: false,
	autoLoad: false,
	proxy: {
		type: 'rest',
		url: Namespace.namespace + 'usuarios/consulta/unidadesOmitidasPorUsuario',
		extraParams:{
			cveUsuario: '',
			idUnidad:'',
			idDependencia:'',
			ejercicio:null
		},

		reader: {
			type: 'json',
			root: 'data'
		}
	}
});