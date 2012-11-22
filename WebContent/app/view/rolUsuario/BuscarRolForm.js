/**
 * @author José Luis Landero
 */
Ext.ClassManager.create('PR.view.rolUsuario.BuscarRolForm', {
	extend: 'Ext.form.Panel',
	alias: 'widget.formbuscarrol',
	
	initComponent: function() {
		Ext.apply(this, {
			layout: 'anchor',
			bodyPadding: 10,
			items: [{
				xtype: 'combobox',
				store: 'RolesAutocomplete',
				id: 'nombreRol',
				displayField: 'rol',
				valueField: 'rol',
				fieldLabel: 'Rol',
				emptyText: 'Buscar rol',
				queryMode: 'remote',
				queryParam: 'nombreRol',
				minChars: 3,
				hideTrigger: true,
				anchor: '100%',
				labelPad: 10
			}]
		});
		
		this.callParent(arguments);
	}
});