package com.example.demo.controllers.student;

import com.example.demo.controllers.student.dto.StudentM;
import com.example.demo.controllers.student.dto.StudentParams;
import com.example.demo.domain.student.Student;
import com.example.demo.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/student")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class StudentController {
    private final StudentService studentService;
    @PostMapping("/insertStudent")
    public Long insertStudent(@RequestBody StudentParams student)
    {
        Student newStudent = new Student();
        newStudent.setFirstName(student.getFirstName());
        newStudent.setLastName(student.getLastName());
        newStudent.setEmail(student.getEmail());
        newStudent.setDob(student.getDob());
        return studentService.insertStudent(newStudent).getId();
    }
    @GetMapping("/allStudents")
    public List<StudentM> getAll()
    {
            return studentService.findAll().stream()
                    .map(StudentM::new)
                    .collect(Collectors.toList());
    }
    @GetMapping("/byIndex")
    public StudentM getStudentByIndex(@RequestParam String indeks)
    {

        return new StudentM(
                studentService.findByIndex(indeks)
        );
    }

    @DeleteMapping("/removeStudent/{indeks}")
    public void removeStudent(@RequestParam String indeks)
    {
        studentService.deleteStudent(
                studentService.findByIndex(indeks)
        );
    }


}
