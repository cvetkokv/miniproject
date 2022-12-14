package com.example.demo.controllers.student.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter

public class StudentParams {
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dob;


}
