/**
 * @class PR.view.usuario.DetalleForm
 * @extends Ext.form.Panel
 * 
 * Form de detalles del Usuario
 * 
 * @author Daniel Ramon Zapata
 * @version 0.1 2011-09-20
 */
Ext.define('PR.view.usuario.DetalleForm', {
	extend: 'Ext.form.Panel',
	alias: 'widget.detalleform',
	id:'idDetalleForm',
	url: 'usuarioDetalle',
	width: '700px',
	style: {
		marginLeft: 'auto',
		marginRight: 'auto'
	},
	bodyPadding: '10 10 0 0',
	
		
	fieldDefaults: {
		msgTarget: 'side',
		labelWidth: 150,
		labelPad: 20,
		labelAlign: 'right',
		padding: '0 0 5 0'
	},
	
	initComponent: function() {
		this.items = [{
			xtype: 'textfield',
			id:'idNombre',
			fieldLabel: 'Nombre',
			name: 'nombre',
			readOnly :true,
			width:500
		}, {
			xtype: 'textfield',
			id:'idArea',
			fieldLabel: 'Area',
			name: 'area',
			readOnly :true,
			width:500
		
		},{
			xtype: 'textfield',
			id:'idUnidad',
			fieldLabel: 'Unidad Administrativa',
			name: 'unidad',
			readOnly :true,
			width:500
		
		} ,{
			xtype: 'textfield',
			id:'idCorreo',
			fieldLabel: 'Correo Electrónico',
			name: 'correo',
			readOnly :true,
			width:500
		
		},{
			xtype: 'textfield',
			id:'idDependencia',
			fieldLabel: 'Dependencia',
			name: 'dependencia',
			readOnly :true,
			width:500
		
		},{
			xtype: 'textfield',
			id:'idPuesto',
			fieldLabel: 'Puesto',
			name: 'puesto',
			readOnly :true,
			width:500
		
		},{
			xtype: 'textfield',
			id:'idRol',
			fieldLabel: 'Rol',
			name: 'rol',
			readOnly :true,
			width:500
		
		},{
			xtype: 'textfield',
			id:'idUsername',
			fieldLabel: 'Nombre de Usuario',
			name: 'username',
			readOnly :true,
			width:500
		
		}, {
			xtype:'displayfield',
			labelWidth: 300,
			fieldLabel:'<a href="'+Namespace.namespace + 'usuarios/cambiarcontrasenia">Cambiar Contraseña</a> ',
			labelAlign: 'right',
			labelSeparator:"",
			margin:'0 0 0 -15'
			}
			];
		this.callParent(arguments);
	}
});