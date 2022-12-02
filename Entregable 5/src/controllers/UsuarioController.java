package controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import model.DonacionManguito;
import model.DonacionPlan;
import model.Emprendimiento;
import model.Usuario;
import services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;


	 
	 @PostMapping("/registrarUsuario")
	 public ResponseEntity<Usuario> registrarUsuario(@RequestBody Usuario usu) {
		 Usuario usuario = usuarioService.registrarUsuario(usu);
		 if (usuario != null) {
			 return new ResponseEntity<Usuario>(HttpStatus.CREATED);
		 }
		 return new ResponseEntity<Usuario>(HttpStatus.BAD_REQUEST);
	 }
		
	 @PutMapping("/actualizarUsuario")
	 public ResponseEntity<Usuario> actualizarUsuario(@RequestBody Usuario usuario) {
		 String mensaje = "El usuario ingresado no se encuentra en la BD";
		 Usuario usu = usuarioService.buscarUsuario(usuario.getId());
		 if (usu != null) {
			 usuario.registrarEmprendimiento(usu.getEmprendimiento());
			 usuarioService.actualizarUsuario(usuario);
			 mensaje = "Se ha cambiado la contraseña con exito";
			 return new ResponseEntity(mensaje,HttpStatus.OK);
		 }
		 else  return new ResponseEntity(mensaje,HttpStatus.NOT_FOUND);
	 	}

	
	 @GetMapping("/buscarUsuario")
	 public  ResponseEntity<Usuario> findByUsuario(@RequestParam int idUsuario){
		 String mensaje = "El usuario ingresado no se encuentra en la BD";
		 Usuario usu= usuarioService.buscarUsuario(idUsuario);
		 if (usu !=null) {
			 return new ResponseEntity<Usuario>(usu,HttpStatus.OK);
		 }
		 else  return new ResponseEntity(mensaje,HttpStatus.NOT_FOUND);
	 }
	 
	 @PostMapping("/login")
	 public ResponseEntity<Usuario> loginUsuario(@RequestParam String usuario, @RequestParam String contraseña) {
		 String mensaje = "Usuario o contraseña no validos";
		 if (usuarioService.loginUsuario(usuario, contraseña))  { 
			 mensaje = "Usuario logeado con exito"; 
			 return new ResponseEntity(mensaje, HttpStatus.OK);
		 } 
		 return new ResponseEntity(mensaje,HttpStatus.FORBIDDEN);
	 }
	 
	 @PostMapping("/registrarEmprendimiento")
	 public ResponseEntity<Usuario> registrarEmprendimiento(@RequestParam int idUsuario, @RequestBody Emprendimiento empre){
		 String mensaje = "El usuario ingresado no se encuentra en la BD";
		 if (usuarioService.registrarEmprendimiento(idUsuario, empre) != null) {
			 mensaje = "Se ha registrado con exito el emprendimiento";
			 return new ResponseEntity(mensaje,HttpStatus.OK);
		 }
		 else  return new ResponseEntity(mensaje,HttpStatus.NOT_FOUND);
		 
	 }
	 
	 @PutMapping ("/donarManguitos")
	 @Transactional
	 public ResponseEntity<Usuario> donarManguitos(@RequestBody DonacionManguito donacion, @RequestParam int idEmprendimiento){
		 usuarioService.donarManguitos(donacion, idEmprendimiento);
		 return new ResponseEntity("Se ha registrado la donacion de forma exitosa",HttpStatus.OK);
	 }
	 
	 @PutMapping ("/donarPlan")
	 @Transactional
	 public ResponseEntity<Usuario> donarPlan(@RequestBody DonacionPlan donacion, @RequestParam int idPlan){
		 if(usuarioService.verificarDonacionPlan(donacion, idPlan)) {
			 usuarioService.donarPlan(donacion,idPlan);
			 return new ResponseEntity("Se ha registrado la donacion de forma exitosa",HttpStatus.OK);
		 }
		 
		 return new ResponseEntity("Debe ingresar un email para realizar la compra de este plan",HttpStatus.NOT_FOUND);
	 }
	 
	 @DeleteMapping("/eliminarUsuario")
	 public  ResponseEntity<Usuario> eliminarUsuario(@RequestParam int idUsuario){
		 if (usuarioService.eliminarUsuario(idUsuario) != null) {
			 return new ResponseEntity("Usuario eliminado",HttpStatus.OK);
		 }
		 else  return new ResponseEntity("El usuario ingresado no se encuentra en la BD",HttpStatus.NOT_FOUND);
	 }
}

