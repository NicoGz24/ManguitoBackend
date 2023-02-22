package services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Categoria;
import model.Emprendimiento;
import repositorys.CategoriaRepository;
import repositorys.EmprendimientoRepository;

@Service
@Transactional
public class CategoriaService {

	
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private EmprendimientoRepository emprendimientoRepository;
	
	
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
	public List<Emprendimiento>recuperarEmprenPorCate(int idCategoria){
		Categoria cate = this.buscarCategoriaId(idCategoria);

		
		return null;
	}
	
}
