package repositorys;
import org.springframework.data.jpa.repository.JpaRepository;

import model.Posteo;

public interface PosteoRepository extends JpaRepository <Posteo, Integer> {

}
