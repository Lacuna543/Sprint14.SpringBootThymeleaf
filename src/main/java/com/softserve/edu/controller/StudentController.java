package com.softserve.edu.controller;

import com.softserve.edu.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@Data
@AllArgsConstructor
public class StudentController {

    private UserService userService;

    @GetMapping("/students")
    public String getAllMarathons(Model model) {
        model.addAttribute("users", userService.getAll());
        return "students";

    }

}
