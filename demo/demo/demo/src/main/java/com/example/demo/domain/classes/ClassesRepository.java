package com.example.demo.domain.classes;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassesRepository extends CrudRepository<Classes,Long> {
}
