Ext.ClassManager.create('PR.view.usuario.AsignarRolUsuarioForm', {
	extend: 'Ext.form.Panel',
	alias: 'widget.asignarRolUsuarioForm',
	id: 'agregarusuario',
	url: 'agregarusuario',
	width: '100%',
	defaults: {
		anchor: '95%',
		labelPad: 20,
		labelAlign: 'right',
		padding: '10 0 5 0',
		labelWidth: 155
	},
	
	initComponent: function() {
		this.items = [ 
//		               {
//			xtype: 'combobox',
//			id: 'idNombreEmpleado',
//			fieldLabel: 'Nombre de Empleado',
//			name: 'nombreEmpleado',
//			queryMode: 'local',
//			displayField: 'nombre',
//			forceSelection:true,
//			valueField: 'cve',
//			store: 'Empleados'
//		}, 
		{
			xtype: 'combobox',
			id: 'cmb-usuario',
			fieldLabel: 'Nombre de Usuario<span class="required">*</span>',
			name: 'cveUsuario',
			queryMode: 'local',
			displayField: 'nombreUsuario',
			forceSelection:true,
			valueField: 'cve',
			store: 'EditarUsuariosGrid',
			 loadingText: 'Buscando...',
			 typeAhead :true,
			 emptyText :'Introduzca las primeras cinco letras del usuario',
			 hideTrigger :true,
			 enableKeyEvents:true,
			allowBlank: false
		},{
			xtype: 'combobox',
			id: 'idRolUsuario',
			fieldLabel: 'Roles<span class="required">*</span>',
			name: 'rol',
			queryMode: 'local',
			displayField: 'rol',
			allowBlank: false,
			forceSelection:true,
			valueField: 'rol',
			store:'Roles'
		}];
		
		this.dockedItems=[{
			xtype: 'toolbar',
			cls:'grid-toolbar',
			dock: 'bottom',
			items: ['->', {
				text: 'Asignar Rol',
				id:'btn-asignar-rol',
	        	formBind:true
			}]
		}];
		
		this.callParent(arguments);
	}
});