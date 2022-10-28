package com.skypro.introductiontodatabases.repository;

import com.skypro.introductiontodatabases.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    Collection<Student> findAllByAge(int age);
}
