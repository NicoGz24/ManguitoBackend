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
	 public ResponseEntity<Usuario> setNewPassword(@RequestBody Usuario usu) {
		 usuarioRepository.save(usu);
		 return new ResponseEntity<Usuario>(HttpStatus.OK);
		 }
	 
	 
	 @GetMapping("/buscarUsuario")
	 public  ResponseEntity<Usuario> findByUsuario(@RequestParam String usuario){
		 Usuario usu= usuarioRepository.findByUsuario(usuario);
		 if (usu != null) {
			 return new ResponseEntity<Usuario>(usu,HttpStatus.OK);
		 }
		 else  return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
	 }
	 
	 @PutMapping("/login")
	 public ResponseEntity<Usuario> loginUsuario(@RequestParam String usuario, @RequestParam String contraseña) {
		 //String mensaje = "";
		 Usuario usu = usuarioRepository.findByUsuarioAndContraseña(usuario , contraseña);
		 if (usu != null)  {
			  //mensaje	= "Usuario logeado correctamente"; 
			 return new ResponseEntity<Usuario>( HttpStatus.OK);
		 }
		 //mensaje = "El usuario o la contraseña no son correctos"; 
		 return new ResponseEntity<Usuario>(HttpStatus.NOT_ACCEPTABLE);
	 }
	 
	 @PutMapping ("/donarManguitos")
	 public ResponseEntity<Usuario> donarManguitos(@RequestBody Donacion donacion, @RequestParam String nombre){
		 EmprendimientoRepository empreRepo = null;
		 Emprendimiento empre = empreRepo.findBynombre(nombre);
		 empre.agregarDonacion((DonacionManguito)donacion);
		 empreRepo.save(empre);
		 //donacion.getDonador().donarManguitos(donacion); Hace falta hacer esto ??
		 usuarioRepository.save(donacion.getDonador());
		 return new ResponseEntity<Usuario>(HttpStatus.OK);
	 }
}

