/**
  * @author Daniel Ramon Zapata
 * @version 2011-10-07
 */
Ext.application({
	name: 'PR',
	appFolder: '../app',
	controllers: ['EditarRoles'],
	
	launch: function() {
		var form = Ext.ClassManager.instantiate('PR.view.usuario.AgregarRol', {
			renderTo: 'form-agregar-rol'
		});
		
		var grid = Ext.ClassManager.instantiate('PR.view.usuario.RolGrid', {
			renderTo: 'grid-editar-rol'
		});
		
		var gridModulo = Ext.ClassManager.instantiate('PR.view.usuario.ModulosGrid',{
			renderTo:'form-grid-modulo',
			hidden:true
		});
		
		this.getController('EditarRoles').widgets.push(form);
		this.getController('EditarRoles').widgets.push(gridModulo);
		this.getController('EditarRoles').widgets.push(grid);
	}
});