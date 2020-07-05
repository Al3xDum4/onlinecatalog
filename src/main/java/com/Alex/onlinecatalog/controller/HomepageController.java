package com.Alex.onlinecatalog.controller;

import com.Alex.onlinecatalog.model.SchoolGroup;
import com.Alex.onlinecatalog.service.SchoolGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Comparator;
import java.util.List;

@Controller
public class HomepageController {

    @Autowired
    private SchoolGroupService schoolGroupService;

    @GetMapping("homeallschoolgroups")
    public String showHomeAllSchoolGroups(Model model) {
        List<SchoolGroup> schoolGroupList = schoolGroupService.findAll();
        model.addAttribute("homeschoolgroups", schoolGroupList);
        model.addAttribute("byGroupName", Comparator.comparing(SchoolGroup::getGroupName));
        return "homepage/showhomepage";
    }

    @GetMapping("/home/group/{id}/students")
    public String viewHomeStudentsInGroup(Model model, @PathVariable Integer id) {
        model.addAttribute("students", schoolGroupService.findStudentsByGroup(id));
        return "schoolgroup/viewstudents";
    }

    @GetMapping("/home/group/{id}/disciplines")
    public String viewHomeDisciplinesInGroup(Model model, @PathVariable Integer id) {
        model.addAttribute("disciplines", schoolGroupService.findDisciplinesByGroup(id));
        return "schoolgroup/viewdisciplines";
    }

//    @GetMapping("/home/group/{id}/professors")
//    public String viewHomeProfessorsInGroup(Model model, @PathVariable Integer id) {
//        model.addAttribute("professors", schoolGroupService.findProfessorsByGroup(id));
//        return "schoolgroup/viewprofessors";
//    }

}
