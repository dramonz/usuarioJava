Ext.define('PR.view.usuario.UsuarioGrid', {
	extend:'Ext.grid.Panel',
	alias:'widget.usuarioGrid',
	
	initComponent: function() {
		Ext.apply(this, {
			title:'Usuarios',
			store:'EditarUsuariosGrid',
			id:'idUsuario',
			style: {
				marginLeft : 'auto',
				marginRight: 'auto'
			},
			width:'90%',
			height: 300,
			selType: 'rowmodel',
			columns: [{
                text:'Nombre',
                flex:1,
                dataIndex:'nombreCompleto',
                menuDisabled:true,
                draggable:false
            }, {
                text:'Usuario',
                flex:1,
                dataIndex:'nombreUsuario',
                menuDisabled:true,
                draggable:false
          	}, {
            	text:'Activo',
                flex:1,
                dataIndex:'activo',
                renderer:function(value){
                switch(value){
                	case 0:return 'Inactivo';break;
                	case 1:return 'Activo';break;
                }
                },
                menuDisabled:true,
                draggable:false
            }
//          	, {
//                text: 'Roles',
//                flex: 1,
//                dataIndex: 'descripcion',
//                menuDisabled:true,
//                draggable:false
//            }
            ],
            dockedItems: [{
            	xtype: 'toolbar',
            	dock: 'top',
            	items: [{
            		xtype: 'combobox',
            		id: 'idNombreEmpleadoBuscar',
            		fieldLabel: 'Nombre de Empleado',
            		name: 'nombreEmpleado',
            		queryMode: 'local',
            		labelWidth:140,
            		displayField: 'nombre',
            		forceSelection:true,
            		valueField: 'cve',
            		 loadingText: 'Buscando...',
					 typeAhead :true,
					 emptyText :'Introduzca las primeras cinco letras del nombre',
					 hideTrigger :true,
					 enableKeyEvents:true,
            		store: 'Empleados',
            		flex: 1
            	}]
            }]
		});
		
		this.callParent(arguments);
	}
});
