/**
  * @author Daniel Ramon Zapata
 * @version 2011-10-14
 */
Ext.application({
	name: 'PR',
	appFolder: appFolder,
	controllers: ['PermisoRol'],
	
	launch: function() {
		
		var permisosRolLayout = Ext.ClassManager.instantiate('Ext.container.Container', {
			renderTo: 'permisos-rol-layout',
			layout: 'border',
			width: '100%',
			height: 600,
			items: [{
				region: 'center',
				layout: 'fit',
				items: [{
					xtype: 'PermisoRolGrid',
					border: 0,
					dockedItems: [{
						xtype: 'toolbar',
						items: [{
							xtype: 'combobox',
							id: 'idRol',
							fieldLabel: 'Roles',
							name: 'rol',
							queryMode: 'local',
							displayField: 'rol',
							allowBlank: false,
							forceSelection:true,
							valueField: 'rol',
							store:'Roles',
							width: 400
						}, {
							text: 'Buscar',
							id: 'idBuscar'
						}]
					}]
				}]
			}, {
				region: 'east',
				width: 350,
				layout: 'fit',
				title: 'Roles',
				xtype: 'treepanel',
				store: 'RolesTree',
				rootVisible: false,
				collapsible: true,
				dockedItems: [{
					xtype: 'toolbar',
					dock: 'bottom',
					items: ['->', {
						text : 'Guardar',
						id : 'idGuardar'
					}]
				}]
			}]
		});
		
		this.getController('PermisoRol').widgets.push(permisosRolLayout);
	}
});