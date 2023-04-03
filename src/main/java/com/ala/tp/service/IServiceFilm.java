package com.ala.tp.service;

import com.ala.tp.entities.acteur;
import com.ala.tp.entities.film;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IServiceFilm {
	
	public film createFilm(film f)  ;
	public film findFilmById(int id) ;
	public List<film> findAllFilms();
	public film updateFilm(film f) ;
	public void deleteFilm (int id);
	public List<film> findFilmByacteur(acteur a);
	public List<film> findFilmByAnnee(int n);
	public List<film> findFilmByCatego(int n);
	public Page<film> findPaginatedFilms(int pageNum,int pageSize,String sortField,String sortDir);
	public boolean filmExists(int id);
}
