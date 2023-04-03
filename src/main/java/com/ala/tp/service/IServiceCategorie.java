package com.ala.tp.service;

import com.ala.tp.entities.Categorie;
import com.ala.tp.entities.film;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IServiceCategorie {

	public Categorie createCategorie(Categorie c)  ;
	public Categorie findCategorieById(int id) ;
	public List<Categorie> findAllCategories();
	public Categorie updateFilm(Categorie f) ;
	public void deleteCategorie (int id);

}
