package se.yrgo.studyGroup.Controller;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import se.yrgo.studyGroup.Domain.Student;
import se.yrgo.studyGroup.Repository.ProgramRepository;
import se.yrgo.studyGroup.Repository.StudentRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
public class StudentController {

    StudentRepository studentRepository;
    ProgramRepository programRepository;

    public StudentController(StudentRepository studentRepository, ProgramRepository programRepository) {
        this.studentRepository = studentRepository;
        this.programRepository = programRepository;
    }

    public ResponseEntity<Student> createStudent(@RequestParam("name")String name,@RequestParam("gender")String gender) {

        Student student = new Student(name,gender);

        studentRepository.save(student);

        return ResponseEntity.ok(student);
    }



    public ResponseEntity<List<Student>> getListOfStudents(){

        List<Student> studentList =  studentRepository.findAll();

        return ResponseEntity.ok(studentList);
    }


    public ResponseEntity<List<Object[]>> getListOfStudentsAndTheirProgram(){

      List<Object[]> objects = studentRepository.findStudentsAndTheirProgram();



        return ResponseEntity.ok(objects);
    }







}
