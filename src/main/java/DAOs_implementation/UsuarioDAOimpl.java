package DAOs_implementation;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import DAO.EMF;
import DAOs_intefaces.UsuarioDAO;
import model.Usuario;
import net.bytebuddy.agent.builder.AgentBuilder.Identified.Extendable;

public class UsuarioDAOimpl extends GenericDAOimpl<Usuario> implements UsuarioDAO{

	private EntityManager em = EMF.getEMF().createEntityManager();
	private EntityTransaction etx = em.getTransaction();
		

	public UsuarioDAOimpl() {
		super(Usuario.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Usuario getUsuario(String usuario) {
		Usuario usu = null;
		try {
			etx.begin();
			TypedQuery<Usuario> consulta = EMF.getEMF().createEntityManager().createQuery("select u from Usuario u where usuario = :usuario ", Usuario.class);
			etx.commit();
			consulta.setParameter("usuario", usuario);
			usu = (Usuario) consulta.getSingleResult();
		}
		catch (NoResultException e) {
			System.out.println("No hay registro en la BD de lo solicitado");
		}
		catch (NonUniqueResultException e) {
			System.out.println("Se han encontrado mas de un resultado de los solicitado, en la BD");
		}
		return usu;
	}

	@Override
	public void borrarUsuarioPorNombre(String usuario) {
			Usuario usu = this.getUsuario(usuario);
			this.borrar(usu.getId());
			
		
	}

	public EntityTransaction getEtx() {
		return etx;
	}

	public void setEtx(EntityTransaction etx) {
		this.etx = etx;
	}




}
