package com.example.demo.controllers.student.dto;

import com.example.demo.domain.student.Student;
import lombok.Getter;

import java.time.LocalDate;
import java.time.Period;

@Getter
public class StudentM {
    private final String name;
    private final String email;
    private final Integer age;
    private final String indeks;
    public StudentM(Student student)
    {
        this.name=student.getFirstName().trim()+
                " "+
                student.getLastName().trim();
        this.email=student.getEmail();
        this.age= Period.between(
                student.getDob(), LocalDate.now()
        ).getYears();
        this.indeks=student.getIndexNumber()+
                "/"+
                student.getStartingYear();
    }
}
