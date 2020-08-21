package com.Alex.onlinecatalog.repository;

import com.Alex.onlinecatalog.model.PendingUser;
import com.Alex.onlinecatalog.model.Professor;
import com.Alex.onlinecatalog.model.SchoolGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SchoolGroupRepository extends JpaRepository<SchoolGroup, Integer> {
//    @Query("FROM SchoolGroup s where s.discipline.id = :firstName")
//    Optional<SchoolGroup> findAllBy(@Param("username") String username);

//    @Query("FROM SchoolGroup s where s.professor.id = :professorId")
//    Optional<SchoolGroup> findAllProfessorsByGroup(@Param("professorId") Integer professorId);

//    @Query("SELECT s, p FROM SchoolGroup s, Professor p WHERE s.professor.professorId = p.professorId")
//    List<Professor> findAllProfessorsByGroup(@Param("groupId") Integer groupId);
}
