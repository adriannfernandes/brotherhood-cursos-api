package imersao.phoebus.brotherhood.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data // Vai gerar todos os Getters and Setters, Equals, Hash Code e ToString.
@AllArgsConstructor // Gera um construtor com todos os atributos.
@NoArgsConstructor // Gera um construtor vazio.
@Entity
@Builder



public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@JsonProperty("_id")
    private Long id;

    @Column(length = 200, nullable = false)
    private String name;

    @Column(length = 12, nullable = false)
    private String dataNascimento;

    @Column(length = 15, nullable = true)
    private String phone;

    @Column(length = 15, nullable = true)
    private String course;

}
