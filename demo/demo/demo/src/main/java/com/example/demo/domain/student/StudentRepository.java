package com.example.demo.domain.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {
    @Query(nativeQuery = true,value = "SELECT * FROM student WHERE startingYear=:year")
    List<Student> findByYear(Long year);
    @Query(nativeQuery = true,value = "SELECT * FROM student WHERE indexNumber=:index AND startingYear=:year")
    Student findByIndeks(Long index,Long year);
}
