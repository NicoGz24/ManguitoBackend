package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Categoria;
import model.DonacionManguito;
import model.DonacionPlan;
import model.Emprendimiento;
import model.Plan;
import model.Usuario;
import repositorys.CategoriaRepository;
import repositorys.EmprendimientoRepository;
import repositorys.PlanRepository;
import repositorys.UsuarioRepository;

@Service
@Transactional
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private EmprendimientoRepository emprendimientoRepository;
	
	@Autowired
	private PlanRepository planRepository;

	@Autowired
	private CategoriaRepository cateRepository;
	
	public List<Usuario>listar(){
		return usuarioRepository.findAll();
	}
	
	public Usuario registrarUsuario(Usuario usu) {
		 Usuario usuario = usuarioRepository.findByUsuario(usu.getNombre());
		 if ((usu != null) && (usuario == null)) {	 
			 return usuarioRepository.save(usu);
		 }
		 return null;
	}
	
	public void actualizarUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	
	public Usuario buscarUsuario(int idUsuario) {
		return usuarioRepository.findById(idUsuario);
	}
	
	public Usuario loginUsuario( String usuario,String contraseña) {
		Usuario usu = usuarioRepository.findByUsuarioAndPassword(usuario , contraseña);
		return usu;
	}
	
	public Usuario registrarEmprendimiento(int idUsuario, Emprendimiento empre) {
		Usuario usuario = usuarioRepository.findById(idUsuario);
		Emprendimiento emprendimiento = emprendimientoRepository.findBynombre(empre.getNombre());
		if((usuario != null) && (emprendimiento == null)) {
			usuario.registrarEmprendimiento(empre);
			usuarioRepository.save(usuario);
			return usuario;
		}
		return null;
	}
	
	
	public Usuario eliminarUsuario(int idUsuario) {
		Usuario usuario = usuarioRepository.findById(idUsuario);
		if (usuario != null) {
			usuarioRepository.delete(usuario);
			return usuario;
		}
		return usuario;
	}
	
	public boolean donarManguitos(DonacionManguito donacion, int idEmprendimiento) {
		Emprendimiento empre = emprendimientoRepository.findById(idEmprendimiento);
		if(empre !=null) {
			donacion.setDonador(usuarioRepository.findByUsuario(donacion.getDonador().getNombre()));
			empre.agregarDonacion(donacion);
			emprendimientoRepository.save(empre);
			return true;
		}
		return false;
		
	}
	
	public boolean verificarDonacionPlan(DonacionPlan donacion, int idPlan) {
		Plan plan = planRepository.findById(idPlan);
		if((plan.getDestallesBeneficio() != null) && (donacion.getDonador().getEmail() == null)) {
			return false;
		}
		else return true;
	}
	
	public void donarPlan(DonacionPlan donacion, int idPlan) {
		Plan plan = planRepository.findById(idPlan);
		Emprendimiento empre = emprendimientoRepository.findById(plan.getEmprendimiento().getId());
		if(empre !=null) {
			donacion.setDonador(usuarioRepository.findByUsuario(donacion.getDonador().getNombre()));
			donacion.setPlan(plan);
			empre.agregarDonacion(donacion);
			emprendimientoRepository.save(empre);
		}
	}
	
	public Categoria altaCategoria(Categoria categoria) {
		Categoria cate = this.cateRepository.findByNombre(categoria.getNombre());
		if(cate == null) {
			this.cateRepository.save(categoria);
			return categoria;
		}
		return null;
	}
}
