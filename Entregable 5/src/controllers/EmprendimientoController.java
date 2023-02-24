package controllers;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Categoria;
import model.Donacion;
import model.Emprendimiento;
import repositorys.EmprendimientoRepository;
import services.CategoriaService;
import services.EmprendimientoService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/Emprendimiento")
public class EmprendimientoController {

	@Autowired
	private EmprendimientoService emprendimientoService;


	@PutMapping("/actualizarEmprendimiento")
	public ResponseEntity<Emprendimiento> actualizarDatosEmprendimiento(@RequestBody Emprendimiento emprendimiento) {
		Emprendimiento empre = this.emprendimientoService.recuperarEmprendimiento(emprendimiento.getId());
		if(empre !=null) {
			emprendimiento.setPlanes(empre.getPlanes());
			emprendimiento.setPosteos(empre.getPosteos());
			emprendimientoService.actualizarDatosEmprendimiento(emprendimiento);
			return new ResponseEntity<Emprendimiento>(empre,HttpStatus.OK);
		}
		return new ResponseEntity<Emprendimiento>(empre,HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/buscarEmprendimiento")
	public ResponseEntity<Emprendimiento> buscarEmprendimiento(@RequestParam int idEmprendimiento){;
		Emprendimiento empre = emprendimientoService.recuperarEmprendimiento(idEmprendimiento);
		if (empre != null) {
			return new ResponseEntity<Emprendimiento>(empre,HttpStatus.OK); 
		}
		return new ResponseEntity<Emprendimiento>(empre,HttpStatus.NOT_FOUND);	
	}
	
	@GetMapping("/buscarEmprendimientoNombre")
	public ResponseEntity<Emprendimiento> buscarEmprendimientoNombre(@RequestParam String nombre){
		Emprendimiento empre = emprendimientoService.recuperarEmprendimientoNombre(nombre);
		if(empre != null) {
			return new ResponseEntity<Emprendimiento>(empre,HttpStatus.OK);
		}
		else
			return new ResponseEntity<Emprendimiento>(empre,HttpStatus.NOT_FOUND);
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
	
	@GetMapping("/listarEmprendimientos")
	public ResponseEntity<List<Emprendimiento>> listarEmprendimientos(){
		List<Emprendimiento>emprendimientos = this.emprendimientoService.listar();
		if(emprendimientos != null) {
			return new ResponseEntity<List<Emprendimiento>>(emprendimientos,HttpStatus.OK);
		}
		else
			return new ResponseEntity<List<Emprendimiento>>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("filtrarEmprendimientosPorCategoria")
	public ResponseEntity<List<Emprendimiento>>filtrarEmprendimientosPorCategoria(@RequestParam int idCategoria){
		List<Emprendimiento>lista=this.emprendimientoService.listar();
		List<Emprendimiento>listaAux = new ArrayList<Emprendimiento>();
		for (Emprendimiento empre : lista) {
			List<Categoria>categoriasEmpre = empre.getCategorias();
			for(Categoria cate:categoriasEmpre) {
				if(cate.getId()==idCategoria) {
					listaAux.add(empre);}
			}
		}
		if(listaAux != null) {
			return new ResponseEntity<List<Emprendimiento>>(listaAux,HttpStatus.OK);
		}
		else {return new ResponseEntity(null,HttpStatus.NO_CONTENT);}
		
	}
	@GetMapping("verDonacionesEmprendimiento")
	public ResponseEntity<List<Donacion>>verDonacionesEmprendimiento(@RequestParam int idEmprendimiento){
		Emprendimiento emprendimiento = this.emprendimientoService.recuperarEmprendimiento(idEmprendimiento);
		if(emprendimiento != null) {
			List<Donacion>donaciones = emprendimiento.getListaDonaciones();
			return new ResponseEntity<List<Donacion>>(donaciones,HttpStatus.OK);
		}
		else
			return new ResponseEntity<List<Donacion>>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("verManguitosRecaudados")
	public ResponseEntity<Integer>verManguitosRecaudados(@RequestParam int idEmprendimiento){
		Emprendimiento emprendimiento = this.emprendimientoService.recuperarEmprendimiento(idEmprendimiento);
		if(emprendimiento != null) {
			List<Donacion>donaciones = emprendimiento.getListaDonaciones();
			int cantDonaciones=0;
			for(Donacion donacion:donaciones) {
				cantDonaciones += donacion.getValor();
			}
			return new ResponseEntity<Integer>(cantDonaciones,HttpStatus.OK);
		}
		else
			return new ResponseEntity<Integer>(0,HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("actualizarCategoriasEmprendimiento")
	public ResponseEntity<Emprendimiento> actualizarCategoriasEmprendimiento(@RequestParam int idEmprendimiento, @RequestParam int idCategoria){
		Emprendimiento emprendimiento = this.emprendimientoService.actualizarCategorias(idEmprendimiento, idCategoria);
		if(emprendimiento !=null) {
			return new ResponseEntity<Emprendimiento>(emprendimiento,HttpStatus.OK);
		}
		else
			return new ResponseEntity<Emprendimiento>(emprendimiento,HttpStatus.NOT_FOUND);
			
			
	}
	
	
}
