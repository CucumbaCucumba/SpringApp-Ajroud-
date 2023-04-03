package com.ala.tp.repo;

import com.ala.tp.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface categoRepo extends JpaRepository<Categorie, Integer>{

}
