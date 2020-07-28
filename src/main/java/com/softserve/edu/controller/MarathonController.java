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

    @GetMapping("/marathons/edit/{id}")
    public String editMarathon(@PathVariable("id") Long id, Model model) {
        model.addAttribute("marathon", marathonService.getMarathonById(id));
        return "editMarathon";
    }
    @PostMapping("/marathons/edit/{id}")
    public String saveMarathon(@PathVariable("id") Long id, @ModelAttribute Marathon marathon, Model model) {
        model.addAttribute("marathon", marathonService.createOrUpdate(marathon));
        return "editMarathon";
    }



    @GetMapping("/marathons/close")
    public String closeMarathons(Model model) {
        //model.addAttribute("marathons", marathonService.createOrUpdate(marathonService.getId()));
        return "editMarathon";
    }
}
