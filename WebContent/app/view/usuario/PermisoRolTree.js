/**
  * @author Daniel Ramon Zapata
 * @version 2011-10-14
 */
Ext.define('PR.view.usuario.PermisoRolTree', {
	extend:'Ext.tree.Panel',
	alias:'widget.PermisoRolTree',
	title:'Roles',
	store: 'RolesTree',
	collapsible: true,
	cls: 'menu-tree',
    rootVisible: false,
    useArrows: true,
    width: 200,
    height: 450,
	autoScroll:true, 
	collapsedCls: 'menu-collapsed',
	 autoWidth: true,
	 border: 0,
  id:'idPermisoRolGrid',
	buttons : [{
			text: 'Guardar',
			id:'idGuardar',
			formBind: true,
			handler: function() {
				
			}
		}]
});