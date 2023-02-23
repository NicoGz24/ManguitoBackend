package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Categoria;
import model.Emprendimiento;
import repositorys.CategoriaRepository;
import repositorys.EmprendimientoRepository;


@Service
@Transactional
public class EmprendimientoService {

	@Autowired
	private EmprendimientoRepository emprendimientoRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;

	
	
	public Emprendimiento recuperarEmprendimiento(int idEmprendimiento) {
		return emprendimientoRepository.findById(idEmprendimiento);
	}
	
	public Emprendimiento recuperarEmprendimientoNombre(String nombre) {
		return emprendimientoRepository.findBynombre(nombre);
	}
	
	public boolean eliminarEmprendimiento(int idEmprendimiento) {
		Emprendimiento empre = emprendimientoRepository.findById(idEmprendimiento);
		if (empre != null) {
			emprendimientoRepository.delete(empre);
			return true;
		}
		return false;
	}
	
	public void actualizarDatosEmprendimiento(Emprendimiento empre) {
		emprendimientoRepository.save(empre);
	}
	
	public List<Emprendimiento>listar(){
		return emprendimientoRepository.findAll();
	}

	public Emprendimiento actualizarCategorias(int idEmprendimiento, int idCategoria) {
		Emprendimiento emprendimiento = this.recuperarEmprendimiento(idEmprendimiento);
		if(emprendimiento!=null) {
			Categoria categoria = this.categoriaRepository.findById(idCategoria);
			emprendimiento.getCategorias().add(categoria);
			this.emprendimientoRepository.save(emprendimiento);
			return emprendimiento;
		}
		else
			return null;
	}
}
