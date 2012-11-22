Ext.define('PR.model.UsuarioUnidad', {
	extend: 'Ext.data.Model',
	fields: [{
		name: 'idUnidad',
		type: 'int',
		nullable: true
	}, {
		name: 'nombre',
		type: 'string'
	}, {
		name: 'cveUnidad',
		type: 'int'
	},{
		name: 'dependencia',
		type: 'auto'
	}, {
		name: 'codigoUnidad',
		type: 'string'
	}, {
		name: 'codigoGrupo',
		type: 'string'
	}, {
		name: 'idDependencia',
		type: 'string'
	}],idProperty:'idUnidad'
});
