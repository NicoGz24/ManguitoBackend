package DAOs_intefaces;



import model.Usuario;

public interface UsuarioDAO {
	public Usuario getUsuario(String usuario);
	public void borrarUsuarioPorNombre(String usuario);
}
