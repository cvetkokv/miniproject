package com.example.demo.domain.student;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "student",indexes = {
        @Index(columnList = "email",unique = true,name = "email_index")
})
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private String firstName;
    private String lastName;
    @NotNull
    private String email;
    private LocalDate dob;
    @NotNull
    private Long indexNumber;
    @NotNull
    private Long startingYear;

    public Student(Student student) {
        this.firstName = student.firstName;
        this.lastName = student.lastName;
        this.email = student.email;
        this.dob = student.dob;
        this.indexNumber=student.getIndexNumber();
        this.startingYear=student.getStartingYear();
    }


}
