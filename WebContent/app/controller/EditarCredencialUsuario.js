Ext.ClassManager.create('PR.controller.EditarCredencialUsuario', {
	extend: 'Ext.app.Controller',
	models: [],
	stores: [],
	views: ['usuario.EditarCredencialForm'],
	requires: ['PR.util.Namespace'],
	
	init: function() {
		this.control({
			'formeditarcredencialusuario #save-changes': {
				click: this.saveChanges
			}
		});
	},
	
	saveChanges: function(btn) {
		var newPassword = btn.up().up().down('#new-password').getValue(),
			newPasswordConfirmation = btn.up().up().down('#new-password-confirmation').getValue();
		
		if (newPassword != newPasswordConfirmation) {
			Ext.Msg.show({
				msg: 'Las contraseñas no coinciden (campos nueva contraseña y confirmar contraseña)',
				buttons: Ext.Msg.OK
			});
			return;
		}
		
		Ext.Msg.show({
			msg: '¿Está seguro que desa guardar las modificaciones a su contraseña? Estas modificaciones no son reversibles',
			buttons: Ext.Msg.YESNO,
			fn: function(b) {
				if (b == 'yes') {
					btn.up().up().getForm().submit({
						url: Namespace.namespace + 'usuario/actualizar-credenciales',
						success: function(form, action) {
							Ext.Msg.show({
								msg: action.result.msg,
								buttons: Ext.Msg.OK,
								icon: Ext.Msg.INFO
							});
						},
						failure: function(form, action) {
							switch (action.failureType) {
							case Ext.form.action.Action.CLIENT_INVALID:
								Ext.Msg.show({
									msg: 'Los campos del formulario son inválidos',
									buttons: Ext.Msg.OK,
									icon: Ext.Msg.ERROR
								});
								break;
							case Ext.form.action.Action.CONNECT_FAILURE:
								Ext.Msg.show({
									msg: 'No se ha podido establecer la conexión al servidor',
									buttons: Ext.Msg.OK,
									icon: Ext.Msg.ERROR
								});
								break;
							case Ext.form.action.Action.SERVER_INVALID:
								Ext.Msg.show({
									msg: action.result.msg,
									buttons: Ext.Msg.OK,
									icon: Ext.Msg.ERROR
								});
							}
						}
					});
				}
			}
		});
	}
	
});