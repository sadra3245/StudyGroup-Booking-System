package se.yrgo.studyGroup.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import se.yrgo.studyGroup.Domain.Program;
import se.yrgo.studyGroup.Domain.Student;
import se.yrgo.studyGroup.Repository.ProgramRepository;
import se.yrgo.studyGroup.Repository.StudentRepository;

import java.util.List;

@Controller
public class ProgramController {

    ProgramRepository programRepository;
    StudentRepository studentRepository;

    public ProgramController(ProgramRepository programRepository, StudentRepository studentRepository) {
        this.programRepository = programRepository;
        this.studentRepository = studentRepository;
    }


    public ResponseEntity<Program> createProgram(@RequestParam("programName")String name) {

        Program program = new Program(name);

        programRepository.save(program);

        return ResponseEntity.ok(program);
    }



    public ResponseEntity<List<Program>> getListOfPrograms(){

        List<Program> programList =  programRepository.findAll();

        return ResponseEntity.ok(programList);
    }


    public ResponseEntity<List<Object[]>> getListOfProgramsAndTheirStudents(){

        List<Object[]> objects = programRepository.findProgramsAndTheirStudents();

        return ResponseEntity.ok(objects);
    }

}
