package imersao.phoebus.brotherhood.service;

import imersao.phoebus.brotherhood.domain.Funcionario;
import imersao.phoebus.brotherhood.repository.FuncionarioRepository;
import imersao.phoebus.brotherhood.requests.FuncionarioPostRequestBody;
import imersao.phoebus.brotherhood.requests.FuncionarioPutRequestBody;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository ;

    //private FuncionarioPostRequestBody funcionarioPostRequestBody;



    public List<Funcionario> listAll(){
        return funcionarioRepository.findAll();
    }

    public Funcionario findByIdOrThrowBadRequestException(long id){

        return funcionarioRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Employee not found"));


    }

    public Funcionario save(FuncionarioPostRequestBody funcionarioPostRequestBody){
        return funcionarioRepository.save(Funcionario.builder()
                .name(funcionarioPostRequestBody.getName())
                .email(funcionarioPostRequestBody.getEmail())
                .role(funcionarioPostRequestBody.getRole())
                .build());
    }

    public void delete(long id){
        funcionarioRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace (FuncionarioPutRequestBody funcionarioPutRequestBody){
      Funcionario funcionario = Funcionario.builder()
              .id(funcionarioPutRequestBody.getId())
              .name(funcionarioPutRequestBody.getName())
              .email(funcionarioPutRequestBody.getEmail())
              .role(funcionarioPutRequestBody.getRole())
              .build();
    funcionarioRepository.save(funcionario);
    }
}
