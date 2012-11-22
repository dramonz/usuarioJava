/**
  * @author Daniel Ramon Zapata
 * @version 2011-10-07
 */
Ext.define('PR.view.usuario.RolGrid', {
	extend:'Ext.grid.Panel',
	alias:'widget.rolGrid',
	
	initComponent: function() {
		Ext.apply(this, {
			title:'Roles',
			store:'Roles',
			id:'idRolGrid',
			height: 300,
			selType: 'rowmodel',
			columns: [{
				text:'Rol',
				flex:1,
				dataIndex:'rol',
				menuDisabled:true,
				draggable:false
			}, {
				text:'Descripción',
				flex:1,
				dataIndex:'descripcion',
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
					flex: 1,
					id: 'idRolUsuario',
					fieldLabel: 'Roles',
					name: 'rolUsuario',
					queryMode: 'local',
					displayField: 'rol',
					forceSelection:true,
					valueField: 'rol',
					store:'Roles'
				}]
			}] 
		});
		
		this.callParent(arguments);
	}
});