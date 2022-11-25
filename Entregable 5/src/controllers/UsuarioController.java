package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Donacion;
import model.DonacionManguito;
import model.Emprendimiento;
import model.Usuario;
import repositorys.EmprendimientoRepository;
import repositorys.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	private EmprendimientoRepository emprendimientoRepository;


	 
	 @PostMapping("/registrarUsuario")
	 public ResponseEntity<Usuario> registrarUsuario(@RequestBody Usuario usu) {
		 Usuario usuario = usuarioRepository.findByUsuario(usu.getNombre());
		 if (usuario== null) {
			 usuarioRepository.save(usu);
			 return new ResponseEntity<Usuario>(HttpStatus.CREATED);
		 }
		 return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
	 }
		
	 @PutMapping("/NewPassword")
	 public ResponseEntity<Usuario> setNewPassword(@RequestParam String usuario, @RequestParam String contraseña) {
		 String mensaje = "El usuario ingresado no se encuentra en la BD";
		 Usuario usu= usuarioRepository.findByUsuario(usuario);
		 if (usu != null) {
			 usu.setContraseña(contraseña);
			 usuarioRepository.save(usu);
			 mensaje = "Se ha cambiado la contraseña con exito";
			 return new ResponseEntity<Usuario>(usu,HttpStatus.OK);
		 }
		 else  return new ResponseEntity(mensaje,HttpStatus.NOT_FOUND);
	 	}

	
	 @GetMapping("/buscarUsuario")
	 public  ResponseEntity<Usuario> findByUsuario(@RequestParam String usuario){
		 String mensaje = "El usuario ingresado no se encuentra en la BD";
		 Usuario usu= usuarioRepository.findByUsuario(usuario);
		 if (usu != null) {
			 return new ResponseEntity<Usuario>(usu,HttpStatus.OK);
		 }
		 else  return new ResponseEntity(mensaje,HttpStatus.NOT_FOUND);
	 }
	 
	 @PostMapping("/login")
	 public ResponseEntity<Usuario> loginUsuario(@RequestParam String usuario, @RequestParam String contraseña) {
		 String mensaje = "Usuario o contraseña no validos";
		 Usuario usu = usuarioRepository.findByUsuarioAndContraseña(usuario , contraseña);
		 if (usu != null)  { 
			 mensaje = "Usuario logeado con exito"; 
			 return new ResponseEntity(mensaje, HttpStatus.OK);
		 } 
		 return new ResponseEntity(mensaje,HttpStatus.NOT_ACCEPTABLE);
	 }
	 
	 @PostMapping("/registrarEmprendimiento")
	 public ResponseEntity<Usuario> registrarEmprendimiento(@RequestParam String usuario, @RequestBody Emprendimiento empre){
		 String mensaje = "El usuario ingresado no se encuentra en la BD";
		 Usuario usu= usuarioRepository.findByUsuario(usuario);
		 if (usu != null) {
			 usu.registrarEmprendimiento(empre);
			 usuarioRepository.save(usu);
			 mensaje = "Se ha registrado con exito el emprendimiento del usuario "+usuario;
			 return new ResponseEntity(mensaje,HttpStatus.OK);
		 }
		 else  return new ResponseEntity(mensaje,HttpStatus.NOT_FOUND);
		 
	 }
	 
	 @PutMapping ("/donarManguitos")
	 public ResponseEntity<Usuario> donarManguitos(@RequestBody DonacionManguito donacion, @RequestParam String emprendimiento){
		 Emprendimiento empre = emprendimientoRepository.findBynombre(emprendimiento);
		 empre.agregarDonacion(donacion);
		 emprendimientoRepository.save(empre);
		 Usuario usu = usuarioRepository.findByUsuario(donacion.getDonador().getNombre());
		 if(usu != null) {
			 usu.donarManguitos(donacion);
			 usuarioRepository.save(usu);
		 }
		 String mensaje = "Se ha registrado la donacion de forma exitosa";
		 return new ResponseEntity<Usuario>(HttpStatus.OK);
	 }
}

