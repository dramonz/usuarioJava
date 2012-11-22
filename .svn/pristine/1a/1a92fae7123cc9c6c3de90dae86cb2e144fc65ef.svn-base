Ext.ClassManager.create('PR.view.usuario.BusquedaUsuario', {
	extend: 'Ext.form.Panel',
	alias: 'widget.busquedaUsuario',
	bodyPadding: 10,
	fieldDefaults: {
		labelWidth: 150,
		labelPad: 10,
		labelAlign: 'right'
	},
	initComponent: function() {
		
		
		this.items=[
		       {xtype:'fieldcontainer',
//		    	fieldLabel:'Buscar por',
		    	fieldLabel:'Dependencia',
		    	layout:'hbox',
		    	fieldDefaults: {
		    		labelWidth: 120,
		    		labelPad: 10,
		    		labelAlign: 'right'
		    	},
		    	items:[{


//		    		xtype:'combobox',
//		    		id:'Busqueda',
		    		name:'tipoBusqueda',

		    		store:Ext.create('Ext.data.Store', {
		    		    fields: ['tipo', 'nombre'],
		    		    data : [
//		    		        {"tipo":0, "nombre":"Todos"},
//		    		        {"tipo":1, "nombre":"Dependencia"}
		    		    ]}),
		    		editable: false,
		    		valueField:'tipo',
		    		displayField:'nombre',
		    		forceSelection:true,
					allowBlank: false
		    	},{
		    		xtype:'splitter',
		    		resizable:false,
		    	   width:30
		    	},{
		    		xtype:'combobox',
		    		id:'idDependencia',
		    		name:'idDependencia',
		    		editable:false,
		    		valueField:'id',
		    		store:'DependenciasComboUsuarios',
		    		queryMode: 'local',
		    		visible:false,
		    		displayField:'nombre',
		    		width:850

		    	}
		  ]}
		],
		
		this.dockedItems = [ {
				xtype : 'toolbar',
				cls : 'grid-toolbar',
				dock : 'bottom',
				items : [ '->', {
					text : 'Buscar',
					id : 'idBuscar',
					action : 'idBuscar',
					formBind : true
				}]
			} ];
	
	this.callParent();
}
});

