package se.yrgo.studyGroup.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import se.yrgo.studyGroup.Domain.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findbyname(String name);

    @Query("SELECT s.name,s.program,s.class  from Student as s left join Program as p")
    List<Object[]> findStudentsAndTheirProgram();
}
