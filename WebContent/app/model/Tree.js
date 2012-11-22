 Ext.define('PR.model.Tree', {
	extend:'Ext.data.Model',
	fields:[
	    {name:'expandable',		type:'string'},
		{name:'children',		type:'string'},
		{name:'text',			type:'string'},
		{name:'cls',			type:'string'},
		{name:'id',				type:'int'},
		{name:'leaf',			type:'string'},
		{name:'expanded',		type:'string'}
	],idProperty:'id'
});