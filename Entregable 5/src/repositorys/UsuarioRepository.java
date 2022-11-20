package repositorys;

import org.springframework.data.jpa.repository.JpaRepository;


import model.Usuario;

public interface UsuarioRepository extends JpaRepository <Usuario, Integer> {
	
	
	public Usuario findByUsuario(String usuario);
	
	public Usuario findByUsuarioAndContraseña(String usuario, String contraseña);
	
	
	
}
