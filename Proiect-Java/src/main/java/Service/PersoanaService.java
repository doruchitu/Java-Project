package Service;

import Clase.Persoana;

import Repository.PersoanaRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class PersoanaService{
    private static PersoanaRepository persoanaRepository;
    public static void savePersoana(Persoana persoana){
        persoanaRepository.save(persoana);
    }

}
