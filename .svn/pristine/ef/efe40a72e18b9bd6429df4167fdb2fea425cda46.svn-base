/**
 * @author Daniel Ramon Zapata
 * @version 2011-10-19
 * @description Controlador de Recuperar Contraseña
 */
Ext.ClassManager.create('PR.controller.RecuperarContrasenia', {
	extend: 'Ext.app.Controller',
	views: ['usuario.RecuperarContrasenia'],
	requires: ['PR.util.Namespace'],
	
	widgets: [],
	
	init: function() {
		this.control({
			'button[id = idCambiarContrasenia]':{click:this.onCambiarContrasenia},
			'textfield[id = idConfirmarContrasenia]':{blur:this.onValidarContrasenia},
			'textfield[id = idNuevaContrasenia]':{blur:this.onLimpiarTextConfirmacion}
			});
		Ext.EventManager.onWindowResize(this.onWindowResizeListener, this);
	},
	/**
	 *@author Daniel Ramon Zapata
	 *@version 2011-10-19
	 *@description limpia el textfield de la confirmacion al dejar el focus del textfield de la nueva contraseña
	 **/
	onLimpiarTextConfirmacion:function(){Ext.getCmp('idConfirmarContrasenia').setValue('');},
	/**
	 *@author Daniel Ramon Zapata
	 *@version 2011-10-19
	 *@description valida que la nueva contraseña coincida con la confirmacion
	 **/
	onValidarContrasenia:function(){
		var confirmar = Ext.getCmp('idConfirmarContrasenia').getValue();
		var contrasenia= Ext.getCmp('idNuevaContrasenia').getValue();
		
		if(confirmar!=contrasenia){
			Ext.Msg.show({
						title: 'Usuario',
						buttons: Ext.Msg.OK,
						icon: Ext.Msg.INFO,
						closable :false,
						msg: 'La confirmacion de la contraseña no coincide',
						fn: function(btn) {
							Ext.getCmp('idNuevaContrasenia').setValue('');
							Ext.getCmp('idNuevaContrasenia').focus();
							}
					});	
		}
		
	},
	onCambiarContrasenia:function(){
		
		var form= Ext.getCmp('recuperarContrasenia');
		form.getForm().submit({
			url:Namespace.namespace+'usuarios/cambiarcontrasenia/guardar',
			waitTitle:'Guardando',
	        waitMsg: 'Guardando datos...',
			success: function (form, action) {	
						//var dato=Ext.decode(action.response.responseText);
						//if(!dato.existe){
							Ext.Msg.show({
								title: 'Usuario',
								buttons: Ext.Msg.OK,
								icon: Ext.Msg.INFO,
								closable :false,
								msg: 'La contraseña a sido cambiada con exito',
								fn: function(btn) {	}
							});
						/*}else{
							Ext.Msg.show({
								title: 'Usuario',
								buttons: Ext.Msg.OK,
								icon: Ext.Msg.INFO,
								closable :false,
								msg: 'Introdusca la contraseña Anterior Valida',
								fn: function(btn) { 
									Ext.getCmp('idContraseniaAnterior').setValue('');
									Ext.getCmp('idContraseniaAnterior').focus();
								}
							});
						}*/
					},
					failure: function (form, action) {
						form.reset();
								if (!action || !action.result) {
									Ext.MessageBox.alert('Error', 'Problemas en la conexion');
									return;
								}
								Ext.MessageBox.alert('Error', 'Ocurrio un error al modificar la contraseña');
					}
		});
	},
	

	/**
	 * Función que escucha al evento onWindowResize, es la encargada de aplicar
	 * el redimensionado a los widgets contenidos en {widget}.
	 */
	onWindowResizeListener: function() {
		for (var i = 0, l = this.widgets.length; i < l; i++) {
			this.widgets[i].doComponentLayout();
		}
	}
});