package com.softserve.edu.controller;


import com.softserve.edu.service.MarathonService;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Data
public class MarathonController {
    private MarathonService marathonService;
    private UserService userService;

    @GetMapping("/marathons")
    public String getAllMarathons(Model model) {
        //TODO
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

    @GetMapping("/marathons/marathon")
    public String marathon(@PathVariable("id") Long id, Model model) {
     User user = userService.getUserById(id);
       Marathon marathon = marathonService.getMarathonById(id);
     userService.addUserToMarathon(user, marathon);
        return "marathon";
    }

}
