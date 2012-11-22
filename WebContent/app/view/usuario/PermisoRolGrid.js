/**
  * @author Daniel Ramon Zapata
 * @version 2011-10-14
 */
Ext.define('PR.view.usuario.PermisoRolGrid', {
	extend:'Ext.grid.Panel',
	alias:'widget.PermisoRolGrid',
	
	initComponent: function() {
		Ext.apply(this, {
			title:'Roles',
			store:'MapasPeticiones',
			id:'idPermisoRolGrid',
			selType: 'rowmodel',
			autoScroll: true,
			columns: [{
                text:'Rol',
                flex:1,
                dataIndex:'rol',
                menuDisabled:true,
                draggable:false,
                renderer:function(value){return rol;}
			}, {
				text:'Descripción Permiso',
				flex:1,
				dataIndex:'descripcion',
				menuDisabled:true,
				draggable:false
			},{
				header: 'Acciones',
				menuDisabled: true,
				draggable: false,
				sortable: false,
				xtype: 'actioncolumn',
				id:'idEliminar',
				width: 70,
	    		items: [{
	    			tooltip: 'Eliminar',
	    			iconCls: 'delete-antecedente-button',
	    			icon: Namespace.namespace+'resources/images/delete.png'
	    		}]
			}] 
		});
		
		this.callParent(arguments);
	}
});