package com.ala.tp.service;

import com.ala.tp.entities.acteur;
import com.ala.tp.entities.film;
import com.ala.tp.repo.acteurRepo;
import com.ala.tp.repo.filmRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceActeur implements IServiceActeur{

	@Autowired
	acteurRepo ar;
	@Autowired
	IServiceFilm sf;
	
	@Override
	public acteur createActeur(acteur a) {
		// TODO Auto-generated method stub
		return ar.save(a);
	}

	@Override
	public acteur findActeurById(int id) {
		// TODO Auto-generated method stub
		return ar.findById(id).get();
	}

	@Override
	public List<acteur> findAllActeurs() {
		// TODO Auto-generated method stub
		return ar.findAll();
	}

	@Override
	public acteur updateActeur(acteur a) {
		// TODO Auto-generated method stub
		return ar.save(a);
	}

	@Override
	public void deleteActeur(int id) {
		// TODO Auto-generated method stub
		acteur m=ar.findById(id).get();
		List<film> lf= sf.findFilmByacteur(m);
		for (film f:lf
			 ) {
			List<acteur>la=f.getActeurs();
			la.remove(m);
			f.setActeurs(la);
		}

		ar.deleteById(id);
	}

}
