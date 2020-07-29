package com.softserve.edu.controller;


import com.softserve.edu.model.Marathon;
import com.softserve.edu.service.MarathonService;
import com.softserve.edu.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Data
@AllArgsConstructor
public class MarathonController {
    private MarathonService marathonService;
    private UserService userService;

    @GetMapping("/marathons")
    public String getAllMarathons(Model model) {
        model.addAttribute("marathons", marathonService.getAll());
        return "marathons";
    }

    @GetMapping("/marathons/create")
    public String createMarathons(Model model) {
        model.addAttribute("marathon", new Marathon());
        return "createMarathon";
    }

    @PostMapping("/marathons/create")
    public String createMarathons(@ModelAttribute Marathon marathon, Model model) {
        model.addAttribute(marathonService.createOrUpdate(marathon));
        return "redirect:/marathons";
    }

    @GetMapping("/marathons/edit/{id}")
    public String editMarathon(@PathVariable("id") Long id, Model model) {
        model.addAttribute("marathon", marathonService.getMarathonById(id));
        return "editMarathon";
    }

    @PostMapping("/marathons/edit/{id}")
    public String saveMarathon(@PathVariable("id") Long id, @ModelAttribute Marathon marathon, Model model) {
        model.addAttribute("marathon", marathonService.createOrUpdate(marathon));
        return "redirect:/marathons";
    }

    @GetMapping("/marathons/close/{id}")
    public String closeMarathons(@PathVariable("id") Long id) {
        marathonService.deleteMarathonById(id);
        return "redirect:/marathons";
    }

    @GetMapping("/marathons/marathon/{id}")
    public String marathon(@PathVariable("id") Long id, Model model) {
        Marathon marathon = marathonService.getMarathonById(id);
        model.addAttribute("marathon", marathon);
        return "marathon";
    }

}
