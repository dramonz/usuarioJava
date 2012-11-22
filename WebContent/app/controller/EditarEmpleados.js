Ext.ClassManager.create('PR.controller.EditarEmpleados', {
	extend: 'Ext.app.Controller',
	views: ['usuario.AgregarEmpleado','usuario.EmpleadoGrid'],
	stores:['UnidadesComboUsuarios','Empleados','Puesto','Area','jefeEmpleados'],
	models:['UnidadesCombo','Empleado','Puesto','Area'],
	requires: ['PR.util.Namespace'],
	
	widgets: [],
	
	init: function() {
		this.control({
			'button[id = idAgregarEmpleado]':{click:this.onAgregarEmpleado},
			'agregarempleadoform':{render:this.onRenderForm},
			'combobox[id = idNombreEmpleadoBuscar]':{select:this.onBuscarEmpleado},
			'empleadogrid':{select:this.onSelectGrid},
			'#jefe-empleado':{keypress:this.onKeyPressEmpleadoJefe},
			'#idNombreEmpleadoBuscar':{keypress:this.onKeyPressEmpleado},
			});
		Ext.EventManager.onWindowResize(this.onWindowResizeListener, this);
		Ext.getStore('UnidadesComboUsuarios').load({start:0,limit:10000});
	},
	onKeyPressEmpleado:function(_this,event){
		if(_this.rawValue.length>5) return;
		var str = _this.rawValue+String.fromCharCode(event.getKey());
		if(str.length==5){
			_this.store.load({params:{empleado:str}});
			Ext.ComponentQuery.query('#jefe-empleado')[0].store.load({params:{empleado:str}});
		}else if(str.length<6){
			_this.store.removeAll();
			Ext.ComponentQuery.query('#jefe-empleado')[0].store.removeAll();
		}
	},
	/**
	 * Carga el store con los tres primeros caracteres que optiene
	 * @param _this
	 * @param event
	 */
	onKeyPressEmpleadoJefe:function(_this,event){
		if(_this.rawValue.length>5) return;
		var str = _this.rawValue+String.fromCharCode(event.getKey());
		if(str.length==5){
			_this.store.load({params:{empleado:str}});
		}else if(str.length<6){
			_this.store.removeAll();
		}
	},
	onBuscarEmpleado:function(){
		var store=Ext.getStore('Empleados');
		store.clearFilter();
		store.filter("cve", Ext.getCmp('idNombreEmpleadoBuscar').getValue());
	},
	
	onSelectGrid:function(selectgrid,record,index,eOpts){
		Ext.getCmp('editar-nombre-empleado').setValue(record.data.nombre);
		Ext.getCmp('area-empleado').select(record.get('cveArea'));		
		Ext.getCmp('puesto-empleado').setValue(record.data.cvePuesto);
		Ext.getCmp('email-empleado').setValue(record.data.correoElectronico);
		Ext.getCmp('unidad-empleado').setValue(record.data.idUnidad);
		Ext.getCmp('activoEmpleado').setValue(record.data.activo.toString());
		Ext.getStore('jefeEmpleados').load({
			params:{cveJefe:record.data.cveJefe},
			callback: function(records, operation, success) {
			      if(success){
			    	  Ext.ComponentQuery.query('#jefe-empleado')[0].setValue(record.data.cveJefe);}
			    }
		});
		cveEmpleado=record.data.cve;
		
	},
	
	onRenderForm:function(){
		Ext.getCmp('idAgregarEmpleado').setText('Editar Empleado');
		Ext.getCmp('apellidos-empleado').setVisible(false);
		Ext.getCmp('apellidos-empleado').setDisabled(true);
		Ext.getCmp('editar-nombre-empleado').setVisible(true);
		Ext.getCmp('editar-nombre-empleado').setDisabled(false);
		Ext.getCmp('nombre-empleado').setVisible(false);
		Ext.getCmp('nombre-empleado').setDisabled(true);
	},
	
	/**
	 * Función que escucha al evento onAgregarEmpleado, es la encargada de agregar
	 * la llamada al metodo de java para agregar al empleado al mandar el submit
	 */
	onAgregarEmpleado:function(){
		if(cveEmpleado==null){return;}
//		console.log("cveempleado "+cveEmpleado);
//		Ext.getCmp('nombre-empleado').setDisabled(true);
//		Ext.getCmp('nombre-empleado').setVisible(false);
//		console.log("uno "+Ext.getCmp('editar-nombre-empleado').getValue());
//		console.log("dos "+Ext.getCmp('area-empleado').getValue());
//		console.log("tres "+Ext.getCmp('puesto-empleado').getValue());
//		console.log("cuatro "+Ext.getCmp('email-empleado').getValue());
//		console.log("cinco "+Ext.getCmp('unidad-empleado').getValue());
//		console.log("seis "+cveEmpleado);
//		console.log("siete "+Ext.getCmp('jefe-empleado').getValue());
//		console.log("ocho "+Ext.getCmp('activoEmpleado').getValue());
		var activ=0;
		if(Ext.getCmp('activoEmpleado').getValue()==true)
			activ=1;
		else
			activ=0;
		Ext.Ajax.request({
			url:Namespace.namespace+'usuarios/editarempleado',
			params: {
				activo : activ,
				area : (Ext.getCmp('area-empleado').getValue()),
				cve : (cveEmpleado),
				email : Ext.getCmp('email-empleado').getValue(),
				jefe : Ext.getCmp('jefe-empleado').getValue(),
//				jefe : parseInt(Ext.getCmp('jefe-empleado').getValue()),
				nombreEditar : Ext.getCmp('editar-nombre-empleado').getValue(),
				puesto : (Ext.getCmp('puesto-empleado').getValue()),
				unidad : (Ext.getCmp('unidad-empleado').getValue()),
						
			},
			success: function(response){
				Ext.Msg.show({
					title: 'Empleados',
					buttons: Ext.Msg.YESNO,
					icon: Ext.Msg.INFO,
					msg: 'El empleado se ha modificado con exito, desea agregrar mas empleados',
					fn: function(btn) { 
						if (btn == 'yes') {
								var form = Ext.getCmp('agregarempleado');
								var store=null;
								
								grid = Ext.getStore('Empleados').removeAll();
								form.getForm().reset();
								store = Ext.getStore('Empleados').load();
								store.clearFilter();
								store.filter("cve", Ext.getCmp('idNombreEmpleadoBuscar').getValue());
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
				Ext.MessageBox.alert('Error', 'Ocurrio un error al modificar al empleado');
			}
		});
		cveEmpleado=null;
//		var form = Ext.getCmp('agregarempleado');
//			form.getForm().submit({
//				url:Namespace.namespace+'usuarios/editarempleado',
//				params:{cve:cveEmpleado},
//				waitTitle:'Agregando Empleado',
//	         	waitMsg: 'Guardando...',
//				success: function (form, action) {	
//					Ext.Msg.show({
//					title: 'Empleados',
//					buttons: Ext.Msg.YESNO,
//					icon: Ext.Msg.INFO,
//					msg: 'El empleado se ha modificado con exito, desea agregrar mas empleados',
//					fn: function(btn) { 
//						if (btn == 'yes') {
//								var form = Ext.getCmp('agregarempleado');
//								form.getForm().reset();
//								Ext.getStore('Empleados').load();
//							}else{
//								window.parent.location = Namespace.namespace;
//							}
//					}
//					});	
//				},
//							failure: function (form, action) {
//								if (!action || !action.result) {
//									Ext.MessageBox.alert('Error', 'Problemas en la conexion');
//									return;
//								}
//								Ext.MessageBox.alert('Error', 'Ocurrio un error al modificar al empleado');
//							}
//				});
//			cveEmpleado=null;
	},
	
	cveEmpleado:null,
	
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