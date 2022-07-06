package imersao.phoebus.brotherhood.controller;


import imersao.phoebus.brotherhood.domain.Aluno;
import imersao.phoebus.brotherhood.requests.AlunoPostRequestBody;
import imersao.phoebus.brotherhood.requests.AlunoPutRequestBody;
import imersao.phoebus.brotherhood.service.AlunoService;
import imersao.phoebus.brotherhood.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/alunos")
@Log4j2
@RequiredArgsConstructor

public class AlunoController {

    private final DateUtil dateUtil;
    private final AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<Aluno>> list(){
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(alunoService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Aluno> findById(@PathVariable long id){
        return ResponseEntity.ok(alunoService.findByIdOrThrowBadRequestException(id));
    }

    @PostMapping
    public ResponseEntity<Aluno> save (@RequestBody Aluno aluno){
      return new ResponseEntity<>(alunoService.save(aluno), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        alunoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<Aluno> replace (@RequestBody AlunoPutRequestBody alunoPutRequestBody){
        alunoService.replace(alunoPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
