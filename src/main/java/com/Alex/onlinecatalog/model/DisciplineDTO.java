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
public class DisciplineDTO {

    private String disciplineName;


    private List<Professor> professors;


    private List<Student> students;


    private String[] schoolGroups;
}
