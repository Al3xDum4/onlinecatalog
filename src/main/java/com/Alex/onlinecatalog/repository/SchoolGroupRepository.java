package com.Alex.onlinecatalog.repository;

import com.Alex.onlinecatalog.model.PendingUser;
import com.Alex.onlinecatalog.model.SchoolGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface SchoolGroupRepository extends JpaRepository<SchoolGroup, Integer> {
    @Query("FROM SchoolGroup s where s.group_id = :professor")
    Optional<SchoolGroup> findByUsername(@Param("username") String username);
}
