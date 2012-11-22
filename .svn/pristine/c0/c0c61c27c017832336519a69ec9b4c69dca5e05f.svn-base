Ext.define('PR.view.usuario.AgregarFormUnidad', {
	extend: 'Ext.form.Panel',
	alias: 'widget.agregarFormUnidad',
	id:'idAgregarFormUnidad',
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
		this.items = [
		 {
			xtype: 'combobox',
			id: 'id-usuario',
			fieldLabel: Messages.labels.usuario,
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
			id: 'id-ejercicio',
			fieldLabel: Messages.labels.ejercicio,
			name: 'ejercicio',
			queryMode: 'local',
			displayField: 'ejercicio',
			valueField: 'id',
			forceSelection:true,
			allowBlank: false,	
			store: 'Ejercicios'
		
		},
		{
			xtype: 'combobox',
			id: 'id-dependencia-combo',
			fieldLabel: Messages.labels.dependencia,
			name: 'nombre',
			queryMode: 'local',
			displayField: 'nombre',
			valueField: 'id',
			forceSelection:true,
			store: 'DependenciasComboUsuarios'
		},
		{
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