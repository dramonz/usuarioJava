Ext.ClassManager.create('PR.controller.EditarUsuarios', {
	extend: 'Ext.app.Controller',
	views: ['usuario.AgregarUsuario'],
	stores:['Empleados','Roles','EditarUsuariosGrid'],
	models:['Empleado','Rol','EditarUsuarioGrid'],
	requires: ['PR.util.Namespace'],
	
	widgets: [],
	
	init: function() {
		this.control({
			'agregarusuarioform':{render:this.onRenderForm},
			'usuarioGrid':{select:this.onSelectGrid},
			'button[id = idAgregarUsuario]':{click:this.onAgregarUsuario},
			'textfield[id = contraseniaUsuarioConfirmar]':{blur:this.onValidarContrasenia},
			'textfield[id = idNuevaContraseniaUsuario]':{blur:this.onLimpiarTextConfirmacion},
			'checkboxfield[id = idModificarContrasenia]':{change:this.onModificarContrasenia},
			'#idNombreEmpleado':{keypress:this.onKeyPressEmpleado},
			'#idNombreEmpleadoBuscar':{keypress:this.onKeyPressEmpleado,select:this.onBuscarEmpleado}
		});
		Ext.EventManager.onWindowResize(this.onWindowResizeListener, this);
	},
	
	/**
	 * Carga el store con los tres primeros caracteres que optiene
	 * @param _this
	 * @param event
	 */
	onKeyPressEmpleado:function(_this,event){
		if(_this.rawValue.length>5) return;
		var str = _this.rawValue+String.fromCharCode(event.getKey());
		if(str.length==5){
			_this.store.load({params:{empleado:str}});
		}else if(str.length<6){
			_this.store.removeAll();
		}
	},
	onBuscarEmpleado:function(cmb){
		cmb.up().up().getStore().load({params:{cveEmpleado:cmb.getValue()}});
	},
	
	onModificarContrasenia:function(){
		if(Ext.getCmp( 'idModificarContrasenia' ).getValue()){
			Ext.getCmp('idNuevaContraseniaUsuario').setDisabled(false);
			Ext.getCmp('contraseniaUsuarioConfirmar').setDisabled(false);
			Ext.getCmp('idNuevaContraseniaUsuario').setValue('');
			Ext.getCmp('contraseniaUsuarioConfirmar').setValue('');
		} else{
			Ext.getCmp('idNuevaContraseniaUsuario').setDisabled(true);
			Ext.getCmp('contraseniaUsuarioConfirmar').setDisabled(true);
		}
	},
	
	onSelectGrid:function(selectgrid,record,index,eOpts){
		var fechaInic=Ext.Date.parse(record.data.fechaInicio, 'Ymd');
		var fechaVenc=Ext.Date.parse(record.data.fechaVencimiento, 'Ymd');
		Ext.getCmp( 'idModificarContrasenia' ).setValue(false);
		Ext.getCmp('nombreUsuario').setValue(record.data.nombreUsuario);
		Ext.getCmp('idNuevaContraseniaUsuario').setValue(record.data.contrasenia);
		Ext.getCmp('contraseniaUsuarioConfirmar').setValue(record.data.contrasenia);
		Ext.getCmp('fechaInicio').setValue(Ext.Date.format(fechaInic,'d/m/Y'));		
		Ext.getCmp('fechaVencimiento').setValue(Ext.Date.format(fechaVenc,'d/m/Y'));
		if(record.data.activo==0){Ext.getCmp('activoUsuario').setValue(false);
		}else{Ext.getCmp('activoUsuario').setValue(true);}	
		Ext.getStore('Empleados').load({
				params:{cveJefe:record.data.cveEmpleado},
				callback: function(records, operation, success) {
				      if(success) Ext.getCmp('idNombreEmpleado').setValue(record.data.cveEmpleado);
				    }
			});
		this.cveUsuario=record.data.cve;
	},
		
	onRenderForm:function(){
		Ext.getCmp('idAgregarUsuario').setText('Editar');
		Ext.getCmp('contraseniaUsuario').setVisible(false);
		Ext.getCmp('contraseniaUsuario').setDisabled(true);
		Ext.getCmp('idNuevaContraseniaUsuario').setVisible(true);
		Ext.getCmp('contraseniaUsuarioConfirmar').setDisabled(true);
		Ext.getCmp('idContenedorModificarContrasenia').setVisible(true);
		Ext.getCmp('idContenedorModificarContrasenia').setDisabled(false);
	},
	
	onLimpiarTextConfirmacion :function() {
		Ext.getCmp('contraseniaUsuarioConfirmar').setValue('');
	},
	
	onValidarContrasenia: function() {
		var confirmar = Ext.getCmp('contraseniaUsuarioConfirmar').getValue();
		var contrasenia= Ext.getCmp('idNuevaContraseniaUsuario').getValue();
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
	    if(this.cveUsuario==null){return;}
		
		var form= Ext.getCmp('agregarusuario');
		var nombre=Ext.getCmp('idNombreEmpleado').getValue();
		var activoUsuario=Ext.getCmp('activoUsuario').getValue();
		var fechaInicio	= Ext.Date.format( ( Ext.getCmp( 'fechaInicio' ).getValue()), 'Ymd');
		var fechaVencimiento	=	Ext.Date.format( ( Ext.getCmp( 'fechaVencimiento' ).getValue()), 'Ymd');
		var Contrasenia='';	
		if(Ext.getCmp('idModificarContrasenia').getValue())
			Contrasenia=Ext.getCmp('idNuevaContraseniaUsuario').getValue();
				
		Ext.getCmp( 'fechaInicio' ).setDisabled(true);
		Ext.getCmp( 'fechaVencimiento' ).setDisabled(true);
		form.getForm().submit({
			url:Namespace.namespace+'usuarios/editarusuario',
			params:{
				contrasenia:Contrasenia,
				activo:activoUsuario,
				nombreEmpleado:nombre,
				fechaInicio:fechaInicio,
				fechaVencimiento:fechaVencimiento,
				cve:this.cveUsuario
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
								msg: 'El Registro se ha actualizado con éxito,¿Desea seguir editando más usuarios? ',
								fn: function(btn) { 
									Ext.getCmp( 'fechaInicio' ).setDisabled(false);
									Ext.getCmp( 'fechaVencimiento' ).setDisabled(false);
									if (btn == 'yes') {
										window.location = Namespace.namespace+'usuarios/editarusuario';
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
	contar:0,
	cveUsuario:null,

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