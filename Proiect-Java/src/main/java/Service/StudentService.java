package Service;

import Clase.Student;
//import com.example.laboratorjava2024.repository.StudentRepository;
import Repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class StudentService {
    private StudentRepository studentRepository;
    public void saveStudent(Student student){
        studentRepository.save(student);
    }
}
