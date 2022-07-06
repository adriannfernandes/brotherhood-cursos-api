package imersao.phoebus.brotherhood.service;

import imersao.phoebus.brotherhood.domain.Aluno;
import imersao.phoebus.brotherhood.repository.AlunoRepository;
import imersao.phoebus.brotherhood.requests.AlunoPostRequestBody;
import imersao.phoebus.brotherhood.requests.AlunoPutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunoService {

   private final AlunoRepository alunoRepository;
   private AlunoPostRequestBody alunoPostRequestBody;

    public List<Aluno> listAll(){
        return alunoRepository.findAll();
    }

    public Aluno findByIdOrThrowBadRequestException(long id){
        return alunoRepository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST, "Student not found"));
    }

    public Aluno save(Aluno aluno) {
        aluno.setId(null);
        return alunoRepository.save(aluno);
    }

    public void delete (long id){
        alunoRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace (AlunoPutRequestBody alunoPutRequestBody){
        Aluno aluno = Aluno.builder()
                .id(alunoPutRequestBody.getId())
                .name(alunoPutRequestBody.getName())
                .dataNascimento(alunoPutRequestBody.getDataNascimento())
                .phone(alunoPutRequestBody.getPhone())
                .course(alunoPutRequestBody.getCourse())
                .build();
        alunoRepository.save(aluno);
    }
}
