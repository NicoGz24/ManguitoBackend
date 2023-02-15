package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public void actualizarCategoria(Categoria cate) {
		categoriaRepository.save(cate);
	}

	public Categoria eliminarCategoria(int id) {
		System.out.println("DENTRO DEL SERVICIO");
		Categoria cate = categoriaRepository.findById(id);
		if(cate != null) {
			categoriaRepository.delete(cate);
			System.out.println("FIN DEL SERVICIO");
			return cate;
		}
		return cate;
	}
	
}
