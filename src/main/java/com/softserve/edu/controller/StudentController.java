package com.softserve.edu.controller;

import com.softserve.edu.model.Marathon;
import com.softserve.edu.model.User;
import com.softserve.edu.service.MarathonService;
import com.softserve.edu.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
@Data
@AllArgsConstructor
public class StudentController {

    private UserService userService;
    private MarathonService marathonService;

    @GetMapping("/students")
    public String getAllMarathons(Model model) {
        model.addAttribute("users", userService.getAll());
        return "students";

    }
    @GetMapping("students/{marathonId}/delete/{userId}")
    public String deleteUser(@PathVariable(name="marathonId") Long marathonId, @PathVariable(name="userId") Long userId) {

       Marathon m = marathonService.getMarathonById(marathonId);
       User stud = userService.getUserById(userId);
       userService.deleteUserFromMarathon(stud, m);
       return "redirect:/students";
    }



}
