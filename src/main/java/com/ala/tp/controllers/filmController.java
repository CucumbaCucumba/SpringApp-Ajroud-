package com.ala.tp.controllers;

import com.ala.tp.entities.film;
import com.ala.tp.service.IServiceActeur;
import com.ala.tp.service.IServiceCategorie;
import com.ala.tp.service.IServiceFilm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;

@Controller
@RequestMapping("/film/")
public class filmController {

	@Autowired
	IServiceFilm isf;
	@Autowired
	IServiceCategorie isc; 
	@Autowired
	IServiceActeur isa;

	private String uploadDirectory =  System.getProperty("user.dir")+"\\src\\main\\resources\\static\\photos";

	@GetMapping("all")
	public String getAllFilms(Model model){
		model.addAttribute("categories", isc.findAllCategories());
		return getPage(1, model, "title","asc");
	}
	@GetMapping("{id}")
	public String getDetailFilm(Model model ,@PathVariable int id){
		model.addAttribute("film", isf.findFilmById(id));
		model.addAttribute("categories", isc.findAllCategories());
		return "detail";
	}
	@PostMapping("annee")
	public String getAllFilmsByAnne(Model model,int annee){
		model.addAttribute("films", isf.findFilmByAnnee(annee));
		return "affiche";
	}
	@PostMapping("catego")
	public String getAllFilmsByCat(Model model,int id){
		model.addAttribute("films", isf.findFilmByCatego(id));
		return "affiche";
	}
	@GetMapping("new")
	public String afficheNew(Model model){
		int year = Calendar.getInstance().get(Calendar.YEAR);
		model.addAttribute("categories",isc.findAllCategories() );
		model.addAttribute("acteur",isa.findAllActeurs() );
		model.addAttribute("cDate",year);
		return "addFilm";
	}
	@GetMapping("modifier/{id}")
	public String afficheModifier(Model model,@PathVariable int id){
		model.addAttribute("categories",isc.findAllCategories() );
		model.addAttribute("film",isf.findFilmById(id) );
		model.addAttribute("acteur",isa.findAllActeurs() );
		model.addAttribute("err",false);
		return "update";
	}
	@PostMapping("add")
	public String add(Model model, film f, @RequestParam("file")MultipartFile mpf) {

		String fileName = mpf.getOriginalFilename();
		Path fileNameAndPath = Paths.get(uploadDirectory, fileName);
		try {
			Files.write(fileNameAndPath, mpf.getBytes());
		}catch (IOException e) {
			e.printStackTrace();
		}
		f.setPhoto(fileName);

		try{
		isf.createFilm(f);

		return "redirect:/film/all";}
		catch (DataIntegrityViolationException e){
			model.addAttribute("categories",isc.findAllCategories() );
			model.addAttribute("acteur",isa.findAllActeurs() );
			model.addAttribute("err",true);
			return "addfilm";
		}
	}
	@PostMapping("mod")
	public String mod(film f,@RequestParam("file")MultipartFile mpf) {

		if (!mpf.isEmpty()) {
			String fileName = mpf.getOriginalFilename();
			Path fileNameAndPath = Paths.get(uploadDirectory, fileName);
			try {
				Files.write(fileNameAndPath, mpf.getBytes());

			} catch (IOException e) {
				e.printStackTrace();
			}
			f.setPhoto(fileName);
		} else{
			f.setPhoto(isf.findFilmById(f.getId()).getPhoto());
		}
			isf.updateFilm(f);

		return "redirect:/film/all";
	}
	@GetMapping("page/{pageNum}")
	public String getPage(@PathVariable int pageNum,Model model,@RequestParam String sortField,@RequestParam String sortDir) {
		int pageSize = 3;
		Page<film> page = isf.findPaginatedFilms(pageNum,pageSize,sortField,sortDir);
		model.addAttribute("films",page.getContent());
		model.addAttribute("totalPages",page.getTotalPages());
		model.addAttribute("currentPage",pageNum);
		model.addAttribute("sortDir",sortDir);
		model.addAttribute("sortField",sortField);
		model.addAttribute("reverseDir",sortDir.equals("asc")?"desc":"asc");
		return "affiche";
	}
	@GetMapping("delete/{id}")
	public String delete(@PathVariable int id) {
		isf.deleteFilm(id);
		return "redirect:/film/all";
	}
	@GetMapping("forbidden")
	public String forbidden() {
		return "forbidden";
	}
}
