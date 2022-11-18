package DAOs_intefaces;

import java.util.List;

import model.RedSocial;

public interface RedSocialDAO {
	public List<RedSocial> getRedesEmprendimiento(String nombre);
}
