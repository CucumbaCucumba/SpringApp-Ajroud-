package com.ala.tp.service;

import com.ala.tp.entities.acteur;
import com.ala.tp.entities.film;
import com.ala.tp.repo.filmRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceFilm implements IServiceFilm{

	@Autowired
	filmRepo fr ;
	
	@Override
	public film createFilm(film f) {
	return fr.save(f);
	}

	@Override
	public film findFilmById(int id) {
		// TODO Auto-generated method stub
		return fr.findById(id).get();
	}
	public List<film> findFilmByacteur(acteur a) {
		// TODO Auto-generated method stub
		List<film> lf = fr.findAll();
		List<film> rlf = new ArrayList <film>();
		for (film var:lf
			 ) {
			for (acteur act:var.getActeurs()
				 ) {
				if (a.equals(act))
					rlf.add(var);
			}
		}
		return rlf;
	}

	@Override
	public List<film> findFilmByAnnee(int n) {
		return fr.findByAnneeparution(n);
	}

	@Override
	public List<film> findFilmByCatego(int n) {
		return fr.findByCategorieId(n);
	}

	@Override
	public Page<film> findPaginatedFilms(int pageNum, int pageSize,String sortField,String sortDir) {
		Sort sort= sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?
				Sort.by(sortField).ascending():Sort.by(sortField).descending();
		Pageable pageable = PageRequest.of(pageNum-1,pageSize,sort);
		return fr.findAll(pageable);
	}

	@Override
	public boolean filmExists(int id) {
		return fr.existsById(id);
	}

	@Override
	public List<film> findAllFilms() {
		// TODO Auto-generated method stub
		return fr.findAll();
	}

	@Override
	public film updateFilm(film f) {
		// TODO Auto-generated method stub
		return fr.save(f);
	}

	@Override
	public void deleteFilm(int id) {
		fr.deleteById(id);
		
	}

}
