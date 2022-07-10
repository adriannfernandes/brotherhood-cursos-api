package imersao.phoebus.brotherhood.dto;

import imersao.phoebus.brotherhood.domain.Teacher;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class TeacherDTO implements Serializable {

    private static final long SerialVersionIUD = 1L;

    private Long id;

    @NotEmpty(message="Required")
    @Length(min=3, max=80, message="The size must be between 3 and 80 characters")
    private String name;

    @NotEmpty(message="Required")
    @Email(message = "Invalid email")
    private String email;

    @Length(min=3, max=80, message="The size must be between 20 and 80 characters")
    private String phone;

    public TeacherDTO() {}

    public Teacher teacherDTOToTeacher(){
        return new Teacher(id, name, email, phone);
    }

    public TeacherDTO(Teacher obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.email = obj.getEmail();
        this.phone = obj.getPhone();
    }

    @Override
    public String toString() {
        return "TeacherDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
