package repositorys;
import model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository <Categoria, Integer>{

	public Categoria findByNombre(String nombre);
	
	public Categoria findById(int id);
}
