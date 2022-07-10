package imersao.phoebus.brotherhood.repository;

import imersao.phoebus.brotherhood.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository <Teacher, Long> {

    //List<Teacher> listAll();



}
