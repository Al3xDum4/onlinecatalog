package com.Alex.onlinecatalog.repository;

import com.Alex.onlinecatalog.model.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface DisciplineRepository extends JpaRepository<Discipline, String> {
}
