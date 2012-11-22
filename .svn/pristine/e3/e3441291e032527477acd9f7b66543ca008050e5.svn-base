package mx.gob.tabasco.saf.siafe.presupuesto.servicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import mx.gob.tabasco.saf.siafe.mapeo.modelo.Ejercicios;
import mx.gob.tabasco.saf.siafe.presupuesto.dao.IEjercicioDAO;
import mx.gob.tabasco.saf.siafe.presupuesto.utilerias.EjercicioUtilerias;

import org.springframework.stereotype.Service;

@Service
public class EjercicioServicio implements IBaseService<Ejercicios, Long>{

	@Resource
	private IEjercicioDAO dao;
	
	public List<HashMap<String,Long>> listEjercicioActualSiguietne(){
		try {
			List<HashMap<String,Long>> list = new ArrayList<HashMap<String,Long>>();
				HashMap<String,Long> hash = new HashMap<String, Long>();
				hash.put("id", EjercicioUtilerias.getEjercicioActual());
				hash.put("ejercicio", EjercicioUtilerias.getEjercicioActual());
				list.add(hash);
				Long next = EjercicioUtilerias.getEjercicioSiguiente();
				HashMap<String,Long> map = new HashMap<String, Long>();
				map.put("id", next);
				map.put("ejercicio", next);
				list.add(map);
			return list;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	
	@Override
	public Ejercicios getActiveById(Class<Ejercicios> entity, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Ejercicios entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteHistorico(Ejercicios entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Ejercicios> listAll(Class<Ejercicios> entity) {
		// TODO Auto-generated method stub
		return this.dao.listAll(entity);
	}

	@Override
	public List<Ejercicios> listAll(Class<Ejercicios> entity, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ejercicios> listByPage(Class<Ejercicios> entity, int from,
			int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ejercicios getByCve(Class<Ejercicios> entity, Long cve) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Ejercicios entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertHistorico(Ejercicios entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Ejercicios entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateHistorico(Ejercicios entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long countActiveRecords(Class<Ejercicios> entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long findNextCve() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long findNextId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getCveUsuario() {
		// TODO Auto-generated method stub
		return null;
	}

}
