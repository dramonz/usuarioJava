/**
 * @class PR.view.usuario.PermisoRolForm
 * @extends Ext.form.Panel
 * 
 * Form de Permiso de Roles
 * 
 * @author Daniel Ramon Zapata
 * @version 2011-10-14
 */

Ext.ClassManager.create('PR.view.usuario.PermisoRolForm', {
	extend: 'Ext.form.Panel',
	alias: 'widget.permisorolform',
	id: 'idPermisoRolForm',
	url: 'usuarios/permisosroles',
	width: '100%',
	defaults: {
		anchor: '95%',
		labelPad: 20,
		labelAlign: 'right',
		padding: '10 0 5 0',
		labelWidth: 125
	},
	
	initComponent: function() {
		this.items = [{
			xtype: 'combobox',
			id: 'idRol',
			fieldLabel: 'Roles',
			name: 'rol',
			queryMode: 'local',
			displayField: 'descripcion',
			allowBlank: false,
			forceSelection:true,
			valueField: 'rol',
			store:'Roles'
		}];
		
		this.buttons = [{
			text: 'Buscar',
			id:'idBuscar',
			formBind: true,
			handler: function() {
				
			}
		}];
		
		this.callParent(arguments);
	}
});