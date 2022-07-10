package imersao.phoebus.brotherhood.controller;


import imersao.phoebus.brotherhood.domain.Student;
import imersao.phoebus.brotherhood.dto.StudentDTO;
import imersao.phoebus.brotherhood.service.StudentService;
import imersao.phoebus.brotherhood.service.exceptions.StudentAlreadyExistsException;
import imersao.phoebus.brotherhood.util.DateUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/alunos")
@Log4j2
@RequiredArgsConstructor

public class StudentController {

    private final DateUtil dateUtil;
    private final StudentService studentService;

    @GetMapping
    @Operation(summary = "List all students")
    public ResponseEntity<List<Student>> list(Object o){
        return ResponseEntity.ok(studentService.listAll());
    }


    @GetMapping(path = "/find")
    @Operation(summary = "Returns a list of students of a specific course")
    public ResponseEntity<List<Student>> findStudentsByCourse(@RequestBody String course){
        System.out.println(course);
        return ResponseEntity.ok(studentService.findStudentsByCourse(course));
    }

    @GetMapping(path = "/{id}")
    @Operation(summary = "Find a specific student")
    public ResponseEntity<Student> findById(@PathVariable long id){
        return ResponseEntity.ok(studentService.findByIdOrThrowBadRequestException(id));
    }

    @PostMapping
    @Operation(summary = "Create a student")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Successful Operation"),
            @ApiResponse(responseCode = "500", description = "Unsuccessful Operation")
    })
    public ResponseEntity<StudentDTO> save (@RequestBody @Valid StudentDTO studentDTO) throws StudentAlreadyExistsException {
      return new ResponseEntity<>(studentService.save(studentDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    @Operation(summary = "Remove a student")
    public ResponseEntity<Void> delete(@PathVariable long id){
        studentService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path="/{id}")
    @Operation(summary = "Update a student")
    public ResponseEntity<Student> replace (@RequestBody StudentDTO studentDTO) throws StudentAlreadyExistsException{
        studentService.replace(studentDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
