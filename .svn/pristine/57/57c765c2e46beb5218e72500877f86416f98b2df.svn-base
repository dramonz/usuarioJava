/**
  * @author Daniel Ramon Zapata
 * @version 2011-10-06
 */
Ext.ClassManager.create('PR.view.usuario.AgregarRol', {
	extend: 'Ext.form.Panel',
	alias: 'widget.agregarrolform',
	id: 'agregarrol',
	url: 'agregarrol',
	width: '100%',
	defaults: {
		anchor: '95%',
		labelPad: 20,
		labelAlign: 'right',
		padding: '10 0 5 0'
	},
	
	initComponent: function() {
		this.items = [{
			xtype: 'textfield',
			id: 'nomre-rol',
			fieldLabel: 'Nombre<span class="required">*</span>',
			name: 'nombre',			
			allowBlank: false,
			maxLength:50, 
			regex: /(ROLE_[a-zA-Z0-9._]+)$/,
			regexText:'El nombre del Rol debe iniciar con el prefijo ROLE_,puede incluir Mayúsculas, Minúsculas, números y guiones bajos; no debe contener espacios en blanco'
			
		}, {
			xtype: 'textfield',
			id: 'descripcion-rol',	
			fieldLabel: 'Descripción<span class="required">*</span>',
			name: 'descripcion'	,
			allowBlank: false
		},{
			xtype: 'fieldcontainer',
			fieldLabel: 'Activo',
			items: [{
				xtype: 'checkboxfield',
				inputValue: '1',
				name: 'activo',
				id: 'activoRol'
			}]
		}];
		this.dockedItems=[{
			xtype: 'toolbar',
			cls:'grid-toolbar',
			dock: 'bottom',
			items: ['->', {
				text: 'Agregar Rol',
				id:'idAgregarRol',
	        	formBind:true
			}]
		}];
				
		this.callParent(arguments);
	}
});