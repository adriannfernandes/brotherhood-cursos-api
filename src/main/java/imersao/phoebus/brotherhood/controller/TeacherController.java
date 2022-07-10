package imersao.phoebus.brotherhood.controller;


import imersao.phoebus.brotherhood.domain.Teacher;
import imersao.phoebus.brotherhood.dto.TeacherDTO;
import imersao.phoebus.brotherhood.service.TeacherService;
import imersao.phoebus.brotherhood.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("funcionarios")
@Log4j2
@RequiredArgsConstructor

public class TeacherController {

    private final DateUtil dateUtil;

    private final TeacherService teacherService;

    @GetMapping
    public ResponseEntity<List<Teacher>> list() {
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(teacherService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Teacher> findById(@PathVariable long id) {
        return ResponseEntity.ok(teacherService.findByIdOrThrowBadRequestException(id));
    }

    @PostMapping
    public ResponseEntity<Teacher> save (@RequestBody TeacherDTO teacherDTO){
        return new ResponseEntity<>(teacherService.save(teacherDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody TeacherDTO teacherDTO){
        teacherService.replace(teacherDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

