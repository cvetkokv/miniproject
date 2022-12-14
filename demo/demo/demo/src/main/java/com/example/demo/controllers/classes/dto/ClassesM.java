package com.example.demo.controllers.classes.dto;

import com.example.demo.controllers.student.dto.StudentM;
import com.example.demo.domain.classes.Classes;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ClassesM {
    private final Long id;
    private final List<StudentM> students;

    public ClassesM(Classes klas) {
        this.id = klas.getId();
        this.students = klas.getStudents().stream()
                .map(StudentM::new)
                .collect(Collectors.toList());
    }
}
