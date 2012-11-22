/**
 * @author Daniel Ramon Zapata
 * @version 2011-10-14
 * @description optiene los datos de la tabla mapa peticiones mediante el rol al cargar el store
 */
Ext.define('PR.store.MapasPeticiones', {
	extend: 'Ext.data.Store',
	model: 'PR.model.MapaPeticion',
	autoSync: true,
	autoLoad: false, 
	
	proxy: {
		type: 'rest',
		
		api: {
			read:  Namespace.namespace + 'usuarios/permisosroles/consulta',
			destroy: Namespace.namespace + 'usuarios/permisosroles/eliminar?ruta='
		},
		reader: {
			type: 'json',
			root: 'data'
		},
		writer: {
			type: 'json'
		}
	}

});