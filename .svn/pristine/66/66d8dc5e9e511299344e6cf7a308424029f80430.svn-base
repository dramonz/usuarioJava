Ext.define('PR.view.usuario.AgregarFormProyecto', {
	extend: 'Ext.form.Panel',
	alias: 'widget.agregarFormProyecto',
	id:'idAgregarFormProyecto',
	url: '',
	width: '40%',
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
		anchor:'100%'
	},
	
	initComponent: function() {
		this.items = [{
			xtype: 'combobox',
			id: 'id-usuario',
			fieldLabel: 'Usuario',
			name: 'usuario',
			queryMode: 'local',
			displayField: 'nombreUsuario',
			valueField: 'cve',
			forceSelection:true,
			allowBlank: false,	
			loadingText: 'Buscando...',
			 typeAhead :true,
			 emptyText :'Introduzca las primeras cinco letras del usuario',
			 hideTrigger :true,
			 enableKeyEvents:true,
			store: 'EditarUsuariosGrid'
		
		},{
			xtype: 'combobox',
			id: 'idEjercicio',
			fieldLabel: 'Ejercicio',
			name: 'ejercicio',
			queryMode: 'local',
			displayField: 'ejercicio',
			valueField: 'id',
			forceSelection:true,
			allowBlank: false,	
			store: 'Ejercicios'
		
		},{
			xtype: 'textfield',
			id:'idProyecto',
			fieldLabel: 'Proyecto',
			name: 'proyecto',
			enableKeyEvents:true,
			maxLength : 350,
			maxLengthText:'Excede el número máximo de caracteres permitidos',
			flex:1
		},{

			xtype: 'textfield',
			id:'idOficioSolicitud',
			fieldLabel: 'Oficio de Solicitud',
			name: 'oficioSolicitud',
			maxLength : 50,
			maxLengthText:'Excede el numero maximo de caracteres permitidos',
			enableKeyEvents:true,
			flex:1
		
		},{
			xtype: 'combobox',
			id:'idEstatus',
			fieldLabel: 'Estatus',
			queryMode: 'local',
			name: 'cveEstatus',
			store: Ext.create('Ext.data.Store', {fields: ['id','value'],
													data : [
													{"id":1, "value":"Elaborado"},
													{"id":2, "value":"Revisado"},
													{"id":3, "value":"Solicitado"},
        											{"id":4, "value":"Pre-Aprobado"},
        											{"id":6, "value":"Rechazado"},
        											{"id":5, "value":"Aprobado"}
        											]}),
			displayField: 'value',
			maxLength : 12,
			maxLengthText:'Excede el número máximo de caracteres permitidos',
			valueField: 'id',
			forceSelection:true,
			enableKeyEvents:true,
			msgTarget: 'side',
			anchor:'80%',
			padding: 0		
		},{
			xtype: 'combobox',
			id: 'id-dependencia-combo',
			fieldLabel: 'Dependencias',
			name: 'nombre',
			queryMode: 'local',
			displayField: 'nombre',
			valueField: 'id',
			forceSelection:true,
			store: 'DependenciasComboUsuarios'
		},{
			xtype: 'combobox',
			id: 'id-unidades-combo',
			fieldLabel: 'Unidades',
			name: 'unidades',
			queryMode: 'local',
			displayField: 'nombre',
			valueField: 'id',
			forceSelection:true,
			store: 'UnidadesComboUsuarios'
		}];	
		this.dockedItems=[{
			xtype: 'toolbar',
			dock: 'bottom',
			
			items: ['->', {
				text: 'Buscar',
				id:'btbuscar',
	        	action: 'idbuscar',
	        	formBind:true,
				style: {
					border: '1px solid #CCCCCC',
					padding: '5px'
				},
				icon: Namespace.namespace + Namespace.icons.buscar
			}, ' ', '-',  ' ', {
				text: 'Limpiar',
				id:'btlimpiar',
	        	action: 'idlimpiar',
				style: {
					border: '1px solid #CCCCCC',
					padding: '5px'
				},
				icon: Namespace.namespace + Namespace.icons.limpiar,
				handler: function () {   	}
			}]
		}];
		this.callParent(arguments);
	}
});