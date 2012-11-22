/**
 * 
 */
Ext.ClassManager.create('PR.view.usuario.AgregarUsuario', {
	extend: 'Ext.form.Panel',
	alias: 'widget.agregarusuarioform',
	id: 'agregarusuario',
	url: 'agregarusuario',
	width: '100%',
	defaults: {
		anchor: '95%',
		labelPad: 20,
		labelAlign: 'right',
		padding: '10 0 5 0',
		labelWidth: 155
	},
	
	initComponent: function() {
		this.items = [{
			xtype: 'textfield',
			id: 'nombreUsuario',
			fieldLabel: 'Nombre de Usuario<span class="required">*</span>',
			maxLength:50,
			allowBlank: false,
			name: 'nombre'
		},{
			xtype: 'fieldcontainer',
			fieldLabel: 'Modificar Contraseña<span class="required">*</span>',
			id:'idContenedorModificarContrasenia',
			hidden:true,
			disabled:true,
			items: [{
				xtype: 'checkboxfield',
				inputValue: '1',
				name: 'modificarContrasenia',
				id: 'idModificarContrasenia'
			}]
		}, {			
			xtype: 'textfield',
			id: 'idNuevaContraseniaUsuario',
			fieldLabel: 'Nueva Contraseña<span class="required">*</span>',
			inputType: 'password',
			maxLength:50,
			hidden:true,
			disabled:true,
			allowBlank: false,
			name: 'contrasenia'
		
		},{
			xtype: 'textfield',
			id: 'contraseniaUsuario',
			fieldLabel: 'Contraseña<span class="required">*</span>',
			inputType: 'password',
			maxLength:50,
			allowBlank: false,
			name: 'contrasenia'
		}, {
			xtype: 'textfield',
			id: 'contraseniaUsuarioConfirmar',
			fieldLabel: 'Confirmar Contraseña<span class="required">*</span>',
			inputType: 'password',
			maxLength:50,
			allowBlank: false,
			name: 'contrasenia2'
		}, {
			xtype: 'fieldcontainer',
			fieldLabel: 'Activo',
			items: [{
				xtype: 'checkboxfield',
				inputValue: '1',
				name: 'activo',
				id: 'activoUsuario'
			}]
		},{
    	   	xtype:'datefield',
			name: 'fechaInicio',
			fieldLabel: 'Fecha de Inicio<span class="required">*</span>',
			id:'fechaInicio',
			format:'d/M/Y',
			editable :false,
			vtype: 'daterange',
            endDateField: 'fechaVencimiento'
				
       },{
   	   	xtype:'datefield',
		name: 'fechaVencimiento',
		fieldLabel: 'Fecha de Vencimiento<span class="required">*</span>',
		id:'fechaVencimiento',
		format:'d/M/Y',
		editable :false,
		vtype: 'daterange',
		startDateField: 'fechaInicio'
			
       }, {
			xtype: 'combobox',
			id: 'idNombreEmpleado',
			fieldLabel: 'Nombre de Empleado<span class="required">*</span>',
			name: 'nombreEmpleado',
			queryMode: 'local',
			displayField: 'nombre',
			allowBlank: false,
			forceSelection:true,
			valueField: 'cve',
			 loadingText: 'Buscando...',
			 typeAhead :true,
			 emptyText :'Introduzca las primeras cinco letras del nombre',
			 hideTrigger :true,
			 enableKeyEvents:true,
			store: 'Empleados'
		}];
		
		this.dockedItems=[{
			xtype: 'toolbar',
			cls:'grid-toolbar',
			dock: 'bottom',
			items: ['->', {
				text: 'Agregar Usuario',
				id:'idAgregarUsuario',
	        	formBind:true
			}]
		}];
		
		this.callParent(arguments);
	}
});
Ext.apply(Ext.form.field.VTypes, {
    daterange: function(val, field) {
        var date = field.parseDate(val);
        if (!date) {
            return false;
        }
        if (field.startDateField && (!this.dateRangeMax || (date.getTime() != this.dateRangeMax.getTime()))) {
            var start = field.up('form').down('#' + field.startDateField);
            start.setMaxValue(date);
            start.validate();
            this.dateRangeMax = date;
        }
        else if (field.endDateField && (!this.dateRangeMin || (date.getTime() != this.dateRangeMin.getTime()))) {
            var end = field.up('form').down('#' + field.endDateField);
            end.setMinValue(date);
            end.validate();
            this.dateRangeMin = date;
        }
        return true;
    }
});