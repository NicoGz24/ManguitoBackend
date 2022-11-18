package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Donacion;
import model.Emprendimiento;
import repositorys.EmprendimientoRepository;

@RestController
@RequestMapping("/Emprendimiento")
public class EmprendimientoController {

	@Autowired
	private EmprendimientoRepository  emprendimientoRepository;


	@PostMapping
	public ResponseEntity<Emprendimiento> registrarEmprendimiento(@RequestBody Emprendimiento empre){
		if (!emprendimientoRepository.existByNombre(empre.getNombre())) {
			emprendimientoRepository.save(empre);
			return new ResponseEntity<Emprendimiento>(HttpStatus.CREATED);
		}
		return new ResponseEntity<Emprendimiento>(HttpStatus.BAD_REQUEST);
	}

	@PutMapping
	public ResponseEntity<Emprendimiento> actualizarDatosEmprendimiento(@RequestBody Emprendimiento empre) {
		emprendimientoRepository.save(empre);
		return new ResponseEntity<Emprendimiento>(HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<Emprendimiento> buscarEmprendimiento(@RequestBody String nombre){
		Emprendimiento empre = emprendimientoRepository.findByNombre(nombre);
		if (empre ==null) {
			return new ResponseEntity<Emprendimiento>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Emprendimiento>(empre,HttpStatus.OK); 
	}
	
	@GetMapping
	public ResponseEntity<List<Donacion>>obtenerDonaciones(@RequestBody String nombre){
		Emprendimiento empre = emprendimientoRepository.findByNombre(nombre);
		if ((empre != null) && (! empre.getListaDonaciones().isEmpty())) {
			return new ResponseEntity<List<Donacion>>(empre.getListaDonaciones(), HttpStatus.OK);
		}
		return new ResponseEntity<List<Donacion>>(HttpStatus.NO_CONTENT);
	}
}
