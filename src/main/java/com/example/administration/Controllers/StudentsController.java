package com.example.administration.Controllers;

import com.example.administration.Interfaces.StudentInterface;
import com.example.administration.Models.StudentModel;
import com.example.administration.Repositories.StudentRepository;
import com.example.administration.Static.DAOConfig;
import com.example.administration.Static.ModelsHandler;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class StudentsController
{
    // Variables
    //  - Repository
    private StudentInterface studentRepository;
    private DAOConfig config;
    private static final String BASE_MAPPING = "/Administration/students", BASE_PATH = "/Administration/student";

    public StudentsController()
    {
        config = new DAOConfig();
        studentRepository = new StudentRepository(config.getDataSource());
    }

    @GetMapping({BASE_MAPPING, BASE_MAPPING + "/"})
    public String studentsTable(Model model) {
        List<StudentModel> list = studentRepository.get();

        model.addAttribute("students", list);
        return BASE_PATH + "/index";
    }

    @GetMapping(BASE_MAPPING + "/create")
    public String create(Model model) {
        model.addAttribute("studentModel", new StudentModel());
        return BASE_PATH + "/create";
    }

    @PostMapping(BASE_MAPPING + "/create")
    public String create(@ModelAttribute("studentModel") StudentModel studentModel, BindingResult bindingResult) {
        System.out.println("Create post");
        if (bindingResult.hasErrors()) {
            System.out.println("In the if");
            System.out.println("Bug bingding result");
            System.out.println(bindingResult);
            System.out.println("Binding result Create student getData: " + studentModel);
            return "redirect:" + BASE_MAPPING + "/create";
        }
        System.out.println("Student to create: " + studentModel);
        studentRepository.insert(studentModel);
        return "redirect:" + BASE_MAPPING;
    }

    @GetMapping(BASE_MAPPING + "/details")
    public String details(@RequestParam("id") int id, Model model) {
        System.out.println("student by id: " + studentRepository.get(id));
        model.addAttribute("student", studentRepository.get(id));
        return BASE_PATH + "/details";
    }

    @GetMapping(BASE_MAPPING + "/delete")
    public String delete(@RequestParam("id")int id, Model model) {
        model.addAttribute("student", studentRepository.get(id));
        return BASE_PATH + "/delete";
    }

    @PostMapping(BASE_MAPPING + "/delete")
    public String delete(@ModelAttribute StudentModel student) {
        studentRepository.delete(student.getStudID());
        return "redirect:" + BASE_MAPPING;
    }

    @GetMapping(BASE_MAPPING + "/update")
    public String update(@RequestParam("id")int id, Model model) {
        model.addAttribute("student", studentRepository.get(id));
        return BASE_PATH + "/update";
    }

    @PostMapping(BASE_MAPPING + "/update")
    public String update(@ModelAttribute("student") StudentModel student) {
        studentRepository.update(student);
        return "redirect:" + BASE_MAPPING;
    }

    // IS not Needed
    // An example of how to create bindings to complex Types (Date, Classes, etc...)
    /*
    @InitBinder
    public void dateBinder(WebDataBinder binder) {
        System.out.println("Jaaa jeg er i en init binder");
        //The date format to parse or output your dates
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //Create a new CustomDateEditor
        CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
        //Register it as custom editor for the Date type
        binder.registerCustomEditor(Date.class, editor);
    }
    */
}
