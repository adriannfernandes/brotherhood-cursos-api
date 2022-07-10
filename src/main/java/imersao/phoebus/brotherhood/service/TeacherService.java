package imersao.phoebus.brotherhood.service;

import imersao.phoebus.brotherhood.domain.Teacher;
import imersao.phoebus.brotherhood.dto.TeacherDTO;
import imersao.phoebus.brotherhood.repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    //private FuncionarioPostRequestBody funcionarioPostRequestBody;



    public List<Teacher> listAll(){
        return teacherRepository.findAll();
    }

    public Teacher findByIdOrThrowBadRequestException(long id){

        return teacherRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Employee not found"));


    }

    public Teacher save(TeacherDTO teacherDTO){
        return teacherRepository.save(Teacher.builder()
                .name(teacherDTO.getName())
                .email(teacherDTO.getEmail())
                .email(teacherDTO.getEmail())
                .build());
    }

    public void delete(long id){
        teacherRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace (TeacherDTO teacherDTO){
      Teacher teacher = Teacher.builder()
              .id(teacherDTO.getId())
              .name(teacherDTO.getName())
              .email(teacherDTO.getEmail())
              .build();
    teacherRepository.save(teacher);
    }
}
