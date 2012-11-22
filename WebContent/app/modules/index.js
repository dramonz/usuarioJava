/**
 * Aplicación del index de la aplicación, encargada de crear el viewport, el 
 * arból de navegación y  la distribución visual de la aplicación.
 */
Ext.application({
	name: 'PR',
	folder: 'app',
	controllers: ['Index'],
	
	launch: function() {
		var container = Ext.create('Ext.container.Container', {
			renderTo: Ext.getBody(),
			layout: 'fit',
			width: '100%',
			height: '100%',
			border: 0,
			items: [{
				xtype: 'panel',
				layout: 'border',
				border: 0,
				items: [{
					html: '<iframe src="' + Namespace.namespace + 'header" class="section-frame" frameBorder="0"></iframe>',
					region: 'north',
					height: 107,
					border: 0
				}, {
					xtype: 'treepanel',
					title: 'Usuario',
					id: 'menu-tree',
					collapsible: true,
					width: 220,
					border: 0,
					region: 'west',
					cls: 'menu-tree',
					rootVisible: false,
					store: 'Menu',
					collapsedCls: 'menu-collapsed',
					listeners: {
						render: function() {
							document.getElementById('presupuesto-loading').style.display = 'none';
						}
					}
				}, {
					xtype: 'panel',
					border: 0,
					region: 'center',
					html: '<iframe id="content-frame" name="content-frame" class="section-frame" frameBorder="0"></iframe>'
				}, {
					html: '<iframe src="' + Namespace.namespace + 'footer" class="section-frame" frameBorder="0"></iframe>',
					region: 'south',
					height: 26,
					border: 0
				}]
			}]
		});
		
		this.getController('Index').widgets.push(container);
	}
});