Ext.ClassManager.create('PR.view.usuario.BusquedaUsuarioGrid', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.busquedaUsuarioGrid',
	id: 'busquedaUsuarioGrid',

	initComponent: function() {
		Ext.apply(this, {
			height:300,
			store: 'BusquedaUsuarioGrid',
			columns: [{
				 text:'Nombre del empleado',
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
				  text: 'Roles',
	              flex: 1,
	              dataIndex: 'descripcionRol',
	              menuDisabled:true,
	              draggable:false
			}],
			plugins: [Ext.create('Ext.grid.plugin.CellEditing', {
				clickToEdit: 1
			})],
			selType: 'checkboxmodel',
			selModel: 'checkboxmodel',
			dockedItems: [{
				xtype: 'toolbar',
				dock: 'bottom',
				items: ['->', {
					cls: 'activar-usuario',
					text: 'Activar',
					id :'idActivar'
				},
				{
					cls: 'desactivar-usuario',
					text: 'Desactivar',
					id : 'idDesactivar'
				}]
			}]
		});
		
		this.callParent(arguments);
	}
});