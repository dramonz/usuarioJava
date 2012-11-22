Ext.ClassManager.create('PR.view.usuario.EditarCredencialForm', {
	extend: 'Ext.form.Panel',
	alias: 'widget.formeditarcredencialusuario',
	
	initComponent: function() {
		Ext.apply(this, {
			layout: 'anchor',
			bodyPadding: 10,
			items: [{
				xtype: 'textfield',
				fieldLabel: 'Contraseña Actual',
				id: 'current-password',
				name: 'currentPassword',
				labelPad: 10,
				inputType: 'password',
				allowBlank: false,
				anchor: '100%',
				labelWidth: 200,
				msgTarget: 'side',
				maskRe: /\w/
			}, {
				xtype: 'textfield',
				fieldLabel: 'Contraseña Nueva',
				id: 'new-password',
				name: 'newPassword',
				labelPad: 10,
				inputType: 'password',
				allowBlank: false,
				anchor: '100%',
				labelWidth: 200,
				msgTarget: 'side',
				maskRe: /\w/
			}, {
				xtype: 'textfield',
				fieldLabel: 'Confirmar Contraseña',
				id: 'new-password-confirmation',
				labelPad: 10,
				name: 'newPasswordConfirmation',
				inputType: 'password',
				allowBlank: false,
				anchor: '100%',
				labelWidth: 200,
				msgTarget: 'side',
				maskRe: /\w/
			}],
			dockedItems: [{
				xtype: 'toolbar',
				dock: 'bottom',
				items: ['->', {
					text: 'Guardar Cambios',
					id: 'save-changes',
					formBind: true,
					disabled: true
				}]
			}]
		});
		
		this.callParent(arguments);
	}
});