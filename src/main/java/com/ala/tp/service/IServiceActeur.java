package com.ala.tp.service;

import com.ala.tp.entities.acteur;

import java.util.List;

public interface IServiceActeur {


	public acteur createActeur(acteur a)  ;
	public acteur findActeurById(int id) ;
	public List<acteur> findAllActeurs();
	public acteur updateActeur(acteur a) ;
	public void deleteActeur (int id);
	
}
