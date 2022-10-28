package DAOs_implementation;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import DAOs_intefaces.EmprendimientoDAO;
import model.Emprendimiento;

public class EmprendimientoDAOimpl extends GenericDAOimpl<Emprendimiento> implements EmprendimientoDAO{
	
	public EmprendimientoDAOimpl() {
		super(Emprendimiento.class);
		// TODO Auto-generated constructor stub
	}
	public Emprendimiento getEmprendimiento(String nombre) {
		Query consulta = this.getEntityManager().createQuery("select u from Emprendimiento u where nombre = :nombre ", Emprendimiento.class);
		consulta.setParameter("nombre", nombre);
		Emprendimiento resultado = null;
		try {
			resultado = (Emprendimiento) consulta.getSingleResult();
		} catch(NoResultException e) {
			System.out.println("La consulta no arroja resultados");
		}
		return resultado;
	}
	public void borrarEmprendimiento(String nombre) {
		Emprendimiento empre = this.getEmprendimiento(nombre);
		this.borrar(empre.getId());
	}
}
