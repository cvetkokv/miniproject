package com.example.demo.controllers.classes;

import com.example.demo.controllers.classes.dto.ClassesM;
import com.example.demo.controllers.classes.dto.ClassesParam;
import com.example.demo.domain.classes.Classes;
import com.example.demo.domain.student.Student;
import com.example.demo.services.ClassesService;
import com.example.demo.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.stream.Collectors;

@Validated
@RestController
@RequestMapping(path = "/api/classes")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClassesController {
    private final ClassesService classesService;
    private final StudentService studentService;
    @PostMapping("addClas")
    public void addNewClass(@RequestBody ClassesParam param)
    {
        Classes newClass = new Classes();
        newClass.setName(param.getName());
        classesService.saveClass(newClass);
    }

    @PutMapping("/addStudentToClass/{id}")
    public void addStudentToClass(
            @PathVariable Long id,
            @RequestParam String indeks
    ){
        Student student = studentService.findByIndex(indeks);
        Classes klas = classesService.findById(id);
        klas.getStudents().add(student);
        klas.setStudents(klas.getStudents());
        classesService.saveClass(klas);
    }

    @DeleteMapping("/deleteClass/{id}")
    public void deleteClass(@PathVariable Long id)
    {
        Classes klas = classesService.findById(id);
        classesService.deleteClass(klas);
        //studentService.saveAll(klas.getStudents());
    }

    @GetMapping("/getClasses")
    public Map<String,ClassesM> getClasses()
    {
        return  classesService.findAll().stream()
                .collect(Collectors.toMap(Classes::getName,ClassesM::new));
    }

    @DeleteMapping("/deleteStudent")
    public void deleteStudent(@RequestParam String indeks)
    {
        classesService.removeStudent(
                studentService.findByIndex(indeks)
        );
    }
}
