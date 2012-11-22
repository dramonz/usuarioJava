/**
 * @class PR.store.Menu
 * @extends Ext.data.TreeStore
 * 
 * @author José Luis Landero
 * @version 1.0
 */
Ext.ClassManager.create('PR.store.Menu', {
	extend: 'Ext.data.TreeStore',
//	root: {
//		expanded: true,
//		children: []
//	}
	
	root: {
		expanded: true,
		children: [{
			text: 'Configuración de los Sistemas',
			cls: 'proyectos-tree-icon',
			expanded: true,
			children: [{
				text: 'Registrar Empleado',
				href: Namespace.namespace + 'usuarios/agregarempleado', //preguntar
				hrefTarget: 'content-frame',
				leaf: true
			},{
				text: 'Editar Empleado',
				href: Namespace.namespace + 'usuarios/editarempleado',
				hrefTarget: 'content-frame',
				leaf: true
			}, {
				text: 'Agregar Rol',
				href: Namespace.namespace + 'usuarios/agregarrol',
				hrefTarget: 'content-frame',
				leaf: true
			}, {
				text: 'Editar Rol',
				href: Namespace.namespace + 'usuarios/editarrol',
				hrefTarget: 'content-frame',
				leaf: true
			},{
				text: 'Permisos Roles',
				href: Namespace.namespace + 'roles/asignar-rol',
				hrefTarget: 'content-frame',
				leaf: true
			},{
				text: 'Agregar Usuario',
				href: Namespace.namespace + 'usuarios/agregarusuario',
				hrefTarget: 'content-frame',
				leaf: true
			},{
				text: 'Editar Usuario',
				href: Namespace.namespace + 'usuarios/editarusuario',
				hrefTarget: 'content-frame',
				leaf: true
			},{
				text: 'Asignar Rol al Usuario',
				href: Namespace.namespace + 'asignarRolUsuario',
				hrefTarget: 'content-frame',
				leaf: true
			},{
				text: 'Agregar Unidades',
				href: Namespace.namespace + 'usuarios/agregarunidad',
				hrefTarget: 'content-frame',
				leaf: true
			},{
				text: 'Editar Unidades',
				href: Namespace.namespace + 'usuarios/editarunidad',
				hrefTarget: 'content-frame',
				leaf: true
			},{
				text: 'Agregar Proyectos',
				href: Namespace.namespace + 'usuarios/agregarProyecto',
				hrefTarget: 'content-frame',
				leaf: true
			},{
				text: 'Editar Proyectos',
				href: Namespace.namespace + 'usuarios/editarProyecto',
				hrefTarget: 'content-frame',
				leaf: true			
			},{
				text: 'Buscar Usuarios',
				href: Namespace.namespace + 'usuarios/busquedaUsuario',
				hrefTarget: 'content-frame',
				leaf: true
			}]		
		}]
	}
});