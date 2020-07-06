package com.Alex.onlinecatalog;

import com.Alex.onlinecatalog.model.Discipline;
import com.Alex.onlinecatalog.model.SchoolGroup;
import com.Alex.onlinecatalog.model.Student;
import com.Alex.onlinecatalog.repository.*;
import com.Alex.onlinecatalog.service.SendGridEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//TODO: discipline , grade + legaturile cu celelalte clase
//TODO: display of the pages (CSS, HTML)
//TODO: !!!only display year in school group , not the entire date. Only select year in date picker (edited)!!!
//TODO: fix problem in nav between <img> and <span>
//TODO: to be sure that username is unique

@SpringBootApplication
public class OnlinecatalogApplication implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private DisciplineRepository disciplineRepository;
    @Autowired
    private GradeRepository gradeRepository;
    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private SchoolGroupRepository schoolGroupRepository;
    @Autowired
    private SendGridEmailService sendGridEmailService;
    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) { SpringApplication.run(OnlinecatalogApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        try {
            userRepository.deleteById(1);
        }
        catch (Exception ex) {

        }
        //sendGridEmailService.sendHTML("buhaidebalta.15@gmail.com","buhaidebalta.15@gmail.com","Hello from the other side!","Hello!");
//        Student student = new Student();
//        student.setFirstName("John");
//        student.setLastName("Doe");
//
//        Student student2 = new Student();
//        student2.setFirstName("John");
//        student2.setLastName("Doe");
//
//        studentRepository.save(student);
//        studentRepository.save(student2);
//
//        for (Student s : studentRepository.findAll()) {
//            System.out.println(s.getStudentId() + " " + s.getFirstName() + " " + s.getLastName());
//        }
//
//        Discipline discipline = new Discipline();
//        discipline.setDisciplineName("Matematica VIII");
//
//        Discipline discipline1 = new Discipline();
//        discipline1.setDisciplineName("Limba si Literatura Roamana VIII");
//
//        disciplineRepository.save(discipline);
//        disciplineRepository.save(discipline1);
//
//        for (Discipline d: disciplineRepository.findAll()) {
//            System.out.println(d.getDisciplineName());
//        }
    }
}
