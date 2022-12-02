package controllers;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Donacion;
import model.Emprendimiento;
import repositorys.EmprendimientoRepository;
import services.EmprendimientoService;

@RestController
@RequestMapping("/Emprendimiento")
public class EmprendimientoController {

	@Autowired
	private EmprendimientoService emprendimientoService;


	@PutMapping("/actualizarEmprendimiento")
	public ResponseEntity<Emprendimiento> actualizarDatosEmprendimiento(@RequestBody Emprendimiento empre) {
		if(emprendimientoService.recuperarEmprendimiento(empre.getId()) !=null) {
			emprendimientoService.actualizarDatosEmprendimiento(empre);
			return new ResponseEntity("Emprendimiento actualizado con exito",HttpStatus.OK);
		}
		return new ResponseEntity("El emprendimiento ingresado no se encuentra en la bd",HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/buscarEmprendimiento")
	public ResponseEntity<Emprendimiento> buscarEmprendimiento(@RequestParam int idEmprendimiento){;
		Emprendimiento empre = emprendimientoService.recuperarEmprendimiento(idEmprendimiento);
		if (empre != null) {
			return new ResponseEntity<Emprendimiento>(empre,HttpStatus.OK); 
		}
		return new ResponseEntity("El emprendimiento ingresado no se encuentra en la bd",HttpStatus.NOT_FOUND);	
	}
	
	@GetMapping ("/listarDonacionesEmprendimiento")
	public ResponseEntity<List<Donacion>>obtenerDonaciones(@RequestParam int idEmprendimiento){
		Emprendimiento empre = emprendimientoService.recuperarEmprendimiento(idEmprendimiento);
		if (empre != null) {
			List<Donacion>donaciones=empre.getListaDonaciones();
			return new ResponseEntity<List<Donacion>>(donaciones, HttpStatus.OK);
		}
		return new ResponseEntity("El emprendimiento ingresado no se encuentra en la bd",HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/eliminarEmprendimiento")
	public ResponseEntity<Emprendimiento> eliminarEmprendimiento(@RequestParam int idEmprendimiento){
		if (emprendimientoService.eliminarEmprendimiento(idEmprendimiento)) {
			return new ResponseEntity("Emprendimiento eliminado",HttpStatus.OK); 
		}
		return new ResponseEntity("El emprendimiento ingresado no se encuentra en la bd",HttpStatus.NOT_FOUND);	
	}

}
