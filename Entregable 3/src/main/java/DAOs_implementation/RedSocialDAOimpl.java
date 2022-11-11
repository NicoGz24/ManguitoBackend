package DAOs_implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import DAO.EMF;
import DAOs_intefaces.RedSocialDAO;
import model.RedSocial;


public class RedSocialDAOimpl extends GenericDAOimpl<RedSocial> implements RedSocialDAO {
	
	private EntityManager em = EMF.getEMF().createEntityManager();
	private EntityTransaction etx = em.getTransaction();
	
	public RedSocialDAOimpl() {
		super(RedSocial.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<RedSocial> getRedesEmprendimiento(String nombre) {
		EmprendimientoDAOimpl emprendimientoDAO = new EmprendimientoDAOimpl();
		int id = emprendimientoDAO.getEmprendimiento(nombre).getId();
		List<RedSocial>lista = null;
		
		try {
			etx.begin();
			Query consulta = EMF.getEMF().createEntityManager().createQuery("select redesSociales_id_red_social from emprendimientos_redessociales  where Emprendimiento_id_emprendimiento = :id ");
			etx.commit();
			consulta.setParameter("id", id);
			List<Integer>listaId = consulta.getResultList();
			for(Integer id2 : listaId) {
				lista.add(this.recuperar(id2));
			}
		}
		catch (NoResultException e) {
			System.out.println("No hay registro en la BD de lo solicitado");
		}
		return lista;
	}
}
