package mx.gob.tabasco.saf.siafe.presupuesto.utilerias.consultasutileria.sql.presupuesto;

import java.math.BigDecimal;
import java.util.List;

import mx.gob.tabasco.saf.siafe.presupuesto.utilerias.EjercicioUtilerias;
import mx.gob.tabasco.saf.siafe.presupuesto.utilerias.consultasutileria.sql.presupuesto.usuarios.UsuariosConsultasSQLXml;



public class UsuariosSQL {
	
	private UsuariosConsultasSQLXml usuariosConsultasSQLXml=new UsuariosConsultasSQLXml();
	
	public String getSqlCatalogoDependencia(List<Long> ids,boolean admin,Long ejercicio){
		String str_sql ="";
		if(ejercicio!=null){
			str_sql =String.format( usuariosConsultasSQLXml.catalogo_dependencia,ejercicio);
		}else{
			str_sql =String.format( usuariosConsultasSQLXml.catalogo_dependencia,EjercicioUtilerias.getEjercicioActual());
		}
		String id = "";
		if(!admin){
			if(ids !=null){
				if(ids.size()>0){
					for(Long l:ids){
						id+=l.toString()+",";
					}							
					str_sql +="  and cve_dependencia in(select cve_dependencia " +
							"from unidades where id in("+id.substring(0, (id.length()-1))+")) ";
				}else{
					str_sql +=" and cve_dependencia in" +
					"(select cve_dependencia from unidades where id is null)";
				}
			}
		}
		return str_sql;
	}

	public UsuariosSQL(){
		usuariosConsultasSQLXml = new UsuariosConsultasSQLXml();
	}
	public String getSqlConsultaUsuario(List<Long> ids,boolean admin,String empleado){
		String str_sql = usuariosConsultasSQLXml.consultas_usuarios;
		String id = "";
		if(!admin){
			if(ids !=null){
				if(ids.size()>0){
					for(Long l:ids)
						id+=l.toString()+",";			
					str_sql +=" left join unidades uni using (cve_unidad) "
				    +" where uni.id in ("+id.substring(0, (id.length()-1))+") ";
				}else{
					str_sql +=" left join unidades uni using (cve_unidad) "
					    +" where uni.id is null";
				}
				if(empleado!=null)
					if(!empleado.equalsIgnoreCase(""))
						str_sql += " and upper(nombre_completo) like upper('"+empleado+"%')" ;
			}
			if(empleado!=null)
				if(!empleado.equalsIgnoreCase(""))
					str_sql += " where upper(nombre_completo) like upper('"+empleado+"%')" ;
		}
		if(empleado!=null)
			if(!empleado.equalsIgnoreCase(""))
				str_sql += " where upper(nombre_completo) like upper('"+empleado+"%')" ;
		return str_sql;
	}
	public String getSqlListaUnidades(){
		String str_sql = usuariosConsultasSQLXml.unidades;
		return str_sql;
	}
	public String getSqlMapaPeticiones(String rol){
		String str_sql = String.format(usuariosConsultasSQLXml.consulta_mapa_peticiones, rol);
		return str_sql;
	}
	
	public String getSqlCatalogoPeticionesUrlByCve(Long cveCatPeticion){
		String str_sql = String.format(usuariosConsultasSQLXml.consulta_catalogo_peticiones, cveCatPeticion);
		return str_sql;
	}
	public String getSqlConsultaTreePermisos(){
		String str_sql = usuariosConsultasSQLXml.consulta_tree_permisos;
		return str_sql;
	}
	public String getSqlConsultaCatalogoPeticionesCvePadre(BigDecimal object){
		
		String str_sql = String.format(usuariosConsultasSQLXml.consulta_tree_permisos);
		str_sql = str_sql+" and cve_padre="+object;
		return str_sql;
	}
	public String getSqlConsultaTreeByCveUsuario(Long cveUsuario){
		
		String str_sql = String.format(usuariosConsultasSQLXml.consulta_tree_by_cve_usuario,cveUsuario,cveUsuario);
		return str_sql;
	}

	/**
 *Filtra por cveUsuario adquiriendo las unidades asignadas al usuario 
 	* @param
 	***/
	public String getConsultaUnidadesPerteneceCveUsuario(Long cveUsuario, String idUnidad, String idDependencia,List<Long> ids,boolean admin,Long ejercicio){
		if(ejercicio==null){
			ejercicio = EjercicioUtilerias.getEjercicioActual();
		}
		String str_sql = String.format(usuariosConsultasSQLXml.consulta_unidades_pertenece_cveUsuario,ejercicio,cveUsuario);
		if(idUnidad!=""){str_sql = str_sql + " and id_unidad = "+idUnidad+" ";}
		if(idDependencia!=""){str_sql = str_sql + " and d.id = "+idDependencia+" ";}
		
		String id = "";
		if(!admin){
			if(ids !=null){
				if(ids.size()>0){
					for(Long l:ids){
						id+=l.toString()+",";
					}							
					str_sql +=" and id_unidad in ("+id.substring(0, (id.length()-1))+") ";
				}else{
					str_sql +=" and id_unidad is null ";
				}
			}
		}	
		str_sql = str_sql + " order by nombre_unidad ";
		return str_sql;
	}
	
