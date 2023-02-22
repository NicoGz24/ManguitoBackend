package controllers;

import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import model.Categoria;
import model.Emprendimiento;
import services.CategoriaService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/Categoria")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	
	
	
	
	@GetMapping("recuperarCategoriaId")
	public ResponseEntity<Categoria>recuperarCategoriaId(@RequestParam int idCategoria){
		Categoria cate = this.categoriaService.buscarCategoriaId(idCategoria);
		if(cate != null) {
			return new ResponseEntity<Categoria>(cate,HttpStatus.OK);
		}
		else {
			cate = null;
			return new ResponseEntity<Categoria>(cate, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("listarCategorias")
	public ResponseEntity<List<Categoria>>listarCategorias(){
		List<Categoria>categorias = categoriaService.listar();
		if(categorias != null) {
			return new ResponseEntity<List<Categoria>>(categorias,HttpStatus.OK);
		}
		else
			return new ResponseEntity(null,HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("buscarCategoriaPorNombre")
	public ResponseEntity<Categoria>buscarCategoriaPorNombre(@RequestParam String nombre){
		Categoria cate = this.categoriaService.buscarCategoriaNombre(nombre);
		if(cate != null) {
			return new ResponseEntity<Categoria>(cate,HttpStatus.OK);
		}
		else
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}
	
	
	@PutMapping("actualizarCategoria")
	public ResponseEntity<Categoria>editarCategoria(@RequestBody Categoria categoria){
		System.out.println("DENTRO DEL actualizarCategoria");
		if(categoriaService.buscarCategoriaId(categoria.getId()) != null) {
			categoriaService.actualizarCategoria(categoria);
			return new ResponseEntity<Categoria>(categoria,HttpStatus.OK);
		}
		
		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("eliminarCategoria")
	public ResponseEntity<Categoria>eliminarCategoria(@RequestParam int idCategoria){
		System.out.println("DENTRO DEL ELMINAR");
		if(categoriaService.eliminarCategoria(idCategoria)) {
			System.out.println("PASO EL IF");
			return new ResponseEntity(HttpStatus.OK);
		}
		else
			return new ResponseEntity("Categoria no encontrada",HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("recuperarEmprendimientosPorCagoria")
		public ResponseEntity<List<Emprendimiento>>recuperarEmprendimientosPorCategoria(@RequestParam int idCategoria){
			return new ResponseEntity<List<Emprendimiento>>(null);
		}
	
}
