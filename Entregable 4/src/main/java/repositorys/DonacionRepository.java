package repositorys;
import org.springframework.data.jpa.repository.JpaRepository;

import model.Donacion;

public interface DonacionRepository  extends JpaRepository<Donacion, Integer> {

}
