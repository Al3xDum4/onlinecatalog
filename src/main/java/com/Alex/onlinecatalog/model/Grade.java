package com.Alex.onlinecatalog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Grade {
    private double grade;
    private Date gradeDate;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int gradeId;

    @ManyToMany(mappedBy = "grades")
    private List<Student> students;

}
