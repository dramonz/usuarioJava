/**
 * 
 */
Ext.ClassManager.create('PR.controller.AgregarUsuarios', {
	extend: 'Ext.app.Controller',
	views: ['usuario.AgregarUsuario'],
	stores:['Empleados','Roles'],
	models:['Empleado','Rol'],
	requires: ['PR.util.Namespace'],
	
	widgets: [],
	
	init: function() {
		this.control({
			'button[id = idAgregarUsuario]':{click:this.onAgregarUsuario},
			'textfield[id = contraseniaUsuarioConfirmar]':{blur:this.onValidarContrasenia},
			'textfield[id = contraseniaUsuario]':{blur:this.onLimpiarTextConfirmacion},
			'#idNombreEmpleado':{keypress:this.onKeyPressEmpleado}
			});
		Ext.EventManager.onWindowResize(this.onWindowResizeListener, this);
	},
	/**
	 * Carga el store con los tres primeros caracteres que optiene
	 * @param _this
	 * @param event
	 */
	onKeyPressEmpleado:function(_this,event){
		if(_this.rawValue.length>3) return;
		var str = _this.rawValue+String.fromCharCode(event.getKey());
		if(str.length==3){
			_this.store.load({params:{empleado:str}});
		}else if(str.length<4){
			_this.store.removeAll();
		}
	},
	onLimpiarTextConfirmacion:function(){Ext.getCmp('contraseniaUsuarioConfirmar').setValue('');},
	onValidarContrasenia:function(){
		var confirmar = Ext.getCmp('contraseniaUsuarioConfirmar').getValue();
		var contrasenia= Ext.getCmp('contraseniaUsuario').getValue();
		
		if(confirmar!=contrasenia){
			Ext.Msg.show({
						title: 'Usuario',
						buttons: Ext.Msg.OK,
						icon: Ext.Msg.INFO,
						closable :false,
						msg: 'La confirmacion de la contraseña no coincide',
						fn: function(btn) {Ext.getCmp('contraseniaUsuarioConfirmar').setValue('');}
					});	
		}
		
	},
	onAgregarUsuario:function(){
		
		var form= Ext.getCmp('agregarusuario');
		var nombre=Ext.getCmp('idNombreEmpleado').getValue();
		var activoUsuario=Ext.getCmp('activoUsuario').getValue();
		var fechaInicio	= Ext.Date.format( ( Ext.getCmp( 'fechaInicio' ).getValue()), 'Ymd');
		var fechaVencimiento	=	Ext.Date.format( ( Ext.getCmp( 'fechaVencimiento' ).getValue()), 'Ymd');
		Ext.getCmp( 'fechaInicio' ).setDisabled(true);
		Ext.getCmp( 'fechaVencimiento' ).setDisabled(true);
		form.getForm().submit({
			url:Namespace.namespace+'usuarios/agregarusuario',
			params:{
				activo:activoUsuario,
				nombreEmpleado:nombre,
				fechaInicio:fechaInicio,
				fechaVencimiento:fechaVencimiento
				},
				waitTitle:'Agregando Usuario',
	         	waitMsg: 'Guardando...',
				success: function (form, action) {	
						var dato=Ext.decode(action.response.responseText);
						if(!dato.existe){
							Ext.Msg.show({
								title: 'Usuario',
								buttons: Ext.Msg.YESNO,
								icon: Ext.Msg.INFO,
								closable :false,
								msg: 'El Usuario se ha registrado con exito, ¿Desea agregrar mas Usuarios?',
								fn: function(btn) {
									Ext.getCmp( 'fechaInicio' ).setDisabled(false);
									Ext.getCmp( 'fechaVencimiento' ).setDisabled(false);
									if (btn == 'yes') {
										var form = Ext.getCmp('agregarusuario');
										window.location = Namespace.namespace+'usuarios/agregarusuario';
									}else{
										window.parent.location = Namespace.namespace;
									}
								}
							});
						}else{
							Ext.Msg.show({
								title: 'Usuario',
								buttons: Ext.Msg.OK,
								icon: Ext.Msg.INFO,
								closable :false,
								msg: 'El nombre del usuario ya esta en uso',
								fn: function(btn) { 
									Ext.getCmp('nombreUsuario').setValue('');
									Ext.getCmp('nombreUsuario').focus();
								}
							});
						}
					},
					failure: function (form, action) {
								Ext.getCmp( 'fechaInicio' ).setDisabled(false);
								Ext.getCmp( 'fechaVencimiento' ).setDisabled(false);
								if (!action || !action.result) {
									Ext.MessageBox.alert('Error', 'Problemas en la conexion');
									return;
								}
								Ext.MessageBox.alert('Error', 'Ocurrio un error al registrar al Usuario');
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