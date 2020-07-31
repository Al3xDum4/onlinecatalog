package com.Alex.onlinecatalog.controller;

import com.Alex.onlinecatalog.model.Discipline;
import com.Alex.onlinecatalog.model.SchoolGroup;
import com.Alex.onlinecatalog.service.DisciplineService;
import com.Alex.onlinecatalog.service.SchoolGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DisciplineController {
    @Autowired
    private DisciplineService disciplineService;

    @Autowired
    private SchoolGroupService schoolGroupService;

    @GetMapping("alldisciplines")
    public String showAllDisciplines(Model model) {
        List<Discipline> disciplineList = disciplineService.findAll();
        model.addAttribute("disciplines", disciplineList);
        return "discipline/showalldisciplines";
    }

    @GetMapping("/adddiscipline")
    public String addDiscipline(Model model) {
        model.addAttribute("schoolgroups", schoolGroupService.findAll());
        //System.out.println(schoolGroupService.findAll());
        model.addAttribute("discipline", new Discipline()); // initial bind with the form, to say to the webpage what is the type of student th:object
        return "discipline/adddiscipline";
    }

    @PostMapping("/adddiscipline")
    public String addDiscipline(@ModelAttribute Discipline discipline, SchoolGroup schoolGroup) {
        //discipline.setSchoolGroups(discipline.getSchoolGroups());
        //discipline.setSchoolGroups(schoolGroups);
        disciplineService.save(discipline);
        return "redirect:/alldisciplines";
    }

    @GetMapping("/editdiscipline/{id}")
    public String editDiscipline(Model model, @PathVariable String id) {
        Discipline discipline = disciplineService.findById(id);
        model.addAttribute("discipline", discipline); // initial bind with the form, to say to the webpage what is the type of student th:object
        model.addAttribute("schoolgroups", schoolGroupService.findAll());
        return "discipline/editdiscipline";
    }

    @PostMapping("/editdiscipline/{id}")
    public String editDiscipline(@ModelAttribute Discipline discipline, SchoolGroup schoolGroup, @PathVariable String id) {
//        Discipline database_discipline = disciplineService.findById(id); // ti be able to update that id, get it from database
//        database_discipline.setDisciplineName(discipline.getDisciplineName()); // update fields
//        System.out.println(database_discipline);
        discipline.setDisciplineName(discipline.getDisciplineName());
        disciplineService.save(discipline); // save it again. SAVE acts as UPDATE
//        return "redirect:/editstudent/"+id;
        return "redirect:/alldisciplines";
    }

    @GetMapping("/deletediscipline/{id}")
    public String deleteDiscipline(@PathVariable String id) {
        disciplineService.deleteById(id);
        return "redirect:/alldisciplines"; // forward
    }

//    @GetMapping("/group/{id}/students")
//    public String viewStudentsInGroup(Model model, @PathVariable Integer id) {
//        model.addAttribute("students", disciplineService.findStudentsByGroup(id));
//        return "discipline/viewstudents";
//    }
}
