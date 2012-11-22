Ext.define('PR.store.Ejercicios', {
	extend:'Ext.data.Store',
	model:'PR.model.Ejercicio',
	autoLoad:true,
	
	proxy:{
		type:'rest',
		url:Namespace.namespace+'catalogos/combos/data/ejercicios',
		reader:{
			type:'json',
			root:'data'
		},
		writer:{
			type:'json'
		}
	}

});