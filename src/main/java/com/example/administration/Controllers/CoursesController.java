package com.example.administration.Controllers;

import com.example.administration.Interfaces.CourseInterface;
import com.example.administration.Models.CourseModel;
import com.example.administration.Repositories.CourseRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CoursesController
{
    private final String BASE_PATH = "/Administration/course/";
    private CourseInterface repository = new CourseRepository();
    private static final String BASE_MAPPING = "/Administration/courses";

    @RequestMapping(value = {BASE_MAPPING, BASE_MAPPING + "/"}, method = RequestMethod.GET)
    public String index(Model model) {
        List<CourseModel> list = repository.get();
        model.addAttribute("courses", list);

        return BASE_PATH + "index";
    }

    @RequestMapping(value = BASE_MAPPING + "/details", method = RequestMethod.GET)
    public String details(@RequestParam int id, Model model) {
        model.addAttribute("course", this.repository.get(id));

        return BASE_PATH + "details";
    }

    @RequestMapping(value = BASE_MAPPING + "/create", method = RequestMethod.GET)
    public String create(Model model) {
        model.addAttribute("course", new CourseModel());
        return BASE_PATH + "create";
    }

    @RequestMapping(value = BASE_MAPPING + "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute CourseModel entity) {
        if (this.repository.insert(entity)) {
            return "redirect:" + BASE_MAPPING;
        }
        return BASE_PATH + "create";
    }

    @RequestMapping(value = BASE_MAPPING + "/update", method = RequestMethod.GET)
    public String update(@RequestParam("id") int id, Model model) {
        model.addAttribute("course", repository.get(id));
        return BASE_PATH + "/update";
    }

    @RequestMapping(value = BASE_MAPPING + "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute CourseModel entity) {
        if (repository.update(entity)) {
            return "redirect:" + BASE_MAPPING;
        }
        return BASE_PATH + "/update";
    }
}
