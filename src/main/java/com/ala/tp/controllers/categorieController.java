package com.ala.tp.controllers;

import com.ala.tp.service.IServiceCategorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cat/")
public class categorieController {

    @Autowired
    IServiceCategorie isc;

    @GetMapping("films/{id}")
    public String getFilms(Model model, @PathVariable int id){
        model.addAttribute("films", isc.findCategorieById(id).getFilms());
        model.addAttribute("categories", isc.findAllCategories());

        return "affiche";
    }

}
