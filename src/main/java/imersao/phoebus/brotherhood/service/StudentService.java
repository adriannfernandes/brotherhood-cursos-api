package imersao.phoebus.brotherhood.service;

import imersao.phoebus.brotherhood.domain.Student;
import imersao.phoebus.brotherhood.dto.StudentDTO;
import imersao.phoebus.brotherhood.repository.StudentRepository;
import imersao.phoebus.brotherhood.service.exceptions.StudentAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

   private final StudentRepository studentRepository;

   private StudentDTO studentDTO;

    public List<Student> listAll(){
        return studentRepository.findAll();
    }

    public Student findByIdOrThrowBadRequestException(long id){
        return studentRepository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));
    }

    @Transactional
    public StudentDTO save(StudentDTO studentDTO) throws StudentAlreadyExistsException{
        Optional<Student> alunoObj= studentRepository.findByEmail(studentDTO.getEmail());

        if (alunoObj.isPresent()){
            throw new StudentAlreadyExistsException("There is already a student with this e-mail registered in the system!");
        }
        Student student =  studentDTO.alunoDTOToAluno();

        studentRepository.save(student);

       return new StudentDTO(student);
    }

    public void delete (long id){
        studentRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace (StudentDTO studentDTO) throws StudentAlreadyExistsException{

        Student student =  studentDTO.alunoDTOToAluno();
        findByIdOrThrowBadRequestException(student.getId());

        studentRepository.save(student);

    }
    public List<Student> findStudentsByCourse(String course) {

        List<Student> studentsList = studentRepository.groupByCourse(course);

        System.out.println(course);


        return studentsList;
    }
}
