package com.skypro.introductiontodatabases.service;

import com.skypro.introductiontodatabases.component.RecordMapper;
import com.skypro.introductiontodatabases.exeption.FacultyNotFoundException;
import com.skypro.introductiontodatabases.exeption.StudentNotFoundException;
import com.skypro.introductiontodatabases.model.Faculty;
import com.skypro.introductiontodatabases.model.Student;
import com.skypro.introductiontodatabases.record.FacultyRecord;
import com.skypro.introductiontodatabases.record.StudentRecord;
import com.skypro.introductiontodatabases.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final RecordMapper recordMapper;

    public StudentService(StudentRepository studentRepository, RecordMapper recordMapper) {
        this.studentRepository = studentRepository;
        this.recordMapper = recordMapper;
    }

    public StudentRecord create(StudentRecord studentRecord) {
        return recordMapper.toRecord(studentRepository.save(recordMapper.toEntity(studentRecord)));
    }

    public StudentRecord read(long id) {
        return recordMapper.toRecord(studentRepository.findById(id).orElseThrow(()->new StudentNotFoundException(id)));
    }

    public StudentRecord update(long id,
                                StudentRecord studentRecord) {
        Student oldStudent = studentRepository.findById(id).orElseThrow(()->new StudentNotFoundException(id));
        oldStudent.setName(studentRecord.getName());
        oldStudent.setAge(studentRecord.getAge());
        return recordMapper.toRecord(studentRepository.save(oldStudent));
    }

    public StudentRecord delete(long id) {
        Student student = studentRepository.findById(id).orElseThrow(()->new StudentNotFoundException(id));
        studentRepository.delete(student);
        return recordMapper.toRecord(student);
    }

    public Collection<StudentRecord> findByAge(int age) {
        return studentRepository.findAllByAge(age).stream()
                .map(recordMapper::toRecord)
                .collect(Collectors.toList());
    }

}
