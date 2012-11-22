Ext.define('PR.view.usuario.UsuarioEditarUnidadGrid', {
	extend:'Ext.grid.Panel',
	alias:'widget.usuarioUnidadGrid',
	store:'UsuariosUnidadesPerteneceGrid',
	id:'idUsuarioUnidadGrid',
	selType: 'rowmodel',
	title:Messages.titles.unidades,
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
          		text: Messages.columns.dependencia,
          		flex: 2,
          		dataIdenx:'dependencia',
          		menuDisabled:true,
          		draggable:false,
          		renderer:function(value,metaData,record  ){
          			return record.data.dependencia;
          		}
          	}
            ];
		 this.dockedItems= [{
				xtype: 'toolbar',
				dock: 'bottom',
				items: [{
					id:'id-Eliminar-Unidades',
	        		text: Messages.btn.eliminarUnidadesUsuarios,
					icon: Namespace.namespace+Namespace.icons.eliminar,
					handler: function() {}
				}]
			}];
		this.callParent(arguments);
	}
});