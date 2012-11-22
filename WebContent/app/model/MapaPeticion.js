Ext.define('PR.model.MapaPeticion', {
	extend:'Ext.data.Model',
	fields:[
	    {name:'rol',type:'string',useNull:true},
		{name:'url',type:'string'},
		{name:'descripcion',type:'string'}
	],idProperty:'url'
});
