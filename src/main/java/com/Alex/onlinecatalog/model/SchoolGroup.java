package com.Alex.onlinecatalog.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class SchoolGroup {
    private String groupName;
    private Date groupYear;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int groupId;

    /*
    * avem deja maparea facuta pt ca pareta detinatoare
    * a relatiei este entitatea Students in tabelul relational
    * al entitatii fiind gestionata coloana FK.
    *
    * In aceasta entitate, prin mappedBy, se creaza maparea bidirectionala a entitatilor,
    * lista de studenti o folosim pt a obtine informatiile despre studenti in entitatea group.
    *
    * cascade - daca un grup este sters, se sterg odata cu el si asocierile studentilor acelui grup,
    * in cazul de fata aplicabil pe toate operatile de persistenta asupra entitatii
    */
    @OneToMany(mappedBy = "schoolGroup", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Student> students;

    /*
    * tabel suplimentar, il numim prin atributul name (group_discipline).
    * coloana alaturata la entitate este group_id (prin JoinColumn),
    * iar coloana inversa este discipline_id
    */
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinTable(name = "group_discipline", joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "discipline_id"))
    private List<Discipline> disciplines;
}
