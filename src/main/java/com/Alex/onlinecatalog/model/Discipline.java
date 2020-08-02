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
public class Discipline {
    @Id
    private String disciplineName;

    @OneToMany(mappedBy = "discipline", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Professor> professors;

    @ManyToMany(mappedBy = "disciplines")
    @JsonIgnore
    private List<Student> students;

    @ManyToMany(mappedBy = "disciplines")
    @JsonIgnore
    private SchoolGroup[] schoolGroups;
}
