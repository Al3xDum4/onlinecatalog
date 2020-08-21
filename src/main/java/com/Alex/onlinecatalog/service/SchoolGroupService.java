package com.Alex.onlinecatalog.service;

import com.Alex.onlinecatalog.model.Discipline;
import com.Alex.onlinecatalog.model.Professor;
import com.Alex.onlinecatalog.model.SchoolGroup;
import com.Alex.onlinecatalog.model.Student;
import com.Alex.onlinecatalog.repository.ProfessorRepository;
import com.Alex.onlinecatalog.repository.SchoolGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("ISchoolGroupService")
public class SchoolGroupService {

    @Autowired
    private SchoolGroupRepository schoolGroupRepository;

    public List<SchoolGroup> findAll() {
        return schoolGroupRepository.findAll();
    }

    public void save(SchoolGroup schoolGroup) {
        schoolGroupRepository.save(schoolGroup);
    }

    public SchoolGroup findById(Integer id) {
        Optional<SchoolGroup> schoolGroup = schoolGroupRepository.findById(id);
        if (schoolGroup.isPresent()) {
            return schoolGroup.get();
        }
        return null;
    }

    public void deleteById(Integer id) {
        schoolGroupRepository.deleteById(id);
    }

    public List<Student> findStudentsByGroup(Integer id) {
        return schoolGroupRepository.findById(id).get().getStudents();
    }

    public List<Discipline> findDisciplinesByGroup(Integer id) {
        return schoolGroupRepository.findById(id).get().getDisciplines();
    }

    public List<Professor> findAllProfessorsByGroup(Integer id){
        return schoolGroupRepository.findAllProfessorsByGroup(id);
    }
}
