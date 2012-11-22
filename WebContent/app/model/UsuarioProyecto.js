Ext.define('PR.model.UsuarioProyecto', {
	extend: 'Ext.data.Model',
	fields: [
	         {name: 'cveProyecto',			type: 'int',nullable: true}, 
	         {name: 'idProyecto',			type: 'int'},
	         {name: 'numProyecto',			type: 'string'},
	         {name: 'nombreProyecto',		type: 'string'},
	         {name: 'estatus',			    type: 'int'},
	         {name: 'idProyectoOficio',		type: 'int'},
	         {name: 'oficioSolicitud',		type: 'string'},
	         {name: 'oficioRespuesta',		type: 'string'},
	         {name: 'cveProyectoOficio',	type: 'int'},
	         {name: 'idUnidad',				type: 'int'},
	         {name: 'nombreUnidad',			type: 'string'},
	         {name: 'codigoDependencia',	type: 'string'},
	         {name: 'nombreDependencia',	type: 'string'},
	         {name: 'idDependencia',		type: 'int'},
	         {name: 'nombreDependencia',	type: 'string'},
	         {name: 'codigoGrupo',			type: 'string'}
	         ]
});
