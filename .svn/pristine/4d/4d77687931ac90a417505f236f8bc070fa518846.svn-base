Ext.define('PR.store.EditarUsuariosGrid', {
	extend:'Ext.data.Store',
	model:'PR.model.EditarUsuarioGrid',
	autoLoad:false,

	proxy:{
		type:'rest',
	
		url:Namespace.namespace+'usuarios/editarusuario/consulta',
		reader:{
			type:'json',
			root:'data',
			totalProperty:'total'
		},
		writer:{
			type:'json'
		}
	}

});