package com.Alex.onlinecatalog.controller;

import com.Alex.onlinecatalog.model.Discipline;
import com.Alex.onlinecatalog.model.DisciplineDTO;
import com.Alex.onlinecatalog.model.SchoolGroup;
import com.Alex.onlinecatalog.service.DisciplineService;
import com.Alex.onlinecatalog.service.SchoolGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
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
        model.addAttribute("discipline", new DisciplineDTO()); // initial bind with the form, to say to the webpage what is the type of student th:object
        return "discipline/adddiscipline";
    }

    @PostMapping("/adddiscipline")
    public String addDiscipline(@ModelAttribute DisciplineDTO discipline, SchoolGroup schoolGroup) {
        //discipline.setSchoolGroups(discipline.getSchoolGroups());
        //discipline.setSchoolGroups(schoolGroups);
//        disciplineService.save(discipline);
        Discipline discipline1 = new Discipline();
        List<SchoolGroup> list = new ArrayList<>();
        discipline1.setDisciplineName(discipline.getDisciplineName());
        for (int i = 0; i < discipline.getSchoolGroups().length; i++) {
            int a = Integer.parseInt(discipline.getSchoolGroups()[i]);
            SchoolGroup schoolGroup1 = schoolGroupService.findById(a);
            if (!(schoolGroup1 == null)) {
                list.add(schoolGroup1);
            }
        }
        discipline1.setSchoolGroups(list);
        disciplineService.save(discipline1);
        System.out.println(Arrays.toString(discipline.getSchoolGroups()));
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
