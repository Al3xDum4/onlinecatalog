package com.Alex.onlinecatalog.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Student {
    private String firstName;
    private String lastName;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private SchoolGroup schoolGroup;

    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "student_grades", joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "grade_id"))
    private List<Grade> grades;

    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "student_discipline", joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "discipline_id"))
    private List<Discipline> disciplines;

}
