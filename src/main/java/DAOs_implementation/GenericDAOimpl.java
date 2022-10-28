package DAOs_implementation;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import DAO.EMF;
import DAOs_intefaces.GenericDAO;


public class GenericDAOimpl<T> implements GenericDAO<T>{
	
	private EntityManager em = EMF.getEMF().createEntityManager();
	private EntityTransaction etx = em.getTransaction();
		
	protected Class<T> persistentClass;
	
	public Class<T> getPersistentClass(){
		return this.persistentClass;
	}
	public GenericDAOimpl(Class<T> clase) {
		persistentClass = clase;
	}

	public EntityManager getEntityManager() {
		return this.em;
	}
	
	@Override
	public T actualizar(T entity) {
		etx.begin();
		this.getEntityManager().merge(entity);
		etx.commit();
		return entity;
	}

	@Override
	public void borrar(T entity) {
		etx.begin();
		this.getEntityManager().remove(entity);
		etx.commit();
		
	}

	@Override
	public T borrar(Serializable id) {
		etx.begin();
		T entity = this.getEntityManager().find(this.getPersistentClass(), id);
		etx.commit();
		if(entity != null) {
			this.borrar(entity);
		}
		return entity;
	}

	@Override
	public boolean existe(Serializable id) {
		T resul = this.recuperar(id);
		return (resul != null);
	}

	@Override
	public T persistir(T entity) {
		etx.begin();
		this.getEntityManager().persist(entity);
		etx.commit();
		return entity;
	}

	@Override
	public T recuperar(Serializable id) {
		T resul =null;
		try {
			etx.begin();
			Query consulta = EMF.getEMF().createEntityManager().createQuery("select e from "+getPersistentClass().getSimpleName() + " e where id = :id ");
			consulta.setParameter("id", id);
			etx.commit();
			resul = (T) consulta.getSingleResult();
		}
		catch (NoResultException e) {
			System.out.println("No hay registro en la BD de lo solicitado");
		}
		catch (NonUniqueResultException e) {
			System.out.println("Se han encontrado mas de un resultado de los solicitado, en la BD");
		}
		return resul;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> recuperarTodos(String column) {
		Query consulta = EMF.getEMF().createEntityManager().createQuery("select e from "+ getPersistentClass().getSimpleName()+"e order by e." +column);
				List<T> resultado = (List<T>)consulta.getResultList();
				return resultado;
	}

}
