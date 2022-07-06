package imersao.phoebus.brotherhood.repository;

import imersao.phoebus.brotherhood.domain.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoRepository extends JpaRepository <Aluno, Long> {

//    List<Aluno> listAll();

}
