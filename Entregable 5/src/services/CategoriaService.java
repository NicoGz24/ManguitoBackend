package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Categoria;
import repositorys.CategoriaRepository;

@Service
@Transactional
public class CategoriaService {

	
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	
	
	public List<Categoria>listar(){
		return categoriaRepository.findAll();
	}
	
	public Categoria buscarCategoriaId(int id) {
		return categoriaRepository.findById(id);
	}
	
	public Categoria buscarCategoriaNombre(String nombre) {
		return categoriaRepository.findByNombre(nombre);
	}
	
	public void actualizarCategoria(Categoria cate) {
		categoriaRepository.save(cate);
	}

	public boolean eliminarCategoria(int id) {
		System.out.println("DENTRO DEL SERVICIO");
		Categoria cate = categoriaRepository.findById(id);
		if(cate != null) {
			categoriaRepository.delete(cate);
			System.out.println("FIN DEL SERVICIO");
			return true;
		}
		return false;
	}
	
}
