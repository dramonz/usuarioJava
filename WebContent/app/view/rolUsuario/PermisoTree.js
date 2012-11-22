/**
 * @author José Luis Landero
 */
Ext.ClassManager.create('PR.view.rolUsuario.PermisoTree', {
	extend: 'Ext.tree.Panel',
	alias: 'widget.permisotree',

	
	initComponent: function() {
		Ext.apply(this, {
			width: 450,
			height: 500,
			scroll:'vertical',
//			autoScroll: true,
			store: 'PermisosTree',
			rootVisible: false,
			border: 1,
			dockedItems: [{
				xtype: 'toolbar',
				dock: 'bottom',
				items: [{
					text: 'Asignar Permiso',
					id: 'asignar-permisos-rol'
				}]
			}]
		});
		
		this.callParent(arguments);
	}
});