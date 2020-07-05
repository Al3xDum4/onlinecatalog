package com.Alex.onlinecatalog.repository;

import com.Alex.onlinecatalog.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProfessorRepository extends JpaRepository<Professor,Integer> {
}
