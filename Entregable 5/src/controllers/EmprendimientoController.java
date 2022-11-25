package controllers;

import java.util.List;

import org.hibernate.Hibernate;
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
import model.Emprendimiento;
import repositorys.EmprendimientoRepository;

@RestController
@RequestMapping("/Emprendimiento")
public class EmprendimientoController {

	@Autowired
	private EmprendimientoRepository emprendimientoRepository;


	@PostMapping("/registrarEmprendimiento")
	public ResponseEntity<Emprendimiento> registrarEmprendimiento(@RequestBody Emprendimiento empre){
		String mensaje;
		if (!emprendimientoRepository.existsBynombre(empre.getNombre())) {
			emprendimientoRepository.save(empre);
			mensaje = "Emprendimiento creado con exito";
			return new ResponseEntity(mensaje,HttpStatus.CREATED);
		}
		mensaje ="El nombre de emprendimiento ingresado, ya se encuentra registrado";
		return new ResponseEntity(mensaje,HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/actualizarEmprendimiento")
	public ResponseEntity<Emprendimiento> actualizarDatosEmprendimiento(@RequestBody Emprendimiento empre) {
		Emprendimiento emprendimiento = emprendimientoRepository.findBynombre(empre.getNombre());
		if(emprendimiento !=null) {
			emprendimientoRepository.save (empre);
			return new ResponseEntity<Emprendimiento>(HttpStatus.OK);
		}
		return new ResponseEntity<Emprendimiento>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/buscarEmprendimiento")
	public ResponseEntity<Emprendimiento> buscarEmprendimiento(@RequestParam String nombre){
		Emprendimiento empre = emprendimientoRepository.findBynombre(nombre);
		if (empre != null) {
			return new ResponseEntity<Emprendimiento>(empre,HttpStatus.OK); 
		}
		return new ResponseEntity<Emprendimiento>(HttpStatus.NO_CONTENT);	
	}
	
	@GetMapping ("/listarDonacionesEmprendimiento")
	public ResponseEntity<List<Donacion>>obtenerDonaciones(@RequestParam String nombre){
		Emprendimiento empre = emprendimientoRepository.findBynombre(nombre);
		if (empre != null) {
			List<Donacion>donaciones=empre.getListaDonaciones();
			return new ResponseEntity<List<Donacion>>(donaciones, HttpStatus.OK);
		}
		return new ResponseEntity<List<Donacion>>(HttpStatus.NO_CONTENT);
	}
	

}
