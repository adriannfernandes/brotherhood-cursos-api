package imersao.phoebus.brotherhood.util;

import imersao.phoebus.brotherhood.domain.Student;

public class StudentCreator {
    public static Student createStudentToBeSaved(){
        return Student.builder()
                .name("Adrian Ancelmo")
                .dataNascimento("19/04/2001")
                .email("adrian@test.com")
                .phone("(81) 998535587")
                .course("Pre Enem")
                .build();

    }

    public static Student createValidStudent(){
        return Student.builder()
                .id(1l)
                .name("Adrian Ancelmo")
                .dataNascimento("19/04/2001")
                .email("adrian@test.com")
                .phone("(81) 998535587")
                .course("Pre Enem")
                .build();

    }

//    public static StudentDTO createValidStudentDTO(){
//        return Student(){
//                .id(1l)
//                .name("Adrian Ancelmo")
//                .dataNascimento("19/04/2001")
//                .email("adrian@test.com")
//                .phone("(81) 998535587")
//                .course("Pre Enem")
//                .build();
//
//    }
    public static Student createValidUpdatedStudent(){
        return Student.builder()
                .id(1l)
                .name("Adrian Ancelmo F")
                .dataNascimento("19/04/2001")
                .email("adrian@test.com")
                .phone("(81) 998535587")
                .course("Pre Enem")
                .build();

    }
}
