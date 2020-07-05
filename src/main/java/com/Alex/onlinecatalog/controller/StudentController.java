package com.Alex.onlinecatalog.controller;

import com.Alex.onlinecatalog.model.SchoolGroup;
import com.Alex.onlinecatalog.model.Student;
import com.Alex.onlinecatalog.service.SchoolGroupService;
import com.Alex.onlinecatalog.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private SchoolGroupService schoolGroupService;

    @GetMapping("allstudents")
    public String showAllStudents(Model model) {
        List<Student> studentList = studentService.findAll();
        model.addAttribute("students", studentList);
        return "student/showallstudents";
    }

    @GetMapping("/addstudent")
    public String addStudent(Model model) {
        model.addAttribute("schoolgroups", schoolGroupService.findAll());
        model.addAttribute("student", new Student()); // initial bind with the form, to say to the webpage what is the type of student th:object
        return "student/addstudent";
    }

    @PostMapping("/addstudent")
    public String addStudent(@ModelAttribute Student student, RedirectAttributes attributes) {
//      System.out.println(student);
        studentService.save(student);
        attributes.addFlashAttribute("message","Student name created successfully!");
        return "redirect:/allstudents";
    }

    @GetMapping("/editstudent/{id}")
    public String editStudent(Model model, @PathVariable Integer id) {
        Student student = studentService.findById(id);
        model.addAttribute("student", student); // initial bind with the form, to say to the webpage what is the type of student th:object
        model.addAttribute("schoolgroups", schoolGroupService.findAll());
        return "student/editstudent";
    }

    @PostMapping("/editstudent/{id}")
    public String editStudent(@ModelAttribute Student student, @PathVariable Integer id) {
        studentService.save(student); // save it again. SAVE acts as UPDATE
//      return "redirect:/editstudent/"+id;
        return "redirect:/allstudents";
    }

    @GetMapping("/deletestudent/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        studentService.deleteById(id);
        return "redirect:/allstudents"; // forward
    }
}
