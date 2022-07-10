package imersao.phoebus.brotherhood.repository;

import imersao.phoebus.brotherhood.domain.Student;
import imersao.phoebus.brotherhood.util.StudentCreator;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
@DisplayName("Test for Student Repository")
@Log4j2
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    @DisplayName("Save persists Student when successful")
    void save_PersistStudent_WhenSuccessful(){

        Student studentToBeSaved = StudentCreator.createStudentToBeSaved();

        Student studentSaved = this.studentRepository.save(studentToBeSaved);

        Assertions.assertThat(studentSaved).isNotNull();
        Assertions.assertThat(studentSaved.getId()).isNotNull();
        Assertions.assertThat(studentSaved.getEmail()).isEqualTo(studentToBeSaved.getEmail());
    }

    @Test
    @DisplayName("Save updates Student when successful")
    void save_UpdatesStudent_WhenSuccessful(){

        Student studentToBeSaved = StudentCreator.createStudentToBeSaved();

        Student studentSaved = this.studentRepository.save(studentToBeSaved);

        studentSaved.setName("Adrian Fernandes");


        Student studentUpdated = studentRepository.save(studentSaved);

        Assertions.assertThat(studentUpdated).isNotNull();
        Assertions.assertThat(studentUpdated.getId()).isNotNull();
        Assertions.assertThat(studentUpdated.getEmail()).isEqualTo(studentSaved.getEmail());
    }

    @Test
    @DisplayName("Delete removes Student when successful")
    void delete_RemovesStudent_WhenSuccessful(){

        Student studentToBeSaved = StudentCreator.createStudentToBeSaved();

        Student studentSaved = this.studentRepository.save(studentToBeSaved);

        this.studentRepository.delete(studentSaved);

        Optional<Student> studentOptional = this.studentRepository.findById(studentSaved.getId());

        Assertions.assertThat(studentOptional).isEmpty();
    }

    @Test
    @DisplayName("findByEmail returns a Student when successful")
    void findByEmail_ReturnsAStudent_WhenSuccessful(){

        Student studentToBeSaved = StudentCreator.createStudentToBeSaved();

        Student studentSaved = this.studentRepository.save(studentToBeSaved);

        String email = studentSaved.getEmail();

        Optional<Student> studentByEmail = this.studentRepository.findByEmail(email);

        Assertions.assertThat(studentByEmail)
                .isNotEmpty()
                .contains(studentSaved);

    }

    @Test
    @DisplayName("findByEmail returns no Student when no email is found")
    void findByEmail_ReturnsNoStudent_WhenNoEmailIsFound(){

        Optional<Student> studentByEmail = this.studentRepository.findByEmail("test@test.com");

        Assertions.assertThat(studentByEmail).isEmpty();


    }

//    @Test
//    @DisplayName("Save throw ConstraintViolationException when the fields are empty")
//    void save_ThrowConstraintViolationException_WhenFieldsAreEmpty(){
//
//        Student student = new Student();
//        Assertions.assertThatExceptionOfType(ConstraintViolationException.class)
//                .isThrownBy(() -> this.studentRepository.save(student))
//                .withMessageContaining("The Student's Name cannot be empty");
//    }

//    @Test
//    @DisplayName("Save throw StudentAlreadyExistException when successful")
//    void save_ThrowStudentAlreadyExistException_WhenSuccessful(){
//
//        Student student = new Student();
//        Assertions.assertThatExceptionOfType(StudentAlreadyExistsException.class)
//                .isThrownBy(() -> this.studentRepository.save(student))
//                .withMessageContaining("There is already a student with this e-mail registered in the system!");
//    }


}