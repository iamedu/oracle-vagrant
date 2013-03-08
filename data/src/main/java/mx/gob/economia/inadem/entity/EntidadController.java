package mx.gob.economia.inadem.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public final class EntidadController {

	private static final String PERSISTENCE_UNIT_NAME = "fpymeinadempu";

	public static EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory(
				EntidadController.PERSISTENCE_UNIT_NAME).createEntityManager();
	}

	public static synchronized ResultadoTransaccion saveEntidad(Entidad entidad) {
		EntityManager em = EntidadController.getEntityManager();
		try {

			em.getTransaction().begin();
			if (entidad.getId() == null) {
				entidad.setActivo(true);
				entidad.setFechaRegistro(Calendar.getInstance().getTime());
				em.persist(entidad);
			} else {
				entidad.setFechaModificacion(Calendar.getInstance().getTime());
				em.merge(entidad);
			}
			em.getTransaction().commit();

		} catch (Exception exception) {
			exception.printStackTrace();
			return ResultadoTransaccion.FALLO;
		} finally {
			em.close();
		}

		return ResultadoTransaccion.OK;
	}

	public static synchronized ResultadoTransaccion deleteEntidad(
			Entidad entidad) {
		EntityManager em = EntidadController.getEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(em.getReference(entidad.getClass(), entidad.getId()));
			em.getTransaction().commit();
		} catch (Exception exception) {
			exception.printStackTrace();
			return ResultadoTransaccion.FALLO;
		} finally {
			em.close();
		}
		return ResultadoTransaccion.OK;
	}

	@SuppressWarnings("unchecked")
	public static synchronized <T extends Entidad> T refreshEntidad(T entidad) {
		EntityManager em = getEntityManager();
		try {
			entidad = (T) em.find(entidad.getClass(), entidad.getId());
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			em.close();
		}
		return entidad;
	}

	public static synchronized <T extends Entidad> List<T> listEntidades(
			Class<T> entityType) {
		EntityManager em = getEntityManager();
		try {
			return em.createQuery(
					"select a from " + entityType.getSimpleName()
							+ " a order by a.id asc ",
					entityType).getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			em.close();
		}
		return null;
	}

	public static synchronized Object findAnyEntidad(
			Class<?> entityType, Object id) {
		EntityManager em = getEntityManager();
		try {
			return em.find(entityType, id);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			em.close();
		}
		return null;
	}

}
