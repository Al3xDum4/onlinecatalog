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

//    @Query("SELECT s FROM SchoolGroup s JOIN FETCH s.professors")
//    List<Professor> findAllProfessorsByGroup(@Param("groupId") Integer groupId);
    
}
