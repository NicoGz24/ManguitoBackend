package repositorys;

import org.springframework.data.jpa.repository.JpaRepository;


import model.Usuario;

public interface UsuarioRepository extends JpaRepository <Usuario, Integer> {
	
	
	public Usuario findByUsuario(String usuario);
	
	public Usuario findByUsuarioAndPassword(String usuario, String password);
	
	public Usuario findById(int id);
	
	
	
}
