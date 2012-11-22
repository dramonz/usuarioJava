/**
 * 
 */
Ext.ClassManager.create('PR.controller.AgregarEmpleados', {
	extend: 'Ext.app.Controller',
	views: ['usuario.AgregarEmpleado'],
	stores:['UnidadesComboUsuarios','Puesto','Area','Empleados','jefeEmpleados'],
	models:['UnidadesCombo','Puesto','Area','Empleado'],
	requires: ['PR.util.Namespace'],
	
	widgets: [],
	
	init: function() {
		this.control({
			'button[id = idAgregarEmpleado]':{click:this.onAgregarEmpleado},
			'#jefe-empleado':{keypress:this.onKeyPressEmpleado}
			});
		Ext.EventManager.onWindowResize(this.onWindowResizeListener, this);
		Ext.getStore('UnidadesComboUsuarios').load({start:0,limit:10000});
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
	/**
	 * Función que escucha al evento onAgregarEmpleado, es la encargada de agregar
	 * la llamada al metodo de java para agregar al empleado al mandar el submit
	 */
	onAgregarEmpleado:function(){
		var activo = Ext.getCmp('activoEmpleado').getValue();
		if(!activo)
			activo=0;
		var form = Ext.getCmp('agregarempleado');
			form.getForm().submit({
				url:Namespace.namespace+'usuarios/agregarempleado',
				params:{
					nombre:Ext.getCmp('nombre-empleado').getValue(),
					apellidos:Ext.getCmp('apellidos-empleado').getValue(),
					area:Ext.getCmp('area-empleado').getValue(),
					puesto:Ext.getCmp('puesto-empleado').getValue(),
					email:Ext.getCmp('email-empleado').getValue(),
					unidad:Ext.getCmp('unidad-empleado').getValue(),
					cveJefe:Ext.getCmp('jefe-empleado').getValue(),
					activo:activo
				},
				waitTitle:'Agregando Empleado',
	         	waitMsg: 'Guardando...',
				success: function (form, action) {	
					Ext.Msg.show({
					title: 'Empleados',
					buttons: Ext.Msg.YESNO,
					icon: Ext.Msg.INFO,
					msg: 'El empleado se ha registrado con exito, desea agregrar mas empleados',
					fn: function(btn) { 
						if (btn == 'yes') {
								var form = Ext.getCmp('agregarempleado');
								form.getForm().reset();
							}else{
								window.parent.location = Namespace.namespace;
							}
					}
					});	
				},
							failure: function (form, action) {
								if (!action || !action.result) {
									Ext.MessageBox.alert('Error', 'Problemas en la conexion');
								
									return;
								}
									
								Ext.MessageBox.alert('Error', 'Ocurrio un error al registrar al empleado');
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