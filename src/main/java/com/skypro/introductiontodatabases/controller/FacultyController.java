package com.skypro.introductiontodatabases.controller;

import com.skypro.introductiontodatabases.model.Faculty;
import com.skypro.introductiontodatabases.record.FacultyRecord;
import com.skypro.introductiontodatabases.service.FacultyService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/faculties")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public FacultyRecord create(@RequestBody FacultyRecord facultyRecord) {
        return facultyService.create(facultyRecord);
    }

    @GetMapping("/{id}")
    public FacultyRecord read(@PathVariable long id) {
        return facultyService.read(id);
    }

    @PutMapping("/{id}")
    public FacultyRecord update(@PathVariable long id, @RequestBody FacultyRecord facultyRecord) {
        return facultyService.update(id, facultyRecord);
    }

    @DeleteMapping("/{id}")
    public FacultyRecord delete(@PathVariable long id) {
        return facultyService.delete(id);
    }

    @GetMapping
    public Collection<FacultyRecord> findByColor(@RequestParam String color) {
        return facultyService.findByColor(color);
    }
}
