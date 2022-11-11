package DAOs_implementation;

import java.util.List;

import DAOs_intefaces.PosteoDAO;
import model.Posteo;

public class PosteoDAOimpl extends GenericDAOimpl<Posteo> implements PosteoDAO {

	public PosteoDAOimpl() {
		super(Posteo.class);
		// TODO Auto-generated constructor stub
	}
	@Override
	public List<Posteo> getPosteosEmprendimiento(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}
	public Posteo getPosteoPorTitulo(String titulo) {
		return null;
	}
}
