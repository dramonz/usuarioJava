package mx.gob.tabasco.saf.siafe.presupuesto.dao.imp;

import java.util.List;

import mx.gob.tabasco.saf.siafe.mapeo.modelo.CatalogosPeticiones;
import mx.gob.tabasco.saf.siafe.presupuesto.dao.ICatalogoPeticionDAO;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CatalogoPeticioDAO extends BaseHibernateDAO<CatalogosPeticiones>
		implements ICatalogoPeticionDAO {

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<CatalogosPeticiones> getUrlsPadres() {
//		List<Modulos> listaModulos = new ArrayList<Modulos>();
		DetachedCriteria criteria = DetachedCriteria
				.forClass(CatalogosPeticiones.class)
				.add(Restrictions.isNull("catalogosPeticiones.cve"))
				.add(Restrictions.eq("activo", 1))
				.addOrder(Order.asc("modulos"));

//		CustomUserDetails user = (CustomUserDetails) SecurityContextHolder
//				.getContext().getAuthentication();
//		Usuarios usuario = (Usuarios) user.getDetails();
//		for (Roles roles : usuario.getRoles()) {
//			if (roles.getRolesModuloses() != null) {
//				for (RolesModulos rolModulo : roles.getRolesModuloses()) {
//					listaModulos.add(rolModulo.getModulos());
//				}
//			}
//		}
//		if (listaModulos.size() > 0) {
//			criteria.add(Property.forName("modulos").in(listaModulos));
//		}
		return this.getHibernateTemplate().findByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CatalogosPeticiones> findCatalogoPeticionByUrl(String url) {
		log.debug("findRolByUrl instance with url: " + url);
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(
					CatalogosPeticiones.class).add(Restrictions.eq("url", url));

			// @SuppressWarnings("unchecked")
			// CatalogosPeticiones catalogo = DataAccessUtils.uniqueResult(this
			// .getHibernateTemplate().findByCriteria(criteria));
			return this.getHibernateTemplate().findByCriteria(criteria);

		} catch (RuntimeException re) {
			log.error("failed findRolByUrl instance with url: " + url, re);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CatalogosPeticiones> findByUrl(List<String> url)
			throws DataAccessException {
		DetachedCriteria criteria = DetachedCriteria.forClass(CatalogosPeticiones.class)
				.setResultTransformer(DetachedCriteria.DISTINCT_ROOT_ENTITY)
				.add(Restrictions.in("url", url));
		
		return this.getHibernateTemplate().findByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CatalogosPeticiones> getUrlsPadresByPermisosRol(
			List<Long> modulos) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(CatalogosPeticiones.class)
				.setResultTransformer(DetachedCriteria.DISTINCT_ROOT_ENTITY)
				.add(Restrictions.isNull("catalogosPeticiones.cve"))
				.add(Restrictions.eq("activo", 1))
				.add(Restrictions.in("modulos.cve", modulos))
				.addOrder(Order.asc("modulos"));
		
		return this.getHibernateTemplate().findByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CatalogosPeticiones> findByCve(Long[] claves) {
		DetachedCriteria criteria = DetachedCriteria.forClass(CatalogosPeticiones.class)
				.add(Restrictions.in("cve", claves));
		
		return this.getHibernateTemplate().findByCriteria(criteria);
	}
	
}
