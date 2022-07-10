package imersao.phoebus.brotherhood.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data // Vai gerar todos os Getters and Setters, Equals, Hash Code e ToString.
//@AllArgsConstructor // Gera um construtor com todos os atributos.
//@NoArgsConstructor // Gera um construtor vazio.
@Entity
@Builder

public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@JsonProperty("_id")
    private Long id;

// USEI PARA TESTAR, SE NÃO QUEBRAR O CÓDIGO EU DEIXO
//    @NotEmpty(message = "The Student's Name cannot be empty")


    private String name;

    private String dataNascimento;

    private String phone;

    private String email;

    private String course;

    public Student(){}

    public Student(Long id, String name, String dataNascimento, String email, String phone, String course) {
        this.id = id;
        this.name = name;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.phone = phone;
        this.course = course;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
