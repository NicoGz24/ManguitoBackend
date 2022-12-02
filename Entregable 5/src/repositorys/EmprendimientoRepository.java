package repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import model.Emprendimiento;
import model.Usuario;
@Repository
public interface EmprendimientoRepository extends JpaRepository<Emprendimiento, Integer>{

	public boolean existsBynombre(String nombre);
	
	public Emprendimiento findBynombre(String nombre);
	
	public Emprendimiento findById(int id);

	

}
