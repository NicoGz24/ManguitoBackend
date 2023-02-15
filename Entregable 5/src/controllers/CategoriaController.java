package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Categoria;
import services.CategoriaService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/Categoria")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	
	@GetMapping("listarCategorias")
	public ResponseEntity<List<Categoria>>listarCategorias(){
		List<Categoria>categorias = categoriaService.listar();
		if(categorias != null) {
			return new ResponseEntity<List<Categoria>>(categorias,HttpStatus.OK);
		}
		else
			return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("actualizarCategoria")
	public ResponseEntity<Categoria>editarCategoria(@RequestBody Categoria categoria){
		if(categoriaService.buscarCategoriaId(categoria.getId()) != null) {
			categoriaService.actualizarCategoria(categoria);
			return new ResponseEntity<Categoria>(categoria,HttpStatus.OK);
		}
		
		return new ResponseEntity<Categoria>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("eliminarCategoria")
	public ResponseEntity<Categoria>eliminarCategoria(@RequestParam int idCategoria){
		System.out.println("DENTRO DEL ELMINAR");
		if(categoriaService.eliminarCategoria(idCategoria) != null) {
			System.out.println("PASO EL IF");
			return new ResponseEntity<Categoria>(HttpStatus.OK);
		}
		return new ResponseEntity("Categoria no encontrada",HttpStatus.NOT_FOUND);
	}
}
