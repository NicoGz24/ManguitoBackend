package DAOs_implementation;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import DAOs_intefaces.CategoriaDAO;
import model.Categoria;

public class CategoriaDAOimpl extends GenericDAOimpl<Categoria> implements CategoriaDAO {

	public CategoriaDAOimpl() {
		super(Categoria.class);
		// TODO Auto-generated constructor stub
	}

	
	public Categoria getCategoria(String nombre) {
		Query consulta = this.getEntityManager().createQuery("select u from Emprendimiento u where nombre = :nombre ", Categoria.class);
		consulta.setParameter("nombre", nombre);
		Categoria resultado = null;
		try {
			resultado = (Categoria) consulta.getSingleResult();
		} catch(NoResultException e) {
			System.out.println("La consulta no arroja resultados");
		}
		return resultado;
	}
	public void borrarCategoria(String nombre) {
		Categoria categoria = this.getCategoria(nombre);
		this.borrar(categoria.getId());
	}
	
}
