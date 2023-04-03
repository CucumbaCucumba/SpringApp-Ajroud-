package com.ala.tp.service;

import com.ala.tp.entities.Categorie;
import com.ala.tp.entities.film;
import com.ala.tp.repo.categoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCategorie implements IServiceCategorie{

	@Autowired
	categoRepo cr;
	
	@Override
	public Categorie createCategorie(Categorie c) {
		return cr.save(c);
	}

	@Override
	public Categorie findCategorieById(int id) {
		return cr.findById(id).get();
	}

	@Override
	public List<Categorie> findAllCategories() {
		// TODO Auto-generated method stub
		return cr.findAll();
	}



	@Override
	public Categorie updateFilm(Categorie f) {
		// TODO Auto-generated method stub
		return cr.save(f);
	}

	@Override
	public void deleteCategorie(int id) {
		// TODO Auto-generated method stub
		cr.deleteById(id);
	}

}
