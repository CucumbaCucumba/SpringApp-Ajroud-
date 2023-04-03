package com.ala.tp.repo;

import com.ala.tp.entities.acteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface acteurRepo extends JpaRepository<acteur,Integer>{

}
