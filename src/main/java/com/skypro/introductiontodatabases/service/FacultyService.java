package com.skypro.introductiontodatabases.service;

import com.skypro.introductiontodatabases.component.RecordMapper;
import com.skypro.introductiontodatabases.exeption.FacultyNotFoundException;
import com.skypro.introductiontodatabases.model.Faculty;
import com.skypro.introductiontodatabases.record.FacultyRecord;
import com.skypro.introductiontodatabases.repository.FacultyRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;
    private final RecordMapper recordMapper;

    public FacultyService(FacultyRepository facultyRepository, RecordMapper recordMapper) {
        this.facultyRepository = facultyRepository;
        this.recordMapper = recordMapper;
    }

    public FacultyRecord create(FacultyRecord facultyRecord) {
        return recordMapper.toRecord(facultyRepository.save(recordMapper.toEntity(facultyRecord)));
    }

    public FacultyRecord read(long id) {
        return recordMapper.toRecord(facultyRepository.findById(id).orElseThrow(()->new FacultyNotFoundException(id)));
    }

    public FacultyRecord update(long id,
                                FacultyRecord facultyRecord) {
        Faculty oldFaculty = facultyRepository.findById(id).orElseThrow(()->new FacultyNotFoundException(id));
        oldFaculty.setName(facultyRecord.getName());
        oldFaculty.setColor(facultyRecord.getColor());
        return recordMapper.toRecord(facultyRepository.save(oldFaculty));
    }

    public FacultyRecord delete(long id) {
        Faculty faculty = facultyRepository.findById(id).orElseThrow(()->new FacultyNotFoundException(id));
        facultyRepository.delete(faculty);
        return recordMapper.toRecord(faculty);
    }

    public Collection<FacultyRecord> findByColor(String color) {
        return facultyRepository.findAllByColor(color).stream()
                .map(recordMapper::toRecord)
                .collect(Collectors.toList());
    }
}
