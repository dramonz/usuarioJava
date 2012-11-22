/**
 * @class PR.controller.Index
 * @extends Ext.data.Controller
 * 
 * @author José Luis Landero
 * @version 1.0
 */
Ext.ClassManager.create('PR.controller.Index', {
	extend: 'Ext.app.Controller',
	stores: ['Menu'],
	requires: ['PR.util.Namespace'],
	
	/**
	 * Array destinado para contener los widgets que se añadan al modulo y poder
	 * redimensionarlos sin usar un ViewPort
	 */
	widgets: [],
	
	init: function() {
		Ext.EventManager.onWindowResize(this.onWindowResizeListener, this);
	},
	
	/**
	 * Función que escucha al evento onWindowResize, es la encargada de aplicar
	 * el redimensionado a los widgets contenidos en {widget}.
	 */
	onWindowResizeListener: function() {
		for (var i = 0, l = this.widgets.length; i < l; i++) {
			this.widgets[i].doLayout();
		}
	}
});