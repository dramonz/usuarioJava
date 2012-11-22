Ext.define('PR.model.EditarUsuarioGrid', {
	extend:'Ext.data.Model',
	fields:[
	    {name:'cve',				type:'int',useNull:true},
		{name:'nombreUsuario',		type:'string'},
	    {name:'contrasenia',		type:'string'},
	    {name:'activo',				type:'int' },
	    {name:'fechaInicio',		type:'int' },
	    {name:'fechaVencimiento',	type:'int' },
	    {name:'nombreCompleto', 	type:'string' },
//	    {name:'rol',				type:'string'},
//	    {name:'descripcion',		type:'string'},
	    {name:'cveEmpleado',		type:'int'}
	]
});
