/**
 * @class PR.util.Namespace
 * 
 * Auxiliar para definir el namespace en las rutas de stores.
 * 
 * @version 1.0
 */
Ext.ClassManager.create('PR.util.Namespace', {
	singleton: true,
	alternateClassName: ['Namespace'],
	namespace: '/usuarios/',
	icons:{
		actualizar:'resources/images/icon_actualizar.gif',
		buscar:'resources/images/icon_lupa.gif',
		limpiar:'resources/images/icon_limpiar.gif',
		exportar:'resources/images/icon_exportar.gif',
		imprimir:'resources/images/icon_printer.gif',
		rechazar:'resources/images/icon_rechazar.gif',
		aceptar:'resources/images/icon_aceptar.gif',
		agregar:'resources/images/add.gif',
		eliminar:'resources/images/delete.png',
		pdf:'resources/images/icon_pdf.gif',
		excel:'resources/images/icon_excel.gif' ,
		editar:'resources/images/icon_edit.gif',
		mover:'resources/images/mover.gif',
		descargar:'resources/images/descargar.gif',
		regresar:'resources/images/icon_return.gif',
		enviar:'resources/images/icon_enviar.gif'
	}
});