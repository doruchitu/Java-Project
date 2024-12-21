package Repository;

import Clase.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,String> {

    public Student getStudentByNumeAndPrenume(String nume, String prenume);

    //public Object save(Student student);
}

