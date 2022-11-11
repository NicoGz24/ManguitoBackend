package repositorys;
import org.springframework.data.jpa.repository.JpaRepository;

import model.Emprendimiento;
public interface EmprendimientoRepository extends JpaRepository<Emprendimiento, Integer>{

	public boolean existByNombre(String nombre);
	
	public Emprendimiento findByNombre(String nombre);
}
