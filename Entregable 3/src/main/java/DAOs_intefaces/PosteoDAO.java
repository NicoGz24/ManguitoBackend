package DAOs_intefaces;

import java.util.List;

import model.Posteo;

public interface PosteoDAO {
	public List<Posteo> getPosteosEmprendimiento(String nombre);
}
