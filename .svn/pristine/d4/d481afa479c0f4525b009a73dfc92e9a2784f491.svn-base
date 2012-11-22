Ext.ClassManager.create('PR.view.usuario.AsignarRolUsuarioGrid', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.asignarRolUsuarioGrid',
	store: 'UsuariosRoles',
	id: 'asignar-rol-grid',
	width:700,
	height: 250,
	style: {
		marginLeft : 'auto',
		marginRight: 'auto'
	},
	initComponent: function() {
		this.columns = [{
			header: 'Rol',
			dataIndex: 'rol',
			menuDisabled: true,
			draggable: false,
			flex:1
		}, {
			header: 'Descripción',
			dataIndex: 'descripcionRol',
			menuDisabled: true,
			draggable: false,
			flex: 2
		}, {
			header: 'Empleado',
			dataIndex: 'nombreEmpleado',
			menuDisabled: true,
			draggable: false,
			flex: 2
		}		
		,{
			header: 'Acciones',
			menuDisabled: true,
			id:'id-column-acciones',
			draggable: false,
			sortable: false,
			xtype: 'actioncolumn',
	    	width: 70,
	    	items: [{
	    		tooltip: 'Eliminar',
	    		iconCls: 'eliminar-rol-icon',
	    	    icon: Namespace.namespace + 'resources/images/delete.png'
	    	}]
		}];
		
		this.selType = 'rowmodel';
		
		this.callParent(arguments);
	}
	
});