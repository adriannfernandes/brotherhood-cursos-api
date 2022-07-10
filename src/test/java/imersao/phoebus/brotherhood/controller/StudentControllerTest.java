package imersao.phoebus.brotherhood.controller;

import imersao.phoebus.brotherhood.domain.Student;
import imersao.phoebus.brotherhood.service.StudentService;
import imersao.phoebus.brotherhood.service.exceptions.StudentAlreadyExistsException;
import imersao.phoebus.brotherhood.util.StudentCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
class StudentControllerTest {
    @InjectMocks
    //usa para a classe q via ser testada
    private StudentController studentController;
    @Mock
    //usa para todas as classe que a outra utiliza
    private StudentService studentServiceMock;

    @BeforeEach
    void setUp() throws StudentAlreadyExistsException {
        List<Student> studentList = new ArrayList<>(List.of(StudentCreator.createValidStudent())) {
        };

//        BDDMockito.when(studentServiceMock.listAll())
//                .thenReturn(studentList);
//        BDDMockito.when(studentServiceMock.findByIdOrThrowBadRequestException(ArgumentMatchers.anyLong()))
//                .thenReturn(StudentCreator.createValidStudent());
//
//        BDDMockito.when(studentServiceMock.save(ArgumentMatchers.any(Student.class)))
//                .thenReturn(StudentCreator.createValidStudent());
//
//        BDDMockito.doNothing().when(studentServiceMock).replace(ArgumentMatchers.any(Student.class));
//
//        BDDMockito.doNothing().when(studentServiceMock).delete(ArgumentMatchers.anyLong());

    }

    @Test
    @DisplayName("ListAll Returns List of all students when successfull")
    void listAll_ReturnsListOfAllStudents_WhenSuccessful(){
        String expectedName = StudentCreator.createValidStudent().getName();

        List<Student> studentList = studentController.list(null).getBody();

        Assertions.assertThat(studentList).isNotEmpty();
        Assertions.assertThat(studentList.toArray()).isNotEmpty();
        Assertions.assertThat(studentList.get(0).getName()).isEqualTo(expectedName);
    }

//    @Test
//    @DisplayName("findById returns a student when successful ")
//    void findById_ReturnsStudent_WhenSucessful() {
//        Long expectedId = StudentCreator.createValidStudent().getId();
//
//        Student student = studentController.findById(1).getBody();
//
//        Assertions.assertThat(student).isNotNull();
//
//        Assertions.assertThat(student.getId()).isNotNull().isEqualTo(expectedId);
//    }

//    @Test
//    @DisplayName("Replace updates livro when successful ")
//    void replace_UpdatesLivro_WhenSucessful() {
//
//        Assertions.assertThatCode(() -> studentController.replace(StudentCreator.createValidUpdatedStudent()))
//                .doesNotThrowAnyException();
//
//        ResponseEntity<Livro> entity = livroController.replace(LivroPutRequestBodyCreator.createLivroPutRequestBody());
//
//        Assertions.assertThat(entity).isNotNull();
//
//        Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
//
//
//
//    }


}