package com.ala.tp.controllers;

import com.ala.tp.entities.film;
import com.ala.tp.exception.Film404Exception;
import com.ala.tp.service.IServiceFilm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/films/")
public class APIFilmController {
    @Autowired
    IServiceFilm isf;

    @GetMapping("")
    public List<film> getall(){
        return isf.findAllFilms();
    }

    @GetMapping("/{id}")
    public film getparid(@PathVariable int id){
        if (!isf.filmExists(id))
            throw new Film404Exception();
        return isf.findFilmById(id);
    }

    @PostMapping("/add")
    public film add(@RequestBody film f){
        return isf.createFilm(f);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        if (!isf.filmExists(id))
            throw new Film404Exception();
        isf.deleteFilm(id);
    }
    @PutMapping("/update")
    public film update(@RequestBody film f){
        if (!isf.filmExists(f.getId()))
            throw new Film404Exception();
        return isf.createFilm(f);
    }



}
