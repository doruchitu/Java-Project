package Repository;

import Clase.Persoana;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersoanaRepository extends JpaRepository<Persoana,String> {

}

