package DAOs_implementation;

import java.util.List;

import DAOs_intefaces.RedSocialDAO;
import model.RedSocial;

public class RedSocialDAOimpl extends GenericDAOimpl<RedSocial> implements RedSocialDAO {

	
	public RedSocialDAOimpl() {
		super(RedSocial.class);
		// TODO Auto-generated constructor stub
	}
	@Override
	public List<RedSocial> getRedesEmprendimiento(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

}
