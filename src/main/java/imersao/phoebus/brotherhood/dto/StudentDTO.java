package imersao.phoebus.brotherhood.dto;

import imersao.phoebus.brotherhood.domain.Student;
import io.swagger.v3.oas.annotations.media.Schema;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;


public class StudentDTO implements Serializable {

    private static final long SerialVersionIUD = 1L;
    private Long id;


    @NotEmpty(message="Required")
    @Schema(description = "This is the Student's name", example = "Luiz Felipe da Silva", required = true)
    @Length(min=3, max=80, message="The size must be between 3 and 80 characters")
    private String name;

    @Schema(description = "This is the Student's birth date", example = "DD/MM/AAAA")
    @Length(min=3, max=80, message="The size must be between 20 and 80 characters")
    private String dataNascimento;

    @NotEmpty(message="Required")
    @Email(message = "Invalid email")
    @Schema(description = "This is the Student's email", example = "luizfelipe@email.com", required = true)
    private String email;

    @Length(min=3, max=80, message="The size must be between 20 and 80 characters")
    @Schema(description = "This is the Student's phone", example = "(00) 0 0000-0000")
    private String phone;

    @NotEmpty(message="Required")
    @Schema(description = "This is the Student's couser")
    @Length(min=3, max=80, message="The size must be between 20 and 80 characters")
    private String course;

    public StudentDTO() {}

    public Student alunoDTOToAluno(){
        return new Student(id, name,dataNascimento, email, phone, course);
    }

    public StudentDTO(Student obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.dataNascimento = obj.getDataNascimento();
        this.email = obj.getEmail();
        this.phone = obj.getPhone();
        this.course = obj.getCourse();
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Data de Nascimento='" + dataNascimento + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", course='" + course + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

}
