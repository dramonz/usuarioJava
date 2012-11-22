/**
 * @class PR.view.usuario.ModulosGrid
 * @extends Ext.grid.Panel
 * 
 * @author Daniel Ramon
 * @version 0.9
 */
Ext.ClassManager.create('PR.view.usuario.ModulosGrid', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.modulosGrid',
//	title:'Seleccione los modulos a los cuales se puede relacionar el rol',
	store: 'Modulos',
	id: 'modulo-grid',
	width :500,
	style: {
		marginLeft : 'auto',
		marginRight: 'auto'
	},
	selModel:Ext.create('Ext.selection.CheckboxModel'),
	initComponent: function() {
		this.columns = [{
			header: 'Seleccione los módulos a los cuales se puede relacionar el rol',
			dataIndex: 'nombre',
			menuDisabled: true,
			draggable: false,
			flex:1
		}		
		];
		
		this.dockedItems = [{
			xtype: 'toolbar',
			dock: 'bottom',
			cls: 'grid-toolbar',
			items: ['->',{
				id: 'add-guardar-modulo-button',
				hidden:true,
				text: 'Guardar Modulo'
			}]
		}];
		
		this.selType = 'rowmodel';
		
		this.callParent(arguments);
	}
	
});