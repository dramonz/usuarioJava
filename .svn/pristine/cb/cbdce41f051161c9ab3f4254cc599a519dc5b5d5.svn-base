Ext.define('PR.view.usuario.UsuarioProyectoGrid', {
	extend:'Ext.grid.Panel',
	alias:'widget.usuarioProyectoGrid',
	store:'UsuariosProyectosGrid',
	id:'idUsuarioProyectoGrid',
	selType: 'rowmodel',
	title:Messages.titles.proyectos,
	height :450,
	selModel:Ext.create('Ext.selection.CheckboxModel'),
	initComponent: function() {
		this.columns=[
            {
            	text: Messages.columns.proyecto,
                flex:1,
                dataIndex:'numProyecto',
                menuDisabled:true,
                draggable:false
          	},{
            	text: Messages.columns.dependencia,
                flex:2,
                dataIndex:'nombreDependencia',
                menuDisabled:true,
                draggable:false
          	},{
            	text: Messages.columns.nombreUnidad,
                flex:2,
                dataIndex:'nombreUnidad',
                menuDisabled:true,
                draggable:false          	
          	},{
            	text:  Messages.columns.oficioSolicitud,
                flex:1,
                dataIndex:'oficioSolicitud',
                menuDisabled:true,
                draggable:false  
          	},{
            	text: Messages.columns.estatus,
                flex:1,
                dataIndex:'estatus',
                menuDisabled:true,
                draggable:false,
                renderer:function(value){
                	switch(value){
                		case 1:return Messages.combos.elaborado; break;
                		case 2:return Messages.combos.revisado ;break;
                		case 3:return Messages.combos.solicitado; break;
                		case 4:return Messages.combos.preaprobado; break;
                		case 5:return Messages.combos.aprobado;break;
                		case 6:return Messages.combos.rechazado;break;
                	       	}
                }
          	}
            ];
		 this.dockedItems= [{
				xtype: 'toolbar',
				dock: 'bottom',
				items: [{
					id:'id-Agregar-Proyectos',
	        		text: Messages.btn.agregarProyectoUsuario,
					icon: Namespace.namespace+Namespace.icons.agregar,
					handler: function() {}
				}]
			}];
		this.callParent(arguments);
	}
});