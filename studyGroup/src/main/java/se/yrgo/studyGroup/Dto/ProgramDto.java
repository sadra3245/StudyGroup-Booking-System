package se.yrgo.studyGroup.Dto;

import se.yrgo.studyGroup.Domain.Student;

import java.util.List;

public record ProgramDto(Long id, List<String> programName) {
}
