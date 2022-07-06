package imersao.phoebus.brotherhood.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data // Vai gerar todos os Getters and Setters, Equals, Hash Code e ToString.
@AllArgsConstructor // Gera um construtor com todos os atributos.
@NoArgsConstructor // Gera um construtor vazio.
@Entity
@Builder

public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String role;
    private String email;


}
