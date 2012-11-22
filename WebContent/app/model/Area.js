 Ext.define('PR.model.Area', {
	extend:'Ext.data.Model',
	fields:[
	    {name:'cve',				type:'int',useNull:true},
		{name:'nombreArea',				type:'string'},
	],idProperty:'cve'
});
