/**
 * @author Daniel Ramon Zapata
 * @version 2011-10-19
 * @description formulario para la modificacion de contraseña
 */
Ext.ClassManager.create('PR.view.usuario.RecuperarContrasenia', {
	extend: 'Ext.form.Panel',
	alias: 'widget.recuperarcontrasenia',
	id: 'recuperarContrasenia',
	url: 'usuarios/recuperarcontrasenia',
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
			xtype: 'textfield',
			id: 'idContraseniaAnterior',
			fieldLabel: 'Contraseña anterior',
			maxLength:50,
			inputType: 'password',
			allowBlank: false,
			name: 'contraseniaAnterior'
		}, {			
			xtype: 'textfield',
			id: 'idNuevaContrasenia',
			fieldLabel: 'Nueva Contraseña',
			inputType: 'password',
			maxLength:50,
			allowBlank: false,
			name: 'contraseniaNueva'
		
		}, {
			xtype: 'textfield',
			id: 'idConfirmarContrasenia',
			fieldLabel: 'Confirmar Contraseña',
			inputType: 'password',
			maxLength:50,
			allowBlank: false,
			name: 'confirmarContrasenia'
		}];
		
		this.buttons = [{
			text: 'Cambiar contraseña ',
			id:'idCambiarContrasenia',
			formBind: true,
			handler: function() {
				
			}
		}];
		
		this.callParent(arguments);
	}
});