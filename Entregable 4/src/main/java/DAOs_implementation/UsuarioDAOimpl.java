package DAOs_implementation;


import DAOs_intefaces.UsuarioDAO;
import model.Usuario;

public class UsuarioDAOimpl extends GenericDAOimpl<Usuario> implements UsuarioDAO{



	public UsuarioDAOimpl() {
		super(Usuario.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Usuario getUsuario(String usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void borrarUsuarioPorNombre(String usuario) {
		// TODO Auto-generated method stub
		
	}




}
