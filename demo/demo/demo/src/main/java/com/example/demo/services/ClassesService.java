package com.example.demo.services;

import com.example.demo.domain.classes.Classes;
import com.example.demo.domain.classes.ClassesRepository;
import com.example.demo.domain.student.Student;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClassesService {
    private final ClassesRepository classesRepository;

    @Transactional
    public void saveClass(Classes klas)
    {
        classesRepository.save(klas);
    }

    @Transactional
    public Classes findById(Long id)
    {
        return classesRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("No class with such ID"));
    }

    @Transactional
    public void deleteClass(Classes klas)
    {
        classesRepository.deleteById(klas.getId());
    }

    @Transactional
    public List<Classes> findAll()
    {
        return (List<Classes>) classesRepository.findAll();
    }

    @Transactional
    public void removeStudent(Student student)
    {
//        List<Classes> thisStudentClasses = classesRepository.findByStudent(student.getId());
//        for(Classes klas : thisStudentClasses)
//        {
//            klas.getStudents().remove(student);
//        }
    }

}
