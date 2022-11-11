package repositorys;

import org.springframework.data.jpa.repository.JpaRepository;


import model.Usuario;

public interface UsuarioRepository extends JpaRepository <Usuario, Integer> {
	
	public boolean existByUsuario(String usuario);
	
	public Usuario findByUsuario(String usuario);
}