	/**
	 *Filtra por cveUsuario omitiendo las unidades que se le han asignado al usuario
	 * @param idDependencia 
	 * @param idUnidad 
	 *@param 
	 **/
	public String getConsultaUnidadesCveUsuario(Long cveUsuario, String idUnidad, String idDependencia,List<Long> ids,boolean admin,Long ejercicio){
		if(ejercicio==null){
			ejercicio=EjercicioUtilerias.getEjercicioActual();
		}
		String str_sql = String.format(usuariosConsultasSQLXml.consulta_unidades_cveUsuario,ejercicio,cveUsuario);
		
		if(idUnidad!=""){str_sql = str_sql + " and id_unidad = "+idUnidad+" ";}
		if(idDependencia!=""){str_sql = str_sql + " and d.id = "+idDependencia+" ";}		
		String id = "";
		if(!admin){
			if(ids !=null){
				if(ids.size()>0){
					for(Long l:ids){
						id+=l.toString()+",";
					}							
					str_sql +=" and id_unidad in ("+id.substring(0, (id.length()-1))+") ";
				}else{
					str_sql +=" and id_unidad is null ";
				}
			}
		}		
		str_sql = str_sql + " order by nombre_unidad ";
		
		return str_sql;
	}
	/**
	 *Filtra por cveUsuario adquiriendo los proyectos  asignados al usuario
	 *@param 
	 **/
	public String getConsultaProyectoPerteneceCveUsuario(Long cveUsuario,String ejercicio,String proyecto,String oficioSolicitud,String estatus,String idUnidad,String idDependencia,List<Long> ids,boolean admin,List<Long> idsProyecto){
		String str_sql = String.format(usuariosConsultasSQLXml.consulta_proyecto_pertenece_cveUsuario,cveUsuario);
		if(ejercicio!=""){str_sql=str_sql+" AND PROYECTOS.EJERCICIO ="+ejercicio+" ";}
		if(proyecto!=""){ str_sql=str_sql+" AND (upper(nombre_proyecto) like upper('%"+proyecto+"%') or upper(num_proyecto) like upper('%"+proyecto+"%')) ";}
		if(oficioSolicitud!=""){str_sql=str_sql+" AND upper(oficio_solicitud) like upper('%"+oficioSolicitud+"%') ";}
		if(estatus!=""){ str_sql=str_sql+" AND estatus_proyecto like '%"+estatus+"%' ";}
		if(idUnidad!=""){str_sql=str_sql+" and id_unidad ="+idUnidad+" ";}
		if(idDependencia!=""){ str_sql=str_sql+" and dependencias.id= "+idDependencia+" ";}
		String id = "";
		if(!admin){
			if(ids !=null){
				if(ids.size()>0){
					for(Long l:ids){
						id+=l.toString()+",";
					}							
					str_sql +=" and id_unidad in ("+id.substring(0, (id.length()-1))+") ";
				}else{
					str_sql +=" and id_unidad is null ";
				}
			}
			id = "";
			if(idsProyecto!=null){
				if(idsProyecto.size()>0){
					for(Long l:idsProyecto){
						id+=l.toString()+",";
					}							
					str_sql +=" and proyectos.id not in ("+id.substring(0, (id.length()-1))+") ";
				}
			}
		}	
		
		return str_sql;
	}
	
	/**
	 *Filtra por cveUsuario omitiendo proyectos para asignar al usuario excluyendo los que ya les fueron asignados
	 *@param 
	 **/
	public String getConsultaProyectoCveUsuario(Long cveUsuario,String ejercicio,String proyecto,String oficioSolicitud,String estatus,String idUnidad,String idDependencia,List<Long> ids,boolean admin,List<Long> idsProyecto){
		String str_sql = String.format(usuariosConsultasSQLXml.consulta_proyecto_cveUsuario, cveUsuario);
		if(ejercicio!=""){str_sql=str_sql+" AND PROYECTOS.EJERCICIO ="+ejercicio+" ";}
		if(proyecto!=""){ str_sql=str_sql+" AND (upper(nombre_proyecto) like upper('%"+proyecto+"%') or upper(num_proyecto) like upper('%"+proyecto+"%')) ";}
		if(oficioSolicitud!=""){str_sql=str_sql+" AND upper(oficio_solicitud) like upper('%"+oficioSolicitud+"%') ";}
		if(estatus!=""){ str_sql=str_sql+" AND estatus_proyecto like '%"+estatus+"%' ";}
		if(idUnidad!=""){str_sql=str_sql+" and id_unidad ="+idUnidad+" ";}
		if(idDependencia!=""){ str_sql=str_sql+" and dependencias.id= "+idDependencia+" ";}
		String id = "";
		if(!admin){
			if(ids !=null){
				if(ids.size()>0){
					for(Long l:ids){
						id+=l.toString()+",";
					}							
					str_sql +=" and id_unidad in ("+id.substring(0, (id.length()-1))+") ";
				}else{
					str_sql +=" and id_unidad is null ";
				}
			}
			id = "";
			if(idsProyecto!=null){
				if(idsProyecto.size()>0){
					for(Long l:idsProyecto){
						id+=l.toString()+",";
					}							
					str_sql +=" and proyectos.id not in ("+id.substring(0, (id.length()-1))+") ";
				}
			}
		}	
		return str_sql;
	}
	
}
