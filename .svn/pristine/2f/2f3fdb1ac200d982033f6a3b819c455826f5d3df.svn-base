Ext.define('PR.view.usuario.EmpleadoGrid', {
	extend:'Ext.grid.Panel',
	alias:'widget.empleadogrid',
	
	initComponent: function() {
		Ext.apply(this, {
			title:'Empleados',
			store:'Empleados',
			id:'idUsuario',
			height: 300,
			selType: 'rowmodel',
			columns: [{
                text:'Nombre',
                flex:1,
                dataIndex:'nombre',
                menuDisabled:true,
                draggable:false
            }, {
                text:'Área',
                flex:1,
                dataIndex:'area',
                menuDisabled:true,
                draggable:false
          	}, {
            	text:'Puesto',
                flex:1,
                dataIndex:'puesto',
                menuDisabled:true,
                draggable:false
            }, {
                text: 'Correo Electrónico',
                flex: 1,
                dataIndex: 'correoElectronico',
                menuDisabled:true,
                draggable:false
            }, {
                text: 'Unidad',
                flex: 1,
                dataIndex: 'unidad',
                menuDisabled:true,
                draggable:false
            }, {
            	text: 'Estado',
            	flex: 1,
            	dataIndex: 'activo',
            	menuDisabled: true,
            	draggable: false,
            	renderer: function(value) {
            		return value ? 'Activo' : 'Inactivo';
            	}
            }],
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
