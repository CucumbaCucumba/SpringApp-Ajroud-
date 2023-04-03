package com.ala.tp.controllers;

import com.ala.tp.entities.acteur;
import com.ala.tp.service.IServiceActeur;
import com.ala.tp.service.IServiceCategorie;
import com.ala.tp.service.IServiceFilm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/actor/")
public class acteurController {

		@Autowired
		IServiceFilm isf;
		@Autowired
		IServiceCategorie isc;
		@Autowired
		IServiceActeur isa;
		
		@GetMapping("all")
		public String getAllActeur(Model model){
			model.addAttribute("actors", isa.findAllActeurs());
			return "allactors";
		}
		@GetMapping("new")
		public String afficheNew(Model model)
		{
			return "addActeur";
		}
		@GetMapping("modifier/{id}")
		public String afficheModifier(Model model,@PathVariable int id){
			model.addAttribute("acteur",isa.findActeurById(id) );
			return "upActor";
		}
		@PostMapping("add")
		public String add(acteur a) {
			isa.createActeur(a);
			return "redirect:/actor/all";
		}
		@PostMapping("mod")
		public String mod(acteur a) {
			isa.createActeur(a);
			return "redirect:/actor/all";
		}
		@GetMapping("delete/{id}")
		public String delete(@PathVariable int id) {

			isa.deleteActeur(id);
			return "redirect:/actor/all";
		
	}
}
