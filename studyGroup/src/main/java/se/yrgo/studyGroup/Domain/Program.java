package se.yrgo.studyGroup.Domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Program {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String programName;
    @OneToMany(mappedBy = "program")
    List<Student> studentList;


    public Program(String programName) {
        this.programName = programName;
    }

    public Program() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
