package com.example.demo.services;

import com.example.demo.domain.student.Student;
import com.example.demo.domain.student.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class StudentService {
    private final StudentRepository studentRepository;

    @Transactional
    public Student insertStudent(Student student)
    {
        if(
                ((List<Student>)studentRepository.findAll()).stream()
                        .filter(f->f.getStartingYear().equals(
                                Long.valueOf(
                                        LocalDate.now().getYear()
                                )
                        ))
                        .collect(Collectors.toList())
                        .size()!=0
        ){
            List<Student> thisYearStudents=((List<Student>)studentRepository.findAll()).stream()
                    .filter(f->f.getStartingYear().equals(
                            Long.valueOf(
                                    LocalDate.now().getYear()
                            )
                    )).collect(Collectors.toList());

            student.setIndexNumber(
                    thisYearStudents
                            .get(thisYearStudents.size()-1)
                            .getIndexNumber()+1
            );
        }else{
            student.setIndexNumber(1L);
        }
        student.setStartingYear(
                Long.valueOf(LocalDate.now().getYear())
                );
       return studentRepository.save(student);
    }
    @Transactional
    public void saveAll(List<Student> students)
    {
        studentRepository.saveAll(students);
    }
    @Transactional
    public List<Student> findAll()
    {
        return ((List<Student>) studentRepository.findAll());
    }

    @Transactional
    public Student findByIndex(String indeks)
    {
        Long indexNumber =Long.valueOf(
                indeks.trim().split("/")[0]
        );
        Long startingYear = Long.valueOf(
                indeks.trim().trim().split("/")[1]
        );
        return studentRepository.findByIndeks(indexNumber,startingYear);
    }

    @Transactional
    public void deleteStudent(Student student)
    {
        studentRepository.delete(student);
    }


}
