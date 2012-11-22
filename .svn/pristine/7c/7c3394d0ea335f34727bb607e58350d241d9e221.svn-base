Ext.define('PR.store.RolesTree', {
	extend: 'Ext.data.TreeStore',
	model:'PR.model.Tree',
	
	proxy: {
		type: 'ajax',
        url: Namespace.namespace + 'usuarios/permisosMenu'
	},
    sorters: [{
    	property: 'leaf',
        direction: 'ASC'
    }, {
    	property: 'text',
        direction: 'ASC'
    }]
});

