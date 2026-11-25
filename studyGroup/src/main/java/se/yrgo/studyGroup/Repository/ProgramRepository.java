package se.yrgo.studyGroup.Repository;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import se.yrgo.studyGroup.Domain.Program;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

public interface ProgramRepository extends JpaRepository<Program ,Long> {

    Optional<Program> findByProgramName(String programName);

    @Query("SELECT p.programName, s.name, p.studentList  FROM Program as p left join p.studentList s")
   List<Object[]> findProgramsAndTheirStudents();
}
