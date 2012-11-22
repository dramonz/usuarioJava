Ext.define('PR.view.usuario.UsuarioUnidadGrid', {
	extend:'Ext.grid.Panel',
	alias:'widget.usuarioUnidadGrid',
	store:'UsuariosUnidadesGrid',
	id:'idUsuarioUnidadGrid',
	selType: 'rowmodel',
	title:'Unidades',
	height :450,
	selModel:Ext.create('Ext.selection.CheckboxModel'),
	initComponent: function() {
		this.columns=[
            {
            	text: Messages.columns.nombre,
                flex:2,
                dataIndex:'nombre',
                menuDisabled:true,
                draggable:false
          	},{
            	text: Messages.columns.codigoUnidad,
                flex:1,
                dataIndex:'codigoUnidad',
                menuDisabled:true,
                draggable:false
          	},{
            	text: Messages.columns.codigoGrupo,
                flex:1,
                dataIndex:'codigoGrupo',
                menuDisabled:true,
                draggable:false
          	},{
          		header: 'Dependencia',
          		flex: 2,
          		dataIdenx:'dependencia',
          		menuDisabled:true,
          		draggable:false,
          		renderer:function(value,metaData,record){
          			return record.data.dependencia;
          		}
          	}
            ];
		 this.dockedItems= [{
				xtype: 'toolbar',
				dock: 'bottom',
				items: [{
					id:'id-Agregar-Unidades',
	        		text: Messages.btn.agregarUnidadesUsuarios,
					icon: Namespace.namespace+Namespace.icons.agregar,
					handler: function() {}
				}]
			}];
		this.callParent(arguments);
	}
});