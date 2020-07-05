package com.Alex.onlinecatalog.service;

import com.Alex.onlinecatalog.model.Discipline;
import com.Alex.onlinecatalog.model.SchoolGroup;
import com.Alex.onlinecatalog.model.Student;
import com.Alex.onlinecatalog.repository.DisciplineRepository;
import com.Alex.onlinecatalog.repository.SchoolGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("IDisciplineService")
public class DisciplineService {
    @Autowired
    private DisciplineRepository disciplineRepository;

    public List<Discipline> findAll() {
        return disciplineRepository.findAll();
    }

    public void save(Discipline discipline) {
        disciplineRepository.save(discipline);
    }

    public Discipline findById(String id) {
        Optional<Discipline> discipline = disciplineRepository.findById(id);
        if (discipline.isPresent()) {
            return discipline.get();
        }
        return null;
    }

    public void deleteById(String id) {
        disciplineRepository.deleteById(id);
    }

    public List<Student> findStudentsByGroup(String id) {
        //TODO: try catch / check if present
        return disciplineRepository.findById(id).get().getStudents();
    }
}
