package com.skypro.introductiontodatabases.controller;

import com.skypro.introductiontodatabases.model.Student;
import com.skypro.introductiontodatabases.record.StudentRecord;
import com.skypro.introductiontodatabases.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public StudentRecord create(@RequestBody StudentRecord studentRecord) {
        return studentService.create(studentRecord);
    }

    @GetMapping("/{id}")
    public StudentRecord read(@PathVariable long id) {
        return studentService.read(id);
    }

    @PutMapping("/{id}")
    public StudentRecord update(@PathVariable long id,
                          @RequestBody StudentRecord studentRecord) {
        return studentService.update(id,studentRecord);
    }

    @DeleteMapping ("/{id}")
    public StudentRecord delete(@PathVariable long id) {
        return studentService.delete(id);
    }

    @GetMapping
    public Collection<StudentRecord> findByAge(@RequestParam int age) {
        return studentService.findByAge(age);
    }



}
