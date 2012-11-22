/**
 * @author José Luis Landero
 */
Ext.ClassManager.create('PR.view.rolUsuario.RolUsuarioTree', {
	extend: 'Ext.tree.Panel',
	alias: 'widget.rolusuariotree',
		
	initComponent: function() {
		Ext.apply(this, {
			width: 450,
			height: 500,
			scroll:'vertical',
//			autoScroll: true,
			store: 'PermisosRolTree',
			rootVisible: false,
//			id: 'rolUsusarioTreeID',
			border: 1,
			dockedItems: [{
				xtype: 'toolbar',
				dock: 'bottom',
				items: [{
					text: 'Eliminar Permiso',
					id: 'eliminar-permisos-rol'
				}]
			}]
		});
		
		this.callParent(arguments);
	}
});