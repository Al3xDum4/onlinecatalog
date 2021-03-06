package com.Alex.onlinecatalog.controller;

import com.Alex.onlinecatalog.model.Professor;
import com.Alex.onlinecatalog.model.SchoolGroup;
import com.Alex.onlinecatalog.service.DisciplineService;
import com.Alex.onlinecatalog.service.ProfessorService;
import com.Alex.onlinecatalog.service.SchoolGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @Autowired
    private SchoolGroupService schoolGroupService;

    @Autowired
    private DisciplineService disciplineService;

    @GetMapping("allprofessors")
    public String showAllProfessors(Model model) {
        List<Professor> professorList = professorService.findAll();
        model.addAttribute("professors", professorList);
        return "professor/showallprofessors";
    }

    @GetMapping("/addprofessor")
    public String addProfessor(Model model) {
        model.addAttribute("schoolgroups", schoolGroupService.findAll());
        model.addAttribute("disciplines", disciplineService.findAll());
        model.addAttribute("professor", new Professor()); // initial bind with the form, to say to the webpage what is the type of student th:object
        return "professor/addprofessor";
    }

    @PostMapping("/addprofessor")
    public String addProfessor(@ModelAttribute Professor professor) {
//        System.out.println(student);
        professorService.save(professor);
        return "redirect:/allprofessors";
    }

    @GetMapping("/editprofessor/{id}")
    public String editProfessor(Model model, @PathVariable Integer id) {
        Professor professor = professorService.findById(id);
        model.addAttribute("professor", professor); // initial bind with the form, to say to the webpage what is the type of student th:object
        model.addAttribute("schoolgroups", schoolGroupService.findAll());
        return "professor/editprofessor";
    }

    @PostMapping("/editprofessor/{id}")
    public String editProfessor(@ModelAttribute Professor professor, SchoolGroup schoolGroup, @PathVariable Integer id) {
//        Professor database_professor = professorService.findById(id); // ti be able to update that id, get it from database
//        database_professor.setLastName(professor.getLastName()); // update fields
//        database_professor.setFirstName(professor.getFirstName());
//        System.out.println(database_professor);
//        professor.setLastName(professor.getLastName());
//        professor.setFirstName(professor.getFirstName());
//        professor.setDiscipline(professor.getDiscipline());
        professorService.save(professor); // save it again. SAVE acts as UPDATE
//        return "redirect:/editstudent/"+id;
        return "redirect:/allprofessors";
    }

    @GetMapping("/deleteprofessor/{id}")
    public String deleteProfessor(@PathVariable Integer id) {
        professorService.deleteById(id);
        return "redirect:/allprofessors"; // forward
    }
}
