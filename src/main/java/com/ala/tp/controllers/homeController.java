package com.ala.tp.controllers;

import com.ala.tp.service.IServiceCategorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class homeController {

    @Autowired
    IServiceCategorie isc;

    @GetMapping("")
    public String getIndex(Model model){
        model.addAttribute("categories", isc.findAllCategories());
        return "index";
    }

}
