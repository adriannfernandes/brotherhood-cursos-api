package imersao.phoebus.brotherhood.repository;

import imersao.phoebus.brotherhood.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository <Funcionario, Long> {

    //List<Funcionario> listAll();

}